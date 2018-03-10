package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import Model.User;
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

public class AbmeldeButton extends JButton {

	private User u;
	private String abmeldenString;
	

	public AbmeldeButton(User u)	{
		this.u = u;
		setSprache();
		abmeldeButton();
	}
	
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.abmeldenString = r.getString("abmelden");
	}

	public void abmeldeButton() {
		setText(abmeldenString);

		addActionListener(new abmeldeButtonListener());

	}

	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Anmeldefenster anmeldeFenster = new Anmeldefenster();
			HauptmenuNeu.mainFrame.dispose();
		}
	}

}
