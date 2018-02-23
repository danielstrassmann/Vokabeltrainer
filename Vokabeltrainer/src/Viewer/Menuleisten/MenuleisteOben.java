package Viewer.Menuleisten;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Buttons.*;

public class MenuleisteOben extends JPanel {
	


	public MenuleisteOben()
	{
		menuleisteOben();
	}
	
	private void menuleisteOben() 
	{
		setLayout(new BorderLayout());
		setVisible(true);

		KarteiButton kb = new KarteiButton();
		add(kb);
				
	
		
		BenutzerspracheButton bsb = new BenutzerspracheButton();
		add(bsb, BorderLayout.CENTER);
		
		KarteiAuswahlButton kab = new KarteiAuswahlButton();
		add(kab, BorderLayout.CENTER);
		
		AbmeldeButton ab = new AbmeldeButton();
		add(ab);
	}
}
