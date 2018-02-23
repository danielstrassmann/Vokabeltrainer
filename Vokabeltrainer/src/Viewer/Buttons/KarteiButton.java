package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.KarteiErstellen;

public class KarteiButton extends JButton {

	public KarteiButton() {
		

		karteiButton();
	}

	public void karteiButton() {
//		setSize(200, 200);
		addActionListener(new karteiButtonListener());
		setText("Kartei erstellen");
	}

	class karteiButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			KarteiErstellen ke = new KarteiErstellen();
			ke.initComponents();
			ke.initGui();
			
			
		}
	}

	/*
	 * private JButton karteiButton;
	 * 
	 * public KarteiButton() { this.karteiButton = new JButton("Kartei erstellen ");
	 * 
	 * initGui(); karteiButton(); }
	 * 
	 * public void karteiButton() { karteiButton.setBackground(Color.GREEN);
	 * karteiButton.setVisible(true); karteiButton.setSize(200,200);
	 * karteiButton.addActionListener(new karteiButtonListener()); }
	 * 
	 * private void initGui() { setLayout(null); add(karteiButton); }
	 * 
	 * class karteiButtonListener implements ActionListener { public void
	 * actionPerformed(ActionEvent e) { JFrame karteiErstellenFenster = new
	 * JFrame("Fenster zum Erstellen einer Kartei");
	 * karteiErstellenFenster.setVisible(true);
	 * karteiErstellenFenster.setSize(500,500); } }
	 */

}
