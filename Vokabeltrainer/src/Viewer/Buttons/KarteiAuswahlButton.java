package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class KarteiAuswahlButton extends JPanel
{
	
private JPanel karteiAuswahlPanel;
private JComboBox karteiAuswahl;


	public KarteiAuswahlButton()
	{
		karteiAuswahlButton();
		initGui();
		
	}
	
	public void karteiAuswahlButton()
	{
		this.karteiAuswahlPanel = new JPanel();
		
		String karteiAuswahlListe[] = {
				"Deutsch-Englisch", "Französisch-Spanisch", "Englisch-Französisch", 
				"Mathe-Mathe "};
		this.karteiAuswahl = new JComboBox(karteiAuswahlListe);


	}
	
	private void initGui()
	{
		karteiAuswahlPanel.add(karteiAuswahl);
		add(karteiAuswahlPanel,BorderLayout.EAST);
	}

}
