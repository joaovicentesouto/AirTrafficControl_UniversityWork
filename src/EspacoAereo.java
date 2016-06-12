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
	
	// Método de povoamento
	public void levantandoVoo() {
		Inicializacao in = new Inicializacao();
		Random gerador = new Random();
		int quantMax = ((espacoAereo.length*espacoAereo[0].length)/3);
		
		for(int i = 0; i < quantMax; i++){
			String direcaoFinalVoo = null;
			int posicaoFinalX = 0, posicaoFinalY = 0;
			boolean rotaOcupada = true, aviaoTurbo = false;
			
			// switch para gerar um avião turbo ou normal aleatoriamente.
			switch(gerador.nextInt(2)) {
			case 0 : // Avião normal
				do { // DO WHILE para verificar se posso colocar um avião em determinada rota.
					String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
					int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
					int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
					switch(direcaoPossivelVoo) {
					case "DC" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Esse IF verifica qual é maior para definir qual vai ser a posicao inicial da rota.
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) { // FOR varre a diagonal procurando um avião.
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) { // caso ele ache um avião a rota está ocupada e ele para de procurar.
										rotaOcupada = true;
										break;
									} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
										rotaOcupada = false;
										aviaoTurbo = false;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						} else {
							for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) { // Mesma coisa do outro FOR
								for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = false;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "DD" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Mesma lógica para a diagonal crescente
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = false;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						} else {
							for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
								for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = false;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "RVC" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RVD" : // Mesma coisa do RVD.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RHC" : // FOR : varrer uma linha para descobrir se a rota está vazia.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RHD" : // Mesca coisa do RHD.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					default : break;
					}
				} while(rotaOcupada);
				break;
			case 1 : // Avião turbo
				do { // DO WHILE para verificar se posso colocar um avião em determinada rota.
					String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
					int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
					int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
					switch(direcaoPossivelVoo) {
					case "DC" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Esse IF verifica qual é maior para definir qual vai ser a posicao inicial da rota.
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) { // FOR varre a diagonal procurando um avião.
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) { // caso ele ache um avião a rota está ocupada e ele para de procurar.
										rotaOcupada = true;
										break;
									} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
										rotaOcupada = false;
										aviaoTurbo = true;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						} else {
							for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) { // Mesma coisa do outro FOR
								for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = true;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "DD" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Mesma lógica para a diagonal crescente
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = true;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						} else {
							for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
								for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
										rotaOcupada = true;
										break;
									} else {
										rotaOcupada = false;
										aviaoTurbo = true;
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "RVC" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = true;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RVD" : // Mesma coisa do RVD.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = true;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RHC" : // FOR : varrer uma linha para descobrir se a rota está vazia.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = true;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "RHD" : // Mesca coisa do RHD.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								aviaoTurbo = true;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					default : break;
					}
				} while(rotaOcupada);
				break;
			default : break;
			}
			
			// Definindo o combustivelMax.
			int combustivelMax;
			if(espacoAereo.length >= espacoAereo[0].length) {
				combustivelMax = espacoAereo.length+10;
			} else {
				combustivelMax = espacoAereo[0].length+10;
			}
			
			// Criando avião.
			if(aviaoTurbo) {
				// Criando o avião turbo e jogando ele na matriz (espaco aéreo).
				AviaoTurbo av = new AviaoTurbo(("Av_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY, false);
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
	public void entrandoAviao() {
		Inicializacao in = new Inicializacao();
		Random gerador = new Random();

		String direcaoFinalVoo = null;
		int posicaoFinalX = 0, posicaoFinalY = 0;
		boolean rotaOcupada = true, aviaoTurbo = false;

		// Mesmo conceito de gerar n avioes aleatórios porém aqui se cria apenas um, e a posição inicial é sempre em alguma borda.
		switch(gerador.nextInt(2)) {
		case 0 : // Avião normal
			do {
				String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
				int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
				int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
				
				switch(direcaoPossivelVoo) {
				case "DC" :
					if(possivelPosicaoX <= possivelPosicaoY) {

						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = false;
									posicaoFinalX = 0;
									posicaoFinalY = possivelPosicaoY-possivelPosicaoX;
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					} else {
						for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = false;
									posicaoFinalX = possivelPosicaoX-possivelPosicaoY;
									posicaoFinalY = 0;
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					}
					break;
				case "DD" :
					if((espacoAereo.length-possivelPosicaoX) <= (espacoAereo[0].length-possivelPosicaoY)) {

						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = false;
									posicaoFinalX = possivelPosicaoX+(espacoAereo[0].length-possivelPosicaoY);
									posicaoFinalY = possivelPosicaoY+(espacoAereo[0].length-possivelPosicaoY);
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					} else {
						for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = false;
									posicaoFinalX = possivelPosicaoX+(espacoAereo.length-possivelPosicaoX);
									posicaoFinalY = possivelPosicaoY+(espacoAereo.length-possivelPosicaoX);
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					}
					break;
				case "RVC" :
					for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
						if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = false;
							posicaoFinalX = 0;
							posicaoFinalY = possivelPosicaoY;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RVD" :
					for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
						if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = false;
							posicaoFinalX = espacoAereo.length-1;
							posicaoFinalY = possivelPosicaoY;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RHC" :
					for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
						if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = false;
							posicaoFinalX = possivelPosicaoX;
							posicaoFinalY = 0;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RHD" :
					for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
						if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = false;
							posicaoFinalX = possivelPosicaoX;
							posicaoFinalY = espacoAereo[0].length-1;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				default : break;
				}
			} while(rotaOcupada);
			break;
		case 1 : // Avião turbo
			do {
				String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
				int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
				int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
				
				switch(direcaoPossivelVoo) {
				case "DC" :
					if(possivelPosicaoX <= possivelPosicaoY) {

						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = true;
									posicaoFinalX = 0;
									posicaoFinalY = possivelPosicaoY-possivelPosicaoX;
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					} else {
						for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = true;
									posicaoFinalX = possivelPosicaoX-possivelPosicaoY;
									posicaoFinalY = 0;
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					}
					break;
				case "DD" :
					if((espacoAereo.length-possivelPosicaoX) <= (espacoAereo[0].length-possivelPosicaoY)) {

						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = true;
									posicaoFinalX = possivelPosicaoX+(espacoAereo[0].length-possivelPosicaoY);
									posicaoFinalY = possivelPosicaoY+(espacoAereo[0].length-possivelPosicaoY);
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					} else {
						for(int inicioRotaX = possivelPosicaoX-possivelPosicaoY; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							for(int inicioRotaY = 0; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
								if(espacoAereo[inicioRotaX][inicioRotaY] != null) {
									rotaOcupada = true;
									break;
								} else {
									rotaOcupada = false;
									aviaoTurbo = true;
									posicaoFinalX = possivelPosicaoX+(espacoAereo.length-possivelPosicaoX);
									posicaoFinalY = possivelPosicaoY+(espacoAereo.length-possivelPosicaoX);
									direcaoFinalVoo = direcaoPossivelVoo;
								}
							}
						}
					}
					break;
				case "RVC" :
					for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
						if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = true;
							posicaoFinalX = 0;
							posicaoFinalY = possivelPosicaoY;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RVD" :
					for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
						if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = true;
							posicaoFinalX = espacoAereo.length-1;
							posicaoFinalY = possivelPosicaoY;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RHC" :
					for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
						if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = true;
							posicaoFinalX = possivelPosicaoX;
							posicaoFinalY = 0;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				case "RHD" :
					for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
						if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
							rotaOcupada = true;
							break;
						} else {
							rotaOcupada = false;
							aviaoTurbo = true;
							posicaoFinalX = possivelPosicaoX;
							posicaoFinalY = espacoAereo[0].length-1;
							direcaoFinalVoo = direcaoPossivelVoo;
						}
					}
					break;
				default : break;
				}
			} while(rotaOcupada);
			break;
		default : break;
		}

		// Definindo o combustivelMax.
		int combustivelMax;
		if(espacoAereo.length >= espacoAereo[0].length) {
			combustivelMax = espacoAereo.length+10;
		} else {
			combustivelMax = espacoAereo[0].length+10;
		}

		// Criando avião.
		if(aviaoTurbo) {
			// Criando o avião turbo e jogando ele na matriz (espaco aéreo).
			AviaoTurbo av = new AviaoTurbo(("Av_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY, false);
			espacoAereo[posicaoFinalX][posicaoFinalY] = av;
			quantTotalAvioes++;
		} else {
			// Criando o avião e jogando ele na matriz (espaco aéreo).
			Aviao av = new Aviao(("Av_" + (quantTotalAvioes+1)), 75, combustivelMax, direcaoFinalVoo, posicaoFinalX, posicaoFinalY);
			espacoAereo[posicaoFinalX][posicaoFinalY] = av;
			quantTotalAvioes++;
		}
	}
	
	// Método para atualizar a próxima posição de todos os aviões.
	public void proximaPosicaoTodos() {
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
	
	// Método para Atualizar o espaço aéreo.
	public void atualizarEspacoAereo() {
		
		// Atualiza todos para avanca(PODE AVANÇAR). Toda vez que executar esse método todos os aviões tem que estar
		// prontos para avançar pq ele a seguir só altera se houver colisão. Logo se não houver e estiver como FIQUE PARADO
		// o avião não avançaria mesmo podendo.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se existir um avião nessa posição.

					// SWITCH : usado para verificar o avanca e fazer as atualizações.
					switch(espacoAereo[i][j].getAvanca()) {
					case "Avanca" : 
						// Não precisa alterar nada.
						break;
					case "Acelera" :
						espacoAereo[i][j].setAvanca("Avanca");
						break;
					case "Diminui" : 
						espacoAereo[i][j].setAvanca("Avanca");
						break;
					}
				} else {
					// Nada.
				}
			}
		}
		
		// FOR para achar cada avião e verificar se ele pode avançar ou não.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se encontrar o primeiro avião.
					// FOR para comparar a próxima posição do avião com todas as outras próximas posições dos outros aviões.
					for(int k = 0; k < espacoAereo.length; k++) {
						for(int l = 0; l < espacoAereo[0].length; l++) {
							
							if(espacoAereo[k][l] != null) { // Se encontrar um segundo avião.
								
								if((i != k) && (j != l)) {
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
								} else {
									// Nada porque é o mesmo avião.
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
		
		// Agora atualizamos as posições nos baseando no atributo avanca de cada avião.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null) { // Se existir um avião nessa posição.
					
					// SWITCH : usado para verificar o avanca e fazer as atualizações.
					switch(espacoAereo[i][j].getAvanca()) {
					case "Avanca" : 
						espacoAereo[i][j].consumoCombustivel();
						espacoAereo[espacoAereo[i][j].getProximoX()][espacoAereo[i][j].getProximoY()] = espacoAereo[i][j];
						espacoAereo[i][j] = null;
						break;
					case "Acelera" :
						espacoAereo[i][j].velocUp();
						espacoAereo[i][j].consumoCombustivel();
						espacoAereo[espacoAereo[i][j].getProximoX()][espacoAereo[i][j].getProximoY()] = espacoAereo[i][j];
						espacoAereo[i][j] = null;
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
		
		// Atualizar a próxima posição de cada avião.
		for(int i = 0; i < espacoAereo.length; i++) {
			for(int j = 0; j < espacoAereo[0].length; j++) {
				if(espacoAereo[i][j] != null){
					espacoAereo[i][j].proximaPosicao();
				}
			}
		}
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
					grafico += "|   ︎︎";
				}
			}
			grafico += "|\n";
		}
		return grafico;
	}
	
}
