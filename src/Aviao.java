
public class Aviao {

	private double velocidade;
	private int combustivel, posicaoX, posicaoY;
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
	
	public void proximaPosicao() {
		switch (this.direcaoVoo) {
		case "dc" :
			break;
		case "dd" :
			break;
		case "rvc" :
			break;
		case "rvd" :
			break;
		case "rhc" : 
			break;
		case "rhd" :
			break;
		default : break;
		}
	}
	
}
