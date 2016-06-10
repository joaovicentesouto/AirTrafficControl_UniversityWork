
public class EspacoAereo {

	private Aviao[][] espacoAereo;
	
	public EspacoAereo() {
		super();
	}
	
	public EspacoAereo(Aviao[][] espacoAereo) {
		this.espacoAereo = espacoAereo;
	}
	
	public EspacoAereo(int tamanhoX, int tamanhoY) {
		espacoAereo = new Aviao[tamanhoX][tamanhoY];
	}
	
	public Aviao[][] getEspacoAereo() {
		return espacoAereo;
	}
	
	public Aviao getAviao(int posicaoX, int posicaoY) {
		return espacoAereo[posicaoX][posicaoY];
	}
	
	// Método para generalizar a locomoção do avião. Pega a direcão do avião e define a proxima posicao --- FAZER ISSO NO ESPAÇO AEREO.
	
}
