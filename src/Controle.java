
public class Controle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InteracaoUsuario iu = new InteracaoUsuario();

		// Criando o espaço aereo conforme a vontade do usuario.
		EspacoAereo ea = new EspacoAereo(iu.informeInt("Informe quantas linhas o espaço aereo deve ter:"),
				iu.informeInt("Informe quantas colunas o espaço aereo deve ter:"));

		// Comente todo o pedaço de codigo abaixo e descomente os de baixo para ter alguns casos fixos para teste.
		/*ea.inserirAviao(2, 2, "DC", false);
		ea.inserirAviao(2, 3, "RHD", true);
		ea.inserirAviao(3, 3, "RVD", false);
		ea.inserirAviao(0, 5, "RVC", true);
		ea.inserirAviao(5, 0, "RHC", false);
		ea.inserirAviao(3, 0, "DC", true);
		ea.inserirAviao(6, 9, "RHD", false);
		ea.inserirAviao(9, 1, "RVD", true);
		ea.inserirAviao(9, 2, "RVD", false);
		ea.inserirAviao(9, 8, "DD", true);
		ea.inserirAviao(4, 9, "DD", false);*/

		// Escolha do usuario em criar avioes randomicamente ou manualmente.
		int automativo = iu.informeInt("Digite: \n 1 : para preenchimento automativo.\n 2 : para preenchimento manual.");
		if(automativo == 1) {
			ea.randomInicialDeAvioes();
		} else {
			do {
				if(iu.informeInt("Deseja criar um aviao turbo?\n Digite 1: para SIM ou 2: para NAO:") == 1) {
					ea.inserirAviao(iu.informeInt("Informe o numero da linha que deseja inserir:"), iu.informeInt("Informe o numero da coluna que deseja inserir:"),
							iu.informeString("Digite uma das seguintes direçoes abaixo:\nRHC : para Reta Horizontal Crescente\n"
									+ "RHD : para Reta Horizontal Decrescente\nRVC : para Reta Vertical Crescente\nRVD : para Reta Vertical Decrescente\n"
									+ "DC : para Diagonal Crescente\nDD : para Diagonal Decrescente"), true);
				} else {
					ea.inserirAviao(iu.informeInt("Informe o numero da linha que deseja inserir:"), iu.informeInt("Informe o numero da coluna que deseja inserir:"),
							iu.informeString("Digite uma das seguintes direçoes abaixo:\nRHC: para Reta Horizontal Crescente\n"
									+ "RHD: para Reta Horizontal Decrescente\nRVC: para Reta Vertical Crescente\nRVD: para Reta Vertical Decrescente\n"
									+ "DC: para Diagonal Crescente\nDD: para Diagonal Decrescente"), false);
				}
			} while(iu.informeInt("Deseja inserir outro aviao?\n Digite\n1: para SIM\n2: para NAO") == 1);
		}

		// Definindo a quantidade de tempo de simulaçao.
		int periodoDeTempo = iu.informeInt("Informe o período de tempo para a simulação:");

		// FOR : para a simulação em um período de tempo.
		for(int i = 0; i < periodoDeTempo; i++) {

			// Mostra o espaco aereo
			iu.mostraMensagem("Espaço Aereo - Tempo de execuçao: " + (i+1) + " de " + periodoDeTempo + "\n\n" + ea.graficoEspacoAereo());

			// Neste metodo acontece tudo, verifica colisao e avança os avioes.
			ea.atualizarEspacoAereo();

			// A cada 5 "segundos" entra um aviao em algumas das bordas.
			if((i%5) == 0) {
				ea.entrandoAviaoBorda();
			}
		}

		// Informacoes finais antes das opcoes de escolha.
		iu.mostraMensagem("Espaço Aereo FINAL\n\n" + ea.graficoEspacoAereo());
		iu.mostraMensagem("Quantidade total de aviões criados: " + ea.getQuantTotalAvioes() + "\n"
				+ "Quantidade de avioes que permanecem no espaco aereo: " + ea.avioesQuePermanecem() + "\n"
				+ "Quantidade total de aviões que sairam: " + ea.getQuantAvioesSairam() + "\n\n"
				+ "Aviões que mudaram de rota: \n" + ea.getAvioesMudaramDirecao());

		// Menus de interacao com o usuario.
		boolean continua = true;
		do {
			switch(iu.informeInt("Escolha uma das opcoes abaixo:\n"
					+ "1 : Encontrar um aviao pelo nome e mostrar as informacoes mais importantes.\n"
					+ "2 : Encontrar todos os avioes em uma determinada rota.\n"
					+ "3 : Mostrar o grafico do espaço aereo e outras informaçoes.\n"
					+ "4 : toString() de um determinado aviao.\n"
					+ "5 : equals() entre dois avioes.\n"
					+ "6 : Parar o programa.")) {
					case 1 :  // Encontrar aviao.
						iu.mostraMensagem(ea.informacoesAviao(iu.informeString(ea.graficoEspacoAereo() + "\n\n"
								+ "Informe o nome do aviao, respeitando maisculas, numeros e underlines:")));
						break;
					case 2 : // Encontrar todos em uma rota.
						iu.mostraMensagem(ea.avioesNumaRotaX(iu.informeString("Informe o nome da rota que deseja procurar:\nRHC, RHD, RVC, RVD, DC ou DC:"),
								iu.informeInt("Informe qualquer linha que quiser usar como referencia para a rota:"),
								iu.informeInt("Informe qualquer coluna que quiser usar como referencia para a rota:")));

						break;
					case 3 : // Mostrar grafico e informacoes.
						iu.mostraMensagem("Espaço aereo final\n\n" + ea.graficoEspacoAereo());
						iu.mostraMensagem("Quantidade total de aviões criados: " + ea.getQuantTotalAvioes() + "\n"
								+ "Quantidade de avioes que permanecem no espaco aereo: " + ea.avioesQuePermanecem() + "\n"
								+ "Quantidade total de avioes que sairam: " + ea.getQuantAvioesSairam() + "\n\n"
								+ "Aviões que mudaram de rota: \n" + ea.getAvioesMudaramDirecao());
						break;
					case 4 : // toString()
						iu.mostraMensagem(ea.toStringDeUmAviao(iu.informeString(ea.graficoEspacoAereo() + "\n\nInforme o id do aviao que deseja ver o toString().")));
						break;
					case 5 : // equals()
						if(ea.equalsDeUmAviao(iu.informeString(ea.graficoEspacoAereo() + "\n\nInforme o id do primeiro aviao:"),
								iu.informeString(ea.graficoEspacoAereo() + "\n\nInforme o id do segundo aviao:"))) {
							iu.mostraMensagem("Os avioes sao iguais.");
						} else {
							iu.mostraMensagem("Os avioes sao diferentes.");
						}
						break;
					case 6 : // Parar o programa.
						continua = false;
						break;
					default: break;
			}
		} while(continua);
	}

}
