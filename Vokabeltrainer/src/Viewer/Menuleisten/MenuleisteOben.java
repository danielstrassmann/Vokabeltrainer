package Viewer.Menuleisten;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Buttons.*;

public class MenuleisteOben extends JPanel {

	private JLabel willkommen;
	private JLabel karteiBez;
	private JLabel spracheBez;
	
	private JPanel subPanelKartei;
	private JPanel subPanelBenutzer;
	
	public MenuleisteOben() {
		menuleisteOben();
	}

	/*
	 * private void menuleisteOben() { setLayout(new BorderLayout());
	 * setVisible(true);
	 * 
	 * KarteiButton kb = new KarteiButton(); add(kb);
	 * 
	 * 
	 * 
	 * BenutzerspracheButton bsb = new BenutzerspracheButton(); add(bsb,
	 * BorderLayout.CENTER);
	 * 
	 * KarteiAuswahlButton kab = new KarteiAuswahlButton(); add(kab,
	 * BorderLayout.CENTER);
	 * 
	 * AbmeldeButton ab = new AbmeldeButton(); add(ab,BorderLayout.CENTER); }
	 */

	private void menuleisteOben() {
		setLayout(new BorderLayout(10, 10));
		setVisible(true);

		this.willkommen = new JLabel();
		this.willkommen.setText("Willkommen Benutzer");
		add(this.willkommen, BorderLayout.LINE_START);
		
		this.karteiBez = new JLabel();
		this.karteiBez.setText("Kartei");
		this.subPanelKartei = new JPanel();
		KarteiAuswahlButton kab = new KarteiAuswahlButton();
		KarteiButton kb = new KarteiButton();
		this.subPanelKartei.add(karteiBez);
		this.subPanelKartei.add(kab);
		this.subPanelKartei.add(kb);

		add(this.subPanelKartei, BorderLayout.CENTER);

		this.spracheBez = new JLabel();
		this.spracheBez.setText("Benutzersprache");
		this.subPanelBenutzer = new JPanel();
		AbmeldeButton ab = new AbmeldeButton();
		BenutzerspracheButton bsb = new BenutzerspracheButton();
		this.subPanelBenutzer.add(spracheBez);
		this.subPanelBenutzer.add(bsb);
		this.subPanelBenutzer.add(ab);

		add(subPanelBenutzer, BorderLayout.LINE_END);

	}
}
