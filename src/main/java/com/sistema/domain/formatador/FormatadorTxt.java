package com.sistema.domain.formatador;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorTxt {

	public String formatarNome(String nome) {
		String valor = null;
		if (nome.length() > 30) {
			valor = nome.substring(0, 30);
		}else {
			valor = nome;
		}
		return valor.toUpperCase();
	}

	public String formatarDataNascimento(String data) {
		String dataFormatada = null;
		Date dataSql = null;
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date datas = formatador.parse(data);
			dataSql = new java.sql.Date(datas.getTime());
			dataFormatada = String.valueOf(dataSql);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataFormatada.replace("-", "");
	}

	public String formatarCpfCnpj(String cpfCnpj) {
		String cpfCnpjFormatado = null;
		if (cpfCnpj != null) {
			Integer contador = cpfCnpj.length();
			switch (contador) {
			case 14:
				cpfCnpjFormatado = "000" + cpfCnpj.replace(".", "").replace("-", "");
				break;

			case 18:
				cpfCnpjFormatado = cpfCnpj.replace(".", "").replace("-", "").replace("/", "");
				break;

			default:
				break;
			}
		}

		return cpfCnpjFormatado;
	}

	public String formatarSexo(String sexo) {
		String valor = null;
		if (sexo != null) {
			if (sexo.toLowerCase().equals("masculino") || sexo.toLowerCase().equals("m")) {
				valor = new String("M");
			} else if (sexo.toLowerCase().equals("feminino") || sexo.toLowerCase().equals("f")) {
				valor = new String("F");
			} else {
				valor = new String("");
			}
		}

		return valor;
	}

	public String formatarEstadoCivil(String estadoCivil) {
		String valor = null;
		if (estadoCivil != null) {

			if (estadoCivil.toLowerCase().equals("solteiro") || estadoCivil.toLowerCase().equals("solteira")) {
				valor = new String("S");
			}
			if (estadoCivil.toLowerCase().equals("casado") || estadoCivil.toLowerCase().equals("casada")) {
				valor = new String("C");
			}
			if (estadoCivil.toLowerCase().equals("divorciado") || estadoCivil.toLowerCase().equals("divorciada")) {
				valor = new String("D");
			}
			if (estadoCivil.toLowerCase().equals("viuvo") || estadoCivil.toLowerCase().equals("viuva")) {
				valor = new String("V");
			}

		}

		return valor;
	}

	public String formatarRenda(BigDecimal renda) {
		String valor = null;
		String valorFormatado = null;
		if (renda == null) {
			valor = new String("0000000000");
			valorFormatado = valor;
		} else {
			valor = renda.toPlainString().replace(".", "");

			Integer tamanhoString = valor.length();
			if (tamanhoString < 10) {
				Integer calculo = 10 - tamanhoString;

				switch (calculo) {
				case 1:
					valorFormatado = "0" + valor;
					break;
				case 2:
					valorFormatado = "00" + valor;
					break;
				case 3:
					valorFormatado = "000" + valor;
					break;
				case 4:
					valorFormatado = "0000" + valor;
					break;
				case 5:
					valorFormatado = "00000" + valor;
					break;
				case 6:
					valorFormatado = "000000" + valor;
					break;
				case 7:
					valorFormatado = "0000000" + valor;
					break;
				case 8:
					valorFormatado = "00000000" + valor;
					break;
				case 9:
					valorFormatado = "000000000" + valor;
					break;

				default:
					break;
				}

			}

		}
		return valorFormatado;
	}

	public String formatarTelefoneCelular(String telefoneCelular, Integer qtdeCaracteres) {
		String valor = null;
		switch (qtdeCaracteres) {
		case 10:
			if (telefoneCelular != null) {
				valor = telefoneCelular.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
			} else {
				valor = new String("          ");
			}
			break;

		case 11:
			if (telefoneCelular != null) {
				valor = telefoneCelular.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
			} else {
				valor = new String("           ");
			}
			break;

		default:
			break;
		}

		return valor;
	}

	public String formatarEmail(String email) {
		String valor = null;
		if (email != null) {
			valor = email;
		} else {
			valor = new String("                                                  ");
		}

		return valor.toLowerCase();
	}

	public String formatarLogradouroBairroComplemento(String campo, String tipo) {
		String valor = null;
		switch (tipo) {
		case "Logradouro":
			if (campo != null) {
				valor = campo;
			} else {
				valor = new String("                                                            ");
			}

			break;

		case "Bairro":

			if (campo != null) {
				valor = campo;
			} else {
				valor = new String("                              ");
			}

			break;

		case "Complemento":
			if (campo != null) {
				valor = campo;
			} else {
				valor = new String("                    ");
			}

			break;

		default:
			break;
		}
		return valor.toUpperCase();
	}

	public String formatarNumero(String numero) {
		String numeroFormatado = null;
		if (numero != null) {
			Integer contador = numero.length();

			switch (contador) {
			case 1:
				numeroFormatado = new String("0000" + numero);
				break;

			case 2:
				numeroFormatado = new String("000" + numero);
				break;

			case 3:
				numeroFormatado = new String("00" + numero);
				break;

			case 4:
				numeroFormatado = new String("0" + numero);
				break;

			case 5:
				numeroFormatado = numero;
				break;

			default:
				numeroFormatado = new String("00000");
				break;
			}
		}

		return numeroFormatado;
	}

	public String formatarCidade(String cidade) {
		String valor = null;
		if (cidade != null) {
			valor = cidade.toUpperCase();
		} else {
			valor = new String("");
		}
		return valor;
	}

	public String formatarEstado(String estado) {
		String valor = null;
		if (estado != null) {

			estado.toLowerCase();

			if (estado.equals("acre") || estado.equals("ac")) {
				valor = "AC";
			}

			if (estado.equals("alagoas") || estado.equals("al")) {
				valor = "AL";
			}

			if (estado.equals("amazonas") || estado.equals("am")) {
				valor = "AM";
			}

			if (estado.equals("amapa") || estado.equals("ap")) {
				valor = "AP";
			}

			if (estado.equals("bahia") || estado.equals("ba")) {
				valor = "BA";
			}

			if (estado.equals("ceara") || estado.equals("ce")) {
				valor = "CE";
			}

			if (estado.equals("distrito federal") || estado.equals("df")) {
				valor = "DF";
			}

			if (estado.equals("espirito santo") || estado.equals("es")) {
				valor = "ES";
			}

			if (estado.equals("goias") || estado.equals("go")) {
				valor = "GO";
			}

			if (estado.equals("maranhao") || estado.equals("ma")) {
				valor = "MA";
			}

			if (estado.equals("minas gerais") || estado.equals("mg")) {
				valor = "MG";
			}

			if (estado.equals("mato grosso do sul") || estado.equals("ms")) {
				valor = "MS";
			}

			if (estado.equals("mato grosso") || estado.equals("mt")) {
				valor = "MT";
			}

			if (estado.equals("para") || estado.equals("pa")) {
				valor = "PA";
			}

			if (estado.equals("paraiba") || estado.equals("pb")) {
				valor = "PB";
			}

			if (estado.equals("pernambuco") || estado.equals("pe")) {
				valor = "PE";
			}

			if (estado.equals("piaui") || estado.equals("pi")) {
				valor = "PI";
			}

			if (estado.equals("parana") || estado.equals("pr")) {
				valor = "PR";
			}

			if (estado.equals("rio de janeiro") || estado.equals("rj")) {
				valor = "RJ";
			}

			if (estado.equals("rio grande do norte") || estado.equals("rn")) {
				valor = "RN";
			}

			if (estado.equals("rondonia") || estado.equals("ro")) {
				valor = "RO";
			}

			if (estado.equals("roraima") || estado.equals("rr")) {
				valor = "RR";
			}

			if (estado.equals("rio grande do sul") || estado.equals("rs")) {
				valor = "RS";
			}

			if (estado.equals("santa catarina") || estado.equals("sc")) {
				valor = "SC";
			}

			if (estado.equals("sao paulo") || estado.equals("sp")) {
				valor = "SP";
			}

			if (estado.equals("sergipe") || estado.equals("se")) {
				valor = "SE";
			}

		} else {
			valor = new String("");
		}

		return valor;
	}
}
