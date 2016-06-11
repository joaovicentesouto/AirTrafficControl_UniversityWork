
public class Inicializacao {

	String[] direcaoVoo = {"dc", "dd", "rvc", "rvd", "rhc", "rhd"};
	
	public Inicializacao() {
		super();
	}
	
	public String getDirecaoVoo(int i) { // Retorna apenas uma das direções e não o array.
		return direcaoVoo[i];
	}
}
