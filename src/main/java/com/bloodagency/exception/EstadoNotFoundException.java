package com.bloodagency.exception;

public class EstadoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EstadoNotFoundException() {
        super("Estado não encontrado");
    }
}
