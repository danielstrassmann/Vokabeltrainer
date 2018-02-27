package Model;

import java.util.ArrayList;

public class Kartei {

	private int id;
	private ArrayList<Karte> kartensammlung;
	private String frageKartei;
	private String antwortKartei;

	// Standardkonstruktor
	public Kartei() {
	}

	// Erstellt eine neue Kartei, wo Lernkarten abgelegt werden können
	// Die ID wird bei erst beim Ablegen der Kartei in die Sammlung des Users
	// erzeugt
	public Kartei(String frage, String antwort) {
		this.frageKartei = frage;
		this.antwortKartei = antwort;
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
	
	public void setSammlung(ArrayList<Karte> kartensammlung) {
		this.kartensammlung = kartensammlung;
	}

	public void karteInSammlung(Karte k) {
		kartensammlung.add(k);
	}

	public int getAnzahlKartenInSammlung() {
		int anzahlKarten = kartensammlung.size();
		return anzahlKarten;
	}

	public String getFrage() {
		return frageKartei;
	}

	public void setFrage(String frage) {
		this.frageKartei = frage;
	}

	public String getAntwort() {
		return antwortKartei;
	}

	public void setAntwort(String antwort) {
		this.antwortKartei = antwort;
	}

	public void add(Karte k1) {
		// TODO Auto-generated method stub

	}

	public Karte getIndex(int i) {
		return kartensammlung.get(i);
	}

	public Karte remove(int i) {
		return kartensammlung.remove(i);
	}
	public String toString() {
		return (frageKartei +" - " + antwortKartei);
	}
}
