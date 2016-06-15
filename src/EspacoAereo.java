import java.util.Random;

public class EspacoAereo {

	private Aviao[][] espacoAereo;
	private int quantTotalAvioes;

	public EspacoAereo() {
		super();
	}

	public EspacoAereo(Aviao[][] espacoAereo) {
		this.espacoAereo = espacoAereo;
		quantTotalAvioes = 0;
	}

	public EspacoAereo(int tamanhoX, int tamanhoY) {
		espacoAereo = new Aviao[tamanhoX][tamanhoY];
		quantTotalAvioes = 0;
	}

	public Aviao[][] getEspacoAereo() {
		return espacoAereo;
	}

	public Aviao getAviao(int posicaoX, int posicaoY) {
		return espacoAereo[posicaoX][posicaoY];
	}

	// Método complementar levantandoVoo(): achar um avião na verdical.
	private boolean aviaoNaVertical(int coluna) {
		boolean achei = false;
		for(int i = 0; i < espacoAereo.length; i++) {
			if(espacoAereo[i][coluna] != null) {
				achei = true;
				break;
			} else {
				// Não faz nada.
			}
		}
		return achei;
	}

	// Método complementar levantandoVoo(): achar um avião na horizontal.
	private boolean aviaoNaHorizontal(int linha) {
		boolean achei = false;
		for(int i = 0; i < espacoAereo.length; i++) {
			if(espacoAereo[linha][i] != null) {
				achei = true;
				break;
			} else {
				// Não faz nada.
			}
		}
		return achei;
	}

	// Método complementar levantandoVoo(): achar um avião na diagonal.
	private boolean aviaoNaDiagonal(int linha, int coluna) {
		boolean achei = false;
		int contaLinha = 0, contaColuna = 0;
		if(linha <= coluna) {
			contaLinha = 0;
			contaColuna = coluna-linha;
			for(int i = coluna-linha; i < espacoAereo[0].length; i++) {
				if((contaLinha < espacoAereo.length) || (contaColuna < espacoAereo[0].length)) {
					if(espacoAereo[contaLinha][contaColuna] != null) {
						achei = true;
						break;
					} else {
						// Não faz nada.
					}
				} else {
					// Não faz nada.
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
						achei = true;
						break;
					} else {
						// Não faz nada.
					}
				} else {
					// Não faz nada.
				}
				contaLinha++;
				contaColuna++;
			}
		}
		return achei;
	}

	// Método de povoamento
	public void levantandoVoo() {
		Inicializacao in = new Inicializacao();
		Random gerador = new Random(444333);
		int quantMaxAvioes = ((espacoAereo.length*espacoAereo[0].length)/5);

		for(int i = 0; i < quantMaxAvioes; i++){
			String direcaoFinalVoo = null;
			int posicaoFinalX = 0, posicaoFinalY = 0;
			boolean rotaOcupada = true;

			do { // DO WHILE para verificar se posso colocar um avião em determinada rota.
				String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
				int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
				int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
				switch(direcaoPossivelVoo) {
				case "DC" :
					if(aviaoNaDiagonal(possivelPosicaoX, possivelPosicaoY)) { // Esse IF verifica qual é maior para definir qual vai ser a posicao inicial da rota.
						rotaOcupada = true;
						break;
					} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
					break;
				case "DD" :
					if(aviaoNaDiagonal(possivelPosicaoX, possivelPosicaoY)) { // Mesma lógica para a diagonal crescente
						rotaOcupada = true;
						break;
					} else {
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
					break;
				case "RVC" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
					if(aviaoNaVertical(possivelPosicaoY)) {
						rotaOcupada = true;
						break;
					} else {
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
					break;
				case "RVD" : // Mesma coisa do RVD.
					if(aviaoNaVertical(possivelPosicaoY)) {
						rotaOcupada = true;
						break;
					} else {
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
					break;
				case "RHC" : // FOR : varrer uma linha para descobrir se a rota está vazia.
					if(aviaoNaHorizontal(possivelPosicaoX)) {
						rotaOcupada = true;
						break;
					} else {
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
					break;
				case "RHD" : // Mesca coisa do RHD.
					if(aviaoNaHorizontal(possivelPosicaoX)) {
						rotaOcupada = true;
						break;
					} else {
						rotaOcupada = false;
						posicaoFinalX = possivelPosicaoX;
						posicaoFinalY = possivelPosicaoY;
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

			// Criando avião.
			if(gerador.nextInt(2) == 0) {
				// Criando o avião turbo e jogando ele na matriz (espaco aéreo).
				AviaoTurbo av = new AviaoTurbo(("AvT_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY, false);
				espacoAereo[posicaoFinalX][posicaoFinalY] = av;
				quantTotalAvioes++;
			} else {
				// Criando o avião e jogando ele na matriz (espaco aéreo).
				Aviao av = new Aviao(("Av_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY);
				espacoAereo[posicaoFinalX][posicaoFinalY] = av;
				quantTotalAvioes++;
			}
		}
	}

	// Método inserindo um avião pela borda, durante a execução.
	public void entrandoAviaoBorda() {
		Inicializacao in = new Inicializacao();
		Random gerador = new Random(444333);

		String direcaoFinalVoo = null;
		int posicaoFinalX = 0, posicaoFinalY = 0;
		boolean rotaOcupada = true;

		do { // DO WHILE para verificar se posso colocar um avião em determinada rota.
			String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
			int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
			int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
			switch(direcaoPossivelVoo) {
			case "DC" :
				if(aviaoNaDiagonal(possivelPosicaoX, possivelPosicaoY)) { // Esse IF verifica qual é maior para definir qual vai ser a posicao inicial da rota.
					rotaOcupada = true;
					break;
				} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
					rotaOcupada = false;
					if(possivelPosicaoX <= possivelPosicaoY) { // Colocando no começo da rota.
						posicaoFinalX = 0;
						posicaoFinalY = possivelPosicaoY-possivelPosicaoX;
						direcaoFinalVoo = direcaoPossivelVoo;
					} else {
						posicaoFinalX = possivelPosicaoX-possivelPosicaoY;
						posicaoFinalY = 0;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
				}
				break;
			case "DD" :
				if(aviaoNaDiagonal(possivelPosicaoX, possivelPosicaoY)) { // Mesma lógica para a diagonal crescente
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					if((espacoAereo.length-possivelPosicaoX) <= (espacoAereo[0].length-possivelPosicaoY)) { // Colocando no começo da rota, porém no limite.
						posicaoFinalX = espacoAereo.length-1;
						posicaoFinalY = possivelPosicaoY+(espacoAereo.length-possivelPosicaoX-1);
						direcaoFinalVoo = direcaoPossivelVoo;
					} else {
						posicaoFinalX = possivelPosicaoX+(espacoAereo[0].length-possivelPosicaoY-1);
						posicaoFinalY = espacoAereo[0].length-1;
						direcaoFinalVoo = direcaoPossivelVoo;
					}
				}
				break;
			case "RVC" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
				if(aviaoNaVertical(possivelPosicaoY)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					posicaoFinalX = 0;
					posicaoFinalY = possivelPosicaoY;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RVD" : // Mesma coisa do RVD.
				if(aviaoNaVertical(possivelPosicaoY)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					posicaoFinalX = espacoAereo.length;
					posicaoFinalY = possivelPosicaoY;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RHC" : // FOR : varrer uma linha para descobrir se a rota está vazia.
				if(aviaoNaHorizontal(possivelPosicaoX)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					posicaoFinalX = possivelPosicaoX;
					posicaoFinalY = 0;
					direcaoFinalVoo = direcaoPossivelVoo;
				}
				break;
			case "RHD" : // Mesca coisa do RHD.
				if(aviaoNaHorizontal(possivelPosicaoX)) {
					rotaOcupada = true;
					break;
				} else {
					rotaOcupada = false;
					posicaoFinalX = possivelPosicaoX;
					posicaoFinalY = espacoAereo[0].length;
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

		// Criando avião.
		if(gerador.nextInt(2) == 0) {
			// Criando o avião turbo e jogando ele na matriz (espaco aéreo).
			AviaoTurbo av = new AviaoTurbo(("AvT_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY, false);
			espacoAereo[posicaoFinalX][posicaoFinalY] = av;
			quantTotalAvioes++;
		} else {
			// Criando o avião e jogando ele na matriz (espaco aéreo).
			Aviao av = new Aviao(("Av_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY);
			espacoAereo[posicaoFinalX][posicaoFinalY] = av;
			quantTotalAvioes++;
		}
	}

	// ------ MÉTODOS PARA ATUALIZAR O ESPAÇO AÉREO ------  //

	// Método complementar Atualizar EA: para atualizar a próxima posição de todos os aviões.
	private void proximaPosicaoTodos() {
		// FOR pra percorrer a matriz todo, quando achar um avião, executa o método proximaPosicao() dele.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					espacoAereo[i][j].proximaPosicao();
				} else {
					// Nothing.
				}
			}
		}
	}

	// Método complementar Atualizar EA : deixa todos prontos para avançar no início, antes de verificar se podem ou não avançar.
	private void habilitarAvanco() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se existir um avião nessa posição.
					espacoAereo[i][j].setAvanca("Avanca");
				} else {
					// Nada.
				}
			}
		}
	}

	// Método complementar Atualizar EA: para verificar colisão e deixar desativado o avanço do avião mais lento.
	private void verificarColisao() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se encontrar o primeiro avião.
					// FOR para comparar a próxima posição do avião com todas as outras próximas posições dos outros aviões.
					for(int k = 0; k < espacoAereo.length; k++) {
						for(int l = 0; l < espacoAereo[0].length; l++) {

							if(espacoAereo[k][l] != null) { // Se encontrar um segundo avião.

								if((i == k) && (j == l)) {
									// Nada porque é o mesmo avião.
								} else {
									// Verifica colisão entre os dois aviões.
									if((espacoAereo[i][j].getProximoX() == espacoAereo[k][l].getProximoX()) &&
											(espacoAereo[i][j].getProximoY() == espacoAereo[k][l].getProximoY())) {

										// IF : compara a velocidade dos dois aviões.
										if(espacoAereo[i][j].getVelocidade() >= espacoAereo[k][l].getVelocidade()) {
											// Primeiro avião avança.
											espacoAereo[i][j].setAvanca("Acelera");
											// Segunda avião fica parado.
											espacoAereo[k][l].setAvanca("Diminui");
										} else {
											// Segundo avião avança.
											espacoAereo[k][l].setAvanca("Acelera");
											// Primeiro avião fica parado.
											espacoAereo[i][j].setAvanca("Diminui");
										}
									} else {
										// Nada porque ele não precisa mudar nada se os aviões não forem colidir.
									}
								}
							} else {
								// Não faz nada porque não achou nenhum avião.
							}
						}
					}
				} else {
					// Não faz nada porque não achou nenhum avião.
				}
			}
		}
	}

	// Método complementar do movimentoBaseadoNaDirecao() para verificar se a próxima posição tem algum avião antes de movimentar o avião, e depois movimentar.
	private void caminhoLivre(int i, int j) {
		if(espacoAereo[espacoAereo[i][j].getProximoX()][espacoAereo[i][j].getProximoY()] != null) {
			espacoAereo[i][j].velocDown();
		} else {
			espacoAereo[i][j].setPosicaoX(espacoAereo[i][j].getProximoX());
			espacoAereo[i][j].setPosicaoY(espacoAereo[i][j].getProximoY());
			espacoAereo[espacoAereo[i][j].getProximoX()][espacoAereo[i][j].getProximoY()] = espacoAereo[i][j];
			espacoAereo[i][j] = null;
		}
	}
	
	// Método Complementar do movimentarAvioes() ...
	private void movimentoBaseadoNaDireacao(String direcao, int i, int j) {
		switch(direcao) {
		case "DC" :
			if((espacoAereo[i][j].getProximoX() == espacoAereo.length) || (espacoAereo[i][j].getProximoY() == espacoAereo[0].length)) {
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
			break;
		case "DD" :
			if((espacoAereo[i][j].getProximoX() == -1) || (espacoAereo[i][j].getProximoY() == -1)) {
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
		case "RVC" :
			if(espacoAereo[i][j].getProximoX() == espacoAereo.length) { // ERRO : PROCUROU O METODO DE UM NULL, VER PQ.
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
			break;
		case "RVD" :
			if(espacoAereo[i][j].getProximoX() == -1) {
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
			break;
		case "RHC" :
			if(espacoAereo[i][j].getProximoY() == espacoAereo[0].length) {
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
			break;
		case "RHD" :
			if(espacoAereo[i][j].getProximoY() == -1) {
				espacoAereo[i][j] = null;
			} else {
				caminhoLivre(i, j);
			}
			break;
		default : break;
		}
	}

	// Método complementar Atualizar EA: Joga os aviões que podem, nas próximas posições.
	private void movimentarAvioes() {
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se existir um avião nessa posição.

					// SWITCH : usado para verificar o avanca e fazer as atualizações.
					switch(espacoAereo[i][j].getAvanca()) {
					case "Avanca" : 
						espacoAereo[i][j].consumoCombustivel();
						movimentoBaseadoNaDireacao(espacoAereo[i][j].getDirecaoVoo(), i, j);
						break;
					case "Acelera" :
						espacoAereo[i][j].velocUp();
						espacoAereo[i][j].consumoCombustivel();
						movimentoBaseadoNaDireacao(espacoAereo[i][j].getDirecaoVoo(), i, j);
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

	// Método para Atualizar o espaço aéreo.
	public void atualizarEspacoAereo() {

		// Achando a próxima posição de todos
		proximaPosicaoTodos();

		// Habilita o avanço de todos.
		habilitarAvanco();

		// FOR para achar cada avião e verificar se ele pode avançar ou não.
		verificarColisao();

		// Agora atualizamos as posições nos baseando no atributo avanca de cada avião.
		movimentarAvioes();
	}

	// Método para mostrar a o espaço aéreo graficamente.
	public String graficoEspacoAereo() {
		String grafico = "";
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) {
					switch(espacoAereo[i][j].getDirecaoVoo()) {
					case "DC" :
						grafico += "| ↘ ︎";
						break;
					case "DD" :
						grafico += "| ↖ ︎︎";
						break;
					case "RVC" :
						grafico += "| ↓ ︎";
						break;
					case "RVD" :
						grafico += "| ↑ ︎︎";
						break;
					case "RHC" :
						grafico += "| → ︎";
						break;
					case "RHD" :
						grafico += "| ← ︎︎";
						break;
					default : break;
					}
				} else {
					grafico += "|      ︎︎";
				}
			}
			grafico += "|\n";
		}
		return grafico;
	}

}
