package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.KarteiErstellen;

public class KarteiButton extends JButton {

	public KarteiButton() 
	{
		karteiButton();
	}

	public void karteiButton() 
	{
		setSize(200, 200);
		addActionListener(new karteiButtonListener());
		setText("Kartei erstellen");
		setBackground(Color.GREEN);
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
