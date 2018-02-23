package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controller.KarteiController;
import Model.Karte;
import Model.Kartei;

public class TabKartei extends JPanel implements ActionListener, MouseListener {

	private JTable tableKartei;

	private JScrollPane scrollPaneKartei;

	private DefaultTableModel modelKartei;

	private JTextField textFrage;
	private JTextField textAntwort;

	private JButton buttonNeu;
	private JButton buttonAendern;
	private JButton buttonLoeschen;

	private JLabel labelTitel;
	private JLabel labelFrage;
	private JLabel labelAntwort;

	private int selektierteRow;
	private Kartei kk;

	public TabKartei() {
		initComponents();
		initGui();
		bindListener();

	}

	// Initaliziere Komponenten und setze Gr�ssen und Positionen
	private void initComponents() {

		this.textFrage = new JTextField();
		this.textAntwort = new JTextField();

		this.buttonNeu = new JButton("neue Karte ");
		this.buttonAendern = new JButton("Karte �ndern");
		this.buttonLoeschen = new JButton("Karte l�schen");

		this.labelTitel = new JLabel("Alle Karten der Kartei");
		this.labelFrage = new JLabel("Frage eingeben oder �ndern");
		this.labelAntwort = new JLabel("Antwort eingeben oder �ndern");

		textFrage.setBounds(20, 265, 160, 25);
		textAntwort.setBounds(20, 325, 160, 25);

		buttonNeu.setBounds(250, 245, 120, 25);
		buttonAendern.setBounds(250, 285, 120, 25);
		buttonLoeschen.setBounds(250, 325, 120, 25);

		labelTitel.setBounds(20, 0, 250, 25);
		labelFrage.setBounds(20, 240, 200, 25);
		labelAntwort.setBounds(20, 300, 200, 25);
	}

	// Initaliziere Table und setze DefaultTablemodel. Komponenten auf Panel
	// hinzuf�gen
	private void initGui() {

		setLayout(null);

		this.tableKartei = new JTable();
		this.scrollPaneKartei = new JScrollPane(tableKartei, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Object[] spalten = { "Frage", "Antwort" };
		this.modelKartei = new DefaultTableModel();

		modelKartei.setColumnIdentifiers(spalten);

		tableKartei.setModel(modelKartei);

		scrollPaneKartei.setBounds(20, 30, 880, 200);

		add(scrollPaneKartei);

		add(textFrage);
		add(textAntwort);

		add(buttonNeu);
		add(buttonAendern);
		add(buttonLoeschen);

		add(labelTitel);
		add(labelFrage);
		add(labelAntwort);

	}

	// Listeners den Buttons und Table hinzuf�gen
	private void bindListener() {
		buttonNeu.addActionListener(this);
		buttonAendern.addActionListener(this);
		buttonLoeschen.addActionListener(this);
		tableKartei.addMouseListener(this);

	}

	// selektierte Kartei in Table abf�llen
	public void tableKarteiabfuellen(Kartei kk) {
		this.kk = kk;
		modelKartei.setRowCount(0);
		ArrayList<Karte> kartenSammlung = kk.getSammlung();
		Object kartenInTable[] = new Object[2];
		for (int i = 0; i < kartenSammlung.size(); i++) {
			Karte k = kartenSammlung.get(i);
			kartenInTable[0] = k.getFrage();
			kartenInTable[1] = k.getAntwort();
			modelKartei.addRow(kartenInTable);
		}
	}

	// MouseListener. f�gt gew�hlte Row in Textfields Frage und Antwort ab
	@Override
	public void mouseClicked(MouseEvent e) {
		selektierteRow = tableKartei.getSelectedRow();

		textFrage.setText(modelKartei.getValueAt(selektierteRow, 0).toString());
		textAntwort.setText(modelKartei.getValueAt(selektierteRow, 1).toString());

	}

	// ActionListener. F�gt neue Karten hinzu, �ndert gew�hlte Karte, l�scht
	// gew�hlte Karte
	@Override
	public void actionPerformed(ActionEvent e) {
		// neue Karte hinzuf�gen
		if (e.getSource() == this.buttonNeu) {
			String frageHinzu = textFrage.getText();
			String antwortHinzu = textAntwort.getText();
			Karte k = new Karte(frageHinzu, antwortHinzu);
			kk.karteInSammlung(k);
			tableKarteiabfuellen(kk);
			System.out.println("Karte erzeugt");
			// Karte �ndern
		} else if (e.getSource() == this.buttonAendern) {
			Karte karte = kk.getIndex(selektierteRow);
			karte.setFrage(textFrage.getText());
			karte.setAntwort(textAntwort.getText());
			tableKarteiabfuellen(kk);
			System.out.println("Karte ge�ndert");
		}
		// Karte l�schen
		else if (e.getSource() == this.buttonLoeschen) {
			// todo Karte aus ArrayList l�schen
			tableKarteiabfuellen(null);
			System.out.println("Karte gel�scht");

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
