package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;

public class ColetarDados {
	InetAddress ip;

	public String getHostName() {
		return this.ip.getHostName();
	}

	public String getNomeUsuario() {
		return System.getProperty("user.name");
	}

	public String getHostAddress() {
		return this.ip.getHostAddress();
	}

	public String getSO() {
		return System.getProperty("os.name");
	}

	public String getArquitetura() {
		return System.getProperty("os.arch");
	}

	public String getCpuModel() throws Exception {
		final String comando = "wmic cpu get name";
		final Process p = Runtime.getRuntime().exec(comando);
		final BufferedReader leitor = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		leitor.readLine();
		leitor.readLine();
		final String retorno = leitor.readLine();
		leitor.close();
		return retorno;
	}

	public void listaSoftware(final Maquina maquina) throws Exception {
		new File("C:\\temp").mkdir();
		final String arquivo = "C:\\temp\\resultado.txt";
		final File f = new File(arquivo + ".done");
		final ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe",
				"/c",
				"reg query HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall /s /v DisplayName>C:\\temp\\resultado.txt && echo >C:\\temp\\resultado.txt.done");
		builder.redirectErrorStream(true);
		builder.start();

		while (!f.exists()) {
			Thread.sleep(10);
		}
		final BufferedReader leitor = new BufferedReader(
				new FileReader(arquivo));
		leitor.readLine();
		String line = leitor.readLine();
		while (line != null) {

			if (line.contains("Corel")) {
				maquina.sft.setCorel(true);
			}
			if (line.contains("AutoCad")) {
				maquina.sft.setAutoCad(true);
			}
			if (line.contains("Microsoft Office")) {
				maquina.sft.setOffice(true);
			}
			line = leitor.readLine();
			if (maquina.sft.allDone()) {
				line = null;
			}
		}

		leitor.close();
		new ProcessBuilder("cmd.exe", "/c", "del " + arquivo + ".done").start();
		new ProcessBuilder("cmd.exe", "/c", "del " + arquivo).start();

	}

	public int getMemoriaTotal() throws Exception {
		final String comando = "wmic memorychip get capacity";
		final Process p = Runtime.getRuntime().exec(comando);
		final BufferedReader leitor = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		leitor.readLine();
		String line = leitor.readLine();
		BigInteger memoria = BigInteger.valueOf(0);
		while (line != null) {
			line = line.replaceAll(" ", "");
			if (!line.equals("")) {
				memoria = memoria.add(BigInteger.valueOf(Long.parseLong(line)));
			}
			line = leitor.readLine();
		}
		return memoria.divide(BigInteger.valueOf(1048576)).intValue();
	}

	public ColetarDados() throws Exception {
		this.ip = InetAddress.getLocalHost();
	}
}
