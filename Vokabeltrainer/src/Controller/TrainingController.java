package Controller;

import java.util.ArrayList;

import Model.Daten;
import Model.Kartei;
import Model.Training;
import Model.User;

public class TrainingController {

	// Standardkonstruktor
	public TrainingController() {
	}
	
	
	public void starteTrainingBox1(User u) {
		
		// Holt & instanziert aktive Kartei
		Kartei kk = new Kartei();
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();
		// provisorisch fix ID 1 --> ID muss aktive Kartei sein
		int id = 1;
		kk = karteiliste.get(id);

		
		// Holt & instanziert Daten vom User
		Daten d = new Daten();
		d = u.getUserDaten();
		
		// Trainingssession wird gestartet
		Training t = new Training(kk, d);
	}

}
