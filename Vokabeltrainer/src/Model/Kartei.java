package Model;

/**
 * Diese Klasse ist Grundlage f�r Karteiinstanzen. Jedes Attribut kann mit Getter- und Setter-Methoden ver�ndert werden.
 * Eine Kartei besitzt eine Sammlung vom Typ Karte
 * 
 * @author Thomas Brunner St.Gallen / Daniel Strassmann
 * @version 1.0 09.3.2018
 */

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Kartei {

	private int id;
	private ArrayList<Karte> kartensammlung;
	private String frageKartei;
	private String antwortKartei;

	/**
	 * Standardkonstruktor
	 * 
	 */
	public Kartei() {

		kartensammlung = new ArrayList<>();

	}

	/**
	 * Erstellt eine neue Kartei, wo Lernkarten abgelegt werden k�nnen Die ID wird
	 * bei erst beim Ablegen der Kartei in die Sammlung des Users erzeugt
	 * 
	 * @param frage
	 *            Quellsprache der Kartei
	 * @param antwort
	 *            Zielsprache der Datei
	 */
	public Kartei(String frage, String antwort) {
		this.frageKartei = frage;
		this.antwortKartei = antwort;
		kartensammlung = new ArrayList<Karte>();
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
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

	@XmlElement
	public String getFrage() {
		return frageKartei;
	}

	public void setFrage(String frage) {
		this.frageKartei = frage;
	}

	@XmlElement
	public String getAntwort() {
		return antwortKartei;
	}

	public void setAntwort(String antwort) {
		this.antwortKartei = antwort;
	}

	public void add(Karte k1) {
		kartensammlung.add(k1);
	}

	public Karte getIndex(int i) {
		return kartensammlung.get(i);
	}

	public Karte remove(int i) {
		return kartensammlung.remove(i);
	}

	public String toString() {
		return (frageKartei + " - " + antwortKartei);
	}
}
