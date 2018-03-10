package Viewer.Menuleisten;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.User;
import Viewer.Tab.*;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class Tabs extends JPanel {

	private JTabbedPane tabsMenu;
	private JFrame parent;

	private MenuleisteOben mlo;
	private User u;

	private String lernenString;
	private String statistikString;
	private String karteiString;

	public Tabs(User u, MenuleisteOben mlo, JFrame parent) {
		this.parent = parent;
		this.u = u;
		this.mlo = mlo;
		setSprache();
		tabs();

	}

	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.lernenString = r.getString("lernen");
		this.statistikString = r.getString("statistik");
		this.karteiString = r.getString("kartei");
	}

	public void tabs() {
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

		setLayout(new BorderLayout(10, 10));
		setVisible(true);
		add(tabsMenu);

		TabLernen tle = new TabLernen(u, parent);
		tabsMenu.addTab(lernenString, tle);

		TabStatistik tst = new TabStatistik(u);
		tabsMenu.addTab(statistikString, tst);

		TabKartei tka = new TabKartei(u, mlo);
		tabsMenu.addTab(karteiString, tka);

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
