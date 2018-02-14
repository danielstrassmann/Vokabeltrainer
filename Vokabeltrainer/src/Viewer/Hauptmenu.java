package Viewer;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class Hauptmenu extends JPanel{

	private JFrame mainFrame;
	

	
	private JPanel obenMenuZeile;
	private JPanel linkeMenuZeile;
	private JPanel rechteMenuZeile;
	private JPanel untenMenuZeile;
	private JPanel actionFenster;
	
	private JComboBox benutzersprache;

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
	
	private JPanel lernenTab;
	private JPanel statistikTab;
	private JPanel karteiTab;
	private JTabbedPane tabsMenu;
	


	public Hauptmenu() 
	{
		this.mainFrame = new JFrame("Vokabeltrainer");

		this.obenMenuZeile = new JPanel();
		this.linkeMenuZeile = new JPanel();
		this.rechteMenuZeile = new JPanel();
		this.actionFenster = new JPanel();
		this.untenMenuZeile = new JPanel();
				
		this.benutzersprache = new JComboBox();
		
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
				
	}
	
	public void comboBox()
	{
		// create an empty combo box with items of type String
		JComboBox<String> comboLanguage = new JComboBox<String>();
		 
		// add items to the combo box
		comboLanguage.addItem("English");
		comboLanguage.addItem("French");
		comboLanguage.addItem("Spanish");
		comboLanguage.addItem("Japanese");
		comboLanguage.addItem("Chinese");
		
		String sprachenAuswahl[] = {
        		"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Wesdtfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thürindddsfgeeneee"
                };		
  // 		JComboBox<String> jComboBox = new JComboBox<String>(sprachenAuswahl);;
		
   		this.benutzersprache = comboLanguage;  
				
	}
	
	public void tabs()
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
		
		obenMenuZeile.add(abmeldenButton);
		obenMenuZeile.add(key2);
		obenMenuZeile.add(key3);
		obenMenuZeile.add(benutzersprache);
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
	

}
