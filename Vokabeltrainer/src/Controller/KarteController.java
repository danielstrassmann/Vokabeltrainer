package Controller;

import Model.Karte;

public class KarteController {

	private Karte k;
	
	public KarteController() {
	}
	

	public void karteErstellen(String frage, String antwort)
	{
		String f = frage;
		String a = antwort;
		k = new Karte(f, a);
	}
	
	
}
