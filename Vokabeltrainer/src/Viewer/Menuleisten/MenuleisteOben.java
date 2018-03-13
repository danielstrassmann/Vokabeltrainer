package Viewer.Menuleisten;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.UserSammlung;
import Model.Kartei;
import Model.User;
import Viewer.Buttons.AbmeldeButton;
import Viewer.Buttons.BenutzerspracheCombobox;
import Viewer.Buttons.BenutzerspracheListener;
import Viewer.Buttons.KarteiAuswahlButton;
import Viewer.Buttons.KarteiErstellenButton;

/**
 * Diese Klasse wird f�r das GUI der Menueleiste gebraucht.
 * 
 * @author Daniel Strassmann St.Gallen / Marius Br�ndle
 * @version 1.0 09.3.2018
 */

public class MenuleisteOben extends JPanel {

	private JFrame parentFrame;

	private JLabel willkommen;
	private JLabel karteiBez;
	private JLabel spracheBez;

	private JPanel subPanelKartei;
	private JPanel subPanelBenutzer;
	private KarteiAuswahlButton kab;
	private KarteiErstellenButton kb;
	private BenutzerspracheCombobox bsb;
	private AbmeldeButton ab;

	private User u;
	private UserSammlung userliste;

	private String willkommenString;
	private String karteiString;
	private String spracheString;

	public MenuleisteOben(User u, UserSammlung userliste) {
		this.u = u;
		this.userliste = userliste;
		setSprache();
		menuleisteOben();
	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 */
	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.willkommenString = r.getString("willkommen");
		this.karteiString = r.getString("kartei");
		this.spracheString = r.getString("benutzersprache");
	}

	/**
	 * Erstellt alle Felder, welche ben�tigt werden.
	 */
	private void menuleisteOben() {
		setLayout(new BorderLayout(10, 10));
		setVisible(true);

		this.willkommen = new JLabel();

		this.willkommen.setText(willkommenString + " " + u.getBenutzername());
		add(this.willkommen, BorderLayout.LINE_START);

		this.karteiBez = new JLabel();
		this.karteiBez.setText(karteiString);
		this.subPanelKartei = new JPanel();
		kab = new KarteiAuswahlButton();

		kab.comboboxKarteiAbfuellen(u);

		this.kb = new KarteiErstellenButton(u, kab);
		this.subPanelKartei.add(karteiBez);
		this.subPanelKartei.add(kab);
		this.subPanelKartei.add(kb);

		add(this.subPanelKartei, BorderLayout.CENTER);

		this.spracheBez = new JLabel();
		this.spracheBez.setText(spracheString);
		this.subPanelBenutzer = new JPanel();
		this.ab = new AbmeldeButton(u);
		this.bsb = new BenutzerspracheCombobox(u, userliste);
		this.subPanelBenutzer.add(spracheBez);
		this.subPanelBenutzer.add(bsb);
		this.subPanelBenutzer.add(ab);

		add(subPanelBenutzer, BorderLayout.LINE_END);

		setBackground(Color.LIGHT_GRAY);
		subPanelKartei.setBackground(Color.LIGHT_GRAY);
		subPanelBenutzer.setBackground(Color.LIGHT_GRAY);

		u.setAktiveKartei((Kartei) kab.getSelectedItem());

	}

	/**
	 * Itemlistener damit im Hauptmenu die neue ausgew�hlte Kartei empfangen und
	 * weitergegeben werden kann
	 * 
	 * @param itemListener ausgew�hlte Kartei
	 */
	public void addItemChangeListener(ItemListener itemListener) {
		kab.addItemListener(itemListener);

	}

	/**
	 * Itemlistener damit im Hauptmenu die neue ausgew�hlte Sprache empfangen und
	 * weitergegeben werden kann.
	 * 
	 * @param listener BenutzerspracheListener
	 */
	public void addBenutzerspracheChanged(BenutzerspracheListener listener) {
		bsb.addBenutzerspracheListener(listener);
	}

	/**
	 * Methode damit die Sprache aktualisiert wird
	 */
	public void spracheAktualisieren() {
		setSprache();
		this.willkommen.setText(willkommenString + " " + u.getBenutzername());
		this.karteiBez.setText(karteiString);
		this.spracheBez.setText(spracheString);
	}

	public void buttonSpracheAktualisieren() {

		// Wenn Sprache ge�ndert, wird Sprache im GUI aktualisiert
		this.kb.spracheAktualisieren();
		this.ab.spracheAktualisieren();

	}

}
