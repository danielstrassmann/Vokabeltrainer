package Viewer.Popup;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Viewer.Tab.*;


public class Lernen extends JDialog{
	
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
	
	public Lernen(JFrame owner, int aktuelleBox)
	{
		super(owner);
		this.aktuelleBox = aktuelleBox;
		lernen();
		initGui();
	}
	
	private void lernen()
	{
		this.labelTitelLerner = new JLabel("Sie lernen aktuell in der Box " + aktuelleBox);
		this.labelQuellName = new JLabel("XXXX Quellkarteiname XXXX");
		this.labelUbersetzungName = new JLabel("XXXX Übersetzungskarteiname XXXX");
		this.labelUbersichtKarten = new JLabel("XXXX Es sind noch YY Karten in dieser Box " + aktuelleBox);
		this.labelRueckmeldung = new JLabel();
		
		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonKontrollieren = new JButton("Kontrollieren");
		this.buttonAbbrechen = new JButton("Kartei wechseln");
		this.buttonNaechsteKarte = new JButton("nächste Karte");
		
		this.buttonSwitch = new JButton("SWITCH");
		
		this.textKontrolleSwitch = new JTextField("1");
		this.textKontrolleBox = new JTextField();
	}
	
	private void initGui()
	{
		setTitle("aktives Lernen");
		setSize(700,500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		this.textKontrolleBox.setText("" + this.aktuelleBox);

		// Location auf dem Fenster Lernen setzten
		this.labelTitelLerner.setBounds		(10, 1, 300, 25);
		this.labelQuellName.setBounds		(10, 100, 300, 25);
		this.labelUbersetzungName.setBounds	(10, 150, 300, 25);
		this.labelUbersichtKarten.setBounds	(10, 400, 300 , 25);
		this.labelRueckmeldung.setBounds	(10, 230, 500 , 25);
		
		this.textEingabeFrage.setBounds		(310, 100, 260, 25);
		this.textEingabeAntwort.setBounds	(310, 150, 260, 25);
		
		this.buttonNaechsteKarte.setBounds	(10, 300, 200, 25);
		this.buttonKontrollieren.setBounds	(370, 300, 200, 25);
		this.buttonAbbrechen.setBounds		(370, 400, 200, 25);
		this.buttonSwitch.setBounds			(595, 125, 90, 25);
		
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
		
		//Kontrolle welche Box
		this.textKontrolleBox.setBounds		(595, 190, 60, 25);
		this.textKontrolleBox.setBackground(Color.BLUE);
		//Kontrolled Switchfunktion 
		this.textKontrolleSwitch.setBounds 	(595, 350, 50, 25);
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
	}
	
	public void kontrolleEingabe() {
		buttonNaechsteKarte.setVisible(true);
		buttonKontrollieren.setEnabled(false);
		if(textEingabeFrage.getText().equals(textEingabeAntwort.getText())) {
			labelRueckmeldung.setForeground(new Color(0,102,0));
			labelRueckmeldung.setText("Richtig, Team Optimus ist stolz auf dich");
		}
		else {
			labelRueckmeldung.setForeground(Color.RED);
			labelRueckmeldung.setText("Schade Marmelade, leider Falsch, Karte fliegt in die erste Box ");
		}
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
		}
		else {
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
		}
	}
	
}
