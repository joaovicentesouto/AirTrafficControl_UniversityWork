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

	// Metodo complementar randomInicialDeAvioes(): achar um aviao na verdical.
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

	// Metodo complementar randomInicialDeAvioes(): achar um aviao na horizontal.
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

	// Metodo complementar randomInicialDeAvioes(): achar um aviao na diagonal.
	private boolean aviaoNaDiagonal(int linha, int coluna) {
		boolean achei = false;
		int contaLinha = 0, contaColuna = 0;
		if(linha <= coluna) {
			contaLinha = 0;
			contaColuna = coluna-linha;
			for(int i = coluna-linha; i < espacoAereo[0].length; i++) {
				if((contaLinha < espacoAereo.length) || (contaColuna < espacoAereo[0].length)) {
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
			for(int i = linha-coluna; i < espacoAereo[0].length; i++) {
				if((contaLinha < espacoAereo.length) || (contaColuna < espacoAereo[0].length)) {
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

	// Metodo de povoamento
	public void randomInicialDeAvioes() {
		Random gerador = new Random();
		int quantMaxAvioes = ((espacoAereo.length*espacoAereo[0].length)/3);

		// Definindo o combustivelMax.
		int combustivelMax;
		if(espacoAereo.length >= espacoAereo[0].length) {
			combustivelMax = espacoAereo.length+10;
		} else {
			combustivelMax = espacoAereo[0].length+10;
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaDiagonal(possivelLinha, possivelColuna)) { // Esse IF verifica qual eh maior para definir qual vai ser a posicao inicial da rota.
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaDiagonal(possivelLinha, possivelColuna)) { // Mesma logica para a diagonal crescente
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaVertical(possivelColuna)) {
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaVertical(possivelColuna)) {
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaHorizontal(possivelLinha)) {
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
						if(contadorRepeticoes == 5) {
							rotaOcupada = false;
						} else {
							rotaOcupada = true;
						}
						break;
					} else {
						if(aviaoNaHorizontal(possivelLinha)) {
							contadorRepeticoes++;
							if(contadorRepeticoes == 5) {
								rotaOcupada = false;
							} else {
								rotaOcupada = true;
							}
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
			} while(rotaOcupada);

			if(contadorRepeticoes == 5) {
				break;
			} else {
				// Criando aviao.
				if(gerador.nextInt(2) == 0) {
					// Criando o aviao turbo e jogando ele na matriz (espaco aereo).
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
				} else {
					// Criando o aviao e jogando ele na matriz (espaco aereo).
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

	// Metodo inserindo um aviao pela borda, durante a execucao.
	public void entrandoAviaoBorda() {
		Random gerador = new Random();

		String direcaoFinalVoo = null;
		int linhaFinal = 0, colunaFinal = 0;
		boolean rotaOcupada = true;

		do { // DO WHILE para verificar se posso colocar um aviao em determinada rota.
			String direcaoPossivelVoo = direcaoVoo[gerador.nextInt(6)];
			int possivelLinha = gerador.nextInt(espacoAereo.length);
			int possivelColuna = gerador.nextInt(espacoAereo[0].length);
			switch(direcaoPossivelVoo) {
			case "DC" :
				if(aviaoNaDiagonal(possivelLinha, possivelColuna)) { // Esse IF verifica qual eh maior para definir qual vai ser a posicao inicial da rota.
					rotaOcupada = true;
					break;
				} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
					rotaOcupada = false;
					if(possivelLinha <= possivelColuna) { // Colocando no começo da rota.
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
				if(aviaoNaDiagonal(possivelLinha, possivelColuna)) { // Mesma lógica para a diagonal crescente
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					if((espacoAereo.length-possivelLinha) <= (espacoAereo[0].length-possivelColuna)) { // Colocando no começo da rota, porehm no limite.
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
			case "RVC" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
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
			case "RVD" : // Mesma coisa do RVD.
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
			case "RHC" : // FOR : varrer uma linha para descobrir se a rota está vazia.
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
			case "RHD" : // Mesca coisa do RHD.
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
			combustivelMax = espacoAereo.length+10;
		} else {
			combustivelMax = espacoAereo[0].length+10;
		}

		// Criando aviao.
		if(gerador.nextInt(2) == 0) {
			// Criando o aviao turbo e jogando ele na matriz (espaco aereo).
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
		} else {
			// Criando o aviao e jogando ele na matriz (espaco aereo).
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

	// ------ Metodos PARA ATUALIZAR O ESPAÇO aereo ------  //

	// Metodo complementar Atualizar EA: para atualizar a proxima posicao de todos os avioes.
	private void proximaPosicaoTodos() {
		// FOR pra percorrer a matriz todo, quando achar um aviao, executa o Metodo proximaPosicao() dele.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					espacoAereo[i][j].proximaPosicao();
					espacoAereo[i][j].setJaMovimentado(false);
				} else {
					// Nada.
				}
			}
		}
	}

	// Metodo complementar Atualizar EA : deixa todos prontos para avançar no inicio, antes de verificar se podem ou Nao avançar.
	private void habilitarAvanco() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se existir um aviao nessa posicao.
					espacoAereo[i][j].setAvanca("Avanca");
					//espacoAereo[i][j].setTentouMudar(false);
				} else {
					// Nada.
				}
			}
		}
	}

	// Metodo complementar Atualizar EA: para verificar colisao e deixar desativado o avanço do aviao mais lento.
	private void verificarColisao() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se encontrar o primeiro aviao.
					// FOR para comparar a proxima posicao do aviao com todas as outras proximas prosicoes dos outros avioes.
					for(int k = 0; k < espacoAereo.length; k++) {
						for(int l = 0; l < espacoAereo[0].length; l++) {

							if(espacoAereo[k][l] != null) { // Se encontrar um segundo aviao.

								if((i == k) && (j == l)) {
									// Nada porque eh o mesmo aviao.
								} else {
									// Verifica colisao entre os dois avioes.
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
										// Nada porque ele Nao precisa mudar nada se os avioes Nao forem colidir.
									}
								}
							} else {
								// Nao faz nada porque Nao achou nenhum aviao.
							}
						}
					}
				} else {
					// Nao faz nada porque Nao achou nenhum aviao.
				}
			}
		}
	}

	// Metodo Complementar do movimentarAvioes() ...
	private void movimentoGenerico(String direcao, int i, int j) {

		proximaPosicaoTodos();
		if(espacoAereo[i][j].getJaMovimentado()) {
			
		} else {
			if((espacoAereo[i][j].getProximaLinha() < 0) || (espacoAereo[i][j].getProximaLinha() >= espacoAereo.length)
					|| (espacoAereo[i][j].getProximaColuna() < 0) || (espacoAereo[i][j].getProximaColuna() >= espacoAereo[0].length)) {
				espacoAereo[i][j] = null;
				quantAvioesSairam++;
			} else { 
				if(espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()] != null) {
					if(espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].getTentouMudar() == 1) {

						// Alterando a direcao do aviao a frente caso foi tentado mover mais que 2 vezes
						Random gerador = new Random();
						String direcaoAlterada = direcaoVoo[gerador.nextInt(6)];
						avioesMudaramDirecao += espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].getId() + " => ";

						// Mudando ID baseado na direcao mas nao muda o numero do aviao.

						String id = espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].getId();
						String numeroAviao = "";
						for(int letra = 4; letra < id.length(); letra++) {
							numeroAviao += "" + id.charAt(letra);
						}
						if(direcaoAlterada.equals("DD") || direcaoAlterada.equals("DC")) {
							espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].setId(direcaoAlterada + "__" + numeroAviao);
						} else {
							espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].setId(direcaoAlterada + "_" + numeroAviao);
						}
						espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].setDirecaoVoo(direcaoAlterada);
						espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].setTentouMudar(0);
						avioesMudaramDirecao += espacoAereo[espacoAereo[i][j].getProximaLinha()][espacoAereo[i][j].getProximaColuna()].getId() + "\n";
					} else {
						espacoAereo[i][j].incrementoTentouMudar();
					}
					espacoAereo[i][j].velocDown();
				} else {
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

	// Metodo complementar Atualizar EA: Joga os avioes que podem, nas proximas prosicoes.
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
					// Nada.
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

	// Metodo para mostrar a o espaço aereo graficamente.
	public String graficoEspacoAereo() {
		String grafico = "X   |";
		for(int k = 0; k < espacoAereo[0].length; k++) {
			if((k) < 10) {
				grafico += "     0" + k + "     ";
			} else {
				grafico += "     " + k + "      ";
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
					switch(espacoAereo[i][j].getDirecaoVoo()) { // irrelevante para essa situacao mas vou alterar 
					case "DC" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					case "DD" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					case "RVC" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					case "RVD" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					case "RHC" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					case "RHD" :
						grafico += " " + espacoAereo[i][j].getId() + " ";
						break;
					default : break;
					}
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
			combustivelMax = espacoAereo.length+10;
		} else {
			combustivelMax = espacoAereo[0].length+10;
		}

		if(turbo) {
			if((quantTotalAvioes+1) < 10) {
				AviaoTurbo av = new AviaoTurbo(("0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
				espacoAereo[linha][coluna] = av;
				quantTotalAvioes++;
			} else {
				AviaoTurbo av = new AviaoTurbo(("" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna, false);
				espacoAereo[linha][coluna] = av;
				quantTotalAvioes++;
			}
		} else {
			// Criando o aviao e jogando ele na matriz (espaco aereo).
			if((quantTotalAvioes+1) < 10) {
				Aviao av = new Aviao(("0" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
				espacoAereo[linha][coluna] = av;
				quantTotalAvioes++;
			} else {
				Aviao av = new Aviao(("" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoVoo, linha, coluna);
				espacoAereo[linha][coluna] = av;
				quantTotalAvioes++;	
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
		return informacao;
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
						if((contaLinha < espacoAereo.length) || (contaColuna < espacoAereo[0].length)) {
							if(espacoAereo[contaLinha][contaColuna] != null) {
								informacao += espacoAereo[linha][i].getId() + "\n";
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
						if((contaLinha < espacoAereo.length) || (contaColuna < espacoAereo[0].length)) {
							if(espacoAereo[contaLinha][contaColuna] != null) {
								informacao += espacoAereo[linha][i].getId() + "\n";
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

}
