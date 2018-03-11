package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Diese Klasse wird für den User gebraucht
 * 
 * @author Thomas Brunner St.Gallen / Daniel Strassmann
 * @version 1.0 09.3.2018
 */

@XmlAccessorType(XmlAccessType.NONE)
public class User {

	// User Inhalt
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

	// holt den Benutzernamen
	@XmlElement
	public String getBenutzername() {
		return benutzername;
	}
	
	// setzt den Benutzernamen
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	// holt das Passwort
	@XmlElement
	public String getPasswort() {
		return passwort;
	}

	// setzt das Passwort
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	//holt die Benutztersprache
	@XmlElement
	public String getBenutzersprache() {
		return benutzersprache;
	}

	//setzt die Benutzersprache
	public void setBenutzersprache(String benutzersprache) {
		this.benutzersprache = benutzersprache;
	}

	// holt die Karten ID der naechsten Karte
	public int getNextKarteiId() {
		return 0; // todo letztes element von liste + 1 oder wenn liste leer 1
	}

	// Benutzername Passwort und Benutzersprache als String
	public String toString() {
		return benutzername + ", " + passwort + ", " + benutzersprache;

	}

	//holt sich userKarteien aus der AL
	public ArrayList<Kartei> getUserKarteien() {
		return userKarteien;
	}

	//setzt die UserKartei
	public void setUserKarteien(ArrayList<Kartei> userKarteien) {
		this.userKarteien = userKarteien;
	}

	// fügt der Sammlung eine Kartei hinzu
	public void karteiInSammlung(Kartei kk) {
		userKarteien.add(kk);
	}

	//holt sich die Anzahlkarten in der Kartei
	public int getAnzahlKarteienInSammlung() {
		int anzahlKarteien = userKarteien.size();
		return anzahlKarteien;
	}

	// holt sich die UserDaten
	public Daten getUserDaten() {
		return userDaten;
	}

	// setzt die UserDaten
	public void setUserDaten(Daten userDaten) {
		this.userDaten = userDaten;
	}

	//setzt eine Kartei aktiv
	public void setAktiveKartei(Kartei kk) {
		// TODO Auto-generated method stub

		this.aktiveKartei = kk;

	}

	//holt die Aktive Kartei
	public Kartei getAktiveKartei() {
		// TODO Auto-generated method stub

		return aktiveKartei;

	}
}
