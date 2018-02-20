package Model;

import java.util.ArrayList;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;

	// Konstruktor instanziert Training mit Userdaten
	public Training(User u) {

		// Holt & instanziert aktive Kartei
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();
		// TODO: korrekter Listener von Klasse Hauptmenü einbinden, damit richtige
		// Kartei geladen werden kann
		// provisorisch fix ID 0 --> ID muss aktive Kartei sein
		int id = 0;
		trainingsKartei = karteiliste.get(id);

		// Instanziert Daten neue Statistikdaten mit Wert 0 für neues Training
		trainingsDaten = new Daten();

	}

	// Alternativer Konstruktor - für Testzwecke
	public Training(Kartei kk, Daten d) {
		this.setTrainingsKartei(kk);
		this.setTrainingsDaten(d);

	}

	public Kartei getTrainingsKartei() {
		return trainingsKartei;
	}

	public void setTrainingsKartei(Kartei trainingsKartei) {
		this.trainingsKartei = trainingsKartei;
	}

	public Daten getTrainingsDaten() {
		return trainingsDaten;

	}

	public void setTrainingsDaten(Daten trainingsDaten) {
		this.trainingsDaten = trainingsDaten;
	}

}
