package Model;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;

	// Standardkonstruktor
	public Training() {
	}

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
