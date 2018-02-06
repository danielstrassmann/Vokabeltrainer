package Model;

import java.util.ArrayList;

public class Kartei {

	private int id;
	private ArrayList<Karte> sammlung;
	private String frage;
	private String antwort;

	public Kartei() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Karte> getSammlung() {
		return sammlung;
	}

	public void setSammlung(ArrayList<Karte> sammlung) {
		this.sammlung = sammlung;
	}

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

}
