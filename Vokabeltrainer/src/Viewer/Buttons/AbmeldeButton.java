package Viewer.Buttons;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Viewer.Anmeldung.*;
import Viewer.Menu.*;


public class AbmeldeButton extends JPanel{

//private JPanel abmeldeButtonPanel;	
private JButton abmeldeButton;

	public AbmeldeButton()
	{
		this.abmeldeButton = new JButton("Abmelden");

		abmeldeButton();
		initGui();
	}

	public void abmeldeButton()
	{
		abmeldeButton.setBackground(Color.RED);
		abmeldeButton.setVisible(true);
		abmeldeButton.setSize(200,200);
		abmeldeButton.addActionListener(new abmeldeButtonListener());
	}
	
	private void initGui() 
	{
		setLayout(null);
		add(abmeldeButton);
	}
	
	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Anmeldefenster anmeldeFenster = new Anmeldefenster();
			HauptmenuNeu.mainFrame.dispose();
		}
	}
	
}
