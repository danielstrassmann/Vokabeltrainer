package Viewer.Popup;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Model.*;
import SaveAndLoad.AbspeichernLaden;

/**
 * Diese Klasse wird für das Lernfenster gebraucht
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

	// Popup-Fehlerdialog, wenn keine Karten mehr in der Box sind
	private KeineKarten fehlerdialog;

	public Lernen(User u, JFrame owner, int aktuelleBox) {

		super(owner);
		// wird benötigt, damit Training sauber verlassen werden kann

		this.u = u;
		this.aktuelleBox = aktuelleBox;
		this.switchButton = true;
		t = new Training(u, this.aktuelleBox);
		t.gibZufallsKarteAusBox();
		k = t.getAktiveKarte();
		lernen();
		initGui();
	}

	private void lernen() {
		this.labelTitelLerner = new JLabel("Sie lernen aktuell in der Box " + aktuelleBox);
		// Kartei Quellsprache & Zielsprache im UI anzeigen
		this.labelQuellName = new JLabel(u.getAktiveKartei().getFrage());
		this.labelUbersetzungName = new JLabel(u.getAktiveKartei().getAntwort());
		// Anzahl Karten in den Box wird augegeben
		int kartenInBox = t.getAnzahlKartenInBox();
		kartenInBox++;
		this.labelUbersichtKarten = new JLabel("Es sind noch " + kartenInBox + " Karten in dieser Box.");
		this.labelRueckmeldung = new JLabel();

		this.textEingabeFrage = new JTextField();
		this.textEingabeFrage.setText(k.getFrage());

		this.textEingabeAntwort = new JTextField();

		this.buttonKontrollieren = new JButton("Kontrollieren");
		this.buttonAbbrechen = new JButton("Box wechseln");
		this.buttonNaechsteKarte = new JButton("nächste Karte");

		this.buttonSwitch = new JButton("Switch");


	}

	private void initGui() {
		setTitle("Training");
		setSize(700, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		// Location auf dem Fenster Lernen setzten
		this.labelTitelLerner.setBounds(10, 1, 300, 25);
		this.labelQuellName.setBounds(10, 100, 300, 25);
		this.labelUbersetzungName.setBounds(10, 150, 300, 25);
		this.labelUbersichtKarten.setBounds(10, 400, 300, 25);
		this.labelRueckmeldung.setBounds(10, 230, 500, 25);

		this.textEingabeFrage.setBounds(310, 100, 260, 25);
		this.textEingabeAntwort.setBounds(310, 150, 260, 25);

		this.buttonNaechsteKarte.setBounds(10, 300, 200, 25);
		this.buttonKontrollieren.setBounds(370, 300, 200, 25);
		this.buttonAbbrechen.setBounds(370, 400, 200, 25);
		this.buttonSwitch.setBounds(595, 125, 90, 25);

		// Hinzufügen zum Fenster Lernen
		add(labelTitelLerner);
		add(labelQuellName);
		add(labelUbersetzungName);
		add(labelUbersichtKarten);
		add(labelRueckmeldung);

		add(textEingabeFrage);
		add(textEingabeAntwort);
		// add(textKontrolleBox);

		add(buttonNaechsteKarte);
		add(buttonKontrollieren);
		add(buttonAbbrechen);
		add(buttonSwitch);

		// Instanzierung des Zustandes 1
		textEingabeFrage.setText(k.getFrage());
		textEingabeFrage.setEditable(false);

		this.buttonNaechsteKarte.setVisible(false);

		this.buttonKontrollieren.addActionListener(new kontrollierenButton());
		this.buttonNaechsteKarte.addActionListener(new naechsteKarteButton());
		this.buttonSwitch.addActionListener(new switchButton());

		// Listener, welche für das Schliessen des Fenster zuständig sind
		this.buttonAbbrechen.addActionListener(new boxWaehlenButton());
		addWindowListener(new exitLernenFenster());

	}

	// Kartei wechsel Button für WindowListener in TabLernen öffentlich machen
	public JButton getButtonAbbrechen() {
		return buttonAbbrechen;
	}

	public void karteWechseln() {
		buttonNaechsteKarte.setVisible(false);
		buttonKontrollieren.setEnabled(true);
		labelRueckmeldung.setText("");

		t.gibZufallsKarteAusBox();
		int kartenInBox = t.getAnzahlKartenInBox();
		// Muss gemacht werden, da bei Methode t.gibZufallsKarteAusBox bereits die Karte
		// aus der sammlungBox entfernt wurde
		// Nur so wird die aktuell angezeigte Karte mitgezählt in der Anzeige
		kartenInBox++;
		labelUbersichtKarten.setText("Es sind noch " + kartenInBox + " Karten in dieser Box.");
		k = t.getAktiveKarte();

		if (switchButton == true) {

			// Check ob instanziertes k != null
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				fehlerdialog = new KeineKarten();
				this.buttonKontrollieren.setEnabled(false);
				this.buttonNaechsteKarte.setEnabled(false);
				this.buttonSwitch.setEnabled(false);
				this.textEingabeAntwort.setEnabled(false);
				this.labelUbersichtKarten.setText("Es sind noch 0 Karten in dieser Box.");
				exitLernen();
				return;
			}
			textEingabeFrage.setEditable(true);
			textEingabeFrage.setText(k.getFrage());
			textEingabeFrage.setEditable(false);
			textEingabeAntwort.setText("");

		}
		if (switchButton == false) {

			// Check ob instanziertes k != null
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				fehlerdialog = new KeineKarten();
				this.buttonKontrollieren.setEnabled(false);
				this.buttonNaechsteKarte.setEnabled(false);
				this.buttonSwitch.setEnabled(false);
				this.textEingabeFrage.setEnabled(false);
				this.labelUbersichtKarten.setText("Es sind noch 0 Karten in dieser Box.");
				exitLernen();
				return;
			}
			textEingabeAntwort.setEditable(true);
			textEingabeAntwort.setText(k.getAntwort());
			textEingabeAntwort.setEditable(false);
			textEingabeFrage.setText("");
		}

	}

	public void kontrolleEingabe() {
		buttonNaechsteKarte.setVisible(true);
		buttonKontrollieren.setEnabled(false);
		boolean check = t.antwortPruefen(textEingabeAntwort.getText(), textEingabeFrage.getText());

		if (check == true) {
			labelRueckmeldung.setForeground(new Color(0, 102, 0));
			labelRueckmeldung.setText("Antwort Korrekt! Karte geht in nächste Box.");
		}
		if (check == false) {
			labelRueckmeldung.setForeground(Color.RED);
			labelRueckmeldung.setText("Antwort Falsch! Karte geht in erste Box.");
		}

		// Karte wird nach Überprüfen der Eingabe neu in Trainingskartei abgelegt
		t.aktiveKarteNeuInTrainingsKartei();

	}

	private void exitLernen() {
		t.trainingsDatenAnUserdaten(u);
		t.karteiAnUser(u);
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		saveHandler.karteienSpeichern(u);
	}

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

	// Wechselt die Abfragemöglichkeit vom Quell zum Zielwort
	class switchButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switchen();
		}
	}

	class boxWaehlenButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			exitLernen();

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
			exitLernen();
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

}
