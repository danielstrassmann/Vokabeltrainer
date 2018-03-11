package Viewer.Popup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Karte;
import Model.Training;
import Model.User;
import SaveAndLoad.AbspeichernLaden;

/**
 * Diese Klasse wird für das Lernfenster gebraucht Diese Klasse generiert das
 * Popup-Fenster "Lernen". Hier werden Lernkarten aus der ausgewählten Kartei
 * ausgewählt und können gelernt werden. Entweder man sieht den Quellfrage und
 * gibt die Übersetzungslösung ein oder man kehrt es mit dem SWITCH zur
 * Quelllösung um. Diese Kartei wird von der Klasse "TabLernen" aufgerufen.
 * 
 * @author Marius Brändle St.Gallen / Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class Lernen extends JDialog {

	private JLabel labelTitelLerner;
	private JLabel labelQuellName;
	private JLabel labelUbersetzungName;
	private JLabel labelUbersichtKarten;
	private JLabel labelRueckmeldung;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonKontrollieren;
	private JButton buttonAbbrechen;
	private JButton buttonNaechsteKarte;
	private JButton buttonSwitch;

	private int aktuelleBox;

	private Training t;
	private Karte k;
	private User u;
	private boolean switchButton;

	/**
	 *
	 * Popup-Fehlerdialog, wenn keine Karten mehr in der Box sind
	 */
	private KeineKarten fehlerdialog;

	private String frameTitelString;
	private String lernenAktuellString;
	private String karteninBox1String;
	private String karteninBox2String;
	private String kontrollierenString;
	private String boxWechselnString;
	private String naechsteKarteString;
	private String modusWechselnString;
	private String richtigBeantwortetString;
	private String falschBeantwortetString;

	/**
	 * Popup Lernen erstellen
	 * 
	 * @param u
	 *            Alle Daten des Users fliessen in die TabStatistik ein.
	 * @param owner
	 *            Definition ob parent/child.
	 * @param aktuelleBox
	 *            Gibt die Nummer der ausgewählten Box mit.
	 */
	public Lernen(User u, JFrame owner, int aktuelleBox) {

		super(owner);
		/**
		 * wird benötigt, damit Training sauber verlassen werden kann
		 */

		this.u = u;
		this.aktuelleBox = aktuelleBox;
		this.switchButton = true;
		t = new Training(u, this.aktuelleBox);
		t.gibZufallsKarteAusBox();
		k = t.getAktiveKarte();
		setSprache();
		lernen();
		initGui();
	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundls den einzelnen
	 * Datenfelder zu.
	 */
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		frameTitelString = r.getString("training");
		lernenAktuellString = r.getString("lernenAktuelleBox");
		karteninBox1String = r.getString("lernenKartenInBox1");
		karteninBox2String = r.getString("lernenKartenInBox2");
		kontrollierenString = r.getString("kontrollieren");
		boxWechselnString = r.getString("boxWechseln");
		naechsteKarteString = r.getString("naechsteKarte");
		modusWechselnString = r.getString("modusWechseln");
		richtigBeantwortetString = r.getString("richtigBeantwortet");
		falschBeantwortetString = r.getString("falschBeantwortet");
	}

	/**
	 * Erstellt alle Felder, welche für das TabStatistik benötigt werden.
	 */
	private void lernen() {
		this.labelTitelLerner = new JLabel(lernenAktuellString + aktuelleBox);
		/**
		 * Kartei Quellsprache & Zielsprache im UI anzeigen
		 * 
		 */
		this.labelQuellName = new JLabel(u.getAktiveKartei().getFrage());
		this.labelUbersetzungName = new JLabel(u.getAktiveKartei().getAntwort());

		/**
		 * Anzahl Karten in den Box wird augegeben
		 * 
		 */
		int kartenInBox = t.getAnzahlKartenInBox();
		kartenInBox++;
		this.labelUbersichtKarten = new JLabel(karteninBox1String + " " + kartenInBox + " " + karteninBox2String);
		this.labelRueckmeldung = new JLabel();

		this.textEingabeFrage = new JTextField();
		this.textEingabeFrage.setText(k.getFrage());

		this.textEingabeAntwort = new JTextField();

		this.buttonKontrollieren = new JButton(kontrollierenString);
		this.buttonAbbrechen = new JButton(boxWechselnString);
		this.buttonNaechsteKarte = new JButton(naechsteKarteString);

		this.buttonSwitch = new JButton(modusWechselnString);

	}

	/**
	 * Initialisiert das GUI.
	 */
	private void initGui() {
		setTitle(frameTitelString);
		setSize(700, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		/**
		 * Location auf dem Fenster Lernen setzten
		 * 
		 */
		this.labelTitelLerner.setBounds(10, 1, 300, 25);
		this.labelQuellName.setBounds(10, 100, 300, 25);
		this.labelUbersetzungName.setBounds(10, 180, 300, 25);
		this.labelUbersichtKarten.setBounds(10, 400, 300, 25);
		this.labelRueckmeldung.setBounds(10, 230, 500, 25);

		this.textEingabeFrage.setBounds(310, 100, 260, 25);
		this.textEingabeAntwort.setBounds(310, 180, 260, 25);

		this.buttonNaechsteKarte.setBounds(10, 300, 200, 25);
		this.buttonKontrollieren.setBounds(370, 300, 200, 25);
		this.buttonAbbrechen.setBounds(370, 400, 200, 25);
		this.buttonSwitch.setBounds(380, 140, 140, 25);

		this.textEingabeAntwort.addKeyListener(new keyList());
		this.textEingabeFrage.addKeyListener(new keyList());
		/**
		 * Hinzufügen zum Fenster Lernen
		 * 
		 */
		add(labelTitelLerner);
		add(labelQuellName);
		add(labelUbersetzungName);
		add(labelUbersichtKarten);
		add(labelRueckmeldung);
		add(textEingabeFrage);
		add(textEingabeAntwort);
		add(buttonNaechsteKarte);
		add(buttonKontrollieren);
		add(buttonAbbrechen);
		add(buttonSwitch);

		/**
		 * Instanzierung des Zustandes 1
		 * 
		 */
		textEingabeFrage.setText(k.getFrage());
		textEingabeFrage.setEditable(false);

		this.buttonNaechsteKarte.setVisible(false);

		this.buttonKontrollieren.addActionListener(new kontrollierenButton());
		this.buttonNaechsteKarte.addActionListener(new naechsteKarteButton());
		this.buttonSwitch.addActionListener(new switchButton());

		/**
		 * Listener, welche für das Schliessen des Fenster zuständig sind
		 * 
		 */
		this.buttonAbbrechen.addActionListener(new boxWaehlenButton());
		addWindowListener(new exitLernenFenster());

	}

	/**
	 * Kartei wechsel Button für WindowListener in TabLernen öffentlich machen
	 * 
	 */
	public JButton getButtonAbbrechen() {
		return buttonAbbrechen;
	}

	/**
	 * Handhabt die Funktion der Kartewechseln nach dem Random-Prinzip
	 */
	public void karteWechseln() {
		buttonNaechsteKarte.setVisible(false);
		buttonKontrollieren.setEnabled(true);
		labelRueckmeldung.setText("");

		t.gibZufallsKarteAusBox();
		int kartenInBox = t.getAnzahlKartenInBox();
		/**
		 * Muss gemacht werden, da bei Methode t.gibZufallsKarteAusBox bereits die Karte
		 * aus der sammlungBox entfernt wurde. Nur so wird die aktuell angezeigte Karte
		 * mitgezählt in der Anzeige kartenInBox++;
		 * 
		 */
		labelUbersichtKarten.setText(karteninBox1String + " " + kartenInBox + " " + karteninBox2String);
		k = t.getAktiveKarte();

		if (switchButton == true) {

			/**
			 * Check ob instanziertes k != null
			 */
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				fehlerdialog = new KeineKarten(u);
				this.buttonKontrollieren.setEnabled(false);
				this.buttonNaechsteKarte.setEnabled(false);
				this.buttonSwitch.setEnabled(false);
				this.textEingabeAntwort.setEnabled(false);
				this.labelUbersichtKarten.setText(karteninBox1String + " 0 " + karteninBox2String);
				return;
			}
			textEingabeFrage.setEditable(true);
			textEingabeFrage.setText(k.getFrage());
			textEingabeFrage.setEditable(false);
			textEingabeAntwort.setText("");

		}
		if (switchButton == false) {

			/**
			 * Check ob instanziertes k != null
			 * 
			 */
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				fehlerdialog = new KeineKarten(u);
				this.buttonKontrollieren.setEnabled(false);
				this.buttonNaechsteKarte.setEnabled(false);
				this.buttonSwitch.setEnabled(false);
				this.textEingabeFrage.setEnabled(false);
				this.labelUbersichtKarten.setText(karteninBox1String + " 0 " + karteninBox2String);
				return;
			}
			textEingabeAntwort.setEditable(true);
			textEingabeAntwort.setText(k.getAntwort());
			textEingabeAntwort.setEditable(false);
			textEingabeFrage.setText("");
		}

	}

	/**
	 * Kontrolliert die Eingabe mit der entsprechenden Lösung.
	 * 
	 */
	public void kontrolleEingabe() {
		buttonNaechsteKarte.setVisible(true);
		buttonKontrollieren.setEnabled(false);
		boolean check = t.antwortPruefen(textEingabeAntwort.getText(), textEingabeFrage.getText());

		if (check == true) {
			labelRueckmeldung.setForeground(new Color(0, 102, 0));
			labelRueckmeldung.setText(richtigBeantwortetString);
		}

		if (check == false) {
			labelRueckmeldung.setForeground(Color.RED);
			labelRueckmeldung.setText(falschBeantwortetString);
		}

		/**
		 * Karte wird nach Überprüfen der Eingabe neu in Trainingskartei abgelegt
		 * 
		 */
		t.aktiveKarteNeuInTrainingsKartei();

	}

	/**
	 * Definiert was passiert, wenn das Fenster mithilfe des ExitButtons oder
	 * Buttonabbrechen geschlossen wird.
	 * 
	 */
	private void exitLernen() {
		t.trainingsDatenAnUserdaten(u);
		t.karteiAnUser(u);
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		saveHandler.karteienSpeichern(u);
	}

	/**
	 * Definiert das Switchen zwischen der Frage-Eingabe und der Antwort-Eingabe
	 * 
	 */
	public void switchen() {
		if (switchButton == true) {
			switchButton = false;
			labelRueckmeldung.setText("");
			buttonKontrollieren.setEnabled(true);
			textEingabeFrage.setEditable(true);
			textEingabeFrage.setText("");
			textEingabeAntwort.setEditable(false);
			buttonNaechsteKarte.setVisible(false);
		} else {
			switchButton = true;
			labelRueckmeldung.setText("");
			buttonKontrollieren.setEnabled(true);
			textEingabeAntwort.setEditable(true);
			textEingabeAntwort.setText("");
			textEingabeFrage.setEditable(false);
			buttonNaechsteKarte.setVisible(false);
		}
		t.getSammlungBox().add(k);
		karteWechseln();
	}

	class kontrollierenButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			kontrolleEingabe();
		}
	}

	class naechsteKarteButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			karteWechseln();
		}
	}

	/**
	 * Wechselt die Abfragemöglichkeit vom Quell zum Zielwort
	 * 
	 */
	class switchButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switchen();
		}
	}

	class boxWaehlenButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	class exitLernenFenster implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent e) {
			exitLernen();

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			// exitLernen();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}
	class keyList implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				kontrolleEingabe();
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}
	}

}
