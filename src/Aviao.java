
public class Aviao {

	private double velocidade;
	private int combustivel, linhaAtual, colunaAtual, proximaLinha, proximaColuna, tentouMudar;
	private String id, direcaoVoo, avanca;
	private boolean alertaCombustivel, jaMovimentado;

	public Aviao() { // Construtor sem parametros.
		super();
	}

	// Construtor com parametros.
	public Aviao(String id, double velocidade, int combustivel, String direcaoVoo, int linhaAtual, int colunaAtual) {
		this.id = id;
		this.velocidade = velocidade;
		this.combustivel = combustivel;
		this.direcaoVoo = direcaoVoo;
		this.linhaAtual = linhaAtual;
		this.colunaAtual = colunaAtual;
		proximaLinha = 0;
		proximaColuna = 0;
		alertaCombustivel = false;
		tentouMudar = 0;
		avanca = "Avanca";
		jaMovimentado = false;
	}

	
	
	public boolean getJaMovimentado() {
		return jaMovimentado;
	}

	public void setJaMovimentado(boolean jaMovimentado) {
		this.jaMovimentado = jaMovimentado;
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
	
	public int getTentouMudar() {
		return tentouMudar;
	}
	
	public void setTentouMudar(int tentouMudar) {
		this.tentouMudar = tentouMudar;
	}
	
	public String getAvanca() {
		return avanca;
	}
	
	public void setAvanca(String avanca) {
		this.avanca = avanca;
	}

	// Getters e setters: Posições atuais.
	public int getLinhaAtual() {
		return linhaAtual;
	}

	public void setLinhaAtual(int linhaAtual) {
		this.linhaAtual = linhaAtual;
	}

	public int getColunaAtual() {
		return colunaAtual;
	}

	public void setColunaAtual(int colunaAtual) {
		this.colunaAtual = colunaAtual;
	}

	// Getters e setters: Próximas posições.
	public int getProximaLinha() {
		return proximaLinha;
	}

	public void setProximaLinha(int proximaLinha) {
		this.proximaLinha = proximaLinha;
	}

	public int getProximaColuna() {
		return proximaColuna;
	}

	public void setProximaColuna(int proximaColuna) {
		this.proximaColuna = proximaColuna;
	}

	// Método para encontrar a próxima posição. Executado sempre que o avião for mudado para outra posição.
	public void proximaPosicao() {
		switch (this.direcaoVoo) {
		case "DC" :
			proximaLinha = linhaAtual+1;
			proximaColuna = colunaAtual+1;
			break;
		case "DD" :
			proximaLinha = linhaAtual-1;
			proximaColuna = colunaAtual-1;
			break;
		case "RVC" :
			proximaLinha = linhaAtual+1;
			proximaColuna = colunaAtual;
			break;
		case "RVD" :
			proximaLinha = linhaAtual-1;
			proximaColuna = colunaAtual;
			break;
		case "RHC" :
			proximaLinha = linhaAtual;
			proximaColuna = colunaAtual+1;
			break;
		case "RHD" :
			proximaLinha = linhaAtual;
			proximaColuna = colunaAtual-1;
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
	
	// Metodo de incremento do tentouMudar
	public void incrementoTentouMudar() {
		tentouMudar++;
	}

	@Override
	public String toString() {
		return "Aviao [velocidade=" + velocidade + ", combustivel=" + combustivel + ", linhaAtual=" + linhaAtual
				+ ", colunaAtual=" + colunaAtual + ", proximaLinha=" + proximaLinha + ", proximaColuna=" + proximaColuna
				+ ", tentouMudar=" + tentouMudar + ", id=" + id + ", direcaoVoo=" + direcaoVoo + ", avanca=" + avanca
				+ ", alertaCombustivel=" + alertaCombustivel + "]";
	}

	public boolean equals(Aviao aviaoX) {
		if (this == aviaoX)
			return true;
		if (aviaoX == null)
			return false;
		if (getClass() != aviaoX.getClass())
			return false;
		if (alertaCombustivel != aviaoX.alertaCombustivel)
			return false;
		if (avanca == null) {
			if (aviaoX.avanca != null)
				return false;
		} else if (!avanca.equals(aviaoX.avanca))
			return false;
		if (colunaAtual != aviaoX.colunaAtual)
			return false;
		if (combustivel != aviaoX.combustivel)
			return false;
		if (direcaoVoo == null) {
			if (aviaoX.direcaoVoo != null)
				return false;
		} else if (!direcaoVoo.equals(aviaoX.direcaoVoo))
			return false;
		if (id == null) {
			if (aviaoX.id != null)
				return false;
		} else if (!id.equals(aviaoX.id))
			return false;
		if (linhaAtual != aviaoX.linhaAtual)
			return false;
		if (proximaColuna != aviaoX.proximaColuna)
			return false;
		if (proximaLinha != aviaoX.proximaLinha)
			return false;
		if (tentouMudar != aviaoX.tentouMudar)
			return false;
		if (Double.doubleToLongBits(velocidade) != Double.doubleToLongBits(aviaoX.velocidade))
			return false;
		return true;
	}
	
}
