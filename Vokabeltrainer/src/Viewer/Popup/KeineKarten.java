package Viewer.Popup;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class KeineKarten extends JDialog{
	
	private JLabel labelKeineKarten;
	private JLabel bitteBoxWechseln;
	
	public KeineKarten() {
		
		initComponents();
		initGui();
	}
	
	public void initComponents() {
		this.labelKeineKarten = new JLabel("Es hat keine Lernkarten in dieser Box");
		this.bitteBoxWechseln = new JLabel("Bitte Box wechseln");
	}

	public void initGui() {
		setLayout(null);
		setSize(300, 100);
		setResizable(false);
		setTitle("WARNUNG: Keine Lernkarten ");
		setVisible(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		this.labelKeineKarten.setBounds(20, 1, 290, 30);
		this.bitteBoxWechseln.setBounds(20, 35,290, 30);
		
		add(labelKeineKarten);
		add(bitteBoxWechseln);
	}
}
