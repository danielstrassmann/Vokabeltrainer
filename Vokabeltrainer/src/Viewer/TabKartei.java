package Viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.KarteiController;
import Model.Kartei;

public class TabKartei extends JPanel implements ActionListener, MouseListener {

	private JPanel panelKartei;

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
		tableKarteiabfuellen(null);
	}

	public void initComponents() {

		this.textFrage = new JTextField();
		this.textAntwort = new JTextField();

		this.buttonNeu = new JButton("neue Karte");
		this.buttonAendern = new JButton("Karte �ndern");
		this.buttonLoeschen = new JButton("Karte l�schen");

		this.labelTitel = new JLabel("Alle Karten der Kartei");
		this.labelFrage = new JLabel("Frage eingeben oder �ndern");
		this.labelAntwort = new JLabel("Antwort eingeben oder �ndern");

		textFrage.setBounds(20, 220, 100, 25);
		textAntwort.setBounds(20, 250, 100, 25);

		buttonNeu.setBounds(150, 220, 100, 25);
		buttonAendern.setBounds(150, 265, 100, 25);
		buttonLoeschen.setBounds(150, 310, 100, 25);

		labelTitel.setBounds(20, 0, 100, 25);
		labelFrage.setBounds(20, 205, 100, 25);
		labelAntwort.setBounds(20, 245, 100, 25);
	}

	private void initGui() {
		this.panelKartei = new JPanel();
		this.tableKartei = new JTable();
		this.scrollPaneKartei = new JScrollPane(tableKartei);
		this.modelKartei = new DefaultTableModel();
		Object[] spalten = { "Frage", "Antwort" };

		modelKartei.setColumnIdentifiers(spalten);

		tableKartei.setModel(modelKartei);

		scrollPaneKartei.setBounds(0, 0, 880, 200);

		panelKartei.setLayout(null);

		panelKartei.add(tableKartei);

		panelKartei.add(textFrage);
		panelKartei.add(textAntwort);

		panelKartei.add(buttonNeu);
		panelKartei.add(buttonAendern);
		panelKartei.add(buttonLoeschen);

		panelKartei.add(labelTitel);
		panelKartei.add(labelFrage);
		panelKartei.add(labelAntwort);

	}

	public void tableKarteiabfuellen(Kartei kk) {
		Object kartenInTable[] = new Object[2];
		for (int i = 0; i < kk.getAnzahlKartenInSammlung(); i++) {
			kartenInTable[0] = kk.getIndex(i).getFrage();
			kartenInTable[1] = kk.getIndex(i).getAntwort();
			modelKartei.addRow(kartenInTable);
		}
	}

	private void bindListener() {
		buttonNeu.addActionListener(this);
		buttonAendern.addActionListener(this);
		buttonLoeschen.addActionListener(this);
		tableKartei.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.buttonNeu) {
			// todo neue Karte erzeugen hinzuf�gen
			tableKarteiabfuellen(null);
			System.out.println("Karte erzeugt");
		} else if (e.getSource() == this.buttonAendern) {
			// todo Karte �berschreiben
			tableKarteiabfuellen(null);
			System.out.println("Karte ge�ndert");
		}

		else if (e.getSource() == this.buttonLoeschen) {
			// todo Karte aus ArrayList l�schen
			tableKarteiabfuellen(null);
			System.out.println("Karte gel�scht");

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
