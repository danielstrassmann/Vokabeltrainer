package Viewer.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Viewer.Menuleisten.MenuleisteOben;
import Viewer.Menuleisten.Tabs;

public class HauptmenuNeu {

	public static JFrame mainFrame;
	private JPanel hauptPanel;
	
	public HauptmenuNeu()
	{
		this.mainFrame = new JFrame("Vokabeltrainer Optimus");
		this.hauptPanel = new JPanel();

		hauptPanel();		
		mainFrame();
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
		
		MenuleisteOben mlo = new MenuleisteOben();
		hauptPanel.add(mlo, BorderLayout.PAGE_START);
		
		Tabs tab = new Tabs();
		hauptPanel.add(tab, BorderLayout.CENTER);
		

	}
	

}
