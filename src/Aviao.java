
public class Aviao {

	private double velocidade;
	private int combustivel, posicaoX, posicaoY, proximoX, proximoY;
	private String id, direcaoVoo;

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

	public void proximaPosicao() {
		switch (this.direcaoVoo) {
		case "dc" :
			proximoX = posicaoX-1;
			proximoY = posicaoY-1;
			break;
		case "dd" :
			proximoX = posicaoX+1;
			proximoY = posicaoY+1;
			break;
		case "rvc" :
			proximoX = posicaoX;
			proximoY = posicaoY+1;
			break;
		case "rvd" :
			proximoX = posicaoX;
			proximoY = posicaoY-1;
			break;
		case "rhc" :
			proximoX = posicaoX+1;
			proximoY = posicaoY;
			break;
		case "rhd" :
			proximoX = posicaoX-1;
			proximoY = posicaoY;
			break;
		default : break;
		}
	}

}
