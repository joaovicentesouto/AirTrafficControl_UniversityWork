import javax.swing.JOptionPane;

public class InteracaoUsuario {

	public InteracaoUsuario() {
		super();
	}
	
	public String informeString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
	
	public int informeInt(String texto) {
		return Integer.parseInt(JOptionPane.showInputDialog(texto));
	}
	
	public double informeDouble(String texto) {
		return Double.parseDouble(JOptionPane.showInputDialog(texto));
	}
	
	public void mostraMensagem(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	
}
