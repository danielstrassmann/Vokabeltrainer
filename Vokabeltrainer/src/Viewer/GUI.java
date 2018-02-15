package Viewer;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GUI {


	
	public static void main(String[] args) 
	{
		Hauptmenu gui = new Hauptmenu();
		
		gui.tabKartei();
		gui.paint();
		gui.add();
		gui.visible();
		gui.setSize();
		gui.border();
		gui.color();
		gui.karteiAuswahl();
		gui.spracheAuswahl();
		gui.tabs();
		gui.abmeldeButton();

		
//		gui.paintHauptmenu();
	}
	
}
