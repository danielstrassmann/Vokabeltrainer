package Model;

import java.util.ArrayList;

public class Kartei {

	private int id;
	private ArrayList<Karte> kartensammlung;
	private String frage;
	private String antwort;

	// Standardkonstruktor
	public Kartei() {
	}

	// Erstellt eine neue Kartei, wo Lernkarten abgelegt werden können
	// Die ID wird bei erst beim Ablegen der Kartei in die Sammlung des Users
	// erzeugt
	public Kartei(String frage, String antwort) {
		this.frage = frage;
		this.antwort = antwort;
		kartensammlung = new ArrayList<Karte>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Karte> getSammlung() {
		return kartensammlung;
	}

	public void karteInSammlung(Karte k) {
		kartensammlung.add(k);
	}

	public int getAnzahlKartenInSammlung() {
		int anzahlKarten = kartensammlung.size();
		return anzahlKarten;
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

	public void add(Karte k1) {
		// TODO Auto-generated method stub

	}

	public Kartei getIndex(int i) {
		return null;
	}

}
