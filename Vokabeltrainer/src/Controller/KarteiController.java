package Controller;

/**
 * In dieser Controller-Klasse werden Karteien und Karten erstellt
 * Der KarteiController wird in den Klassen TabKartei und KarteiErstellen wiederverwendet
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
	 * 
	 * @param u
	 *            Instanz User muss �bergeben werden, damit der Fehlerdialog
	 *            KeineKarten in der richtigen Usersprache ausgel�st werden kann
	 */
	public KarteiController(User u) {

		this.u = u;

	}

	/**
	 * Erstellt eine Kartei und legt diese in der Instanz User in die Sammlung ab
	 * 
	 * @param frage
	 *            Quellsprache der Kartei
	 * @param antwort
	 *            Zielsprache der Kartei
	 * @param u
	 *            Instanz User muss �bergeben werden, damit die Kartei auf dem User
	 *            gespeichert werden kann
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
	 * Ein Objekt Karte wird erzeugt und in eine Kartei abgelegt ID wird beim
	 * ablegen in ArrayList erzeugt
	 * 
	 * @param frage
	 *            Ist die Quellsprache der Karte
	 * @param antwort
	 *            Ist die Zielsprache der Karte
	 * @param kk
	 *            Instanz Kartei muss �bergeben werden, damit die Karte in der
	 *            richtigen Kartei angelegt wird, welche auf dem User gespeichert
	 *            ist
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
