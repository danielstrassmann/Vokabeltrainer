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
 * Diese Klasse wird f�r die Statistik veranschaung gebraucht
 * 
 * 
 * @author Marius Br�ndle St.Gallen
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
	 *            aktueller User
	 * @param mlo
	 *            Instanz von MenuLeisteoben, damit Listerner �bergeben werden kann.
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
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
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
	 * Erstellt alle Felder, welche ben�tigt werden. Sie werden direkt dem JPanel
	 * hinzugef�gt.
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

	public void tabSpracheAktualisieren() {

		// Wenn Sprache ge�ndert, wird Sprache im GUI aktualisiert
		this.tle.spracheAktualisieren();
		this.tst.spracheAktualisieren();
		this.tka.spracheAktualisieren();

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

	public void spracheAktualisieren() {
		setSprache();
		tabsMenu.setTitleAt(0, lernenString);
		tabsMenu.setTitleAt(1, statistikString);
		tabsMenu.setTitleAt(2, karteiString);
	}

	public TabLernen getLerntenTab() {

		return this.tle;

	}

	public TabStatistik getStatistikTab() {

		return this.tst;

	}

	public TabKartei getKarteiTab() {

		return this.tka;

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
			 * Wenn das Tab Statistik angew�hlt wird, dann wird diese automatisch
			 * aktualisiert.
			 */

			if (tabsMenu.getSelectedIndex() == 1) {
				tst.statistikAktualisieren();

			}
			if (tabsMenu.getSelectedIndex() == 2) {
				tka.karteiAktualisierne();

			}
		}
	}
}
