package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.NONE)
public class User {

	
	private ArrayList<Kartei> userKarteien;
	
	private Daten userDaten;

	public String benutzername;

	private String passwort;

	private String benutzersprache;

	public User() {

	}

	public User(String username, String userpasswort, String lang) {

		benutzername = username;
		passwort = userpasswort;
		/// generiert neue Usersprache nur provisorisch
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


	public int getNextKarteiId() {
		return 0; //todo letztes element von liste + 1 oder wenn liste leer 1
	}
	
	public String toString() {
		return benutzername + ", " + passwort + ", " + benutzersprache;

	}

	public ArrayList<Kartei> getUserKarteien() {
		return userKarteien;
	}

	public void setUserKarteien(ArrayList<Kartei> userKarteien) {
		this.userKarteien = userKarteien;
	}

	public void karteiInSammlung(Kartei kk)
	{
		userKarteien.add(kk);
	}
	
	public int getAnzahlKarteienInSammlung()
	{
		int anzahlKarteien = userKarteien.size();
		return anzahlKarteien;		
	}

	public Daten getUserDaten() {
		return userDaten;
	}

	public void setUserDaten(Daten userDaten) {
		this.userDaten = userDaten;
	}
	
	}

