package Viewer.Tab;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;

import Model.Daten;

public class TabStatistik extends JPanel 
{
	private int a;
	private int b;
	private int c;
	
	private JTable jt;
	private JPanel jp;
	
	public TabStatistik()
	{
		tabStatistik();
		initGui();
	}


	private void tabStatistik()
	{
		Daten d = new Daten(); 
		d.getAntwortenKorrekt();
		d.getAntwortenFalsch();
		d.getAntwortenTotal();
		
		this.a = d.getAntwortenKorrekt();
		this.b = d.getAntwortenFalsch();
		this.c = d.getAntwortenTotal();
		
		
	}
	private void initGui()
	{
		String[] columns = {"Antworten Korrekt", "Antworten Falsch", "Antworten Total"};
		Integer[][] data = {{a},
						    {b},
						    {c}};
		
		this.jp = new JPanel();
		this.jt = new JTable(data, columns);
		jt.setFillsViewportHeight(true);
		jp.add(jt);
		add(jp);
		
		setVisible(true);
		setBackground(Color.green);
		
	}
}
