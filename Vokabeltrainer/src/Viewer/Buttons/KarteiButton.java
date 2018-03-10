package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Model.User;
import Viewer.Popup.KarteiErstellen;

/**
 * Diese Klasse wird f�r die Kartei erstellung gebraucht. Diese Klasse generiert
 * den Button "KarteiButton" Wenn dieser Button bet�tigt wird, wird das
 * PopUp-Fenster "KarteiErstellen" ge�ffnet und man kann eine neue Kartei
 * erstellen Der Button wird der Klasse "MenuLeisteOben" hinzugef�gt.
 * 
 * @author Marius Br�ndle St.Gallen
 * @version 1.0 09.3.2018
 */

public class KarteiButton extends JButton {

	private User u;
	private KarteiAuswahlButton kab;

	public KarteiButton(User u, KarteiAuswahlButton kab) {
		this.u = u;
		this.kab = kab;
		karteiButton();
	}

	public void karteiButton() {

		addActionListener(new karteiButtonListener());
		setText("Kartei erstellen");

	}

	class karteiButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			KarteiErstellen ke = new KarteiErstellen(u, kab);

		}
	}
}
