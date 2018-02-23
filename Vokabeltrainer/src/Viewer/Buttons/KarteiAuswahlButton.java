package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class KarteiAuswahlButton extends JComboBox
{
		public KarteiAuswahlButton()
	{
		karteiAuswahlButton();		
	}
	
	public void karteiAuswahlButton()
	{
		addItem("Deutsch-Englisch");
		addItem("Französisch-Spanisch");
		addItem("Englisch-Französisch");
		addItem("Mathe-Mathe2");
		
		setVisible(true);
	}
	
}


