package Viewer.Menuleisten;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Model.Kartei;
import Model.User;
import Viewer.Buttons.*;

/**
 * Diese Klasse wird für das GUI der Menueleiste gebraucht
 * 
 * @author Marius Brändle St.Gallen
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
	
	private User u;
	
	public MenuleisteOben(User u) {
		this.u = u;
		menuleisteOben();
	}

	private void menuleisteOben() 
	{
		setLayout(new BorderLayout(10, 10));
		setVisible(true);


		this.willkommen = new JLabel();

		this.willkommen.setText("Willkommen Benutzer");
		add(this.willkommen, BorderLayout.LINE_START);
		
		this.karteiBez = new JLabel();
		this.karteiBez.setText("Kartei");
		this.subPanelKartei = new JPanel();
		kab = new KarteiAuswahlButton();
		
		kab.comboboxKarteiAbfuellen(u);
		
		KarteiButton kb = new KarteiButton(u,kab);
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

		setBackground(Color.LIGHT_GRAY);
		subPanelKartei.setBackground(Color.LIGHT_GRAY);
		subPanelBenutzer.setBackground(Color.LIGHT_GRAY);
		
		u.setAktiveKartei((Kartei)kab.getSelectedItem());
		
	}
	
	public void addItemChangeListener(ItemListener itemListener) {
		kab.addItemListener(itemListener);
	}
	
}
