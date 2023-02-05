package com.sistema.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sistema.domain.formatador.FormatadorTxt;

public class SaidaDados {

	private FormatadorTxt formatadorTxt;

	public void escrever(List<Cliente> listaDados) {
		formatadorTxt = new FormatadorTxt();
		File diretorio = new File("src/main/resources/arquivoSaida/conta-rural-fichas-cadastrais.txt");
		File arquivo = new File(diretorio.getAbsolutePath());
		

		try {

			arquivo.createNewFile();
			BufferedWriter escreverArquivo = new BufferedWriter(new FileWriter(arquivo));

			for (Cliente c : listaDados) {
				String nome = formatadorTxt.formatarNome(c.getNome());
				String dataNascimento = formatadorTxt.formatarDataNascimento(c.getDataNascimento());
				String cpfCnpj = formatadorTxt.formatarCpfCnpj(c.getCpfCnpj());
				String sexo = formatadorTxt.formatarSexo(c.getSexo());
				String nomeMae = formatadorTxt.formatarNome(c.getNomeMae());
				String estadoCivil = formatadorTxt.formatarEstadoCivil(c.getEstadoCivil());
				String renda = formatadorTxt.formatarRenda(c.getRendaAtual());
				String telefone = formatadorTxt.formatarTelefoneCelular(c.getContatoCliente().getTelefone(), 10);
				String celular = formatadorTxt.formatarTelefoneCelular(c.getContatoCliente().getCelular(), 11);
				String email = formatadorTxt.formatarEmail(c.getContatoCliente().getEmail());
				String logradouro = formatadorTxt
						.formatarLogradouroBairroComplemento(c.getEnderecoCliente().getLogradouro(), "Logradouro");
				String numero = formatadorTxt.formatarNumero(c.getEnderecoCliente().getNumero());
				String bairro = formatadorTxt.formatarLogradouroBairroComplemento(c.getEnderecoCliente().getBairro(),
						"Bairro");
				String complemento = formatadorTxt
						.formatarLogradouroBairroComplemento(c.getEnderecoCliente().getComplemento(), "Complemento");
				String cidade = formatadorTxt.formatarCidade(c.getEnderecoCliente().getCidade());
				String estado = formatadorTxt.formatarEstado(c.getEnderecoCliente().getEstado());

				escreverArquivo.write("-----------------------DADOS DO CLIENTE-------------------------\n");
				escreverArquivo.write("| Nome = " + nome + " |\n");
				escreverArquivo.write("| Data = " + dataNascimento + " |\n");
				escreverArquivo.write("| CPF/CNPJ = " + cpfCnpj + " |\n");
				escreverArquivo.write("| Sexo = " + sexo + " |\n");
				escreverArquivo.write("| Nome da Mae = " + nomeMae + " |\n");
				escreverArquivo.write("| Estado Civil = " + estadoCivil + " |\n");
				escreverArquivo.write("| Renda Atual = " + renda + " |\n");
				escreverArquivo.write("| Telefone = " + telefone + " |\n");
				escreverArquivo.write("| Celular = " + celular + " |\n");
				escreverArquivo.write("| E-mail = " + email + " |\n");
				escreverArquivo.write("| Lougradouro = " + logradouro + " |\n");
				escreverArquivo.write("| Numero = " + numero + " |\n");
				escreverArquivo.write("| Bairro = " + bairro + " |\n");
				escreverArquivo.write("| Complemento = " + complemento + " |\n");
				escreverArquivo.write("| Cidade = " + cidade + " |\n");
				escreverArquivo.write("| Estado = " + estado + " |\n");
				escreverArquivo.write("-----------------------------------------------------------------");
				escreverArquivo.write("\n");
				escreverArquivo.write("\n");

			}

			escreverArquivo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
