package Viewer.Menuleisten;

import java.awt.BorderLayout;

import javax.swing.*;

import Model.User;
import Viewer.Tab.*;

public class Tabs extends JPanel{
	
private JTabbedPane tabsMenu ;
private JFrame parent;
	
private MenuleisteOben mlo;
private User u;
	
	public Tabs(User u, MenuleisteOben mlo, JFrame parent)
	{
		this.parent = parent;
		this.u = u;
	this.mlo = mlo;
		tabs();
			
	}
	
	public void tabs()
	{
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT );
		
		setLayout(new BorderLayout(10, 10));
		setVisible(true);
		add(tabsMenu);
		
		
		TabLernen tle = new TabLernen(u, parent);
		tabsMenu.addTab("Lernen", tle);
		
		TabStatistik tst = new TabStatistik(u);
		tabsMenu.addTab("Statistik", tst);

		TabKartei tka = new TabKartei(u,mlo);
		tabsMenu.addTab("Kartei", tka);
	}

}
