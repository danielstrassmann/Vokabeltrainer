package Model;

import java.util.ArrayList;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;
	private ArrayList<Karte> sammlungBox;

	// Konstruktor instanziert Training mit Userdaten
	public Training(User u) {

		// Holt & instanziert aktive Kartei
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();
		// TODO: korrekter Listener von Klasse Hauptmen� einbinden, damit richtige
		// Kartei geladen werden kann
		// provisorisch fix ID 0 --> ID muss aktive Kartei sein
		int id = 0;
		trainingsKartei = karteiliste.get(id);

		// Instanziert Daten neue Statistikdaten mit Wert 0
		trainingsDaten = new Daten();
		
		// Instanziert neue Boxsammlung
		sammlungBox = new ArrayList<Karte>();

	}

	// Alternativer Konstruktor - f�r Testzwecke
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

	public ArrayList<Karte> getSammlungBox() {
		return sammlungBox;
	}

	public void setSammlungBox(ArrayList<Karte> sammlungBox) {
		this.sammlungBox = sammlungBox;
	}

}
