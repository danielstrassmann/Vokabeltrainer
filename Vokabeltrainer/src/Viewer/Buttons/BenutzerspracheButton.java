package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class BenutzerspracheButton extends JPanel{

private JComboBox benutzerSprache;
private JPanel spracheAuswahlPanel;
	
	public BenutzerspracheButton()
	{
		benutzerSprache();
		initGui();
	}
	
	public void benutzerSprache()
	{
		this.spracheAuswahlPanel = new JPanel();
		String spracheAuswahlListe[] = {
		"Deutsch", "français", "english", 
		"español"};
		this.benutzerSprache = new JComboBox(spracheAuswahlListe);


	}

	private void initGui()
	{
		spracheAuswahlPanel.add(benutzerSprache);
		add(spracheAuswahlPanel, BorderLayout.WEST);
	}
}
