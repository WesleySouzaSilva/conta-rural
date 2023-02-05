package com.sistema;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.sistema.domain.Cliente;
import com.sistema.domain.EntradaDados;
import com.sistema.domain.SaidaDados;

public class ContaRuralApplication {

	static EntradaDados entradaDados = new EntradaDados();
	static SaidaDados saidaDados = new SaidaDados();
	static List<Cliente> listaDados = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
	
		
		System.out.println("------------INICIANDO APLICACAO-----------\n");
		System.out.println("CARREGANDO DADOS DO ARQUIVO CSV \n");
		listaDados = entradaDados.carregarArquivo("src/main/resources/arquivoEntrada/conta-rural-fichas-cadastrais.csv");
		System.out.println("FAZENDO A LEITURA DOS DADOS.........\n");
		saidaDados.escrever(listaDados);
		System.out.println("GRAVANDO DADOS DO ARQUIVO EM UM ARQUIVO TXT");
		System.out.println("gerou o arquivo : src/main/resources/arquivoSaida/conta-rural-fichas-cadastrais.txt");
		System.out.println("------------FINALIZANDO A APLICACAO-----------\n");
		
	}
	
	

}
