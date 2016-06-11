
public class Inicializacao {

	String[] direcaoVoo = {"DC", "DD", "RVC", "RVD", "RHC", "RHD"};
	
	public Inicializacao() {
		super();
	}
	
	public String getDirecaoVoo(int i) { // Retorna apenas uma das direções e não o array.
		return direcaoVoo[i];
	}
}
