package Viewer.Menuleisten;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.User;
import Viewer.Tab.TabKartei;
import Viewer.Tab.TabLernen;
import Viewer.Tab.TabStatistik;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht
 * 
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

	private TabLernen tle;
	private TabStatistik tst;
	private TabKartei tka;

	/**
	 * TabStatistik erstellen
	 * 
	 * @param u
	 *            Alle Daten des Users fliessen in die TabStatistik ein.
	 * @param mlo
	 *            Wird aus der Menuleisteoben erstellt.
	 * @param parent
	 *            Definition ob parent/child.
	 */

	public Tabs(User u, MenuleisteOben mlo, JFrame parent) {
		this.parent = parent;
		this.u = u;
		this.mlo = mlo;
		setSprache();
		tabs();
	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundls den einzelnen
	 * Datenfelder zu.
	 */
	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.lernenString = r.getString("lernen");
		this.statistikString = r.getString("statistik");
		this.karteiString = r.getString("kartei");
	}

	/**
	 * Erstellt alle Felder, welche benötigt werden. Sie werden direkt dem JPanel
	 * hinzugefügt.
	 */

	public void tabs() {
		this.tabsMenu = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

		setLayout(new BorderLayout(10, 10));
		setVisible(true);
		add(tabsMenu);

		setLernenTab();
		setStatistikTab();
		setKarteiTab();

		tabsMenu.addChangeListener(new TabListener());
	}

	/**
	 * Erstellt das Tab Lernen aus der Klasse TabLernen.
	 */

	public void setLernenTab() {
		this.tle = new TabLernen(u, parent);
		tabsMenu.insertTab(lernenString, null, tle, lernenString, 0);
	}

	/**
	 * Erstellt das Tab Statistik aus der Klasse TabStatistik.
	 */

	public void setStatistikTab() {
		this.tst = new TabStatistik(u);
		tabsMenu.insertTab(statistikString, null, tst, statistikString, 1);
	}

	/**
	 * Erstellt das Tab Kartei aus der Klasse TabKartei.
	 */

	public void setKarteiTab() {
		this.tka = new TabKartei(u, mlo);
		tabsMenu.insertTab(karteiString, null, tka, karteiString, 2);
	}

	/**
	 * Erstellt den Listener, welche definiert, was passiert, wenn man das Tab
	 * wechselt.
	 */

	class TabListener implements ChangeListener {

		public void stateChanged(ChangeEvent changeEvent) {
			if (tabsMenu.getSelectedIndex() == 0) {
			}
			/**
			 * Wenn das Tab Statistik angewählt wird, dann wird diese automatisch
			 * aktualisiert.
			 */

			if (tabsMenu.getSelectedIndex() == 1) {
				// tst.setSprache();
				// tst.statistikSpracheAktualisieren();
				tst.statistikAktualisieren();

			}
			if (tabsMenu.getSelectedIndex() == 2) {
				tka.karteiAktualisierne();
				// tka.setSprache();
				// tka.karteiSpracheAktualisieren();

			}
		}
	}
}
