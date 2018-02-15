package Controller;

import Model.Karte;
import Model.Kartei;
import Model.User;

public class KarteiController {
	
	
	// Standardkonstruktor, wird nicht benötigt
	public KarteiController() {
		
		}
	
	
	// Erstellt eine Kartei und legt diese in der Instanz User in die Sammlung ab
	public void karteiErstellen(String frage, String antwort, User u)
	{
		Kartei kk = new Kartei(frage, antwort);
		int id = u.getAnzahlKarteienInSammlung();
		id++;
		kk.setId(id);
		// TODO: Check einbauen, ob ID bereits in Liste exisiert --> wenn Karteien aus Sammlung gelöscht wurden
		u.karteiInSammlung(kk);		
		
	}
	
	
	
	// Ein Objekt Karte wird erzeugt & in eine Kartei abgelegt
	// ID wird beim ablegen in ArrayList erzeugt
	public void karteInKarteiAblegen(String frage, String antwort, Kartei kk)
	{
		Karte k = new Karte(frage, antwort);
		int id = kk.getAnzahlKartenInSammlung();
		id++;
		k.setId(id);
		// TODO: Check einbauen, ob ID bereits in Liste exisiert --> wenn Karten aus Sammlung gelöscht wurden
		kk.karteInSammlung(k);
	}

}
