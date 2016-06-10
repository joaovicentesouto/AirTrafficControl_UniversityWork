
public class AviaoTurbo extends Aviao {

	boolean turbo = true;

	public AviaoTurbo() {
		super();
	}

	public AviaoTurbo(String id, double velocidade, int combustivel, String direcaoVoo, int posicaoX, int posicaoY){
		super(id, velocidade, combustivel, direcaoVoo, posicaoX, posicaoY);
	}

	public void velocTurbo() {
		super.setVelocidade(super.getVelocidade()*1.25);
	}

	

}
