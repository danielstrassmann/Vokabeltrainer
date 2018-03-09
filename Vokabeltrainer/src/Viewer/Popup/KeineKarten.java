package Viewer.Popup;

import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Diese Klasse wird für das Popup gebraucht, 
 * wenn in der Kartei keine Karten mehr vorhanden sind
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class KeineKarten extends JDialog{
	
	private JLabel labelKeineKarten;
	private JLabel bitteBoxWechseln;
	
	public KeineKarten() {
		
		initComponents();
		initGui();
	}
	
	public void initComponents() {
		this.labelKeineKarten = new JLabel("Es hat keine Karten mehr in dieser Box");
		this.bitteBoxWechseln = new JLabel("Bitte Box wechseln");
	}

	public void initGui() {
		setLayout(null);
		setSize(300, 100);
		setResizable(false);
		setTitle("Box leer");
		setVisible(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		this.labelKeineKarten.setBounds(20, 1, 290, 30);
		this.bitteBoxWechseln.setBounds(20, 35,290, 30);
		
		add(labelKeineKarten);
		add(bitteBoxWechseln);
	}
}
