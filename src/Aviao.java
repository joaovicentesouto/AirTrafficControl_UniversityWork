
public class Aviao {

	private double velocidade;
	private int combustivel, posicaoX, posicaoY, proximoX, proximoY;
	private String id, direcaoVoo, avanca;
	private boolean alertaCombustivel;

	public Aviao() { // Construtor sem parametros.
		super();
	}

	// Construtor com parametros.
	public Aviao(String id, double velocidade, int combustivel, String direcaoVoo, int posicaoX, int posicaoY) {
		this.id = id;
		this.velocidade = velocidade;
		this.combustivel = combustivel;
		this.direcaoVoo = direcaoVoo;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		proximoX = 0;
		proximoY = 0;
		alertaCombustivel = false;
		avanca = "Avanca";
	}

	// Getters e setters.
	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDirecaoVoo() {
		return direcaoVoo;
	}

	public void setDirecaoVoo(String direcaoVoo) {
		this.direcaoVoo = direcaoVoo;
	}
	
	public boolean getAlertaCombustivel() {
		return alertaCombustivel;
	}
	
	public void setAlertaCombustivel(boolean alertaCombustivel) {
		this.alertaCombustivel = alertaCombustivel;
	}
	
	public String getAvanca() {
		return avanca;
	}
	
	public void setAvanca(String avanca) {
		this.avanca = avanca;
	}

	// Getters e setters: Posições atuais.
	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	// Getters e setters: Próximas posições.
	public int getProximoX() {
		return proximoX;
	}

	public void setProximoX(int proximoX) {
		this.proximoX = proximoX;
	}

	public int getProximoY() {
		return proximoY;
	}

	public void setProximoY(int proximoY) {
		this.proximoY = proximoY;
	}

	// Método para encontrar a próxima posição. Executado sempre que o avião for mudado para outra posição.
	public void proximaPosicao() {
		switch (this.direcaoVoo) {
		case "DC" :
			proximoX = posicaoX+1;
			proximoY = posicaoY+1;
			break;
		case "DD" :
			proximoX = posicaoX-1;
			proximoY = posicaoY-1;
			break;
		case "RVC" :
			proximoX = posicaoX;
			proximoY = posicaoY+1;
			break;
		case "RVD" :
			proximoX = posicaoX;
			proximoY = posicaoY-1;
			break;
		case "RHC" :
			proximoX = posicaoX+1;
			proximoY = posicaoY;
			break;
		case "RHD" :
			proximoX = posicaoX-1;
			proximoY = posicaoY;
			break;
		default : break;
		}
	}
	
	// Método para almentar a velocidade em 15%
	public void velocUp() {
		if(velocidade <= 100) {
			if((velocidade*1.15) > 100) {
				velocidade = 100;
			} else {
				velocidade *= 1.15;
			}
		} else {
			// Não faz nada, a velocidade já está no máximo. 
		}
	}
	
	// Método para diminuir a velocidade em 15%
	public void velocDown() {
		if(velocidade >= 10) {
			if((velocidade*0.85) < 10) {
				velocidade = 10;
			} else {
				velocidade *= 0.85;
			}
		} else {
			// Não faz nada, a velocidade já está no minimo.
		}
	}
	
	// Método consumo do combustível.
	public void consumoCombustivel() {
		combustivel--;
		if(combustivel <= 10) {
			alertaCombustivel = true;
		}
	}
	
	
	
}
