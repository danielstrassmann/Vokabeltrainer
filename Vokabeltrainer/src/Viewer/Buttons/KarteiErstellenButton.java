package Viewer.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;

import Model.User;
import Viewer.Popup.KarteiErstellen;

/**
 * Diese Klasse wird für die Kartei erstellung gebraucht. Diese Klasse generiert
 * den Button "KarteiButton" Wenn dieser Button betätigt wird, wird das
 * PopUp-Fenster "KarteiErstellen" geöffnet und man kann eine neue Kartei
 * erstellen Der Button wird der Klasse "MenuLeisteOben" hinzugefügt.
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class KarteiErstellenButton extends JButton {

	private User u;
	private KarteiAuswahlButton kab;
	private String karteiErstellenString;

	public KarteiErstellenButton(User u, KarteiAuswahlButton kab) {
		this.u = u;
		this.kab = kab;
		setSprache();
		karteiButton();
		
		
	}
	
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.karteiErstellenString = r.getString("karteiErstellen");
	}

	public void karteiButton() {

		addActionListener(new karteiButtonListener());
		setText(karteiErstellenString);

	}

	class karteiButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			KarteiErstellen ke = new KarteiErstellen(u, kab);

		}
	}
}
