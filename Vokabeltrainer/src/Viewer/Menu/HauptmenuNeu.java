package Viewer.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Kartei;
import Model.User;
import Viewer.Menuleisten.MenuleisteOben;
import Viewer.Menuleisten.Tabs;

public class HauptmenuNeu {

	public static JFrame mainFrame;
	private JPanel hauptPanel;
	private User u;
	
	public HauptmenuNeu(User u)
	{
		this.u = u;
		this.mainFrame = new JFrame("Vokabeltrainer Optimus");
		this.hauptPanel = new JPanel();

		hauptPanel();		
		mainFrame();
		
		System.out.println("Hauptmenu-User: " + this.u);
	}
	
	public void mainFrame()
	{
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
		mainFrame.setSize(1200,800);
		mainFrame.setResizable(false);
		mainFrame.setMinimumSize(new Dimension(1000,800));
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.add(hauptPanel);
	}
	
	public void hauptPanel()
	{
		hauptPanel.setVisible(true);
		hauptPanel.setBackground(Color.BLACK);
		
		hauptPanel.setLayout(new BorderLayout());

		hauptPanel.setSize(300,300);
		
		MenuleisteOben mlo = new MenuleisteOben(u);
		hauptPanel.add(mlo, BorderLayout.PAGE_START);
		// Karteiliste wird geladen, gemäss aktiver Kartei im UI (TabKartei)
				// Listener übergibt Objekt KK
				mlo.addItemChangeListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent event) {
						if (event.getStateChange() == ItemEvent.SELECTED) {
							Kartei kk = (Kartei) event.getItemSelectable().getSelectedObjects()[0];
							u.setAktiveKartei(kk);
							
							System.out.println(kk);
						}
					}
				});
		
		Tabs tab = new Tabs(u,mlo,mainFrame);
		hauptPanel.add(tab, BorderLayout.CENTER);
		

	}
	

}
