
public class Controle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InteracaoUsuario iu = new InteracaoUsuario();
		EspacoAereo ea = new EspacoAereo(iu.informeInt("Informe quantas linhas o espaço aéreo deve ter:"),
										 iu.informeInt("Informe quantas colunas o espaço aéreo deve ter:"));
		
		// Criando aviões
		ea.levantandoVoo();
		
		int periodoDeTempo = iu.informeInt("Informe o período de tempo para a simulação:");
		// FOR : para a simulação em um período de tempo
		for(int i = 0; i < periodoDeTempo; i++) {
			iu.mostraMensagem(ea.graficoEspacoAereo());
			ea.atualizarEspacoAereo();
		}
		
	}

}
