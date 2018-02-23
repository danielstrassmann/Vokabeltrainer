package Viewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KarteiErstellen extends JDialog {

	private JLabel labelTitelKartei;
	private JLabel labelBezFrage;
	private JLabel labelBezAntwort;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonAnlegen;
	private JButton buttonAbbrechen;

	public KarteiErstellen() {
		initComponents();
		initGui();
	}

	public void initComponents() {
		this.labelTitelKartei = new JLabel("Bitte erstellen Sie eine neue Kartei");
		this.labelBezFrage = new JLabel("Bezeichnung der Frage eingeben");
		this.labelBezAntwort = new JLabel("Bezeichnung der Antwort eingeben");

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton("Anlegen");
		this.buttonAbbrechen = new JButton("Abbrechen");

	}

	public void initGui() {
		setLayout(null);
		setSize(520, 280);
		setResizable(false);
		setTitle("Kartei anlegen");
		setVisible(true);
		setLocationRelativeTo(null);

		this.labelTitelKartei.setBounds(10, 1, 200, 30);
		this.labelBezFrage.setBounds(10, 60, 200, 25);
		this.labelBezAntwort.setBounds(10, 100, 200, 25);

		this.textEingabeFrage.setBounds(250, 60, 250, 25);
		this.textEingabeAntwort.setBounds(250, 100, 250, 25);

		this.buttonAnlegen.setBounds(250, 200, 120, 25);
		this.buttonAbbrechen.setBounds(380, 200, 120, 25);

		add(labelTitelKartei);
		add(labelBezFrage);
		add(labelBezAntwort);

		add(textEingabeFrage);
		add(textEingabeAntwort);

		add(buttonAnlegen);
		add(buttonAbbrechen);

	}
}
