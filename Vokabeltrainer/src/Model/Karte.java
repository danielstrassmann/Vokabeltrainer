package Model;

public class Karte {

	private int id;
	private String frage;
	private String antwort;

	public Karte(String frage, String antwort) {
		// Was ist mit der ID? Geh�rt diese in den Konstruktor?
		this.frage = frage;
		this.antwort = antwort;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

	public String getFrage() {
		return frage;
	}

	public void setFrage(String frage) {
		this.frage = frage;
	}

}
