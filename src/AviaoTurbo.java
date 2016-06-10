
public class AviaoTurbo extends Aviao {

	boolean turbo = true;
	
	public AviaoTurbo() {
		super();
	}
	
	public AviaoTurbo(double velocidade, int combustivel, String direcaoVoo, int proximoX, int proximoY){
		super(velocidade, combustivel, direcaoVoo, proximoX, proximoY);
	}
	
	public void velocTurbo() {
		super.setVelocidade(super.getVelocidade()*1.25);
	}
	
	
	
}
