package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.Buttons.KarteiButton.karteiButtonListener;
import Viewer.Tab.TabKartei;

public class KarteiAuswahlButton extends JComboBox<Kartei> {
	private Kartei kk;
	TabKartei tb;

	public KarteiAuswahlButton() {
		bindListener();
	}	
	
	public KarteiAuswahlButton(TabKartei tb) {
		this.tb = tb;
		bindListener();
	}

	public void bindListener() {
		addItemListener(new ItemChangeListener());
	}

	public void comboboxKarteiAbfuellen(User u) {
		ArrayList<Kartei> karteiliste = u.getUserKarteien();
		for (int i = 0; i < karteiliste.size(); i++) {
			Kartei klk = karteiliste.get(i);
			addItem(klk);
		}
	}

	class ItemChangeListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				  kk =  (Kartei) getSelectedItem();
				System.out.println(kk);
				
				//tb.tableKarteiabfuellen(kk);

			}

		}
		

		public Kartei getSelectedKartei() {
			return kk;
		}
	}
}
