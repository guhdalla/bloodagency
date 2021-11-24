package com.bloodagency.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.bloodagency.model.enums.EstadoBrasil;
import com.bloodagency.model.enums.Genero;
import com.bloodagency.model.enums.TipoSanguineo;

import lombok.Data;

@Data
@Entity
@Table(name="TB_PESSOA")
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(nullable = false)
	private String rg;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_nasc;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genero sexo;
	
	@NotBlank
	@Column(nullable = false)
	private String mae;
	
	@NotBlank
	@Column(nullable = false)
	private String pai;
	
	@NotBlank
	@Column(nullable = false)
	private String email;
	
	@NotBlank
	@Column(nullable = false)
	private String cep;
	
	@NotBlank
	@Column(nullable = false)
	private String endereco;
	
	@Min(0)
	@Column(nullable = false)
	private int numero;
	
	@NotBlank
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EstadoBrasil estado;
	
	@NotBlank
	@Column(name = "telefone_fixo", nullable = false)
	@NumberFormat(pattern = "(##) ####-####")
	private String telefone_fixo;
	
	@NotBlank
	@Column(nullable = false)
	@NumberFormat(pattern = "(##) #####-####")
	private String celular;
	
	@Min(0)
	@Column(nullable = false)
	private Double altura;
	
	@Min(0)
	@Column(nullable = false)
	private int peso;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipo_sanguineo;
	
	public int getIdade() {
		return calculaIdade(data_nasc);
	}
	
	public int calculaIdade(Date dataNasc) {

	    Calendar dataNascimento = Calendar.getInstance();  
	    dataNascimento.setTime(dataNasc); 
	    Calendar hoje = Calendar.getInstance();  

	    int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

	    if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
	      idade--;  
	    } 
	    else 
	    { 
	        if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
	            idade--; 
	        }
	    }

	    return idade;
	}
}
