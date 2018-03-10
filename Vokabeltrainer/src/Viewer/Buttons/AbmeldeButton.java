package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Anmeldung.*;
import Viewer.Menu.*;

/**
 * Diese Klasse generiert den Button "abmelden" Wenn dieser Button bet�tigt
 * wird, wird das mainframe geschlossen und das Anmeldefenster wieder ge�ffnet
 * Der Button wird der Klasse "MenuLeisteOben" hinzugef�gt.
 * 
 * @author Marius Br�ndle St.Gallen
 * @version 1.0 10.03.2018
 */

public class AbmeldeButton extends JButton{

	public AbmeldeButton()
	{
		abmeldeButton();
	}

	public void abmeldeButton()
	{
		setText("Abmelden");
		setVisible(true);
		
		addActionListener(new abmeldeButtonListener());
		
	}
	
	
	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Anmeldefenster anmeldeFenster = new Anmeldefenster();
			HauptmenuNeu.mainFrame.dispose();
		}
	}
	
}
