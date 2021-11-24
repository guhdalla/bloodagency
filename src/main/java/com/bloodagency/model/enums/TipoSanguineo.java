package com.bloodagency.model.enums;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public enum TipoSanguineo {
	@SerializedName("A+") AP("A+"),
	@SerializedName("A-") AN("A-"),
	@SerializedName("B+") BP("B+"),
	@SerializedName("B-") BN("B-"),
	@SerializedName("AB+") ABP("AB+"),
	@SerializedName("AB-") ABN("AB-"),
	@SerializedName("O+") OP("O+"), 
	@SerializedName("O-") ON("O-");

	private String valor;

	TipoSanguineo(String valor) {
		this.valor = valor;
	}
}
