package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.Training;
import Model.User;

public class TrainingController {

	/*
	 * TODO: Attribut User ist nur ein Platzhalter. Im Konstruktor Training(u) muss
	 * ich den angemeldeten User übergeben können --> siehe Methoden trainingBox()
	 */
	private User u;

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

		// Boxsammlung instanzieren
		ArrayList<Karte> boxSammlung;
		boxSammlung = t.getSammlungBox();

		// Karten mit Box abfüllen
		for (Karte k : kartenliste) {

			if (k.getId() == boxNummer) {
				boxSammlung.add(k);
			}

		}

		// Abgefüllte Box zurückschreiben
		t.setSammlungBox(boxSammlung);
	}

	public void boxSpielen() {

		Training t = new Training(u);
		ArrayList<Karte> boxSammlung;
		boxSammlung = t.getSammlungBox();
		
		
		// Zufällige Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = boxSammlung.get(r.nextInt(boxSammlung.size()));

	}

}
