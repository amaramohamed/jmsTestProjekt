package de.mohamed.test.domain;

public class Objekt {

	private int id;
	private String inhalt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Objekt(int id, String inhalt) {
		this.id = id;
		this.inhalt = inhalt;
	}

	public Objekt() {
	}

	@Override
	public String toString() {
		return "Objekt [id=" + id + ", inhalt=" + inhalt + "]";
	}

}
