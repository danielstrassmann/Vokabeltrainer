package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Viewer.Menuleisten.MenuleisteOben;
import Viewer.Popup.Lernen;


public class TabLernen extends JPanel implements ActionListener
{
	private JLabel boxLabel1;
	private JLabel boxLabel2;
	private JLabel boxLabel3;
	private JLabel boxLabel4;
	private JLabel boxLabel5;
	
	private JLabel box1;
	private JLabel box2;
	private JLabel box3;
	private JLabel box4;
	private JLabel box5;
	
	private MenuleisteOben mlo;
	
	public TabLernen(MenuleisteOben mlo)
	{
		this.mlo= mlo;
		tabLernen();
		initGui();
	
	}
	
	private void tabLernen()
	{
		this.boxLabel1 = new JLabel();
		this.boxLabel2 = new JLabel();
		this.boxLabel3 = new JLabel();
		this.boxLabel4 = new JLabel();
		this.boxLabel5 = new JLabel();
		
		this.box1 = new JLabel("BOX 1");
		this.box2 = new JLabel("BOX 2");
		this.box3 = new JLabel("BOX 3");
		this.box4 = new JLabel("BOX 4");
		this.box5 = new JLabel("BOX 5");

		
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
		
		boxLabel1.setLocation(10, 20);


		boxLabel1.setBackground(new Color(100, 120,100));
		boxLabel1.setOpaque(true);
		boxLabel2.setBackground(new Color(100, 140,100));
		boxLabel2.setOpaque(true);
		boxLabel3.setBackground(new Color(100, 160,100));
		boxLabel3.setOpaque(true);
		boxLabel4.setBackground(new Color(100, 180,100));
		boxLabel4.setOpaque(true);
		boxLabel5.setBackground(new Color(100, 200, 100));
		boxLabel5.setOpaque(true);
		

		
		box1.setBounds(50, 350, 300, 25);
		box2.setBounds(50, 350, 300, 25);
		box3.setBounds(50, 350, 300, 25);
		box4.setBounds(50, 350, 300, 25);
		box5.setBounds(50, 350, 300, 25);
		
		box1.setFont(new Font( "Bradley Hand ITC", Font.BOLD, 34));
		box2.setFont(new Font( "Bradley Hand ITC", Font.BOLD, 34));
		box3.setFont(new Font( "Bradley Hand ITC", Font.BOLD, 34));
		box4.setFont(new Font( "Bradley Hand ITC", Font.BOLD, 34));
		box5.setFont(new Font( "Bradley Hand ITC", Font.BOLD, 34));

		
		boxLabel1.add(box1);
		boxLabel2.add(box2);
		boxLabel3.add(box3);
		boxLabel4.add(box4);
		boxLabel5.add(box5);
		
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
				Lernen lernenFennster = new Lernen();
				
//				lernenFennster.setVisible(true);
//				lernenFennster.setSize(500,500);

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
