package Viewer;

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

	// private JPanel panelKartei;

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

	public TabKartei() {
		initComponents();
		initGui();
		bindListener();
		// tableKarteiabfuellen(null);
	}

	public void initComponents() {

		this.textFrage = new JTextField();
		this.textAntwort = new JTextField();

		this.buttonNeu = new JButton("neue Karte");
		this.buttonAendern = new JButton("Karte ändern");
		this.buttonLoeschen = new JButton("Karte löschen");

		this.labelTitel = new JLabel("Alle Karten der Kartei");
		this.labelFrage = new JLabel("Frage eingeben oder ändern");
		this.labelAntwort = new JLabel("Antwort eingeben oder ändern");

		textFrage.setBounds(20, 420, 100, 25);
		textAntwort.setBounds(20, 450, 100, 25);

		buttonNeu.setBounds(250, 240, 100, 25);
		buttonAendern.setBounds(250, 265, 100, 25);
		buttonLoeschen.setBounds(150, 310, 100, 25);

		labelTitel.setBounds(20, 0, 400, 25);
		labelFrage.setBounds(20, 240, 400, 25);
		labelAntwort.setBounds(20, 280, 400, 25);
	}

	public void initGui() {
		//BorderLayout layout = new BorderLayout();
		setLayout(null);
		
		// this.panelKartei = new JPanel();
		this.tableKartei = new JTable();
		this.scrollPaneKartei = new JScrollPane(tableKartei, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Object[] spalten = { "Frage", "Antwort" };
		this.modelKartei = new DefaultTableModel();

		modelKartei.setColumnIdentifiers(spalten);

		tableKartei.setModel(modelKartei);

		scrollPaneKartei.setBounds(0, 30, 880, 200);

		//setSize(1200, 300);

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

	public void tableKarteiabfuellen(Kartei kk) {
		ArrayList<Karte> kartenSammlung = kk.getSammlung();
		Object kartenInTable[] = new Object[2];
		for (int i = 0; i < kartenSammlung.size(); i++) {
			Karte k = kartenSammlung.get(i);
			kartenInTable[0] = k.getFrage();
			kartenInTable[1] = k.getAntwort();
			// kartenInTable[0] = kartenSammlung.getFrage(i);
			// kartenInTable[1] = kk.getIndex(i).getAntwort();
			modelKartei.addRow(kartenInTable);
		}
	}

	private void bindListener() {
		buttonNeu.addActionListener(this);
		buttonAendern.addActionListener(this);
		buttonLoeschen.addActionListener(this);
		tableKartei.addMouseListener(this);
//
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.buttonNeu) {
			// todo neue Karte erzeugen hinzufügen
			tableKarteiabfuellen(null);
			System.out.println("Karte erzeugt");
		} else if (e.getSource() == this.buttonAendern) {
			// todo Karte überschreiben
			tableKarteiabfuellen(null);
			System.out.println("Karte geändert");
		}

		else if (e.getSource() == this.buttonLoeschen) {
			// todo Karte aus ArrayList löschen
			tableKarteiabfuellen(null);
			System.out.println("Karte gelöscht");

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = tableKartei.getSelectedRow();

		textFrage.setText(modelKartei.getValueAt(i, 0).toString());
		textAntwort.setText(modelKartei.getValueAt(i, 1).toString());

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
