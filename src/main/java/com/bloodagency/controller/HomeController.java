package com.bloodagency.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bloodagency.exception.EstadoNotFoundException;
import com.bloodagency.model.Pessoa;
import com.bloodagency.model.enums.EstadoBrasil;
import com.bloodagency.model.enums.Genero;
import com.bloodagency.model.enums.TipoSanguineo;
import com.bloodagency.service.PessoaService;
import com.bloodagency.util.enums.ChartIMC;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private PessoaService service;

	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@GetMapping("/estado/{valor}")
	public ModelAndView show(@PathVariable String valor) {

		EstadoBrasil estado = verificaEstado(valor);

		ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("estado", estado.getValor());

		List<Pessoa> pessoas = service.findAll();
		if (!estado.equals(EstadoBrasil.ALL)) {
			pessoas = pessoas.stream().filter(x -> x.getEstado().equals(estado)).collect(Collectors.toList());
		}

		List<Pessoa> pessoasBlood = new ArrayList<Pessoa>();
		pessoasBlood = pessoas.stream().filter(x -> x.getIdade() >= 16 && x.getIdade() <= 59 && x.getPeso() > 50)
				.collect(Collectors.toList());

		for (TipoSanguineo tipoSanguineo : TipoSanguineo.values()) {
			List<Pessoa> pessoasFiltradas = pessoasBlood.stream()
					.filter(x -> x.getTipo_sanguineo().equals(tipoSanguineo)).collect(Collectors.toList());
			modelAndView.addObject("pessoas" + tipoSanguineo, pessoasFiltradas.size());

			if (!pessoasFiltradas.isEmpty()) {
				int sumIdade = pessoasFiltradas.stream().mapToInt(x -> x.getIdade()).sum() / pessoasFiltradas.size();
				modelAndView.addObject("idade" + tipoSanguineo, sumIdade);
			}
		}

		List<Double> chartImc = new ArrayList<Double>();
		for (ChartIMC imc : ChartIMC.values()) {
			List<Pessoa> pessoasIMC = pessoas.stream()
					.filter(x -> x.getIdade() >= imc.getValorInicial() && x.getIdade() <= imc.getValorFinal())
					.collect(Collectors.toList());

			if (!pessoasIMC.isEmpty()) {
				int mediaPeso = pessoasIMC.stream().mapToInt(x -> x.getPeso()).sum() / pessoasIMC.size();
				OptionalDouble mediaAltura = pessoas.stream().mapToDouble(x -> x.getAltura()).average();
				chartImc.add((double) (mediaPeso / Math.round(Math.pow(mediaAltura.getAsDouble(), 2))));
			}

		}
		modelAndView.addObject("dataChartIMC", chartImc);

		List<Double> chartGenero = new ArrayList<Double>();
		List<Pessoa> pessoasFemininoObeso = new ArrayList<Pessoa>();
		List<Pessoa> pessoasMasculinoObeso = new ArrayList<Pessoa>();
		for (Genero genero : Genero.values()) {
			List<Pessoa> pessoasGenero = pessoas.stream().filter(x -> x.getSexo().equals(genero))
					.collect(Collectors.toList());

			if (!pessoasGenero.isEmpty()) {
				pessoasGenero.forEach(x -> {
					long imc = x.getPeso() / Math.round(Math.pow(x.getAltura(), 2));
					if (imc > 30) {
						if (genero.equals(Genero.Feminino)) {
							pessoasFemininoObeso.add(x);
						} else if (genero.equals(Genero.Masculino)) {
							pessoasMasculinoObeso.add(x);
						}
					}
				});

			}
		}
		int total = pessoasFemininoObeso.size() + pessoasMasculinoObeso.size();
		chartGenero.add((double) (pessoasFemininoObeso.size() * 100 / total));
		chartGenero.add((double) (pessoasMasculinoObeso.size() * 100 / total));
		modelAndView.addObject("dataChartGenero", chartGenero);

		return modelAndView;
	}

	public EstadoBrasil verificaEstado(String valor) {
		for (EstadoBrasil estado : EstadoBrasil.values()) {
			if (estado.toString().equals(valor)) {
				return estado;
			}
		}
		throw new EstadoNotFoundException();
	}
}
