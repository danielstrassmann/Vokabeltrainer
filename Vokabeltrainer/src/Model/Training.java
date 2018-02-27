package Model;

import java.util.ArrayList;
import java.util.Random;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;
	private ArrayList<Karte> sammlungBox;
	private Karte aktiveKarte;

	// Konstruktor instanziert Training mit Userdaten & Karten in Box
	public Training(User u, int boxNummer) {

		// Instanziert Daten neue Statistikdaten mit Wert 0
		trainingsDaten = new Daten();

		// Holt & instanziert aktive Kartei
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();
		// TODO: korrekter Listener von Klasse Hauptmen� einbinden, damit richtige
		// Kartei geladen werden kann
		// provisorisch fix ID 0 --> ID muss aktive Kartei sein
		int id = 0;
		trainingsKartei = karteiliste.get(id);

		// l�dt Kartensammlung aus Kartei, damit die Karten nach Box gefiltert werden
		// k�nnnen
		ArrayList<Karte> kartenliste;
		kartenliste = trainingsKartei.getSammlung();

		// Instanziert neue Boxsammlung
		sammlungBox = new ArrayList<Karte>();

		// Karten in Kartenliste nach ausgew�hlter Box filtern und in sammlungBox
		// abf�llen
		for (Karte k : kartenliste) {

			if (k.getBox() == boxNummer) {
				sammlungBox.add(k);
			}

		}

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
	
	public Karte getAktiveKarte() {
		return aktiveKarte;
	}

	public int getAnzahlKartenInBox() {
		int anzahlKartenInBox = sammlungBox.size();
		return anzahlKartenInBox;
	}

	// Was zur�ckgeben, wenn es keine Karten mehr in der Box gibt?
	public Karte gibZufallsKarteAusBox() {

		// Zuf�llige Karte wird aus Sammlung ausgegeben
		Random r = new Random();
		Karte result = null;
		result = sammlungBox.get(r.nextInt(sammlungBox.size()));

		// Checkt, ob es noch Karten in der Box hat
		if (result != null) {

			sammlungBox.remove(result);
			this.aktiveKarte = result;
			return aktiveKarte;

		}

		else {
			System.out.println("Es hat keine Karten mehr in der Box!");
			Karte k = new Karte();
			// Objekt k ist null, da keine Karten mehr in der Box sind
			// Muss Marius im UI abfangen!!!
			aktiveKarte = k;
			return aktiveKarte;
		}

	}

	// Inputwerte brauche ich vom UI / Marius
	public boolean antwortPruefen(String eingabeAntwort, String eingabeFrage) {
		// Antwort & Frage wird von Karte ausgelesen, die mit Methode
		// gibZufallsKarteAusBox() instanziert wurde
		String frageKarte = aktiveKarte.getFrage();
		String antwortKarte = aktiveKarte.getAntwort();

		// Wert von Karte wird mit Eingabe in UI abgeglichen
		if (frageKarte == eingabeFrage && antwortKarte == eingabeAntwort) {

			// Karte wandert in n�chste Box und wird neu in KartenSammlung in der Kartei
			// abgelegt, Statistikdaten aktualisieren
			aktiveKarte.karteInNaechsteBox();
			trainingsDaten.antwortRichtig();

			return true;
		}

		else {
			// Karte wandert in erste Box und wird neu in KartenSammlung in der Kartei
			// abgelegt, Statistikdaten aktualisieren
			aktiveKarte.karteInErsteBox();
			trainingsDaten.antwortFalsch();

			return false;
		}
	}

	public void aktiveKarteNeuInTrainingsKartei() {
		int id = aktiveKarte.getId();
		// Kartensammlung in Traingingskartei wird nach ausgelesener Karte durchsucht
		// und ersetzt
		ArrayList<Karte> listeNeu = trainingsKartei.getSammlung();
		for (Karte k : listeNeu) {
			if (k.getId() == id) {
				k = aktiveKarte;

			}

			// KartenSammlung wird neu auf TrainingsKartei gesetzt
			trainingsKartei.setSammlung(listeNeu);
		}
	}

	// Daten vom Training werden an User �bertagen
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

	// �bergibt die Trainingskartei neu in die Userkarteiensammlung
	public void karteiAnUser(User u) {
		int id = trainingsKartei.getId();

		ArrayList<Kartei> listeNeu = u.getUserKarteien();
		// In Liste wird nach Kartei mit entsprechender ID gesucht und mit
		// TrainingsKartei �berschrieben
		for (Kartei kk : listeNeu) {
			if (kk.getId() == id) {
				kk = trainingsKartei;
			}
		}
		// KarteienSammlung auf User wird neu gesetzt
		u.setUserKarteien(listeNeu);

	}
}
