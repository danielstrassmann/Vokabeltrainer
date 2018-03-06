package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Model.User;
import Viewer.Popup.KarteiErstellen;

public class KarteiButton extends JButton {
	
	private User u;

	public KarteiButton(User u) 
	{
		this.u = u;
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
			KarteiErstellen ke = new KarteiErstellen(u);
			ke.initComponents();
			ke.initGui();
		}
	}
}
