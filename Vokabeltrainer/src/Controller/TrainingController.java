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
	// ich den angemeldeten User �bergeben k�nnen --> siehe Methoden trainingBox()
	private User u;
	private ArrayList<Karte> sammlungBox;

	// Standardkonstruktor
	public TrainingController() {

	}

	// Training f�r Box, Nummer f�r zu w�hlende Box mitgeben
	public void boxLaden(int boxNummer) {
		// neues Training instanzieren
		Training t = new Training(u);
		// Daten laden, damit diese sp�ter ver�ndert werden k�nnen
		Daten d = t.getTrainingsDaten();

		// Kartensammlung laden
		Kartei kk = t.getTrainingsKartei();
		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		
		// Karten mit Box abf�llen
		for (Karte k : kartenliste) {

			if (k.getId() == boxNummer) {
				sammlungBox.add(k);
			}

		}
	}
	
	
	public void boxSpielen() {
		
		// Zuf�lliges Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = sammlungBox.get(r.nextInt(sammlungBox.size()));

	}

}
