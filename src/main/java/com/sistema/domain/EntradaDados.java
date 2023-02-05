package com.sistema.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaDados {

	private Scanner leitor;
	private ArrayList<Cliente> listaDados = new ArrayList<>();
	private Cliente cliente = null;
	private EnderecoCliente enderecoCliente = null;
	private ContatoCliente contatoCliente = null;

	public List<Cliente> carregarArquivo(String nomeArquivo) {

		System.out.println("achou o arquivo : " + nomeArquivo);

		if (nomeArquivo != null) {

			File arquivoCSV = new File(nomeArquivo);
			try {

				leitor = new Scanner(arquivoCSV);
				String linhasDoArquivo = new String();
				leitor.nextLine();

				while (leitor.hasNext()) {
					linhasDoArquivo = leitor.nextLine();
					String[] valoresEntreVirgulas = linhasDoArquivo.split(";");

					String nome = valoresEntreVirgulas[0].trim();
					String dataNascimento = valoresEntreVirgulas[1].trim();
					String cpfCnpj = valoresEntreVirgulas[2].trim();
					String sexo = valoresEntreVirgulas[3].trim();
					String nomeMae = valoresEntreVirgulas[4].trim();
					String estadoCivil = valoresEntreVirgulas[5].trim();
					String renda = valoresEntreVirgulas[6].trim();
					String telefone = valoresEntreVirgulas[7].trim();
					String celular = valoresEntreVirgulas[8].trim();
					String email = valoresEntreVirgulas[9].trim();
					String logradouro = valoresEntreVirgulas[10].trim();
					String numero = valoresEntreVirgulas[11].trim();
					String bairro = valoresEntreVirgulas[12].trim();
					String complemento = valoresEntreVirgulas[13].trim();
					String cidade = valoresEntreVirgulas[14].trim();
					String estado = valoresEntreVirgulas[15].trim();

					BigDecimal rendaAtual = null;

					if (renda.isEmpty() || renda == null) {
						rendaAtual = new BigDecimal(0);
					}
					rendaAtual = new BigDecimal(renda.replace(".", "").replaceAll(",", "."));

					enderecoCliente = new EnderecoCliente(logradouro, numero, bairro, complemento, cidade, estado);
					contatoCliente = new ContatoCliente(telefone, celular, email);
					cliente = new Cliente(nome, dataNascimento, cpfCnpj, sexo, nomeMae, estadoCivil, rendaAtual,
							contatoCliente, enderecoCliente);
					listaDados.add(cliente);

				}

			} catch (FileNotFoundException e) {

			}

		} else {
			System.out
					.println(" nome do arquivo %d" + nomeArquivo + " não foi encontrado, verifique o nome do arquivo!");
		}

		return listaDados;
	}

}
