package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
public class User {

	
	private ArrayList<Kartei> userKarteien;

	public String benutzername;

	private String passwort;

	private String benutzersprache;

	public User() {

	}

	public User(String username, String userpasswort, String lang) {

		benutzername = username;
		passwort = userpasswort;
		/// generiert neuen User sprache nur provisorisch
		benutzersprache = lang;		
		userKarteien = new ArrayList<>();
		

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

}
