import java.util.Random;

public class EspacoAereo {

	private Aviao[][] espacoAereo;
	private int quantTotalAvioes, quantAvioesSairam;
	private String[] direcaoVoo = {"DC", "DD", "RVC", "RVD", "RHC", "RHD"};
	private String avioesMudaramDirecao;

	public EspacoAereo() {
		super();
	}

	public EspacoAereo(Aviao[][] espacoAereo) {
		this.espacoAereo = espacoAereo;
		quantTotalAvioes = 0;
		quantAvioesSairam = 0;
	}

	public EspacoAereo(int tamanhoLinha, int tamanhoColuna) {
		espacoAereo = new Aviao[tamanhoLinha][tamanhoColuna];
		quantTotalAvioes = 0;
		quantAvioesSairam = 0;
		avioesMudaramDirecao = "";
	}

	public Aviao[][] getEspacoAereo() {
		return espacoAereo;
	}

	public int getQuantTotalAvioes() {
		return quantTotalAvioes;
	}

	public int getQuantAvioesSairam() {
		return quantAvioesSairam;
	}

	public String getAvioesMudaramDirecao() {
		if(avioesMudaramDirecao.equals("")) {
			return "Nenhum aviao alterou sua rota.";
		} else {
			return avioesMudaramDirecao;
		}
	}

// --- Metodos do randomInicialDeAvioes() ----------

// Metodo complementar random e aviao-broda: se achar um aviao na verdical.
	private boolean aviaoNaVertical(int coluna) {
		boolean achei = false;
		for(int i = 0; i < espacoAereo.length; i++) {
			if(espacoAereo[i][coluna] != null) {
				if(espacoAereo[i][coluna].getDirecaoVoo().equals("RVC") || espacoAereo[i][coluna].getDirecaoVoo().equals("RVD")) {
					achei = true;
					break;
				} else {
					// Nao faz nada.
				}
			} else {
				// Nao faz nada.
			}
		}
		return achei;
	}

	// Metodo complementar random e aviao-broda: achar um aviao na horizontal.
	private boolean aviaoNaHorizontal(int linha) {
		boolean achei = false;
		for(int i = 0; i < espacoAereo[0].length; i++) {
			if(espacoAereo[linha][i] != null) {
				if(espacoAereo[linha][i].getDirecaoVoo().equals("RHC") || espacoAereo[linha][i].getDirecaoVoo().equals("RHD")) {
					achei = true;
					break;
				} else {
					// Nao faz nada.
				}
			} else {
				// Nao faz nada.
			}
		}
		return achei;
	}

	// Metodo complementar random e aviao-broda: achar um aviao na diagonal.
	private boolean aviaoNaDiagonal(int linha, int coluna) {
		boolean achei = false;
		int contaLinha = 0, contaColuna = 0;
		if(linha <= coluna) {
			contaLinha = 0;
			contaColuna = coluna-linha;
			for(int i = contaColuna; i < espacoAereo[0].length; i++) {
				if((contaLinha < espacoAereo.length) && (contaColuna < espacoAereo[0].length)) {
					if(espacoAereo[contaLinha][contaColuna] != null) {
						if(espacoAereo[contaLinha][contaColuna].getDirecaoVoo().equals("DC") || espacoAereo[contaLinha][contaColuna].getDirecaoVoo().equals("DD")) {
							achei = true;
							break;
						} else {
							// Nao faz nada.
						}
					} else {
						// Nao faz nada.
					}
				} else {
					// Nao faz nada.
				}
				contaLinha++;
				contaColuna++;
			}	
		} else {
			contaLinha = linha-coluna;
			contaColuna = 0;
			for(int i = contaLinha; i < espacoAereo[0].length; i++) {
				if((contaLinha < espacoAereo.length) && (contaColuna < espacoAereo[0].length)) {
					if(espacoAereo[contaLinha][contaColuna] != null) {
						if(espacoAereo[contaLinha][contaColuna].getDirecaoVoo().equals("DC") || espacoAereo[contaLinha][contaColuna].getDirecaoVoo().equals("DD")) {
							achei = true;
							break;
						} else {
							// Nao faz nada.
						}
					} else {
						// Nao faz nada.
					}
				} else {
					// Nao faz nada.
				}
				contaLinha++;
				contaColuna++;
			}
		}
		return achei;
	}

	// Metodo principal de povoamento
	public void randomInicialDeAvioes() {
		Random gerador = new Random();
		int quantMaxAvioes = ((espacoAereo.length*espacoAereo[0].length)/3);

		// Definindo o combustivelMax.
		int combustivelMax;
		if(espacoAereo.length >= espacoAereo[0].length) {
			combustivelMax = espacoAereo.length+35;
		} else {
			combustivelMax = espacoAereo[0].length+35;
		}

		for(int i = 0; i < quantMaxAvioes; i++){
			String direcaoFinalVoo = null;
			int linhaFinal = 0, colunaFinal = 0, contadorRepeticoes = 0;
			boolean rotaOcupada = true;

			do { // DO WHILE para verificar se posso colocar um aviao em determinada rota.

				String direcaoPossivelVoo = direcaoVoo[gerador.nextInt(6)];
				int possivelLinha = gerador.nextInt(espacoAereo.length);
				int possivelColuna = gerador.nextInt(espacoAereo[0].length);
				switch(direcaoPossivelVoo) {
				case "DC" :
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaDiagonal(possivelLinha, possivelColuna)) {
							contadorRepeticoes++;
							break;
						} else { // caso todas as posicoes estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "DD" :
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaDiagonal(possivelLinha, possivelColuna)) { // Mesma logica para a diagonal crescente
							contadorRepeticoes++;
							break;
						} else {
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RVC" : // FOR : varrer uma coluna para descobrir se a rota esta vazia.
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaVertical(possivelColuna)) {
							contadorRepeticoes++;
							break;
						} else {
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RVD" : // Mesma coisa do RVD.
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaVertical(possivelColuna)) {
							contadorRepeticoes++;
							break;
						} else {
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RHC" : // FOR : varrer uma linha para descobrir se a rota esta vazia.
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaHorizontal(possivelLinha)) {
							contadorRepeticoes++;
							break;
						} else {
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}	
					}
					break;
				case "RHD" : // Mesma coisa do RHD.
					if(espacoAereo[possivelLinha][possivelColuna] != null) {
						contadorRepeticoes++;
						break;
					} else {
						if(aviaoNaHorizontal(possivelLinha)) {
							contadorRepeticoes++;
							break;
						} else {
							rotaOcupada = false;
							linhaFinal = possivelLinha;
							colunaFinal = possivelColuna;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				default : break;
				}

				// Sai do loop se tentar criar um aviao 6 vezes.
				if(contadorRepeticoes == 5) {
					rotaOcupada = false;
				}
			} while(rotaOcupada);

			// Caso tentar criar um aviao e entrar em um loop, ele tenta 6 vezes e para.
			if(contadorRepeticoes == 5) {
				break;
			} else { // Caso não, cria o aviao.

				// A criação dos avioes está assim porque eu precisei definir como seria o nome do aviao para o grafico ficar bem feito.
				
				if(gerador.nextInt(2) == 0) {	// Criando aviao turbo
					if(direcaoFinalVoo.equals("DD") || direcaoFinalVoo.equals("DC")) {
						if((quantTotalAvioes+1) < 10) {
							AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						} else {
							AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						}
					} else {
						if((quantTotalAvioes+1) < 10) {
							AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						} else {
							AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						}
					}
				} else {	// Criando o aviao normal.
					if(direcaoFinalVoo.equals("DD") || direcaoFinalVoo.equals("DC")) {
						if((quantTotalAvioes+1) < 10) {
							Aviao av = new Aviao((direcaoFinalVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						} else {
							Aviao av = new Aviao((direcaoFinalVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						}
					} else {
						if((quantTotalAvioes+1) < 10) {
							Aviao av = new Aviao((direcaoFinalVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						} else {
							Aviao av = new Aviao((direcaoFinalVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
							espacoAereo[linhaFinal][colunaFinal] = av;
							quantTotalAvioes++;
						}
					}
				}
			}
		}
	}

// --- FIM --- Metodos do randomInicialDeAvioes() ----------

// --- Metodo entrandoAviaoBorda() ----------
// Usa alguns metodos do random de verificar se existem alguma aviao naquela rota com a mesma rota ou rota contraria.

	public void entrandoAviaoBorda() { // Mesma logica do criador random de avioes mas coloca eles nas bordas aleatoriamente.
		Random gerador = new Random();

		String direcaoFinalVoo = null;
		int linhaFinal = 0, colunaFinal = 0;
		boolean rotaOcupada = true;

		do {
			String direcaoPossivelVoo = direcaoVoo[gerador.nextInt(6)];
			int possivelLinha = gerador.nextInt(espacoAereo.length);
			int possivelColuna = gerador.nextInt(espacoAereo[0].length);
			switch(direcaoPossivelVoo) {
			case "DC" :
				if(aviaoNaDiagonal(possivelLinha, possivelColuna)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					if(possivelLinha <= possivelColuna) {
						linhaFinal = 0;
						colunaFinal = possivelColuna-possivelLinha;
						direcaoFinalVoo = direcaoPossivelVoo;
					} else {
						linhaFinal = possivelLinha-possivelColuna;
						colunaFinal = 0;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
				}
				break;
			case "DD" :
				if(aviaoNaDiagonal(possivelLinha, possivelColuna)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					if((espacoAereo.length-possivelLinha) <= (espacoAereo[0].length-possivelColuna)) {
						linhaFinal = espacoAereo.length-1;
						colunaFinal = possivelColuna+(espacoAereo.length-possivelLinha-1);
						direcaoFinalVoo = direcaoPossivelVoo;
					} else {
						linhaFinal = possivelLinha+(espacoAereo[0].length-possivelColuna-1);
						colunaFinal = espacoAereo[0].length-1;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
				}
				break;
			case "RVC" :
				if(aviaoNaVertical(possivelColuna)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					linhaFinal = 0;
					colunaFinal = possivelColuna;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RVD" :
				if(aviaoNaVertical(possivelColuna)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					linhaFinal = espacoAereo.length-1;
					colunaFinal = possivelColuna;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RHC" :
				if(aviaoNaHorizontal(possivelLinha)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					linhaFinal = possivelLinha;
					colunaFinal = 0;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RHD" :
				if(aviaoNaHorizontal(possivelLinha)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					linhaFinal = possivelLinha;
					colunaFinal = espacoAereo[0].length-1;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			default : break;
			}
		} while(rotaOcupada);

		// Definindo o combustivelMax.
		int combustivelMax;
		if(espacoAereo.length >= espacoAereo[0].length) {
			combustivelMax = espacoAereo.length+35;
		} else {
			combustivelMax = espacoAereo[0].length+35;
		}

		if(gerador.nextInt(2) == 0) {	// Criando o aviao turbo.
			if(direcaoFinalVoo.equals("DD") || direcaoFinalVoo.equals("DC")) {
				if((quantTotalAvioes+1) < 10) {
					AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				} else {
					AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				}
			} else {
				if((quantTotalAvioes+1) < 10) {
					AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				} else {
					AviaoTurbo av = new AviaoTurbo((direcaoFinalVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal, false);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				}
			}
		} else {	// Criando o aviao normal.
			if(direcaoFinalVoo.equals("DD") || direcaoFinalVoo.equals("DC")) {
				if((quantTotalAvioes+1) < 10) {
					Aviao av = new Aviao((direcaoFinalVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				} else {
					Aviao av = new Aviao((direcaoFinalVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				}
			} else {

				if((quantTotalAvioes+1) < 10) {
					Aviao av = new Aviao((direcaoFinalVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				} else {
					Aviao av = new Aviao((direcaoFinalVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, linhaFinal, colunaFinal);
					espacoAereo[linhaFinal][colunaFinal] = av;
					quantTotalAvioes++;
				}
			}
		}
	}

// --- FIM --- Metodo entrandoAviaoBorda() ----------

// --- Metodos atualizarEspacoAereo() ----------

	// Metodo complementar atualizar...(): para atualizar a proxima posicao de todos os avioes.
	private void proximaPosicaoTodos() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					espacoAereo[i][j].proximaPosicao();
				} else {
					// Nao faz nada.
				}
			}
		}
	}

	// Metodo complementar atualizar...(): deixa todos prontos para avançar no inicio, antes de verificar se podem ou nao. E define false para jaMovimentado.
	private void habilitarAvanco() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					espacoAereo[i][j].setAvanca("Avanca");
					espacoAereo[i][j].setJaMovimentado(false);
				} else {
					// Nao faz nada.
				}
			}
		}
	}

	// Metodo complementar atualizar...(): para verificar colisao.
	private void verificarColisao() {

		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {

				if(espacoAereo[i][j] != null) { // Se encontrar o primeiro aviao.

					for(int k = 0; k < espacoAereo.length; k++) {
						for(int l = 0; l < espacoAereo[0].length; l++) {

							if(espacoAereo[k][l] != null) { // Se encontrar um segundo aviao.

								if((i == k) && (j == l)) {
									// Nada porque eh o mesmo aviao.
								} else {
									// Verifica colisao entre os dois avioes (mesmas posicoes).
									if((espacoAereo[i][j].getProximaLinha() == espacoAereo[k][l].getProximaLinha()) &&
											(espacoAereo[i][j].getProximaColuna() == espacoAereo[k][l].getProximaColuna())) {

										// IF : compara a velocidade dos dois avioes.
										if(espacoAereo[i][j].getVelocidade() >= espacoAereo[k][l].getVelocidade()) {
											// Primeiro aviao avança.
											espacoAereo[i][j].setAvanca("Acelera");
											// Segunda aviao fica parado.
											espacoAereo[k][l].setAvanca("Diminui");
										} else {
											// Segundo aviao avança.
											espacoAereo[k][l].setAvanca("Acelera");
											// Primeiro aviao fica parado.
											espacoAereo[i][j].setAvanca("Diminui");
										}
									} else {
										// Nada porque ele nao precisa mudar nada se os avioes nao forem colidir.
									}
								}
							} else {
								// Nao faz nada porque nao achou nenhum aviao.
							}
						}
					}
				} else {
					// Nao faz nada porque nao achou nenhum aviao.
				}
			}
		}
	}

	// Metodo Complementar do movimentarAvioes(): que é complementar do atualizar...():
	private void movimentoGenerico(String direcao, int i, int j) {

		// Atualiza proximas posicoes de todos novamente.
		proximaPosicaoTodos();

		// Verifica se o aviao ja foi movimentado uma vez.
		if(espacoAereo[i][j].getJaMovimentado()) {
			// Nao faz nada porque ja foi movimentado
		} else {
			// Verifica se o aviao vai sair do espaco aereo.
			if((espacoAereo[i][j].getProximaLinha() < 0) || (espacoAereo[i][j].getProximaLinha() >= espacoAereo.length)
					|| (espacoAereo[i][j].getProximaColuna() < 0) || (espacoAereo[i][j].getProximaColuna() >= espacoAereo[0].length)) {
				// Sai do espaco aereo e conta++ pra avioes que sairam.
				espacoAereo[i][j] = null;
				quantAvioesSairam++;
			} else {
				// Se tiver um aviao na frente dele.
				if(espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()] != null) {

					// Se o aviao ja tentou mudar mais de uma vez.
					if(espacoAereo[i][j].getTentouMudar() == 1) {

						// Alterando a direcao do aviao caso foi tentado mover mais que 2 vezes
						Random gerador = new Random();
						String direcaoAlterada = direcaoVoo[gerador.nextInt(6)];
						avioesMudaramDirecao += espacoAereo[i][j].getId() + " => ";

						// Mudando ID baseado na direcao mas nao muda o numero do aviao.
						String id = espacoAereo[i][j].getId();
						String numeroAviao = "";
						for(int letra = 4; letra < id.length(); letra++) {
							numeroAviao += "" + id.charAt(letra);
						}
						if(direcaoAlterada.equals("DD") || direcaoAlterada.equals("DC")) {
							espacoAereo[i][j].setId(direcaoAlterada + "__" + numeroAviao);
						} else {
							espacoAereo[i][j].setId(direcaoAlterada + "_" + numeroAviao);
						}
						espacoAereo[i][j].setDirecaoVoo(direcaoAlterada);
						espacoAereo[i][j].setTentouMudar(0);
						avioesMudaramDirecao += espacoAereo[i][j].getId() + "\n";
					} else {
						// Se tentou mas nao o limite, entao incrementa a tentativa.
						espacoAereo[i][j].incrementoTentouMudar();
					}
				} else { // Caso não tenha ninguem na frente dele ele se move sem problemas.
					espacoAereo[i][j].setTentouMudar(0);
					espacoAereo[i][j].setJaMovimentado(true);
					espacoAereo[i][j].setLinhaAtual(espacoAereo[i][j].getProximaLinha());
					espacoAereo[i][j].setColunaAtual(espacoAereo[i][j].getProximaColuna());
					espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()] = espacoAereo[i][j];
					espacoAereo[i][j] = null;
				}
			}
		}
	}

	// Metodo complementar atualizar...(): Joga os avioes que podem, nas proximas prosicoes.
	private void movimentarAvioes() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {

				if(espacoAereo[i][j] != null) { // Se existir um aviao nessa posicao.

					// SWITCH : usado para verificar o avanca e fazer as atualizações.
					switch(espacoAereo[i][j].getAvanca()) {
					case "Avanca" : 
						espacoAereo[i][j].consumoCombustivel();
						movimentoGenerico(espacoAereo[i][j].getDirecaoVoo(), i, j);
						break;
					case "Acelera" :
						espacoAereo[i][j].velocUp();
						espacoAereo[i][j].consumoCombustivel();
						movimentoGenerico(espacoAereo[i][j].getDirecaoVoo(), i, j);
						break;
					case "Diminui" : 
						espacoAereo[i][j].velocDown();
						break;
					}
				} else {
					// Nao faz nada.
				}
			}
		}
	}

	// Metodo para Atualizar o espaço aereo.
	public void atualizarEspacoAereo() {

		// Achando a proxima posicao de todos
		proximaPosicaoTodos();

		// Habilita o avanço de todos.
		habilitarAvanco();

		// Verificar se houver colisao, se os avioes pode avançar ou nao.
		verificarColisao();

		// Agora atualizamos as prosicoes nos baseando no atributo avanca de cada aviao.
		movimentarAvioes();
	}

// --- FIM --- Metodos atualizarEspacoAereo() ----------

// --- Outros metodos, apartir daqui nao existem complementares.
	
	// Metodo para mostrar a o espaço aereo graficamente.
	public String graficoEspacoAereo() {
		String grafico = "X   |";
		for(int k = 0; k < espacoAereo[0].length; k++) {
			if((k) < 10) {
				grafico += "     0" + k + "     ";
			} else {
				grafico += "     " + k + "     ";
			}
		}
		grafico += "\n";
		for(int i = 0; i < espacoAereo.length; i++) {
			if((i) < 10) {
				grafico += "0" + i + " |";
			} else {
				grafico += "" + i + " |";
			}
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					grafico += " " + espacoAereo[i][j].getId() + " ";
				} else {
					grafico += "     --     ";
				}
			}
			grafico += "\n";
		}
		return grafico;
	}

	// Metodo para inserir um aviao manualmente.
	public void inserirAviao(int linha, int coluna, String direcaoVoo, boolean turbo) {
		int combustivelMax;
		if(espacoAereo.length >= espacoAereo[0].length) {
			combustivelMax = espacoAereo.length+35;
		} else {
			combustivelMax = espacoAereo[0].length+35;
		}

		if(turbo) {
			// Criando o aviao turbo e jogando ele na matriz (espaco aereo).
			if(direcaoVoo.equals("DD") || direcaoVoo.equals("DC")) {
				if((quantTotalAvioes+1) < 10) {
					AviaoTurbo av = new AviaoTurbo((direcaoVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				} else {
					AviaoTurbo av = new AviaoTurbo((direcaoVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				}
			} else {
				if((quantTotalAvioes+1) < 10) {
					AviaoTurbo av = new AviaoTurbo((direcaoVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				} else {
					AviaoTurbo av = new AviaoTurbo((direcaoVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				}
			}
		} else {
			// Criando o aviao e jogando ele na matriz (espaco aereo).
			if(direcaoVoo.equals("DD") || direcaoVoo.equals("DC")) {
				if((quantTotalAvioes+1) < 10) {
					Aviao av = new Aviao((direcaoVoo + "__0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				} else {
					Aviao av = new Aviao((direcaoVoo + "__" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				}
			} else {
				if((quantTotalAvioes+1) < 10) {
					Aviao av = new Aviao((direcaoVoo + "_0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				} else {
					Aviao av = new Aviao((direcaoVoo + "_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
					espacoAereo[linha][coluna] = av;
					quantTotalAvioes++;
				}
			}
		}
	}

	// Metodo para retornar informacoes sobre um aviao.
	public String informacoesAviao(String id) {
		String informacao = "";
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					if(espacoAereo[i][j].getId().equals(id)) {
						informacao += "O aviao " + id + " foi encontrado na posicao: \nLinha: " + i + ", coluna: " + j + "\n\n"
								+ "A sua velocidade atual eh: " + espacoAereo[i][j].getVelocidade() + "\n"
								+ "E resta " + espacoAereo[i][j].getCombustivel() + " litros de combustivel."; 
					}
				}
			}
		}
		if(informacao.equals("")) {
			return "Nao foi encontrado nenhum aviao com o seguinte id: " + id;
		} else {
			return informacao;
		}
	}

	// Metodo para achar os avioes em uma determinada rota
	public String avioesNumaRotaX(String direcao, int linha, int coluna) {
		String informacao = "";

		if(direcao.equals("RHC") || direcao.equals("RHD")) { // Rota Horizontal
			for(int i = 0; i < espacoAereo[0].length; i++) {
				if(espacoAereo[linha][i] != null) {
					informacao += espacoAereo[linha][i].getId() + "\n";
				} else {
					// Nao faz nada.
				}
			}
		} else { // Rota Vertical
			if(direcao.equals("RVC") || direcao.equals("RVD")) {
				for(int i = 0; i < espacoAereo.length; i++) {
					if(espacoAereo[i][coluna] != null) {
						informacao += espacoAereo[linha][i].getId() + "\n";
					} else {
						// Nao faz nada.
					}
				}
			} else { // Rota Diagonal
				int contaLinha, contaColuna;
				if(linha <= coluna) {
					contaLinha = 0;
					contaColuna = coluna-linha;
					for(int i = coluna-linha; i < espacoAereo[0].length; i++) {
						if((contaLinha < espacoAereo.length) && (contaColuna < espacoAereo[0].length)) {
							if(espacoAereo[contaLinha][contaColuna] != null) {
								informacao += espacoAereo[contaLinha][contaColuna].getId() + "\n";
							} else {
								// Nao faz nada.
							}
						} else {
							// Nao faz nada.
						}
						contaLinha++;
						contaColuna++;
					}	
				} else {
					contaLinha = linha-coluna;
					contaColuna = 0;
					for(int i = linha-coluna; i < espacoAereo.length; i++) {
						if((contaLinha < espacoAereo.length) && (contaColuna < espacoAereo[0].length)) {
							if(espacoAereo[contaLinha][contaColuna] != null) {
								informacao += espacoAereo[contaLinha][contaColuna].getId() + "\n";
							} else {
								// Nao faz nada.
							}
						} else {
							// Nao faz nada.
						}
						contaLinha++;
						contaColuna++;
					}
				}
			}
		}
		if(informacao.equals("")) {
			return "Nao foram encontrados avioes nessa rota.";
		} else {
			return informacao;	
		}
	}

	// Metodo para descobrir quantos avioes ainda estao no espaco aereo.
	public int avioesQuePermanecem() {
		int quantidade = 0;
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					quantidade++;
				}
			}
		}
		return quantidade;
	}

	// Metodo para pegar o toString de um determinado aviao.
	public String toStringDeUmAviao(String id) {
		String toString = "";
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					if(espacoAereo[i][j].getId().equals(id)) {
						toString = espacoAereo[i][j].toString();
					}
				}
			}
		}

		if(toString.equals("")) {
			return "Nao foi encontrado nenhum aviao com o id informado.";
		} else {
			return toString;
		}
	}

	// Metodo para usar o equals() de um determinado aviao.
	public boolean equalsDeUmAviao(String primeiroId, String segundoId) {
		int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					if(espacoAereo[i][j].getId().equals(primeiroId)) {
						x1 = i;
						y1 = j;
					}
					if(espacoAereo[i][j].getId().equals(segundoId)) {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		if((x1 == -1) || (y1 == -1) || (x2 == -1) || (y2 == -1)) {
			return false;
		} else {
			return espacoAereo[x1][y1].equals(espacoAereo[x2][y2]);	
		}
	}

}
