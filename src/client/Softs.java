package client;

import java.util.List;

public class Softs {
	private List<Software> softwareList;
	private boolean office, corel, autoCad;

	public boolean isOffice() {
		return this.office;
	}

	public void setOffice(final boolean office) {
		this.office = office;
	}

	public boolean isCorel() {
		return this.corel;
	}

	public void setCorel(final boolean corel) {
		this.corel = corel;
	}

	public boolean isAutoCad() {
		return this.autoCad;
	}

	public void setAutoCad(final boolean autoCad) {
		this.autoCad = autoCad;
	}

	public boolean allDone() {
		return this.office && this.corel && this.autoCad;
	}

}