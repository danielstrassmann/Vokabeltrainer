package Viewer.Popup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KarteiErstellen extends JDialog // implements ActionListener 
{

	private JLabel labelTitelKartei;
	private JLabel labelBezFrage;
	private JLabel labelBezAntwort;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonAnlegen;
	private JButton buttonAbbrechen;

	public KarteiErstellen() {
		initComponents();
		bindListener();
		initGui();

	}

	public void initComponents() {
		this.labelTitelKartei = new JLabel("Bitte erstellen Sie eine neue Kartei");
		this.labelBezFrage = new JLabel("Bezeichnung der Quelle eingeben");
		this.labelBezAntwort = new JLabel("Bezeichnung der Übersetzung eingeben");

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton("Anlegen");
		this.buttonAbbrechen = new JButton("Abbrechen");
	}

	public void bindListener() {
		buttonAnlegen.addActionListener(new anlegenButtonListener());
		buttonAbbrechen.addActionListener(new abbrechenButtonListener());
	}

	public void initGui() {
		setLayout(null);
		setSize(520, 280);
		setResizable(false);
		setTitle("Kartei anlegen");
		setVisible(true);
		setLocationRelativeTo(null);

		this.labelTitelKartei.setBounds		(10, 1, 200, 30);
		this.labelBezFrage.setBounds		(10, 60, 200, 25);
		this.labelBezAntwort.setBounds		(10, 100, 200, 25);

		this.textEingabeFrage.setBounds		(250, 60, 250, 25);
		this.textEingabeAntwort.setBounds	(250, 100, 250, 25);

		this.buttonAnlegen.setBounds		(250, 200, 120, 25);
		this.buttonAbbrechen.setBounds		(380, 200, 120, 25);

		add(labelTitelKartei);
		add(labelBezFrage);
		add(labelBezAntwort);

		add(textEingabeFrage);
		add(textEingabeAntwort);

		add(buttonAnlegen);
		add(buttonAbbrechen);

	}

	class anlegenButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
				System.out.println("kartei anlegen");
		}
	}
	class abbrechenButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
				System.out.println("abbrechen button gedrückt");
		}
	}
//	@Override
/*	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.buttonAnlegen) {
			System.out.println("kartei anlegen");
			// TODO implementierung Kartei anlegen. auch prüfen, ob Kartei schon vorhanden?
		} else if (e.getSource() == this.buttonAbbrechen) {
			System.out.println("test");
			// dispose();

		}
	}
*/


}
