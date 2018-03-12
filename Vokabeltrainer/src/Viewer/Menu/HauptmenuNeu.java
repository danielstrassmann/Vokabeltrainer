package Viewer.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.UserSammlung;
import Model.Kartei;
import Model.User;
import Viewer.Buttons.BenutzerspracheListener;
import Viewer.Menuleisten.MenuleisteOben;
import Viewer.Menuleisten.Tabs;
import Viewer.Tab.TabKartei;
import Viewer.Tab.TabLernen;
import Viewer.Tab.TabStatistik;

/**
 * Diese Klasse wird für das GUI des Hauptmenus gebraucht
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class HauptmenuNeu {

	public static JFrame mainFrame;
	private JPanel hauptPanel;
	private User u;
	private UserSammlung userliste;

	private String frameTitelString;
	
	private MenuleisteOben mlo;
	

	private Tabs tabs;
	

	public HauptmenuNeu(User u, UserSammlung userliste) {
		this.u = u;
		this.userliste = userliste;
		this.mainFrame = new JFrame();
		setSprache();
		hauptPanel();
		mainFrame();
	}

	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.frameTitelString = r.getString("vokabeltrainer");
	}

	public void mainFrame() {
		mainFrame.setTitle(frameTitelString);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(1200, 800);
		mainFrame.setResizable(false);
		mainFrame.setMinimumSize(new Dimension(1000, 800));
		mainFrame.setLocationRelativeTo(null);

	}

	public void hauptPanel() {
		this.hauptPanel = new JPanel();
		mainFrame.add(hauptPanel);
		hauptPanel.setVisible(true);
		hauptPanel.setBackground(Color.BLACK);

		hauptPanel.setLayout(new BorderLayout());

		hauptPanel.setSize(300, 300);

		this.mlo = new MenuleisteOben(u, userliste);
		hauptPanel.add(mlo, BorderLayout.PAGE_START);
		mlo.addBenutzerspracheChanged(new BenutzerspracheListener() {

			@Override
			public void benutzerspracheChanged() {
				
				tabs.tabSpracheAktualisieren();
				
				
				// TODO TBR
				// für TabLernen, TabKartei, TabStatistik, mlo --> geht über Tabs
				

			}
		});
		// Listener übergibt Objekt KK an User, so weiss man, was die aktive Kartei ist
		mlo.addItemChangeListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Kartei kk = (Kartei) event.getItemSelectable().getSelectedObjects()[0];
					u.setAktiveKartei(kk);

					// System.out.println(kk);
				}
			}
		});

		this.tabs = new Tabs(u, mlo, mainFrame);
		hauptPanel.add(tabs, BorderLayout.CENTER);

	}

}
