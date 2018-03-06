package Viewer.Popup;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Viewer.Tab.*;

import Model.*;

public class Lernen extends JDialog {

	private JLabel labelTitelLerner;
	private JLabel labelQuellName;
	private JLabel labelUbersetzungName;
	private JLabel labelUbersichtKarten;
	private JLabel labelRueckmeldung;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JTextField textKontrolleSwitch;
	private JTextField textKontrolleBox;

	private JButton buttonKontrollieren;
	private JButton buttonAbbrechen;
	private JButton buttonNaechsteKarte;
	private JButton buttonSwitch;

	private int aktuelleBox;

	private Training t;
	private Karte k;

	private User u;

	public Lernen(User u, JFrame owner, int aktuelleBox) {
		
		super(owner);
		this.u = u;
		this.aktuelleBox = aktuelleBox;
		Training t = new Training(u, this.aktuelleBox);
		t.gibZufallsKarteAusBox();
		k = t.getAktiveKarte();
		lernen();
		initGui();
	}

	private void lernen() {
		this.labelTitelLerner = new JLabel("Sie lernen aktuell in der Box " + aktuelleBox);
		this.labelQuellName = new JLabel("XXXX Quellkarteiname XXXX");
		this.labelUbersetzungName = new JLabel("XXXX Übersetzungskarteiname XXXX");
		this.labelUbersichtKarten = new JLabel("XXXX Es sind noch YY Karten in dieser Box " + aktuelleBox);
		this.labelRueckmeldung = new JLabel();

		this.textEingabeFrage = new JTextField();
		this.textEingabeFrage.setText(k.getFrage());

		this.textEingabeAntwort = new JTextField();

		this.buttonKontrollieren = new JButton("Kontrollieren");
		this.buttonAbbrechen = new JButton("Box wechseln");
		this.buttonNaechsteKarte = new JButton("nächste Karte");

		this.buttonSwitch = new JButton("SWITCH");

		this.textKontrolleSwitch = new JTextField("1");
		this.textKontrolleBox = new JTextField();

	}

	private void initGui() {
		setTitle("aktives Lernen");
		setSize(700, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		this.textKontrolleBox.setText("" + this.aktuelleBox);

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
		add(textKontrolleBox);

		add(buttonNaechsteKarte);
		add(buttonKontrollieren);
		add(buttonAbbrechen);
		add(buttonSwitch);

		// Instanzierung des Zustandes 1
		textEingabeFrage.setText("FRAGE sollte hier stehen");
		textEingabeFrage.setEditable(false);

		this.buttonNaechsteKarte.setVisible(false);

		this.buttonKontrollieren.addActionListener(new kontrollierenButton());
		this.buttonNaechsteKarte.addActionListener(new naechsteKarteButton());
		this.buttonSwitch.addActionListener(new switchButton());
		
		// Listener, welche für das Schliessen des Fenster zuständig sind
		this.buttonAbbrechen.addActionListener(new boxWaehlenButton());
		addWindowListener(new exitLernenFenster());

		// Kontrolle welche Box
		this.textKontrolleBox.setBounds(595, 190, 60, 25);
		this.textKontrolleBox.setBackground(Color.BLUE);
		// Kontrolled Switchfunktion
		this.textKontrolleSwitch.setBounds(595, 350, 50, 25);
		textKontrolleSwitch.setBackground(Color.RED);
		add(textKontrolleSwitch);

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
		k = t.getAktiveKarte();

		if (textKontrolleSwitch.getText().equals("1")) {

			// Check ob instanziertes k != null
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				dispose();
			}
			textEingabeFrage.setEditable(true);
			textEingabeFrage.setText(k.getFrage());
			textEingabeFrage.setEditable(false);
		}
		if (textKontrolleSwitch.getText().equals("2")) {

			// Check ob instanziertes k != null
			if (k == null) {
				System.out.println("Keine Karten mehr vorhanden in Box");
				dispose();
			}
			textEingabeAntwort.setEditable(true);
			textEingabeAntwort.setText(k.getAntwort());
			textEingabeAntwort.setEditable(false);
		}

	}

	public void kontrolleEingabe() {
		buttonNaechsteKarte.setVisible(true);
		buttonKontrollieren.setEnabled(false);
		boolean check = t.antwortPruefen(textEingabeAntwort.getText(), textEingabeFrage.getText());
		
		
		if ( check == true) {
			labelRueckmeldung.setForeground(new Color(0, 102, 0));
			labelRueckmeldung.setText("Richtig, Team Optimus ist stolz auf dich");
		} 
		if(check == false) { 
			labelRueckmeldung.setForeground(Color.RED);
			labelRueckmeldung.setText("Schade Marmelade, leider Falsch, Karte fliegt in die erste Box ");
		}
		
		// Karte wird nach Überprüfen der Eingabe neu in Trainingskartei abgelegt
		t.aktiveKarteNeuInTrainingsKartei();

	}

	private void exitLernen() {
		t.trainingsDatenAnUserdaten(u);
		t.karteiAnUser(u);
	}
	
	public void switchen() {
		if (textKontrolleSwitch.getText().equals("1")) {
			textKontrolleSwitch.setText("2");
			labelRueckmeldung.setText("");
			buttonKontrollieren.setEnabled(true);
			textEingabeFrage.setEditable(true);
			textEingabeFrage.setText("");
			textEingabeAntwort.setText("ANTWORT sollte hier stehen");
			textEingabeAntwort.setEditable(false);
			buttonNaechsteKarte.setVisible(false);
		} else {
			textKontrolleSwitch.setText("1");
			labelRueckmeldung.setText("");
			buttonKontrollieren.setEnabled(true);
			textEingabeAntwort.setEditable(true);
			textEingabeAntwort.setText("");
			textEingabeFrage.setText("FRAGE sollte hier stehen");
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
			karteWechseln();
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
