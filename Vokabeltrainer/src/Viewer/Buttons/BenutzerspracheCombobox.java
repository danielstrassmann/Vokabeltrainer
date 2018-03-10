package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.User;
import SaveAndLoad.AbspeichernLaden;

public class BenutzerspracheCombobox extends JComboBox implements ItemListener {

	private User u;
	private String benutzersprache;
	private String deutschString;
	private String englischString;
	private String franzoesischString;
	private String italienischString;

	public BenutzerspracheCombobox(User u) {
		this.u = u;
		setSprache();
		sprachComboboxAbfuellen();
		gespeicherteSpracheSetzen();
		bindListener();

	}

	private void setSprache() {
		//Locale l = new Locale(u.getBenutzersprache());
	//	ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.deutschString = "DE";
		this.englischString = "EN";
		this.franzoesischString = "FR";
		this.italienischString = "IT";

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
		} else if (u.getBenutzersprache().equals("it")) {
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
		 setSprache();
		// AbspeichernLaden saveHandler = new AbspeichernLaden();
		// File savedUser = saveHandler.userSpeichern(userliste);
	}
}}
