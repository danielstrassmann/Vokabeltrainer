package Model;

public class Training {
	
	private Kartei kk;
	private int antwortenKorrekt;
	private int antwortenFalsch;
	private int antwortenTotal;
	// Attribut definieren für Zeit, die man Spielt? Wie macht mann das?
	
	
	// Standardkonstruktor
	public Training () {
	}
	
	
	public Training(Kartei kk) {
		this.kk = kk;
		setAntwortenKorrekt(0);
		setAntwortenFalsch(0);
		setAntwortenTotal(0);
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



}
