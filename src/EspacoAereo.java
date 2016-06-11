import java.util.Random;

public class EspacoAereo {

	private Aviao[][] espacoAereo;
	
	public EspacoAereo() {
		super();
	}
	
	public EspacoAereo(Aviao[][] espacoAereo) {
		this.espacoAereo = espacoAereo;
	}
	
	public EspacoAereo(int tamanhoX, int tamanhoY) {
		espacoAereo = new Aviao[tamanhoX][tamanhoY];
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
			// switch para gerar um avião turbo ou normal aleatoriamente.
			switch(gerador.nextInt(2)) {
			case 0 : // Avião normal
				String direcaoFinalVoo;
				int posicaoFinalX, posicaoFinalY;
				boolean rotaOcupada = true;
				
				do { // DO WHILE para verificar se posso colocar um avião em determinada rota.
					String direcaoPossivelVoo = in.getDirecaoVoo(gerador.nextInt(5));
					int possivelPosicaoX = gerador.nextInt(espacoAereo.length);
					int possivelPosicaoY = gerador.nextInt(espacoAereo[0].length);
					switch(direcaoPossivelVoo) {
					case "dc" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Esse IF verifica qual é maior para definir qual vai ser a posicao inicial da rota.
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) { // FOR varre a diagonal procurando um avião.
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) { // caso ele ache um avião a rota está ocupada e ele para de procurar.
										rotaOcupada = true;
										break;
									} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
										rotaOcupada = false;
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
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "dd" :
						if(possivelPosicaoX <= possivelPosicaoY) { // Mesma lógica para a diagonal crescente
							
							for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) { // FOR varre a diagonal procurando um avião.
								for(int inicioRotaY = possivelPosicaoY-possivelPosicaoX; inicioRotaY < espacoAereo[0].length; inicioRotaY++) {
									if(espacoAereo[inicioRotaX][inicioRotaY] != null) { // caso ele ache um avião a rota está ocupada e ele para de procurar.
										rotaOcupada = true;
										break;
									} else { // caso todas as posicões estejam vazias ele, ele termina com a rota false e passa adiante a posicao.
										rotaOcupada = false;
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
										posicaoFinalX = possivelPosicaoX;
										posicaoFinalY = possivelPosicaoY;
										direcaoFinalVoo = direcaoPossivelVoo;
									}
								}
							}
						}
						break;
					case "rvc" : // FOR : varrer uma coluna para descobrir se a rota está vazia.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "rvd" : // Mesma coisa do RVD.
						for(int inicioRotaX = 0; inicioRotaX < espacoAereo.length; inicioRotaX++) {
							if(espacoAereo[inicioRotaX][possivelPosicaoY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "rhc" : // FOR : varrer uma linha para descobrir se a rota está vazia.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
								posicaoFinalX = possivelPosicaoX;
								posicaoFinalY = possivelPosicaoY;
								direcaoFinalVoo = direcaoPossivelVoo;
							}
						}
						break;
					case "rhd" : // Mesca coisa do RHD.
						for(int inicioRotaY = 0; inicioRotaY < espacoAereo.length; inicioRotaY++) {
							if(espacoAereo[possivelPosicaoX][inicioRotaY] != null) {
								rotaOcupada = true;
								break;
							} else {
								rotaOcupada = false;
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
				break;
				default : break;
			}	
		}
		
		
	}
	
}
