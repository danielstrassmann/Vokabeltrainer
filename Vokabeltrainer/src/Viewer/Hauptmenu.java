package Viewer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Karte;


public class Hauptmenu extends JPanel{

	private JFrame mainFrame;
	

	//Panels Hauptmenu
	private JPanel obenMenuZeile;
	private JPanel linkeMenuZeile;
	private JPanel rechteMenuZeile;
	private JPanel untenMenuZeile;
	private JPanel actionFenster;
	
	//ComboBox
	private JComboBox spracheAuswahl;
	private JComboBox karteiAuswahl;

	
	//Buttons
	private JButton abmeldenButton;
	private JButton key2;
	private JButton key3;
	private JButton key4;
	private JButton key5;
	private JButton key6;
	private JButton key7;
	private JButton key8;
	private JButton key9;
	private JButton key10;
	private JButton key11;
	private JButton key12;
	
	//Tabs
	private JPanel lernenTab;
	private JPanel statistikTab;
	private JPanel karteiTab;
	private JTabbedPane tabsMenu;
	
	//Kartei Tab
	private JPanel inhaltLernen;
	private JPanel inhaltStatistik;
	private JPanel inhaltKartei;

	public Hauptmenu() 
	{
		this.mainFrame = new JFrame("Vokabeltrainer");

		this.obenMenuZeile = new JPanel();
		this.linkeMenuZeile = new JPanel();
		this.rechteMenuZeile = new JPanel();
		this.actionFenster = new JPanel();
		this.untenMenuZeile = new JPanel();
		
		//Dropdown
//		this.benutzersprache = new JComboBox();
//		this.karteiAuswahl = new JComboBox();
		
		
		this.abmeldenButton = new JButton("abmelden");
		this.key2 = new JButton("2");
		this.key3 = new JButton("3");
		this.key4 = new JButton("4");
		this.key5 = new JButton("5");
		this.key6 = new JButton("6");
		this.key7 = new JButton("7");
		this.key8 = new JButton("8");
		this.key9 = new JButton("9");
		this.key10 = new JButton("10");
		this.key11 = new JButton("11");
		this.key12 = new JButton("12");
		
		// TABS
		this.lernenTab = new JPanel();
		this.statistikTab = new JPanel();
		this.karteiTab = new JPanel();
		this.tabsMenu = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
		
		//InhaltTab
		this.inhaltLernen = new JPanel();
		this.inhaltStatistik = new JPanel();
		this.inhaltKartei = new JPanel();
	}
	
	// Dropdownmenu für die Auswahl der Kartei
	public void karteiAuswahl()
	{
		JPanel karteiAuswahlPanel = new JPanel();
		
		String karteiAuswahlListe[] = {
				"Deutsch-Englisch", "Französisch-Spanisch", "Englisch-Französisch", 
				"Mathe-Mathe"};
		

		this.karteiAuswahl = new JComboBox(karteiAuswahlListe);
		karteiAuswahlPanel.add(karteiAuswahl);
		obenMenuZeile.add(karteiAuswahlPanel,BorderLayout.EAST);
	}
	
	// Dropdownmenu für die Auswahl der Benutzersprache
	public void spracheAuswahl()
	{
		JPanel spracheAuswahlPanel = new JPanel();
		
		String spracheAuswahlListe[] = {
				"Deutsch", "français", "english", 
				"español"};
		

		this.spracheAuswahl = new JComboBox(spracheAuswahlListe);
		spracheAuswahlPanel.add(spracheAuswahl);
		obenMenuZeile.add(spracheAuswahlPanel, BorderLayout.WEST);
	}
	
	public void abmeldeButton()
	{
		
	}
	
	class KeyListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ziffer = e.getActionCommand();
	//		displayTextfield.setText(displayTextfield.getText() + ziffer);
		}
	}
	
	public void paint()
	{

		mainFrame.setResizable(false);
		mainFrame.setLayout(new BorderLayout(200, 200));

		
		obenMenuZeile.setLayout(new FlowLayout());
		untenMenuZeile.setLayout(new FlowLayout());
		linkeMenuZeile.setLayout(new BoxLayout(linkeMenuZeile, BoxLayout.PAGE_AXIS));
		rechteMenuZeile.setLayout(new BoxLayout(rechteMenuZeile, BoxLayout.PAGE_AXIS));
		actionFenster.setLayout(new GridBagLayout());

	}

	public void border()
	{
		Border border = actionFenster.getBorder();
		Border margin = new LineBorder(Color.gray,4);
		actionFenster.setBorder(new CompoundBorder(border, margin));
		linkeMenuZeile.setBorder(new CompoundBorder(linkeMenuZeile.getBorder(), margin));
		rechteMenuZeile.setBorder(new CompoundBorder(rechteMenuZeile.getBorder(), margin));		
		obenMenuZeile.setBorder(new CompoundBorder(obenMenuZeile.getBorder(), margin));
		untenMenuZeile.setBorder(new CompoundBorder(untenMenuZeile.getBorder(), margin));
	}

	
	public void add() 
	{
		mainFrame.add(linkeMenuZeile, BorderLayout.WEST);
		mainFrame.add(rechteMenuZeile, BorderLayout.EAST);
		mainFrame.add(obenMenuZeile, BorderLayout.NORTH);
//		mainFrame.add(actionFenster, BorderLayout.CENTER);
		mainFrame.add(tabsMenu, BorderLayout.CENTER);
		mainFrame.add(untenMenuZeile, BorderLayout.SOUTH);

		
//		obenMenuZeile.add(abmeldenButton);
//		obenMenuZeile.add(key2);
//		obenMenuZeile.add(key3);
//		obenMenuZeile.add(karteiAuswahlPanel);
//		obenMenuZeile.add(benutzersprache);
//		obenMenuZeile.add(comboLanguage);
		
		linkeMenuZeile.add(key4);
		linkeMenuZeile.add(key5);
		linkeMenuZeile.add(key6);
		
		rechteMenuZeile.add(key7);
		rechteMenuZeile.add(key8);
		rechteMenuZeile.add(key9);
		
//		actionFenster.add(key10);
//		actionFenster.add(key11);
//		actionFenster.add(key12);
//		actionFenster.add(tabsMenu);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void visible()
	{
		mainFrame.setVisible(true);		
		linkeMenuZeile.setVisible(true);
		rechteMenuZeile.setVisible(true);
		obenMenuZeile.setVisible(true);
		actionFenster.setVisible(true);
	}

	public void setSize()
	{
		mainFrame.setSize(800, 800);
		mainFrame.setResizable(true);
		mainFrame.setMinimumSize(new Dimension(800,800));
		
		linkeMenuZeile.setPreferredSize(new Dimension(100,100));
		linkeMenuZeile.setMinimumSize(new Dimension(500,100));
		linkeMenuZeile.setMaximumSize(new Dimension(200, 500));
		
//		obenMenuZeile.setPreferredSize(new Dimension(100,100));
//		obenMenuZeile.setMinimumSize(new Dimension(500,100));
//		obenMenuZeile.setMaximumSize(new Dimension(200, 500));
		
		actionFenster.setMinimumSize(new Dimension(700,700));
		
		untenMenuZeile.setPreferredSize(new Dimension(100,  100));
		

		key2.setPreferredSize(new Dimension(100,100));
		key2.setMinimumSize(new Dimension(100,100));
		key2.setMaximumSize(new Dimension(100,100));
		key4.setPreferredSize(new Dimension(100,100));
		key4.setMinimumSize(new Dimension(100,100));
		key4.setMaximumSize(new Dimension(100,100));
		key5.setPreferredSize(new Dimension(100,100));
		key5.setMinimumSize(new Dimension(100,100));
		key5.setMaximumSize(new Dimension(100,100));
		key6.setPreferredSize(new Dimension(100,100));
		key6.setMinimumSize(new Dimension(100,100));
		key6.setMaximumSize(new Dimension(100,100));
	}
	

	
	public void color()
	{

		linkeMenuZeile.setBackground(Color.red);
//		key1.setBackground(Color.RED);
	}
	
	public void tabs() //https://www.java-tutorial.org/JTabbedPane.html
	{
		// Hintergrund definieren
		lernenTab.setBackground(Color.RED);
		statistikTab.setBackground(Color.BLUE);
		karteiTab.setBackground(Color.GREEN);
		
        // Erzeugung eines JTabbedPane-Objektes
        
		lernenTab.add(inhaltLernen,BorderLayout.CENTER);
		statistikTab.add(inhaltStatistik);
		karteiTab.add(inhaltKartei,BorderLayout.CENTER);
		
		// Hier werden die JPanels als Registerkarten hinzugefügt
        tabsMenu.addTab("Lernen", lernenTab);
        tabsMenu.addTab("Statistik", statistikTab);
        tabsMenu.addTab("Kartei", karteiTab);
	}

	public void tabLernen()
	{
		
	}
	
	public void tabStatistik()
	{
		
	}
	
	public void tabKartei()
	{
		//		Hauptmenu gui = new Hauptmenu();
		Test_TabKartei testTabKartei = new Test_TabKartei();
		
		testTabKartei.ListKarte();

		
		
		
		// erstelle JFrame and JTable
		JTable table = new JTable();

		// erstelle tablemodel DefaultTableModel für Array und definiere Spalten
		Object[] columns = { "Frage", "Antwort" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		// setze das Model
		table.setModel(model);

		// Change A JTable Background Color, Font Size, Font Color, Row Height
		// table.setBackground(Color.LIGHT_GRAY);
		// table.setForeground(Color.black);
		// Font font = new Font("",1,22);
		// table.setFont(font);
		// table.setRowHeight(30);

		// erstelle JTextFields
		JTextField textFrage = new JTextField();
		JTextField textAntwort = new JTextField();


		// erstelle JButtons
		JButton btnAdd = new JButton("Neu");
		JButton btnDelete = new JButton("Löschen");
		JButton btnUpdate = new JButton("Ändern");

		textFrage.setBounds(20, 220, 100, 25);
		textAntwort.setBounds(20, 250, 100, 25);

		btnAdd.setBounds(150, 220, 100, 25);
		btnUpdate.setBounds(150, 265, 100, 25);
		btnDelete.setBounds(150, 310, 100, 25);

		// erstelle JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		inhaltKartei.setLayout(null);

		inhaltKartei.add(pane);

		// füge JTextFields auf dem jframe hinzu
		inhaltKartei.add(textFrage);
		inhaltKartei.add(textAntwort);

		// füge JButtons auf dem jframe hinzu
		inhaltKartei.add(btnAdd);
		inhaltKartei.add(btnDelete);
		inhaltKartei.add(btnUpdate);

		// fügt ArrayList Karten hinzu
		ArrayList<Karte> kartenliste = Test_TabKartei.ListKarte();
		Object rowData[] = new Object[2];
		for (int i = 0; i < kartenliste.size(); i++) {
			rowData[0] = kartenliste.get(i).getFrage();
			rowData[1] = kartenliste.get(i).getAntwort();
			model.addRow(rowData);}

			// erstelle eine Array und fügt es dem Model hinzu
			Object[] row = new Object[2];

			// button add row --> Button Neu
			btnAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					row[0] = textFrage.getText();
					row[1] = textAntwort.getText();

					// fügt neue Karte im Model hinzu
					model.addRow(row);
				}
			});

			// button remove row --> Button löschen
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();
					if (i >= 0) {
						// lösche eine row vom jtable
						model.removeRow(i);
					} else {
						System.out.println("Delete Error");
					}
				}
			});

			// übertrage Felder vom selektierten row in die JTextFields
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();

					textFrage.setText(model.getValueAt(i, 0).toString());
					textAntwort.setText(model.getValueAt(i, 1).toString());
				}
			});

			// button update row --> Button Ändern
			btnUpdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();

					if (i >= 0) {
						model.setValueAt(textFrage.getText(), i, 0);
						model.setValueAt(textAntwort.getText(), i, 1);

					} else {
						System.out.println("Update Error");
					}
				}
			});

			inhaltKartei.setSize(900, 400);

	}


}
