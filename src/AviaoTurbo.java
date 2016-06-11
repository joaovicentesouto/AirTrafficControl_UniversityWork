
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
	
	// Generalizei o nome para que quando eu chamar o método velocUp de qualquer avião, se ele for turbo vai aumentar mais 25%
	// a velocidade e liga o turbo, que é algo que um avião comum só aumentar 15%, sem turbo.
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
			// Não faz nada, a velocidade já está no máximo. 
		}
	}
	
	// Também generalizei o velocDown
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

	

}
