package Viewer.Popup;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Lernen extends JFrame{
	
	private JLabel labelTitelLerner;
	private JLabel labelQuellName;
	private JLabel labelUbersetzungName;
	private JLabel labelUbersichtKarten;

	private JTextField textEingabeFrage;
	private JTextField textEingabeAntwort;

	private JButton buttonAnlegen;
	private JButton buttonAbbrechen;
	
	public Lernen()
	{
		lernen();
		initGui();
		
	}
	
	private void lernen()
	{
		this.labelTitelLerner = new JLabel("Sie lernen aktuell in der Box XXYYXX");
		this.labelQuellName = new JLabel("XXXX Quellkarteiname XXXX");
		this.labelUbersetzungName = new JLabel("XXXX Übersetzungskarteiname XXXX");
		this.labelUbersichtKarten = new JLabel("XXXX Es sind noch YY Karten in dieser Box XXXX");

		this.textEingabeFrage = new JTextField();
		this.textEingabeAntwort = new JTextField();

		this.buttonAnlegen = new JButton("Kontrollieren");
		this.buttonAbbrechen = new JButton("Abbrechen");
	
	}
	
	private void initGui()
	{
		setTitle("aktives Lernen");
		setSize(700,500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		this.labelTitelLerner.setBounds		(10, 1, 300, 25);
		this.labelQuellName.setBounds		(10, 100, 300, 25);
		this.labelUbersetzungName.setBounds	(10, 150, 300, 25);
		this.labelUbersichtKarten.setBounds	(10, 400, 300 , 25);
		
		this.textEingabeFrage.setBounds		(310, 100, 260, 25);
		this.textEingabeAntwort.setBounds	(310, 150, 260, 25);

		this.buttonAnlegen.setBounds		(310, 300, 120, 25);
		this.buttonAbbrechen.setBounds		(450, 300, 120, 25);

		add(labelTitelLerner);
		add(labelQuellName);
		add(labelUbersetzungName);
		add(labelUbersichtKarten);

		add(textEingabeFrage);
		add(textEingabeAntwort);

		add(buttonAnlegen);
		add(buttonAbbrechen);
	}

}
