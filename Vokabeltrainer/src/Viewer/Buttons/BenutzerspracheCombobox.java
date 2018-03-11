package Viewer.Buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import Controller.UserSammlung;
import Model.User;
import SaveAndLoad.AbspeichernLaden;

public class BenutzerspracheCombobox extends JComboBox implements ItemListener {

	private User u;
	private UserSammlung userliste;
	private String deutschString;
	private String englischString;
	private String franzoesischString;
	private String italienischString;

	public BenutzerspracheCombobox(User u, UserSammlung userliste) {
		this.u = u;
		this.userliste = userliste;
		setSprache();
		sprachComboboxAbfuellen();
		gespeicherteSpracheSetzen();
		bindListener();

	}

	private void setSprache() {
		this.deutschString = "Deutsch";
		this.englischString = "English";
		this.franzoesischString = "Francais";
		this.italienischString = "Italiano";

	}

	public void sprachComboboxAbfuellen() {
		addItem(deutschString);
		addItem(englischString);
		addItem(franzoesischString);
		addItem(italienischString);
	}

	public void bindListener() {
		addItemListener(this);
	}

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
		}
	}
}
