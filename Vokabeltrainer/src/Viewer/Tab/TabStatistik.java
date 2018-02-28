package Viewer.Tab;

import java.awt.Color;
import java.awt.image.ImageObserver;
import java.lang.Object;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

import Model.Daten;

public class TabStatistik extends JPanel 
{
	
	
	public TabStatistik()
	{
		tabStatistik();
		initGui();
	}


	private void tabStatistik()
		{
	class PieChart extends JFrame {
			   private Font         font; 

				   public PieChart()
				   {
					a = new Integer(null);
					b = new Integer(null);
					c = new Integer(null);
					  setSize( 600, 400 );	
				      setLocation( 70, 70 ) ;
				      setVisible(true);
				   }

				   public void paint( Graphics g )
				   {
			      font = new Font("Sanserif", Font.BOLD, 14);
			      // start at 0 and sweep 360 degrees
			      g.setColor( Color.black );
			      g.fillArc( 110, 80, 300, 300, 0, 36 );
			      g.drawString("", 420, 80);
			      g.setColor( Color.red );
			      g.fillArc( 110, 80, 300, 300, 36, 120 );
			      g.drawString("", 420, 100);
			      g.setColor( Color.blue );
			      g.fillArc( 110, 80, 300, 300, 156, 80 );
			      g.drawString("", 420, 120);
			      g.setColor( Color.green );
			      g.fillArc( 110, 80, 300, 300, 236, 80 );
			      g.drawString("", 420, 140);
			      g.setColor( Color.orange );
			      g.fillArc( 110, 80, 300, 300, 316, 44 );
			      g.drawString("", 420, 160);
			      g.setColor( Color.black );
			      g.drawArc( 110, 80, 300, 300, 0, 360 );
			   }
			   public void main( String args[] )
			   {
			      PieChart chart = new PieChart();
			               System.exit( 0 );
		            }
			         
			   }
		}


		JTable table0,table1,table2;
		boolean value=true;
		DrawingPanel panel;
		
		Color[] color1= {
		new Color (198, 40, 40),new Color (173, 20, 87),new Color(106, 27, 154),
		new Color (69, 39, 160),new Color (40 ,53 ,147)
		};
	public static void main(String args[]) {
		 new TabStatistik().gui();
		 
	
	}
	
	public void gui()
	{
		panel = new DrawingPanel();
		
		table0=new JTable(
		new Object[5][1],new String [] {"Despription"} );
		
	}
abstract class DrawingPanel implements ImageObserver{
	
}
	private void initGui()
	{
		setVisible(true);
		setBackground(Color.green);
	}
}
