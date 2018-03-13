package Viewer.Buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Controller.UserSammlung;
import Model.User;
import SaveAndLoad.AbspeichernLaden;

/**
 * In dieser Klasse wird die ComboBox für die Auswahl der Benutzersprache
 * erstellt. 
 * 
 * @author Daniel Strassmann St.Gallen
 * @version 1.0 09.3.2018
 */
public class BenutzerspracheCombobox extends JComboBox implements ItemListener {

	private User u;
	private UserSammlung userliste;
	private String deutschString;
	private String englischString;
	private String franzoesischString;
	private String italienischString;
	private ArrayList<BenutzerspracheListener> listeners;

	public BenutzerspracheCombobox(User u, UserSammlung userliste) {
		this.u = u;
		this.userliste = userliste;
		setSprache();
		sprachComboboxAbfuellen();
		gespeicherteSpracheSetzen();
		bindListener();
		listeners = new ArrayList<>();

	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 */
	private void setSprache() {
		this.deutschString = "Deutsch";
		this.englischString = "English";
		this.franzoesischString = "Francais";
		this.italienischString = "Italiano";

	}

	/**
	 * Fügt die auswählbaren Sprachen der ComboBox hinzu
	 * 
	 */
	public void sprachComboboxAbfuellen() {
		addItem(deutschString);
		addItem(englischString);
		addItem(franzoesischString);
		addItem(italienischString);
	}

	/**
	 * Fügt dieser ComboBox den Listener hinzu
	 * 
	 */
	public void bindListener() {
		addItemListener(this);
	}

	/**
	 * Holt die gesetzte Sprache der letzten Session und setzt das entsprechende Item in der Combobox.
	 * 
	 */
	public void gespeicherteSpracheSetzen() {
		if (u.getBenutzersprache().equals("DE")) {
			setSelectedItem(deutschString);
		} else if (u.getBenutzersprache().equals("EN")) {
			setSelectedItem(englischString);
		} else if (u.getBenutzersprache().equals("FR")) {
			setSelectedItem(franzoesischString);
		} else if (u.getBenutzersprache().equals("IT")) {
			setSelectedItem(italienischString);
		}
	}

	/**
	 * Definiert den Listener und entscheidet, was passiert wenn man die
	 * Benutzersprache ändert.
	 * 
	 */
	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (getSelectedItem() == deutschString) {
				u.setBenutzersprache("DE");
			} else if (getSelectedItem() == englischString) {
				u.setBenutzersprache("EN");
			} else if (getSelectedItem() == franzoesischString) {
				u.setBenutzersprache("FR");
			} else if (getSelectedItem() == italienischString) {
				u.setBenutzersprache("IT");
			}
			AbspeichernLaden savehandler = new AbspeichernLaden();
			savehandler.userSpeichern(userliste);
			fireBenutzerspracheChanged();
		}
	}
/**
 *  eigener Listener damit die Sprache in das Hauptmenu übergeben werden kann.
 * @param listener 
 */
	public void addBenutzerspracheListener(BenutzerspracheListener listener) {
		listeners.add(listener);
	}
/**
 *  eigener Listener damit die Sprache in das Hauptmenu übergeben werden kann.
 */
	public void fireBenutzerspracheChanged() {
		for (BenutzerspracheListener l : listeners) {
			l.benutzerspracheChanged();
		}

	}
}
