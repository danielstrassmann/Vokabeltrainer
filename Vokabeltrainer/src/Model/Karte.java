package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Karte {

	private int id;
	private String frage;
	private String antwort;
	
	public Karte()
	{}

	public Karte(String frage, String antwort) {
		// Was ist mit der ID? Gehört diese in den Konstruktor?
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
