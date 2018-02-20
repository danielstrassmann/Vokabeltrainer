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

import java.awt.event.*;

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
	private JButton karteiErstellenButton;
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
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT );
		
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
		karteiAuswahl.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("");
				
			}
		});
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
		this.abmeldenButton = new JButton("abmelden");	
		abmeldenButton.setBackground(Color.RED);
		obenMenuZeile.add(abmeldenButton, BorderLayout.CENTER);
		this.abmeldenButton.addActionListener(new abmeldeButtonListener());
	}
	
	
	class abmeldeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			abmeldenButton.setFont(Font.getFont("SanSerif"));
			JFrame anmeldeFenster = new JFrame("Anmeldefenster für Karteilösung");
			anmeldeFenster.setVisible(true);
			anmeldeFenster.setSize(500,500);
			mainFrame.dispose();
			anmeldeFenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	public void karteiErstellen()
	{
		this.karteiErstellenButton = new JButton("Kartei erstellen");	
		karteiErstellenButton.setBackground(Color.GREEN);
		obenMenuZeile.add(karteiErstellenButton, BorderLayout.SOUTH);
		this.karteiErstellenButton.addActionListener(new karteiErstellenButtoListener());
	}
	class karteiErstellenButtoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			karteiErstellenButton.setFont(Font.getFont("SanSerif"));
			JFrame karteiErstellenFenster = new JFrame("Fenster zum Erstellen einer Kartei");
			karteiErstellenFenster.setVisible(true);
			karteiErstellenFenster.setSize(500,500);
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
//		mainFrame.add(linkeMenuZeile, BorderLayout.WEST);
//		mainFrame.add(rechteMenuZeile, BorderLayout.EAST);
		mainFrame.add(obenMenuZeile, BorderLayout.NORTH);
//		mainFrame.add(actionFenster, BorderLayout.CENTER);
		mainFrame.add(tabsMenu, BorderLayout.CENTER);
		mainFrame.add(untenMenuZeile, BorderLayout.SOUTH);
		
		
//		obenMenuZeile.add(this.abmeldenButton, BorderLayout.CENTER);
//		obenMenuZeile.add(key2);
//		obenMenuZeile.add(key3);
//		obenMenuZeile.add(karteiAuswahlPanel);
//		obenMenuZeile.add(benutzersprache);
//		obenMenuZeile.add(comboLanguage);
		
//		linkeMenuZeile.add(key4);
//		linkeMenuZeile.add(key5);
//		linkeMenuZeile.add(key6);
		
//		rechteMenuZeile.add(key7);
//		rechteMenuZeile.add(key8);
//		rechteMenuZeile.add(key9);
		
//		actionFenster.add(key10);
//		actionFenster.add(key11);
//		actionFenster.add(key12);
//		actionFenster.add(tabsMenu);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void visible()
	{
		mainFrame.setVisible(true);		
//		linkeMenuZeile.setVisible(true);
//		rechteMenuZeile.setVisible(true);
		obenMenuZeile.setVisible(true);
		actionFenster.setVisible(true);
	}

	public void setSize()
	{
		mainFrame.setSize(800, 800);
		mainFrame.setResizable(true);
		mainFrame.setMinimumSize(new Dimension(800,800));
		
//		linkeMenuZeile.setPreferredSize(new Dimension(100,100));
//		linkeMenuZeile.setMinimumSize(new Dimension(500,100));
//		linkeMenuZeile.setMaximumSize(new Dimension(200, 500));
		
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
        
		// Hier werden die JPanels als Registerkarten hinzugefügt
        tabsMenu.addTab("Lernen", lernenTab);
        tabsMenu.addTab("Statistik", statistikTab);
        tabsMenu.addTab("Kartei", karteiTab);
        
        
	}

	public void tabLernen()
	{
		JButton box1 = new JButton("Box 1");
		JButton box2 = new JButton("Box 2");
		JButton box3 = new JButton("Box 3");
		JButton box4 = new JButton("Box 4");
		JButton box5 = new JButton("Box 5");
		
		JLabel boxLabel1 = new JLabel("Box 1 - Label");
		JLabel boxLabel2 = new JLabel("Box 2 - Label");
		JLabel boxLabel3 = new JLabel("Box 3 - Label");
		JLabel boxLabel4 = new JLabel("Box 4 - Label");
		JLabel boxLabel5 = new JLabel("Box 5 - Label");
		
		Border border = actionFenster.getBorder();
		Border margin = new LineBorder(Color.gray,4);
		boxLabel1.setBorder(new CompoundBorder(border, margin));
		boxLabel2.setBorder(new CompoundBorder(border, margin));
		boxLabel3.setBorder(new CompoundBorder(border, margin));
		boxLabel4.setBorder(new CompoundBorder(border, margin));
		boxLabel5.setBorder(new CompoundBorder(border, margin));
		

		boxLabel1.setPreferredSize(new Dimension(100,200));
		boxLabel2.setPreferredSize(new Dimension(100,200));
		boxLabel3.setPreferredSize(new Dimension(100,200));
		boxLabel4.setPreferredSize(new Dimension(100,200));
		boxLabel5.setPreferredSize(new Dimension(100,200));
		
		inhaltLernen.add(boxLabel1);
		inhaltLernen.add(boxLabel2);
		inhaltLernen.add(boxLabel3);
		inhaltLernen.add(boxLabel4);
		inhaltLernen.add(boxLabel5);
	
//		lernenTab.setSize(200,200);
//		inhaltLernen.setPreferredSize(new Dimension(800,800));
		
		lernenTab.add(inhaltLernen,BorderLayout.CENTER);
		
		boxLabel1.addMouseListener(new boxMausKlick());
		boxLabel2.addMouseListener(new boxMausKlick());	
		boxLabel3.addMouseListener(new boxMausKlick());	
		boxLabel4.addMouseListener(new boxMausKlick());	
		boxLabel5.addMouseListener(new boxMausKlick());	
		
	}

	 class boxMausKlick implements MouseListener 
	{
		public void mouseClicked(MouseEvent s) 
		{
//			karteiErstellenButton.setFont(Font.getFont("SanSerif"));
			JFrame lernenFennster2 = new JFrame("LernenFenster");
			lernenFennster2.setVisible(true);
			lernenFennster2.setSize(500,500);

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
	
	public void tabStatistik()
	{
		statistikTab.add(inhaltStatistik,BorderLayout.CENTER);
	}
	
	public void tabKartei()
	{

		karteiTab.add(inhaltKartei);
		
	}


}
