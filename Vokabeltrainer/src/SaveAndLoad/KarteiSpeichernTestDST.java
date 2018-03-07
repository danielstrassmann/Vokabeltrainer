package SaveAndLoad;

import java.io.File;
import java.util.ArrayList;

import Controller.UserSammlung;
import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.User;

public class KarteiSpeichernTestDST {
	public static void main(String args[]) throws Exception {

		AbspeichernLaden saveHandler = new AbspeichernLaden();
		ArrayList<Kartei> karteiArray = new ArrayList<>();

		User user1 = new User();
		user1.setBenutzername("Peter");
		user1.setPasswort("eli");
		user1.setBenutzersprache("de");

		Kartei kartei1 = new Kartei();
		kartei1.setFrage("deutsch");
		kartei1.setAntwort("englisch");
		
		Karte karte1 = new Karte();
		karte1.setFrage("Haus");
		karte1.setAntwort("House");
		karte1.setBox(1);
		
		Karte karte2 = new Karte();
		karte2.setFrage("Maus");
		karte2.setAntwort("Mouse");
		karte2.setBox(1);
		 
		
		kartei1.add(karte1);
		kartei1.add(karte2);
		
		karteiArray.add(kartei1);
		
		user1.setUserKarteien(karteiArray);
		
		Daten daten = new Daten();
		daten.setAntwortenFalsch(4);
		daten.setAntwortenKorrekt(15);
		daten.setAntwortenTotal(19);
		
		user1.setUserDaten(daten);
		
		
		saveHandler.karteienSpeichern(user1);
		
		user1.setUserKarteien(null);
		user1.setUserDaten(null);
		
		saveHandler.karteienLaden(user1);
		if(user1.getUserKarteien() != null || user1.getUserDaten() != null) {
			System.out.println("falsch");
		}
		
	}
}