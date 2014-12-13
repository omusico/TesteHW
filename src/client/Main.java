package client;

public class Main {

	public static void main(final String[] args) {
		final Maquina maquina = new Maquina();
		final ColetarDados dados;
		try {
			dados = new ColetarDados();
			maquina.setNomeMaquina(dados.getHostName());
			maquina.setUsuario(dados.getNomeUsuario());
			maquina.setIp(dados.getHostAddress());
			maquina.setSistemaOperacional(dados.getSO());
			maquina.setAquitetura(dados.getArquitetura());
			maquina.setProcessador(dados.getCpuModel());
			dados.listaSoftware(maquina);
			maquina.setMemoria(dados.getMemoriaTotal());
		} catch (final Exception e) {
			e.printStackTrace();
		}

		System.out.println(maquina.sft.isCorel());
		System.out.println(maquina.sft.isAutoCad());
		System.out.println(maquina.sft.isOffice());
		System.out.println(maquina.getAquitetura());
		System.out.println(maquina.getIp());
		System.out.println(maquina.getNomeMaquina());
		System.out.println(maquina.getProcessador());
		System.out.println(maquina.getSistemaOperacional());
		System.out.println(maquina.getUsuario());
		System.out.println(maquina.getMemoria());

	}
}
