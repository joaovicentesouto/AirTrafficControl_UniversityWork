
public class AviaoTurbo extends Aviao {

	private boolean turboLigado = false;

	public AviaoTurbo() {
		super();
	}

	public AviaoTurbo(String id, double velocidade, int combustivel, String direcaoVoo, int posicaoX, int posicaoY){
		super(id, velocidade, combustivel, direcaoVoo, posicaoX, posicaoY);
	}

	public boolean getTurboLigado() {
		return turboLigado;
	}
	
	public void setTurboLigado(boolean turboLigado) {
		this.turboLigado = turboLigado;
	}
	
	public void velocTurbo() {
		super.setVelocidade(super.getVelocidade()*1.25);
		turboLigado = true;
	}
	
	public void VelocTurboDesligar() {
		super.setVelocidade(super.getVelocidade()*0.75);
		turboLigado = false;
	}

	

}
