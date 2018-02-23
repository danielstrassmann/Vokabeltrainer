package Viewer.Menu;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

import Viewer.Menuleisten.*;



public class HauptmenuNeu {

	public static JFrame mainFrame;
	private JPanel hauptPanel;
	


	
	public HauptmenuNeu()
	{
		this.mainFrame = new JFrame("Vokabeltrainer Optimus ");
		this.hauptPanel = new JPanel();

		hauptPanel();		
		mainFrame();


	}
	
	public void mainFrame()
	{
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
		mainFrame.setSize(1500,1000);
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
		

/*		
		BenutzerspracheButton bsb = new BenutzerspracheButton();
		hauptPanel.add(bsb, BorderLayout.CENTER);
				
		KarteiButton kb = new KarteiButton();
		hauptPanel.add(kb, BorderLayout.CENTER);
		
		AbmeldeButton ab = new AbmeldeButton();
		hauptPanel.add(ab, BorderLayout.CENTER);
*/		

		
		
	}
	

}
