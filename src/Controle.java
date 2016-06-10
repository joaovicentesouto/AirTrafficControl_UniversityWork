
public class Controle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aviao aviao = new Aviao("01", 90, 100, "rhc", 0, 0);

		System.out.println("1 - " + aviao.getProximoX());
		System.out.println("1 - " + aviao.getProximoY());
		aviao.proximaPosicao();

		System.out.println("2 - " + aviao.getProximoX());
		System.out.println("2 - " + aviao.getProximoY());


	}

}
