package testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(final String[] args) {
		/*
		 * final InetAddress ip; try { ip = InetAddress.getLocalHost();
		 * System.out.println(ip.getHostName());
		 * System.out.println(System.getProperty("user.name"));
		 * System.out.println(ip.getHostAddress());
		 * System.out.println(System.getProperty("os.name"));
		 * System.out.println(System.getProperty("os.arch"));
		 * System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
		 * System.out.println(System.getenv("NUMBER_OF_PROCESSORS")); //
		 * System.getProperties().list(System.out); } catch (final Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		final StringBuffer output = new StringBuffer();

		Process p;
		try {
			final String comando = "wmic cpu get name";
			p = Runtime.getRuntime().exec(comando);
			p.waitFor();
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
		final String saida = output.toString();
		final StringBuilder sb = new StringBuilder();
		sb.append(saida);

		System.out.println(sb.subSequence(45, saida.length()));

	}
}
