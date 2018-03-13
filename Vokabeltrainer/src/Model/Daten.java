package Model;

/**
 * In dieser Klasse werden die Statstikdaten verwaltet, welche auf dem User
 * gepseichert sind
 * 
 * @author Thomas Brunner St.Gallen
 * @version 1.0 09.3.2018
 */

public class Daten {

	/**
	 * Inhalt der Statistikdaten
	 */
	private int antwortenKorrekt;
	private int antwortenFalsch;
	private int antwortenTotal;

	public Daten() {
		antwortenKorrekt = 0;
		antwortenFalsch = 0;
		antwortenTotal = 0;
	}

	public int getAntwortenKorrekt() {
		return antwortenKorrekt;
	}

	public void setAntwortenKorrekt(int antwortenKorrekt) {
		this.antwortenKorrekt = antwortenKorrekt;
	}

	public int getAntwortenFalsch() {
		return antwortenFalsch;
	}

	public void setAntwortenFalsch(int antwortenFalsch) {
		this.antwortenFalsch = antwortenFalsch;
	}

	public int getAntwortenTotal() {
		return antwortenTotal;
	}

	public void setAntwortenTotal(int antwortenTotal) {
		this.antwortenTotal = antwortenTotal;
	}

	public void antwortRichtig() {
		this.antwortenKorrekt++;
		this.antwortenTotal++;
	}

	public void antwortFalsch() {
		this.antwortenFalsch++;
		this.antwortenTotal++;

	}

}
