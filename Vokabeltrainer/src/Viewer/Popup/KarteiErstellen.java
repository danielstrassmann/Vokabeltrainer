package Viewer.Popup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.AbspeichernLaden;
import Controller.KarteiController;
import Model.User;
import Viewer.Buttons.KarteiAuswahlButton;

/**
 * Diese Klasse wird für das GUI der Karteierstellung gebraucht Diese Klasse
 * generiert den Inhalt des Popup-Fenster "KarteiErstellen. Diese Klasse wird
 * mit dem Button "Kartei erstellen" von der Klasse "HauptmenuNeu* aufgerufen.
 * In dieser Klasse kan man eine neue Kartei erstellen, bei welcher die
 * Bezeichnung der Frage und Antwort mitgegeben wird.
 * 
 * @author Daniel Strassmann St.Gallen / Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class KarteiErstellen extends JDialog implements ActionListener {
	private KarteiController kc;
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

	private String dialogTitelString;
	private String titelKarteiString;
	private String bezFrageString;
	private String bezAntwortString;
	private String nachrichtRichtigString;
	private String nachrichtFalschString;
	private String anlegenButtonString;
	private String schliessenButtonString;

	/**
	 * PopUp KarteiErstellen erstellen
	 * 
	 * @param u
	 *            Instanz des eingeloggten Users
	 * 
	 * @param kab
	 *            Nimmt den KarteiAuswahlButton mit
	 */
	public KarteiErstellen(User u, KarteiAuswahlButton kab) {
		this.kab = kab;
		this.u = u;
		this.kc = new KarteiController(this.u);
		setSprache();
		initComponents();
		initGui();
		bindListener();

	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 */
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.dialogTitelString = r.getString("karteiErstellen");
		this.titelKarteiString = r.getString("karteiInfotext");
		this.bezFrageString = r.getString("karteiQuelleEingeben");
		this.bezAntwortString = r.getString("karteiUebersetzungEingeben");
		this.nachrichtRichtigString = r.getString("karteiErfolgreichInfotext");
		this.nachrichtFalschString = r.getString("karteiFehlerInfotext");
		this.anlegenButtonString = r.getString("erstellen");
		this.schliessenButtonString = r.getString("schliessen");
	}

	/**
	 * Erstellt alle Felder, welche benötigt werden.
	 */

	public void initComponents() {
		this.labelTitelKartei = new JLabel(titelKarteiString);
		this.labelBezFrage = new JLabel(bezFrageString);
		this.labelBezAntwort = new JLabel(bezAntwortString);
		this.labelNachricht = new JLabel("");

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton(anlegenButtonString);
		this.buttonAbbrechen = new JButton(schliessenButtonString);
	}

	/**
	 * Initialisiert das GUI.
	 */
	public void initGui() {
		setLayout(null);
		setSize(310, 280);
		setResizable(false);
		setTitle(dialogTitelString);
		setVisible(true);
		setLocationRelativeTo(null);
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

	/**
	 * Fügt die Listeners den einzelnen Felder zu.
	 */
	public void bindListener() {
		buttonAnlegen.addActionListener(this);
		buttonAbbrechen.addActionListener(this);
	}

	/**
	 * Erstellt den Buttonlistener Hier wird abgefangen, ob wirklich eine gültige
	 * Kartei erstellt wurde. Einge gültige Kartei ist nur wenn beide Felder
	 * abgefüllt sind.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		if (e.getSource() == this.buttonAnlegen) {
			if (textEingabeFrage.getText().equals("") || textEingabeAntwort.getText().equals("")) {

				labelNachricht.setForeground(Color.red);
				labelNachricht.setText(nachrichtFalschString);

			} else {
				String frageKarteiHinzu = textEingabeFrage.getText();
				String antwortKarteihinzu = textEingabeAntwort.getText();
				kc.karteiErstellen(frageKarteiHinzu, antwortKarteihinzu, u);
				labelNachricht.setForeground(new Color(0, 102, 0));
				labelNachricht.setText(nachrichtRichtigString);
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
