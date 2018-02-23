package Viewer;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class KarteiButton extends JPanel {

	
private JButton karteiButton;

	public KarteiButton()
	{
		this.karteiButton = new JButton("Kartei erstellen");
		
		initGui();
		karteiButton();
	}
	
	public void karteiButton()
	{
		karteiButton.setBackground(Color.GREEN);
		karteiButton.setVisible(true);
		karteiButton.setSize(200,200);
		karteiButton.addActionListener(new karteiButtonListener());
	}
	
	private void initGui() 
	{
		setLayout(null);
		add(karteiButton);
	}
	
	class karteiButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame karteiErstellenFenster = new JFrame("Fenster zum Erstellen einer Kartei");
			karteiErstellenFenster.setVisible(true);
			karteiErstellenFenster.setSize(500,500);
		}
	}
	
}


