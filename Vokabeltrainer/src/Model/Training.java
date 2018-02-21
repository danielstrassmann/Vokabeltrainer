package Model;

import java.util.ArrayList;
import java.util.Random;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;
	private ArrayList<Karte> sammlungBox;
	private int boxNummer;

	// Konstruktor instanziert Training mit Userdaten & Karten in Box
	public Training(User u, int boxNummer) {

		// Instanziert Daten neue Statistikdaten mit Wert 0
		trainingsDaten = new Daten();

		// Holt & instanziert aktive Kartei
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();
		// TODO: korrekter Listener von Klasse Hauptmenü einbinden, damit richtige
		// Kartei geladen werden kann
		// provisorisch fix ID 0 --> ID muss aktive Kartei sein
		int id = 0;
		trainingsKartei = karteiliste.get(id);

		// lädt Kartensammlung aus Kartei, damit die Karten nach Box gefiltert werden
		// könnnen
		ArrayList<Karte> kartenliste;
		kartenliste = trainingsKartei.getSammlung();

		// Instanziert neue Boxsammlung
		sammlungBox = new ArrayList<Karte>();

		// Karten in Kartenliste nach ausgewählter Box filtern und in sammlungBox
		// abfüllen
		for (Karte k : kartenliste) {

			if (k.getBox() == boxNummer) {
				sammlungBox.add(k);
			}

		}

		// Test für Methode gibZufallsKarteAusBox
		this.boxNummer = boxNummer;

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

	public ArrayList<Karte> getSammlungBox() {
		return sammlungBox;
	}

	public void setSammlungBox(ArrayList<Karte> sammlungBox) {
		this.sammlungBox = sammlungBox;
	}

	
	// Was zurückgeben, wenn es keine Karten mehr in der Box gibt?
	public Karte gibZufallsKarteAusBox() {

		// Zufällige Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = sammlungBox.get(r.nextInt(sammlungBox.size()));

		// Checkt, ob es noch Karten in der Box hat
		if (result != null) {

			sammlungBox.remove(result);
			return result;

		}

		else {
			System.out.println("Es hat keine Karten mehr in der Box!");
		}

	}

	// Daten vom Training werden an User übertagen
	public void trainingsDatenAnUserdaten(User u) {

		// Statistikdaten des aktuellen Training auslesen
		int at1 = trainingsDaten.getAntwortenFalsch();
		int at2 = trainingsDaten.getAntwortenKorrekt();
		int at3 = trainingsDaten.getAntwortenTotal();

		// Statistikdaten auf User auslesen
		Daten d = u.getUserDaten();
		int au1 = d.getAntwortenFalsch();
		int au2 = d.getAntwortenKorrekt();
		int au3 = d.getAntwortenTotal();

		// Statistikdaten addieren
		int antwortenFalschNeu = at1 + au1;
		int antwortenKorrektNeu = at2 + au2;
		int antwortenTotalNeu = at3 + au3;

		// Daten neu auf User speichern
		d.setAntwortenFalsch(antwortenFalschNeu);
		d.setAntwortenKorrekt(antwortenKorrektNeu);
		d.setAntwortenTotal(antwortenTotalNeu);
		u.setUserDaten(d);

	}

}
