package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class BenutzerspracheButton extends JComboBox
{
		public BenutzerspracheButton()
		{
			benutzerSprache();
		}
		
		public void benutzerSprache()
		{
			addItem("Deutsch");
			addItem("français");
			addItem("english");
			addItem("italiano");

			setVisible(true);
			setSize(200,200);
		}

}