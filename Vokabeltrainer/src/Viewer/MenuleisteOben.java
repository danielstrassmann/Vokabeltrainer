package Viewer;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

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
				
		AbmeldeButton ab = new AbmeldeButton();
		add(ab);	
		
		BenutzerspracheButton bsb = new BenutzerspracheButton();
		add(bsb, BorderLayout.CENTER);
		
		KarteiAuswahlButton kab = new KarteiAuswahlButton();
		add(kab, BorderLayout.CENTER);
	}
}
