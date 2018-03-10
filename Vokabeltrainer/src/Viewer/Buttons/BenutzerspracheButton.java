package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.User;

/**
 * Diese Klasse wird für die Benutzersprache gebraucht
 * Diese Klasse generiert die Combobox "Benutzersprache" Wenn diese Combobox betätigt
 * wird, kann die Menusprache gewechselt werden
 * Der Combobox wird der Klasse "MenuLeisteOben" und "anmeldefenster" hinzugefügt.
 * 
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class BenutzerspracheButton extends JComboBox

{
	public String sprachName;
	public String sprachCode;

	User u;
	String value = new String();

	public BenutzerspracheButton() {
		benutzerSprache();

	}

	public void benutzerSprache() {
		addItem("Deutsch");
		addItem("français");
		addItem("english");
		addItem("italiano");

		setVisible(true);
		setSize(200, 200);

		addItemListener(new SpracheChangeListener());

		getSprachCode();

	}

	public void getSprachCode() {
		this.sprachName = String.valueOf(getSelectedItem());
		if (this.sprachName == "Deutsch") {
			String sprachCode = "DE";
			int lang = 0;
		}
		if (this.sprachName == "français") {
			String sprachCode = "FR";
			int lang = 1;
		}
		if (this.sprachName == "english") {
			String sprachCode = "EN";
			int lang = 2;
		}
		if (this.sprachName == "italiano") {
			String sprachCode = "IT";
			int lang = 3;
		} else {

		}

	}

	class SpracheChangeListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent langEvent) {
			// TODO Auto-generated method stub

			getSprachCode();
		}
	}

}