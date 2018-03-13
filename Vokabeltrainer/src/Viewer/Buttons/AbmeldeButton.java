package Viewer.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;

import Model.User;
import Viewer.Anmeldung.Anmeldefenster;
import Viewer.Menu.HauptmenuNeu;

/**
 * Diese Klasse generiert den Button "abmelden". Wenn dieser Button betätigt
 * wird, wird das mainframe geschlossen und das Anmeldefenster wieder geöffnet
 * Der Button wird der Klasse "MenuLeisteOben" hinzugefügt.
 * 
 * @author Marius Brändle St.Gallen / Daniel Strassmann
 * @version 1.0 10.03.2018
 */

public class AbmeldeButton extends JButton {

	private User u;
	private String abmeldenString;

	/**
	 * Abmeldebutton erstellen
	 * 
	 * @param u
	 *            Alle Daten des Users fliessen in die TabStatistik ein.
	 */
	public AbmeldeButton(User u) {
		this.u = u;
		setSprache();
		abmeldeButton();
	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 */
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.abmeldenString = r.getString("abmelden");
	}

	public void abmeldeButton() {
		setText(abmeldenString);

		addActionListener(new abmeldeButtonListener());

	}

	public void spracheAktualisieren() {
		setSprache();
		setText(abmeldenString);
	}
	/**
	 * Diese Innere Klasse ist zuständig für den Listener auf den abmeldeButton.
	 */
	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Anmeldefenster anmeldeFenster = new Anmeldefenster();
			HauptmenuNeu.mainFrame.dispose();
		}
	}
	

}
