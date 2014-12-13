package client;

public class Maquina {
	private String nomeMaquina;
	private String usuario;
	public Softs sft;
	private String ip;
	private String sistemaOperacional;
	private String aquitetura;
	private String Processador;
	private int memoria;

	public String getNomeMaquina() {
		return this.nomeMaquina;
	}

	public void setNomeMaquina(final String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	public void setIp(final String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public String getSistemaOperacional() {
		return this.sistemaOperacional;
	}

	public void setSistemaOperacional(final String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getAquitetura() {
		return this.aquitetura;
	}

	public void setAquitetura(final String aquitetura) {
		this.aquitetura = aquitetura;
	}

	public void setProcessador(final String processador) {
		this.Processador = processador;
	}

	public String getProcessador() {
		return this.Processador;
	}

	public void setMemoria(final int memoria) {
		this.memoria = memoria;
	}

	public int getMemoria() {
		return this.memoria;
	}

	public Maquina() {
		this.sft = new Softs();
	}

}
