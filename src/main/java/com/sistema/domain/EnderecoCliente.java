package com.sistema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente {

	private Integer id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
}
