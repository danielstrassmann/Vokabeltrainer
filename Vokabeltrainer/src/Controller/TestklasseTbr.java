package Controller;

import Model.User;

import java.util.ArrayList;

import Model.Kartei;

public class TestklasseTbr {
		
	private User u;
	private Kartei kk;
	private KarteiController test;

	
	public TestklasseTbr() {
		
		// neuer User erstellen mit User-Konstruktor
		u = new User("brunnert", "eli", "deutsch");	
		
		//Neue Kartei erstellen mittels Methode vom KarteiController
		test.karteiErstellen("Deutsch", "Englisch", u);
		
		//Get ArrayList vom zuvor instanzierten User
		ArrayList<Kartei> liste;
		liste = u.getUserKarteien();
		
		// Zuvor erstellte Kartei aus ArrayList auslesen
		kk = liste.get(0);
		
		
		// Attribute vom Objekt ausgeben um zu prüfen, ob alles klappt
		System.out.println("Die Kartei " + kk.getFrage() + "-" + kk.getAntwort() + " besitzt die Id " + kk.getId());
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Die Kartei " + kk.getFrage() + "-" + kk.getAntwort() + " besitzt die Id " + kk.getId());

	}

}
