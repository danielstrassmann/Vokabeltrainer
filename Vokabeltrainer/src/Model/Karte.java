
package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Karte {

	private int id;
	private String frage;
	private String antwort;
	
	public Karte() {
		
	}
	
	
	public Karte(String frage, String antwort) {
		// die ID wird erst gesetzt, wenn die Karte in die ArrayList der Kartei abgelegt wird
		this.frage = frage;
		this.antwort = antwort;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}
	@XmlElement
	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}


}
