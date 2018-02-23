package Viewer.Tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


public class TabLernen extends JPanel implements ActionListener
{
	private JLabel boxLabel1;
	private JLabel boxLabel2;
	private JLabel boxLabel3;
	private JLabel boxLabel4;
	private JLabel boxLabel5;
	
	public TabLernen()
	{
		tabLernen();
		initGui();
	
	}
	
	private void tabLernen()
	{
		this.boxLabel1 = new JLabel("Box 1");
		this.boxLabel2 = new JLabel("Box 2");
		this.boxLabel3 = new JLabel("Box 3");
		this.boxLabel4 = new JLabel("Box 4");
		this.boxLabel5 = new JLabel("Box 5");
		
		boxLabel1.addMouseListener(new boxMausKlick());
		boxLabel2.addMouseListener(new boxMausKlick());	
		boxLabel3.addMouseListener(new boxMausKlick());	
		boxLabel4.addMouseListener(new boxMausKlick());	
		boxLabel5.addMouseListener(new boxMausKlick());
	}
	
	
	private void initGui()
	{
		Border border = getBorder();
		Border margin = new LineBorder(Color.lightGray,5);
		
		boxLabel1.setBorder(new CompoundBorder(border, margin));
		boxLabel2.setBorder(new CompoundBorder(border, margin));
		boxLabel3.setBorder(new CompoundBorder(border, margin));
		boxLabel4.setBorder(new CompoundBorder(border, margin));
		boxLabel5.setBorder(new CompoundBorder(border, margin));
		
		boxLabel1.setPreferredSize(new Dimension(200,700));
		boxLabel2.setPreferredSize(new Dimension(200,700));
		boxLabel3.setPreferredSize(new Dimension(200,700));
		boxLabel4.setPreferredSize(new Dimension(200,700));
		boxLabel5.setPreferredSize(new Dimension(200,700));
		
		boxLabel1.setBackground(Color.BLUE);
		boxLabel2.setBackground(Color.RED);
		boxLabel3.setBackground(Color.BLUE);
		boxLabel4.setBackground(Color.BLUE);
		boxLabel5.setBackground(Color.BLUE);
				
	
		
		
		add(boxLabel1);
		add(boxLabel2);
		add(boxLabel3);
		add(boxLabel4);
		add(boxLabel5);
		
		setVisible(true);
		setBackground(Color.GRAY);
		
	}
	
	 class boxMausKlick implements MouseListener 
		{
			public void mouseClicked(MouseEvent s) 
			{
				JFrame lernenFennster = new JFrame("LernenFenster");
				lernenFennster.setVisible(true);
				lernenFennster.setSize(500,500);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
