package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Diese Klasse bildet die Grundlagen für Userinstanzen. Es ist die wichtigste Model-Klasse!
 * Auf dem User werden Userdaten, Trainingsdaten und Karteisammlungen, welche Karten enthalten, gespeichert
 * Ausserdem wird die aktive Kartei und aktive Sprache gespeichert, damit das GUI korrekt geladen wird
 * 
 * @author Thomas Brunner St.Gallen / Daniel Strassmann
 * @version 1.0 09.3.2018
 */

@XmlAccessorType(XmlAccessType.NONE)
public class User {

	/**
	 * User-Inhalt
	 * 
	 */
	private ArrayList<Kartei> userKarteien;

	private Daten userDaten;

	public String benutzername;

	private String passwort;

	private String benutzersprache;

	private Kartei aktiveKartei;

	public User() {

		userKarteien = new ArrayList<>();
		userDaten = new Daten();

	}

	public User(String username, String userpasswort, String lang) {

		benutzername = username;
		passwort = userpasswort;
		benutzersprache = lang;
		userKarteien = new ArrayList<Kartei>();
		userDaten = new Daten();

	}

	@XmlElement
	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	@XmlElement
	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@XmlElement
	public String getBenutzersprache() {
		return benutzersprache;
	}

	public void setBenutzersprache(String benutzersprache) {
		this.benutzersprache = benutzersprache;
	}

	/**
	 * holt die Karten ID der naechsten Karte
	 * 
	 * @return
	 */
	public int getNextKarteiId() {
		return 0;
	}

	/**
	 * Benutzername Passwort und Benutzersprache als String
	 * 
	 */
	public String toString() {
		return benutzername + ", " + passwort + ", " + benutzersprache;

	}

	public ArrayList<Kartei> getUserKarteien() {
		return userKarteien;
	}

	public void setUserKarteien(ArrayList<Kartei> userKarteien) {
		this.userKarteien = userKarteien;
	}

	/**
	 * fügt der Sammlung eine Kartei hinzu
	 * 
	 * @param kk
	 */
	public void karteiInSammlung(Kartei kk) {
		userKarteien.add(kk);
	}

	/**
	 * holt sich die Anzahlkarten in der Kartei
	 * 
	 * @return
	 */
	public int getAnzahlKarteienInSammlung() {
		int anzahlKarteien = userKarteien.size();
		return anzahlKarteien;
	}

	public Daten getUserDaten() {
		return userDaten;
	}

	public void setUserDaten(Daten userDaten) {
		this.userDaten = userDaten;
	}

	public void setAktiveKartei(Kartei kk) {
		// TODO Auto-generated method stub

		this.aktiveKartei = kk;

	}

	public Kartei getAktiveKartei() {
		// TODO Auto-generated method stub

		return aktiveKartei;

	}
}
