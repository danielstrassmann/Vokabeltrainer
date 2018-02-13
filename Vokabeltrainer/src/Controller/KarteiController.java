package Controller;

import Model.Karte;
import Model.Kartei;

public class KarteiController {
	
	// z�hlt wie viele Karteien erstellt wurden und generiert die ID
	private int karteiCounter;
	
	
	
	/** z�hlt wie viele Karteien erstellt wurden und generiert die ID
	 * --> wird ben�tigt, da in ArrayList<Karte> eine Karte wieder gel�scht werden kann. 
	 *     Man erh�lt also durch loopen durch ArrayList keine eindeutige ID.
	 * 
	 */
	private int karteCounter;
	
	
	public KarteiController() {
		
		karteiCounter = 0;
		karteCounter = 0;
	}
	
	public void karteiErstellen(String frage, String antwort)
	{
		Kartei k = new Kartei(frage, antwort);
		k.setId(karteiCounter);
		karteiCounter++;
	}
	
	// Ein Objekt Karte wird erzeugt
	public void karteErstellen(String frage, String antwort)
	{
		Karte k = new Karte(frage, antwort);
		k.setId(karteCounter);
		karteCounter++;
	}
	
	
	//Ein Objekt Karte wird erzeugt & in eine Kartei abgelegt
	// Wie wird Kartei kk �bergeben? Wie weiss ich, welche Kartei ausgew�hlt ist?
	public void karteInKarteiAblegen(String frage, String antwort, Kartei kk)
	{
		Karte k = new Karte(frage, antwort);
		k.setId(karteCounter);		
		kk.karteInSammlung(k);
		karteCounter++;
	}

}
