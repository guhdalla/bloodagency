package com.bloodagency.util.enums;

import lombok.Getter;

@Getter
public enum ChartIMC {
	IMC0a10(0,10), IMC11a20(11,20), IMC21a30(21,30), IMC31a40(31,40), IMC41a50(41,50), IMC51a60(51,60), IMC61a70(61,70);

	private int valorInicial;
	private int valorFinal;
	
	ChartIMC(int i, int j) {
		this.valorInicial = i;
		this.valorFinal = j;
	}
}
