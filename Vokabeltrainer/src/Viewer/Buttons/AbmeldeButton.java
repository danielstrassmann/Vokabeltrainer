package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Anmeldung.*;
import Viewer.Menu.*;


public class AbmeldeButton extends JButton{

	public AbmeldeButton()
	{
		abmeldeButton();
	}

	public void abmeldeButton()
	{
		setText("Abmelden");
		setVisible(true);
		
		addActionListener(new abmeldeButtonListener());
		
	}
	
	
	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Anmeldefenster anmeldeFenster = new Anmeldefenster();
			HauptmenuNeu.mainFrame.dispose();
		}
	}
	
}
