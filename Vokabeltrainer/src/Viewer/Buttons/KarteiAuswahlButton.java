package Viewer.Buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.Kartei;
import Model.User;
import Viewer.Tab.TabKartei;

/**
 * Diese Klasse wird f�r die Karteiauswahl gebraucht Diese Klasse generiert die
 * Combobox "KarteiAuswahl" Wenn diese Combobox bet�tigt wird, kann die Kartei
 * gewechselt werden Der Button wird der Klasse "MenuLeisteOben" hinzugef�gt.
 * 
 * @author Marius Br�ndle St.Gallen
 * @version 1.0 09.3.2018
 */

public class KarteiAuswahlButton extends JComboBox<Kartei> {
	private User u;
	private Kartei kk;
	TabKartei tb;

	public KarteiAuswahlButton() {
		bindListener();
	}

	public KarteiAuswahlButton(TabKartei tb) {
		this.tb = tb;
		bindListener();
		comboboxKarteiAbfuellen(u);

	}

	public void bindListener() {
		addItemListener(new ItemChangeListener());
	}

	public void comboboxKarteiAbfuellen(User u) {
		removeAllItems();
		ArrayList<Kartei> karteiliste = u.getUserKarteien();
		if (karteiliste != null) {
			for (int i = 0; i < karteiliste.size(); i++) {
				Kartei klk = karteiliste.get(i);
				addItem(klk);
			}
		}
	}

	class ItemChangeListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				kk = (Kartei) getSelectedItem();
				//System.out.println(kk);
			}
		}

		public Kartei getSelectedKartei() {
			return kk;
		}
	}
}
