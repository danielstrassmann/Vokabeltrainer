package Model;

/**
 * Diese Klasse wird für das Durchführen des Trainigs benötigt
 * Karteien und Karten werden vom User ausgelesen und nach dem Training aktualisiert und wieder zurückgegeben
 * 
 * @author Thomas Brunner St.Gallen 
 * @version 1.0 09.3.2018
 */

import java.util.ArrayList;
import java.util.Random;

public class Training {

	private Kartei trainingsKartei;
	private Daten trainingsDaten;
	private ArrayList<Karte> sammlungBox;
	private Karte aktiveKarte;

	/**
	 * Konstruktor instanziert Training mit Userdaten und Karten in Box
	 * 
	 * @param u
	 *            Instanz User muss übergeben werden, damit die Trainingsdaten
	 *            (Karten und Daten) dem korrekten User übergeben wird
	 * @param boxNummer
	 *            Instanz Boxnummer wird von Klasse TabLenrnen übergeben, damit die
	 *            SammlungBox im Konsturktor korrekt abgefüllt wird
	 */
	public Training(User u, int boxNummer) {

		/**
		 * Instanziert Daten neue Statistikdaten mit Wert 0
		 * 
		 */
		trainingsDaten = new Daten();

		/**
		 * Instanziert Kartei fürs Training gemäss ausgewählter Kartei von Hauptmenü
		 * 
		 */
		trainingsKartei = u.getAktiveKartei();

		/**
		 * lädt Kartensammlung aus Kartei, damit die Karten nach Box gefiltert werden
		 * könnnen
		 * 
		 */
		ArrayList<Karte> kartenliste;
		kartenliste = trainingsKartei.getSammlung();

		/**
		 * Instanziert neue Boxsammlung
		 * 
		 */
		sammlungBox = new ArrayList<Karte>();

		/**
		 * Karten in Kartenliste nach ausgewählter Box filtern und in sammlungBox
		 * abfüllen
		 * 
		 */
		for (Karte k : kartenliste) {

			if (k.getBox() == boxNummer) {
				sammlungBox.add(k);
			}

		}

	}

	/**
	 * Alternativer Konstruktor
	 * 
	 */
	public Training() {
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

	/**
	 * Was zurückgeben, wenn es keine Karten mehr in der Box gibt?
	 * 
	 * @return Eine Instanz Karte aus Sammlung Box wird zufällig ausgegeben Wenn die
	 *         Box leer ist, wird eine Instanz Karte mit "null" geliefert
	 */
	public Karte gibZufallsKarteAusBox() {

		/**
		 * Zufällige Karte wird aus Sammlung ausgegeben
		 * 
		 */
		Random r = new Random();
		Karte result = null;

		try {
			result = sammlungBox.get(r.nextInt(sammlungBox.size()));

			/**
			 * Checkt, ob es noch Karten in der Box hat
			 * 
			 */

			sammlungBox.remove(result);
			this.aktiveKarte = result;
			return aktiveKarte;

		}

		catch (Exception e) {
			System.out.println("Es hat keine Karten mehr in der Box! " + e.toString());
			/**
			 * Objekt k ist null, da keine Karten mehr in der Box sind, wird in Klasse
			 * Lernen validiert
			 */
			aktiveKarte = null;
			return aktiveKarte;
		}

	}

	/**
	 * Inputwerte kommen von Klasse Lernen
	 * 
	 * @param eingabeAntwort
	 *            Eingabe des Antwort vom GUI (Klasse Lernen)
	 * @param eingabeFrage
	 *            Eingabe der Frage vom GUI (Klasse Lernen)
	 * @return Übergibt an Klasse Lernen, ob Karte korrekt oder falsch beantwortet
	 *         wurde. Je nach Wert des boolean verhaltet sich das GUI anders.
	 */
	public boolean antwortPruefen(String eingabeAntwort, String eingabeFrage) {
		/**
		 * Antwort & Frage wird von Karte ausgelesen, die mit Methode
		 * gibZufallsKarteAusBox() instanziert wurde
		 * 
		 */
		String frageKarte = aktiveKarte.getFrage();
		String antwortKarte = aktiveKarte.getAntwort();

		/**
		 * Wert von Karte wird mit Eingabe in UI abgeglichen
		 * 
		 */
		if (frageKarte.equals(eingabeFrage) && antwortKarte.equals(eingabeAntwort)) {

			/**
			 * Karte richtig und befindet sich bereits in Box 5, muss wieder in SammlungBox
			 * 
			 */
			if (aktiveKarte.getBox() == 5) {
				sammlungBox.add(aktiveKarte);
			}

			/**
			 * Karte wandert in nächste Box und wird neu in KartenSammlung in der Kartei
			 * abgelegt, Statistikdaten aktualisieren
			 * 
			 */
			aktiveKarte.karteInNaechsteBox();
			trainingsDaten.antwortRichtig();

			return true;
		}

		else {

			/**
			 * Karte falsch und befindet sich bereits in Box 1, muss wieder in SammlungBox
			 * 
			 */
			if (aktiveKarte.getBox() == 1) {
				sammlungBox.add(aktiveKarte);
			}

			/**
			 * Karte wandert in erste Box und wird neu in KartenSammlung in der Kartei
			 * abgelegt, Statistikdaten aktualisieren
			 * 
			 */
			aktiveKarte.karteInErsteBox();
			trainingsDaten.antwortFalsch();

			return false;
		}
	}

	public void aktiveKarteNeuInTrainingsKartei() {
		int id = aktiveKarte.getId();
		/**
		 * Kartensammlung in Traingingskartei wird nach ausgelesener Karte durchsucht
		 * und ersetzt
		 * 
		 */
		ArrayList<Karte> listeNeu = trainingsKartei.getSammlung();
		for (Karte k : listeNeu) {
			if (k.getId() == id) {
				k = aktiveKarte;

			}

			/**
			 * KartenSammlung wird neu auf TrainingsKartei gesetzt
			 * 
			 */
			trainingsKartei.setSammlung(listeNeu);
		}
	}

	/**
	 * Daten vom Training werden an User übertagen
	 * 
	 * @param u
	 *            Instanz User muss übergeben werden, damit die Statistikdaten dem
	 *            korrekten User übergeben werden
	 */
	public void trainingsDatenAnUserdaten(User u) {

		/**
		 * Statistikdaten des aktuellen Training auslesen
		 * 
		 */
		int at1 = trainingsDaten.getAntwortenFalsch();
		int at2 = trainingsDaten.getAntwortenKorrekt();
		int at3 = trainingsDaten.getAntwortenTotal();

		/**
		 * Statistikdaten auf User auslesen
		 * 
		 */
		Daten d = u.getUserDaten();
		int au1 = d.getAntwortenFalsch();
		int au2 = d.getAntwortenKorrekt();
		int au3 = d.getAntwortenTotal();

		/**
		 * Statistikdaten addieren
		 * 
		 */
		int antwortenFalschNeu = at1 + au1;
		int antwortenKorrektNeu = at2 + au2;
		int antwortenTotalNeu = at3 + au3;

		/**
		 * Daten neu auf User speichern
		 * 
		 */
		d.setAntwortenFalsch(antwortenFalschNeu);
		d.setAntwortenKorrekt(antwortenKorrektNeu);
		d.setAntwortenTotal(antwortenTotalNeu);
		u.setUserDaten(d);

	}

	/**
	 * Übergibt die Trainingskartei neu in die Userkarteiensammlung
	 * 
	 * @param u
	 *            Instanz User muss übergeben werden, damit die TrainingsKartei
	 *            (beinhaltet modifizierte Karten durch Training), korrekt dem User
	 *            übergeben werden
	 */
	public void karteiAnUser(User u) {
		int id = trainingsKartei.getId();

		ArrayList<Kartei> listeNeu = u.getUserKarteien();
		/**
		 * In Liste wird nach Kartei mit entsprechender ID gesucht und mit
		 * TrainingsKartei überschrieben
		 * 
		 */
		for (Kartei kk : listeNeu) {
			if (kk.getId() == id) {
				kk = trainingsKartei;
			}
		}
		/**
		 * KarteienSammlung auf User wird neu gesetzt
		 * 
		 */
		u.setUserKarteien(listeNeu);

	}
}
