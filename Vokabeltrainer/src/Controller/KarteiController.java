package Controller;

/**
 * Diese Klasse wird f�r die Karteispeicherung gebraucht
 * 
 * @author Thomas Brunner St.Gallen
 * @version 1.0 09.3.2018
 */

import java.util.ArrayList;

import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.Popup.KeineKarten;

public class KarteiController {

	/**
	 * Braucht man nur, um Instanz KeineKarten zu erzeugen
	 */
	private User u;

	/**
	 * Standardkonstruktor
	 */
	public KarteiController(User u) {

		this.u = u;

	}

	/**
	 * Erstellt eine Kartei und legt diese in der Instanz User in die Sammlung ab
	 * 
	 */
	public void karteiErstellen(String frage, String antwort, User u) {
		Kartei kk = new Kartei(frage, antwort);

		/**
		 * Methode wenn noch keine Kartei vorhanden.
		 * 
		 */
		ArrayList<Kartei> userKartei = u.getUserKarteien();
		if (userKartei == null) {
			userKartei = new ArrayList<>();
			u.setUserKarteien(userKartei);
		}

		int id = u.getAnzahlKarteienInSammlung();
		id++;

		/**
		 * stellt sicher, dass keine Kartei in Sammlung eine doppelte ID hat
		 * 
		 */
		for (Kartei kartei : userKartei) {
			if (kartei.getId() == id) {
				id++;
			}
		}

		kk.setId(id);
		u.karteiInSammlung(kk);

	}

	/**
	 * Ein Objekt Karte wird erzeugt & in eine Kartei abgelegt ID wird beim ablegen
	 * in ArrayList erzeugt
	 * 
	 * @param frage
	 * @param antwort
	 * @param kk
	 */
	public void karteInKarteiAblegen(String frage, String antwort, Kartei kk) {

		if (kk == null) {
			KeineKarten fehlerdialog = new KeineKarten(this.u);
			return;
		}

		Karte k = new Karte(frage, antwort);
		int id = kk.getAnzahlKartenInSammlung();
		id++;

		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		/**
		 * stellt sicher, dass keine Karte in Sammlung eine doppelte ID hat
		 * 
		 */
		for (Karte karte : kartenliste) {
			if (karte.getId() == id) {
				id++;
			}
		}

		k.setId(id);
		kk.karteInSammlung(k);
	}

}
