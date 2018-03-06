package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import Model.User;
import Viewer.Menuleisten.MenuleisteOben;

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
	private JLabel labelMutation;

	private int selektierteRow;
	private Kartei kk;
	
	private MenuleisteOben mlo;
	private User u;

	public TabKartei(User u, MenuleisteOben mlo) {
		this.u = u;
		this.mlo = mlo;
		initComponents();
		initGui();
		bindListener();

	}

	// Initaliziere Komponenten und setze Grössen und Positionen
	private void initComponents() {

		this.textFrage = new JTextField();
		this.textAntwort = new JTextField();

		this.buttonNeu = new JButton("neue Karte ");
		this.buttonAendern = new JButton("Karte ändern");
		this.buttonLoeschen = new JButton("Karte löschen");

		this.labelTitel = new JLabel("Alle Karten der Kartei");
		this.labelFrage = new JLabel("Frage eingeben oder ändern");
		this.labelAntwort = new JLabel("Antwort eingeben oder ändern");
		this.labelMutation = new JLabel ("");

		this.textFrage.setBounds(20, 265, 160, 25);
		this.textAntwort.setBounds(20, 325, 160, 25);

		this.buttonNeu.setBounds(250, 245, 120, 25);
		this.buttonAendern.setBounds(250, 285, 120, 25);
		this.buttonLoeschen.setBounds(250, 325, 120, 25);
        
		this.labelTitel.setBounds(20, 0, 250, 25);
		this.labelFrage.setBounds(20, 240, 200, 25);
		this.labelAntwort.setBounds(20, 300, 200, 25);
		this.labelMutation.setBounds(390, 245, 200,25);
	}

	// Initaliziere Table und setze DefaultTablemodel. Komponenten auf Panel
	// hinzufügen
	private void initGui() {

		setLayout(null);

		this.tableKartei = new JTable();
		this.scrollPaneKartei = new JScrollPane(tableKartei, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Object[] spalten = { "Frage", "Antwort" };
		this.modelKartei = new DefaultTableModel();

		this.modelKartei.setColumnIdentifiers(spalten);

		this.tableKartei.setModel(modelKartei);

		this.scrollPaneKartei.setBounds(20, 30, 880, 200);

		add(this.scrollPaneKartei);

		add(this.textFrage);
		add(this.textAntwort);
            
		add(this.buttonNeu);
		add(this.buttonAendern);
		add(this.buttonLoeschen);
            
		add(this.labelTitel);
		add(this.labelFrage);
		add(this.labelAntwort);
		add(this.labelMutation);

	}

	// Listeners den Buttons und Table hinzufügen
	private void bindListener() {
		buttonNeu.addActionListener(this);
		buttonAendern.addActionListener(this);
		buttonLoeschen.addActionListener(this);
		tableKartei.addMouseListener(this);
		mlo.addItemChangeListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Kartei kk =  (Kartei) event.getItemSelectable().getSelectedObjects()[0];
					System.out.println(kk);
					
					tableKarteiabfuellen(kk);

				}
				
			}
		});

	}

	// selektierte Kartei in Table abfüllen
	public void tableKarteiabfuellen(Kartei kk) {
		this.kk = kk;
		modelKartei.setRowCount(0);
		textFrage.setText("");
		textAntwort.setText("");
		ArrayList<Karte> kartenSammlung = kk.getSammlung();
		Object kartenInTable[] = new Object[2];
		for (int i = 0; i < kartenSammlung.size(); i++) {
			Karte k = kartenSammlung.get(i);
			kartenInTable[0] = k.getFrage();
			kartenInTable[1] = k.getAntwort();
			modelKartei.addRow(kartenInTable);
			//tableKartei.setModel(modelKartei);
		}
	}

	// MouseListener. fügt gewählte Row in Textfields Frage und Antwort ab
	@Override
	public void mouseClicked(MouseEvent e) {
		selektierteRow = tableKartei.getSelectedRow();

		textFrage.setText(modelKartei.getValueAt(selektierteRow, 0).toString());
		textAntwort.setText(modelKartei.getValueAt(selektierteRow, 1).toString());

	}

	// ActionListener. Fügt neue Karten hinzu, Ändert gewählte Karte, löscht
	// gewählte Karte
	@Override
	public void actionPerformed(ActionEvent e) {
		// neue Karte hinzufügen
		if (e.getSource() == this.buttonNeu) {
			if (textFrage.getText().equals("")||textAntwort.getText().equals("") ) {
				this.labelMutation.setBounds(390, 245, 300,25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText("Zuerst Frage und Antwort eintragen");
			} else {
				String frageHinzu = textFrage.getText();
				String antwortHinzu = textAntwort.getText();
				Karte k = new Karte(frageHinzu, antwortHinzu);
				kk.karteInSammlung(k);
				tableKarteiabfuellen(kk);
				System.out.println("Karte erzeugt");
				this.labelMutation.setBounds(390, 245, 300,25);
				this.labelMutation.setForeground(new Color (0,102,0));
				this.labelMutation.setText("Karte erfolgreich angelegt");
			}
			// Karte ändern
		} else if (e.getSource() == this.buttonAendern) {
			if (textFrage.getText().equals("")) {
				System.out.println("Karte selektieren");
				this.labelMutation.setBounds(390, 285, 300,25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText("Zuerst eine Karte wählen");
			} else {
				Karte karte = kk.getIndex(selektierteRow);
				karte.setFrage(textFrage.getText());
				karte.setAntwort(textAntwort.getText());
				tableKarteiabfuellen(kk);
				this.labelMutation.setBounds(390, 285, 300,25);
				this.labelMutation.setForeground(new Color (0,102,0));
				this.labelMutation.setText("Karte erfolgreich geändert");
			}
		}

		// Karte löschen
		else if (e.getSource() == this.buttonLoeschen) {
			if (textFrage.getText().equals("")) {
				this.labelMutation.setBounds(390, 325, 300,25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText("Zuerst eine Karte wählen");
			} else {
				Karte karte = kk.remove(selektierteRow);
				tableKarteiabfuellen(kk);
				this.labelMutation.setBounds(390, 325, 300,25);
				this.labelMutation.setForeground(new Color (0,102,0));
				this.labelMutation.setText("Karte erfolgreich gelöscht");
				

			}
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
