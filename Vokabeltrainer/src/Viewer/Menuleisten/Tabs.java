package Viewer.Menuleisten;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.User;
import Viewer.Tab.*;

/**
 * Diese Klasse wird f�r die Statistik veranschaung gebraucht
 * 
 * @author Marius Br�ndle St.Gallen
 * @version 1.0 09.3.2018
 */

public class Tabs extends JPanel {

	private JTabbedPane tabsMenu;
	private JFrame parent;

	private MenuleisteOben mlo;
	private User u;

	public Tabs(User u, MenuleisteOben mlo, JFrame parent) {
		this.parent = parent;
		this.u = u;
		this.mlo = mlo;
		tabs();

	}

	public void tabs() {
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

		setLayout(new BorderLayout(10, 10));
		setVisible(true);
		add(tabsMenu);

		TabLernen tle = new TabLernen(u, parent);
		tabsMenu.addTab("Lernen", tle);

		TabStatistik tst = new TabStatistik(u);
		tabsMenu.addTab("Statistik", tst);

		TabKartei tka = new TabKartei(u, mlo);
		tabsMenu.addTab("Kartei", tka);

		tabsMenu.addChangeListener(new TabListener());
	}

	class TabListener implements ChangeListener {

		public void stateChanged(ChangeEvent changeEvent) {
			if (tabsMenu.getSelectedIndex() == 0) {
			}
			if (tabsMenu.getSelectedIndex() == 1) {
				TabStatistik s = new TabStatistik(u);
				s.statistikAktualisieren();
			}
			if (tabsMenu.getSelectedIndex() == 2) {
			}
		}
	}
}
