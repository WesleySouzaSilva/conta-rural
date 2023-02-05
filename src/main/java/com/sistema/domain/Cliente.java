package com.sistema.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	private String nome;
	private String dataNascimento;
	private String cpfCnpj;
	private String sexo;
	private String nomeMae;
	private String estadoCivil;
	private BigDecimal rendaAtual;
	private ContatoCliente contatoCliente;
	private EnderecoCliente enderecoCliente;

}
