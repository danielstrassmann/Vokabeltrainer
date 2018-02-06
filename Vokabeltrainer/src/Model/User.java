package Model;

import java.util.ArrayList;

public class User {

	private ArrayList<String> userliste;

	private String benutzername;
	private String passwort;
	private String benutzersprache;

	public User(String username, String userpasswort, String lang) {
		benutzername = username;
		passwort = userpasswort;
		benutzersprache = lang;
		/// generiert neuen User sprache nur provisorisch

	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getBenutzersprache() {
		return benutzersprache;
	}

	public void setBenutzersprache(String benutzersprache) {
		this.benutzersprache = benutzersprache;
	}

	public ArrayList<String> getUserliste() {
		return userliste;
	}

	public void setUserliste(ArrayList<String> userliste) {
		this.userliste = userliste;
	}

}
