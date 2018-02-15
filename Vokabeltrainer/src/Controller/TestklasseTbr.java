package Controller;

import java.util.ArrayList;

import Model.Kartei;
import Model.User;

public class TestklasseTbr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// neuer User erstellen mit User-Konstruktor
		User u = new User("brunnert", "eli", "deutsch");

		// Neue Kartei erstellen mittels Methode vom KarteiController
		KarteiController test = new KarteiController();
		test.karteiErstellen("Deutsch", "Englisch", u);

		// Get ArrayList vom zuvor instanzierten User
		ArrayList<Kartei> liste;
		liste = u.getUserKarteien();

		// Zuvor erstellte Kartei aus ArrayList auslesen
		Kartei kk = new Kartei();
		kk = liste.get(0);

		// Attribute vom Objekt ausgeben um zu prüfen, ob alles klappt
		System.out.println("Die Kartei " + kk.getFrage() + "-" + kk.getAntwort() + " besitzt die Id " + kk.getId());

	}

}
