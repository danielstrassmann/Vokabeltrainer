package Viewer.Popup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.KarteiController;
import Model.User;

public class KarteiErstellen extends JDialog 
{
	KarteiController kc = new KarteiController();
	User u = new User();
	private JLabel labelTitelKartei;
	private JLabel labelBezFrage;
	private JLabel labelBezAntwort;
	private JLabel labelFehler;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonAnlegen;
	private JButton buttonAbbrechen;

	public KarteiErstellen() {
		initComponents();
		bindListener();
		initGui();

	}

	public void initComponents() {
		this.labelTitelKartei = new JLabel("Bitte erstellen Sie eine neue Kartei");
		this.labelBezFrage = new JLabel("Bezeichnung der Quelle eingeben");
		this.labelBezAntwort = new JLabel("Bezeichnung der Übersetzung eingeben");
		this.labelFehler = new JLabel ("");
		

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton("Anlegen");
		this.buttonAbbrechen = new JButton("Abbrechen");
	}

	public void bindListener() {
		buttonAnlegen.addActionListener(new anlegenButtonListener());
		buttonAbbrechen.addActionListener(new abbrechenButtonListener());
	}

	public void initGui() {
		setLayout(null);
		setSize(310, 280);
		setResizable(false);
		setTitle("Kartei anlegen");
		setVisible(true);
		setLocationRelativeTo(null);

		this.labelTitelKartei.setBounds(20, 1, 200, 30);
		this.labelBezFrage.setBounds(20, 40, 350, 25);
		this.labelBezAntwort.setBounds(20, 100, 350, 25);
		this.labelFehler.setBounds(20, 160, 350, 25);
		this.labelFehler.setForeground(Color.red);

		this.textEingabeFrage.setBounds(20, 65, 250, 25);
		this.textEingabeAntwort.setBounds(20, 125, 250, 25);

		this.buttonAnlegen.setBounds(20, 200, 120, 25);
		this.buttonAbbrechen.setBounds(150, 200, 120, 25);

		add(labelTitelKartei);
		add(labelBezFrage);
		add(labelBezAntwort);
		add(labelFehler);

		add(textEingabeFrage);
		add(textEingabeAntwort);

		add(buttonAnlegen);
		add(buttonAbbrechen);

	}

	class anlegenButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (textEingabeFrage.getText().equals("") || textEingabeAntwort.getText().equals("")) {
				String frageKarteiHinzu = textEingabeFrage.getText();
				String antwortKarteihinzu = textEingabeAntwort.getText();
				kc.karteiErstellen(frageKarteiHinzu, antwortKarteihinzu, u);

				System.out.println("kartei anlegen");
			} else {
				labelFehler.setText("Bitte Quelle und Übersetzung eingeben");
			}
		}
	}

	class abbrechenButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("abbrechen button gedrückt");
			System.exit(0);
		}

	}
}
