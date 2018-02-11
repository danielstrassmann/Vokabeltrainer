package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User {

	private ArrayList<String> userliste;
	@XmlElement
	private String benutzername;
	@XmlElement
	private String passwort;
	@XmlElement
	private String benutzersprache;
	
	public User() {
		
	}

	public User(String username, String userpasswort, String lang) {
		
		benutzername = username;
		passwort = userpasswort;
		benutzersprache = lang;
		/// generiert neuen User sprache nur provisorisch
		ArrayList<User> userliste = new ArrayList<User>();
		

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
	
	public String toString() {
		return benutzername + ", "+ passwort + ", " + benutzersprache;

	}

}
