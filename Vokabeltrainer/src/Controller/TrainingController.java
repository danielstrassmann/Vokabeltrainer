package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.Training;
import Model.User;


// wird vermutlich nicht benötigt
public class TrainingController {


	private Training t;
	
	
	// Standardkonstruktor
	public TrainingController() {

	}


	public void naechsteFrage(User u, int boxNummer) {
		
				
		Training t = new Training(u, boxNummer);
		ArrayList<Karte> boxSammlung;
		boxSammlung = t.getSammlungBox();
		
		
		// Zufällige Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = boxSammlung.get(r.nextInt(boxSammlung.size()));

	}

}
