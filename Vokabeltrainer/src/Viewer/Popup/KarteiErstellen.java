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
import SaveAndLoad.AbspeichernLaden;
import Viewer.Buttons.KarteiAuswahlButton;
import Viewer.Menu.HauptmenuNeu;

public class KarteiErstellen extends JDialog implements ActionListener {
	private KarteiController kc = new KarteiController();
	private User u;
	private KarteiAuswahlButton kab; 

	private JLabel labelTitelKartei;
	private JLabel labelBezFrage;
	private JLabel labelBezAntwort;
	private JLabel labelNachricht;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonAnlegen;
	private JButton buttonAbbrechen;

	public KarteiErstellen(User u,KarteiAuswahlButton kab ) {
		this.kab = kab;
		this.u = u;
		initComponents();
		initGui();
		bindListener();

	}

	public void initComponents() {
		this.labelTitelKartei = new JLabel("Bitte erstellen Sie eine neue Kartei");
		this.labelBezFrage = new JLabel("Bezeichnung der Quelle eingeben");
		this.labelBezAntwort = new JLabel("Bezeichnung der Übersetzung eingeben");
		this.labelNachricht = new JLabel("");

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton("Anlegen");
		this.buttonAbbrechen = new JButton("Schliessen");
	}

	public void initGui() {
		setLayout(null);
		setSize(310, 280);
		setResizable(false);
		setTitle("Kartei anlegen");
		setVisible(true);
		setLocationRelativeTo(null);
		// setModalityType(DEFAULT_MODALITY_TYPE);
		setAlwaysOnTop(true);

		this.labelTitelKartei.setBounds(20, 1, 200, 30);
		this.labelBezFrage.setBounds(20, 40, 350, 25);
		this.labelBezAntwort.setBounds(20, 100, 350, 25);
		this.labelNachricht.setBounds(20, 160, 350, 25);

		this.textEingabeFrage.setBounds(20, 65, 250, 25);
		this.textEingabeAntwort.setBounds(20, 125, 250, 25);

		this.buttonAnlegen.setBounds(20, 200, 120, 25);
		this.buttonAbbrechen.setBounds(150, 200, 120, 25);

		add(labelTitelKartei);
		add(labelBezFrage);
		add(labelBezAntwort);
		add(labelNachricht);

		add(textEingabeFrage);
		add(textEingabeAntwort);

		add(buttonAnlegen);
		add(buttonAbbrechen);
	}

	public void bindListener() {
		buttonAnlegen.addActionListener(this);
		buttonAbbrechen.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		if (e.getSource() == this.buttonAnlegen) {
			if (textEingabeFrage.getText().equals("") || textEingabeAntwort.getText().equals("")) {

				labelNachricht.setForeground(Color.red);
				labelNachricht.setText("Bitte Quelle und Übersetzung eingeben");

			} else {
				String frageKarteiHinzu = textEingabeFrage.getText();
				String antwortKarteihinzu = textEingabeAntwort.getText();
				kc.karteiErstellen(frageKarteiHinzu, antwortKarteihinzu, u);
				labelNachricht.setForeground(new Color(0, 102, 0));
				labelNachricht.setText("Kartei erfolgreich angelegt");
				textEingabeFrage.setText(null);
				textEingabeAntwort.setText(null);
				kab.comboboxKarteiAbfuellen(u);
				saveHandler.karteienSpeichern(u);
				
			}
		} else if (e.getSource() == this.buttonAbbrechen) {
		
			dispose();
		}

	}

}
