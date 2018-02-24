package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Popup.KarteiErstellen;

public class KarteiButton extends JButton {

	public KarteiButton() 
	{
		karteiButton();
	}

	public void karteiButton() 
	{
		
		addActionListener(new karteiButtonListener());
		setText("Kartei erstellen");
		
	}

	class karteiButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			KarteiErstellen ke = new KarteiErstellen();
			ke.initComponents();
			ke.initGui();
		}
	}
}
