package Viewer.Menuleisten;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import Model.Kartei;
import Model.User;
import Viewer.Buttons.*;

/**
 * Diese Klasse wird f�r das GUI der Menueleiste gebraucht
 * 
 * @author Marius Br�ndle St.Gallen
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
	
	private String willkommenString;
	private String karteiString;
	private String spracheString;
	
	public MenuleisteOben(User u) {
		this.u = u;
		setSprache();
		menuleisteOben();
	}
	
	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.willkommenString = r.getString("willkommen");
		this.karteiString = r.getString("kartei");
		this.spracheString = r.getString("benutzersprache");
	}
	

	private void menuleisteOben() 
	{
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
		
		KarteiErstellenButton kb = new KarteiErstellenButton(u,kab);
		this.subPanelKartei.add(karteiBez);
		this.subPanelKartei.add(kab);
		this.subPanelKartei.add(kb);

		add(this.subPanelKartei, BorderLayout.CENTER);

		this.spracheBez = new JLabel();
		this.spracheBez.setText(spracheString);
		this.subPanelBenutzer = new JPanel();
		AbmeldeButton ab = new AbmeldeButton(u);
		BenutzerspracheCombobox bsb = new BenutzerspracheCombobox(u);
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
