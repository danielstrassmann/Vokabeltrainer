package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Model.User;
import Viewer.Popup.KarteiErstellen;

public class KarteiButton extends JButton {
	
	private User u;
	private KarteiAuswahlButton kab;

	public KarteiButton(User u, KarteiAuswahlButton kab) 
	{
		this.u = u;
		this.kab = kab;
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
			KarteiErstellen ke = new KarteiErstellen(u,kab);

		}
	}
}
