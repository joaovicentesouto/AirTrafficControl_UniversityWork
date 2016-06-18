
public class Controle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InteracaoUsuario iu = new InteracaoUsuario();
		EspacoAereo ea = new EspacoAereo(iu.informeInt("Informe quantas linhas o espaço aéreo deve ter:"),
				iu.informeInt("Informe quantas colunas o espaço aéreo deve ter:"));

		// Criando aviões
		ea.randomInicialDeAvioes();
		
		/* Teste colocando manualmente
		ea.inserirAviao(3, 0, "RHC", false);
		ea.inserirAviao(0, 3, "RVC", true);
		ea.inserirAviao(4, 0, "RHC", false);
		ea.inserirAviao(0, 4, "RVC", true);
		ea.inserirAviao(3, 2, "DC", false);
		ea.inserirAviao(4, 3, "RVD", true);
		ea.inserirAviao(3, 3, "RHD", false);
		ea.inserirAviao(0, 5, "RVC", true);
		ea.inserirAviao(12, 6, "RVD", false);
		ea.inserirAviao(14, 4, "RVC", true);
		ea.inserirAviao(3, 14, "RHC", false);
		ea.inserirAviao(14, 17, "RVC", true);
		iu.mostraMensagem(ea.graficoEspacoAereo());*/
		
		int periodoDeTempo = iu.informeInt("Informe o período de tempo para a simulação:");
		iu.mostraMensagem(ea.graficoEspacoAereo());
		// FOR : para a simulação em um período de tempo
		for(int i = 0; i < periodoDeTempo; i++) {
			ea.atualizarEspacoAereo();
			iu.mostraMensagem(ea.graficoEspacoAereo());
		}
		
		iu.mostraMensagem("Quantidade total de aviões criados: " + ea.getQuantTotalAvioes() + "\n"
				+ "Quantidade total de aviões que sairam: " + ea.getQuantAvioesSairam() + "\n\n"
						+ "Aviões que mudaram de rota: \n" + ea.getAvioesMudaramDirecao());

	}

}
