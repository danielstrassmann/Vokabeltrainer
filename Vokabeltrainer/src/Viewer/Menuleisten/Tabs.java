package Viewer.Menuleisten;

import java.awt.BorderLayout;

import javax.swing.*;

import Viewer.Tab.*;

public class Tabs extends JPanel{
	
private JTabbedPane tabsMenu ;	
	
	
	public Tabs()
	{
		tabs();
			
	}
	
	public void tabs()
	{
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT );
		
		setLayout(new BorderLayout(10, 10));
		setVisible(true);
		add(tabsMenu);
		
		
		TabLernen tle = new TabLernen();
		tabsMenu.addTab("Lernen", tle);
		
		TabStatistik tst = new TabStatistik();
		tabsMenu.addTab("Statistik", tst);

		TabKartei tka = new TabKartei();
		tabsMenu.addTab("Kartei", tka);
				
	}

}
