
public class AviaoTurbo extends Aviao {

	private boolean turboLigado = false;

	public AviaoTurbo() {
		super();
	}

	public AviaoTurbo(String id, double velocidade, int combustivel, String direcaoVoo, int posicaoX, int posicaoY, boolean turboLigado){
		super(id, velocidade, combustivel, direcaoVoo, posicaoX, posicaoY);
		this.turboLigado = turboLigado;
	}

	public boolean getTurboLigado() {
		return turboLigado;
	}
	
	public void setTurboLigado(boolean turboLigado) {
		this.turboLigado = turboLigado;
	}
	
	// Generalizei o nome, como havia conversado com a professora, para que quando eu chamar
	//o metodo velocUp (que era pra ser velocTurbo()) de qualquer aviao, se ele for turbo vai
	//aumentar mais 25% a velocidade e liga o turbo, que é algo que um aviao comum só aumentar 15%, sem turbo.
	public void velocUp() {
		if(super.getVelocidade() <= 125) {
			if((super.getVelocidade()*1.15) > 125) {
				super.setVelocidade(125);
				turboLigado = true;
			} else {
				super.setVelocidade(super.getVelocidade()*1.25);
				turboLigado = true;
			}
		} else {
			// Nao faz nada, a velocidade já esta no maximo. 
		}
	}
	
	// Tambem generalizei o velocDown
	public void velocDown() {
		super.setVelocidade(super.getVelocidade()*0.75);
		turboLigado = false;
		if(super.getVelocidade() >= 10) {
			if((super.getVelocidade()*0.75) < 10) {
				super.setVelocidade(10);
				turboLigado = false;
			} else {
				super.setVelocidade(super.getVelocidade()*0.75);
				turboLigado = false;
			}
		} else {
			// Não faz nada, a velocidade já está no minimo.
		}
	}

	// toString() e equals()
	@Override
	public String toString() {
		return super.toString() + "AviaoTurbo [turboLigado=" + turboLigado + "]";
	}

	// Alterado como o outro, inclusive chamo o metodo equals do super para conferir todos os outros atributos.
	public boolean equals(AviaoTurbo aviaoT) {
		if(super.equals(aviaoT)) {
			if (this == aviaoT)
				return true;
			if (aviaoT == null)
				return false;
			if (getClass() != aviaoT.getClass())
				return false;
			if (turboLigado != aviaoT.turboLigado)
				return false;
			return true;
		} else {
			return false;
		}
	}
	
}
