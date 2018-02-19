package Controller;

import java.util.ArrayList;

import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.TabKartei;

public class TestklasseTbr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// neuer User erstellen mit User-Konstruktor
		User u = new User("brunnert", "eli", "deutsch");

		// Neue Kartei erstellen mittels Methode vom KarteiController
		KarteiController test = new KarteiController();
		test.karteiErstellen("Deutsch", "Englisch", u);

		// Get ArrayList vom zuvor instanzierten User
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();

		// Zuvor erstellte Kartei aus ArrayList auslesen
		Kartei kk = new Kartei();
		kk = karteiliste.get(0);


		
		// TEST F�R KARTEI: Attribute vom Objekt ausgeben um zu pr�fen, ob alles klappt
		System.out.println("TEST f�r Kartei:");
		System.out.println("-----------------");
		System.out.println("Die Kartei " + kk.getFrage() + "-" + kk.getAntwort() + " besitzt die Id " + kk.getId());
		System.out.println("");
		System.out.println("");
		

		
		
				
		// Karten in erstellte Kartei ablegen
		test.karteInKarteiAblegen("Haus", "House", kk);
		test.karteInKarteiAblegen("Wasser", "Water", kk);
		test.karteInKarteiAblegen("Feuer", "Fire", kk);
		
		
		// Get ArrayList von der Klasse Kartei
		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		
		// Karten aus ArrayList in Klasse Kartei auslesen
		Karte k1 = kartenliste.get(0);
		Karte k2 = kartenliste.get(1); 
		Karte k3 = kartenliste.get(2);
		
		
		
		// TEST F�R KARTEN: Attribute von Objekten ausgeben und pr�fen, ob alles klappt
		System.out.println("TEST f�r Karten:");
		System.out.println("-----------------");
		System.out.println("Die Karte mit der Id " + k1.getId() + " hat die Frage [" + k1.getFrage() + "] und die Antwort [" + k1.getAntwort() + "]");
		System.out.println("Die Karte mit der Id " + k2.getId() + " hat die Frage [" + k2.getFrage() + "] und die Antwort [" + k2.getAntwort() + "]");
		System.out.println("Die Karte mit der Id " + k3.getId() + " hat die Frage [" + k3.getFrage() + "] und die Antwort [" + k3.getAntwort() + "]");
		
		TabKartei tb = new TabKartei();

	}

}