package Viewer.Buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;

import Model.User;

public class BenutzerspracheComboboxNice extends JComboBox implements ItemListener  {
	private User u;
	private String benutzersprache;
	private String deutschString;
	private String englischString;
	private String franzoesischString;
	private String italienischString;
	// private Locale l;
	// private ResourceBundle r;

	public BenutzerspracheComboboxNice(User u) {
		this.u = u;
		setSprache();
		sprachComboboxAbfuellen();
		gespeicherteSpracheSetzen();
		bindListener();

	}

	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.deutschString = r.getString("deutsch");
		this.englischString = r.getString("englisch");
		this.franzoesischString = r.getString("franzoesisch");
		this.italienischString = r.getString("italienisch");

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
			System.out.println("deutsch wurde gesetzt");
		} else if (getSelectedItem() == englischString) {
			u.setBenutzersprache("EN");
		} else if (getSelectedItem() == franzoesischString) {
			u.setBenutzersprache("FR");
		} else if (getSelectedItem() == italienischString) {
			u.setBenutzersprache("IT");
		}
		 setSprache();
		 removeAllItems();
		 sprachComboboxAbfuellen();
		// AbspeichernLaden saveHandler = new AbspeichernLaden();
		// File savedUser = saveHandler.userSpeichern(userliste);
	}

	}}
