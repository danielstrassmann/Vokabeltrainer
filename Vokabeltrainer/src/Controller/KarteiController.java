package Controller;

/**
 * Diese Klasse wird für die Karteispeicherung gebraucht
 * 
 * @author Thomas Brunner St.Gallen / Daniel Strassmann
 * @version 1.0 09.3.2018
 */

import java.util.ArrayList;

import Model.Karte;
import Model.Kartei;
import Model.User;

public class KarteiController {

	// Standardkonstruktor
	public KarteiController() {

	}

	// Erstellt eine Kartei und legt diese in der Instanz User in die Sammlung ab
	public void karteiErstellen(String frage, String antwort, User u) {
		Kartei kk = new Kartei(frage, antwort);

		// Methode wenn noch keine Kartei vorhanden.
		ArrayList<Kartei> userKartei = u.getUserKarteien();
		if (userKartei == null) {
			userKartei = new ArrayList<>();
			u.setUserKarteien(userKartei);
		}

		int id = u.getAnzahlKarteienInSammlung();
		id++;

		// stellt sicher, dass keine Kartei in Sammlung eine doppelte ID hat
		for (Kartei kartei : userKartei) {
			if (kartei.getId() == id) {
				id++;
			}
		}

		kk.setId(id);
		u.karteiInSammlung(kk);

	}

	// Ein Objekt Karte wird erzeugt & in eine Kartei abgelegt
	// ID wird beim ablegen in ArrayList erzeugt
	public void karteInKarteiAblegen(String frage, String antwort, Kartei kk) {
		Karte k = new Karte(frage, antwort);
		int id = kk.getAnzahlKartenInSammlung();
		id++;

		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		// stellt sicher, dass keine Karte in Sammlung eine doppelte ID hat
		for (Karte karte : kartenliste) {
			if (karte.getId() == id) {
				id++;
			}
		}

		k.setId(id);
		kk.karteInSammlung(k);
	}

}
