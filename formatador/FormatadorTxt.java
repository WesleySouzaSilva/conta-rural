package com.sistema.domain.formatador;

public class FormatadorTxt {

	public String formatarNome(String nome) {
		if (nome.chars().count() > 30) {
			nome.substring(0, 30);
			nome.toLowerCase();
		} else {
			nome.toLowerCase();
		}
		return nome;
	}

}
