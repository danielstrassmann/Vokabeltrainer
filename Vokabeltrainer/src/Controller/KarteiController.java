package Controller;

import Model.Karte;
import Model.Kartei;

public class KarteiController {
	
	private Kartei kk;
	private Karte k;
	
	
	public KarteiController() {
	}
	
	
	public void karteiErstellen(String frage, String antwort)
	{
		String f = frage;
		String a = antwort;
		kk = new Kartei(f, a);
	}
	
	//Baustelle
	public void karteInKarteiAblegen(Karte k, Kartei kk)
	{
		kk sammlung.add(k);
	}

}
