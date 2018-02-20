package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.Training;
import Model.User;

public class TrainingController {

	// TODO: Attribut User ist nur ein Platzhalter. Im Konstruktor Training(u) muss
	// ich den angemeldeten User übergeben können --> siehe Methoden trainingBox()
	private User u;
	private ArrayList<Karte> sammlungBox;

	// Standardkonstruktor
	public TrainingController() {

	}

	// Training für Box, Nummer für zu wählende Box mitgeben
	public void boxLaden(int boxNummer) {
		// neues Training instanzieren
		Training t = new Training(u);
		// Daten laden, damit diese später verändert werden können
		Daten d = t.getTrainingsDaten();

		// Kartensammlung laden
		Kartei kk = t.getTrainingsKartei();
		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		
		// Karten mit Box abfüllen
		for (Karte k : kartenliste) {

			if (k.getId() == boxNummer) {
				sammlungBox.add(k);
			}

		}
	}
	
	
	public void boxSpielen() {
		
		// Zufälliges Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = sammlungBox.get(r.nextInt(sammlungBox.size()));

	}

}
