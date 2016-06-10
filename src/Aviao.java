
public class Aviao {

	private double velocidade;
	private int combustivel;
	private String direcaoVoo;
	private int[] proximaPosicao = new int[2];
	
	public Aviao() { // Construtor sem parametros.
		super();
	}
	
	// Construtor com parametros.
	public Aviao(double velocidade, int combustivel, String direcaoVoo, int proximoX, int proximoY) {
		this.velocidade = velocidade;
		this.combustivel = combustivel;
		this.direcaoVoo = direcaoVoo;
		proximaPosicao[0] = proximoX;
		proximaPosicao[1] = proximoY;
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

	public String getDirecaoVoo() {
		return direcaoVoo;
	}

	public void setDirecaoVoo(String direcaoVoo) {
		this.direcaoVoo = direcaoVoo;
	}

	public int[] getProximaPosicao() {
		return proximaPosicao;
	}

	public void setProximaPosicao(int[] proximaPosicao) {
		this.proximaPosicao = proximaPosicao;
	}
	
	// Getters da proxima posição X e Y
	public int getProximaPosicaoX() {
		return proximaPosicao[0];
	}
	
	public int getProximaPosicaoY() {
		return proximaPosicao[1];
	}
	
	
	
}
