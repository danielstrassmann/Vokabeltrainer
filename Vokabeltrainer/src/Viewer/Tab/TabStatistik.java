package Viewer.Tab;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Model.Daten;
import Model.User;

public class TabStatistik extends JPanel 
{
	private JTable jt;
	private Daten d;
	private User u;
	JTable jt2;
	JPanel Gritt;
	TabStatistik stats;
	int zahl;
	Calendar now = Calendar.getInstance();
	
	public TabStatistik(User u)
	{
		this.u = u;
		tabStatistik();
		initGui();
	}


	private void tabStatistik()
	{
		
		//u.getUserDaten();
		this.d = new Daten();
		
		//
		int zahl = 0;
		
		int a = new Integer(zahl);
		int b = new Integer(zahl);
		int c = new Integer(zahl);
		
		//d.getAntwortenKorrekt();
		d.getAntwortenFalsch();
		d.getAntwortenTotal();
		
		a = d.getAntwortenKorrekt();
		b = d.getAntwortenFalsch();
		c = d.getAntwortenTotal();
		u.setUserDaten(d);
		
		a=12;
		b=12;
		c=a+b;
		
		//
		String[] columns = {"Antworten Korrekt", "Antworten Falsch", "Antworten Total"};
		Object[][] data = {{""+a,""+b,""+c}}; //parameter einsetzten
					
		String[] timesoll = {"Zuletzt gelernt"};
		Object[][] timeist = {{now.get(Calendar.DATE)+"."+now.get(Calendar.MONTH)+"."+now.get(Calendar.YEAR)}};				//Calendar.YEAR
		
		Gritt = new JPanel();
	
		jt = new JTable(data, columns);
		jt.isCellEditable(1, 1);
		jt2 = new JTable( timeist, timesoll);
		jt.setPreferredScrollableViewportSize(new Dimension(450, 16));
		jt.setFillsViewportHeight(true);
		jt.setEnabled(false);
		jt2.setPreferredScrollableViewportSize(new Dimension(450, 16));
		jt2.setFillsViewportHeight(true);
		jt2.setEnabled(false);
		
		JScrollPane jps = new JScrollPane(jt);
		add(jps);
		JScrollPane jps2 = new JScrollPane(jt2);
		add(jps2);
		
		
		
	}
	
	private void initGui()
	
	{
		JFrame jf = new JFrame();
		TabStatistik stats = new TabStatistik(u);
		jf.setTitle("Vokabeltrainer");
		jf.setSize(600,200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(stats);
		
		setVisible(true);
		setBackground(Color.green);
		
		
		
	}
	
}
