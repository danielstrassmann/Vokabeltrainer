package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Daten;
import Model.User;

public class TabStatistik extends JPanel {
	private JTable jt;
	private Daten d;
	private User u;

	private JLabel labelWerte;
	private JLabel labelDiagramm;
	
	private DiagrammBasic labelDiagramm2;

	private BoxLabel boxWerte;
	private BoxLabel boxDiagramm;

	JTable jt2;
	// JPanel Gritt;
	// TabStatistik stats;
	int zahl;
	Calendar now = Calendar.getInstance();

	public TabStatistik(User u) {
		this.u = u;

		tabStatistik();
		initGui();
	}

	private void initGui() {
		boxWerte.setPreferredSize(new Dimension(200, 700));
		boxDiagramm.setPreferredSize(new Dimension(400, 400));

		boxWerte.setBackground(new Color(180, 240, 180));
		boxWerte.setOpaque(true);
		boxDiagramm.setBackground(new Color(180, 240, 180));
		boxDiagramm.setOpaque(true);

		labelWerte.setBounds(50, 350, 300, 25);
//		labelDiagramm2.setBounds(50, 350, 300, 25);

		boxWerte.add(labelWerte);
		boxDiagramm.add(labelDiagramm2);
		
        labelDiagramm2.setData(100,20);

		add(boxWerte);
		add(boxDiagramm);

		setVisible(true);
		// setBackground(Color.green);

	}


	public class DiagrammBasic extends Canvas {

		private int marginX;
		private int marginY;
		private int totalCards;
		private int wrongCards;
		private int arc;

		public DiagrammBasic() {
			super();
			marginX = 20;
			marginY = 20;
		}

		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.GREEN);
			g2d.fillOval(getPieCenterX(), getPieCenterY(), getPieWidth(), getPieHeight());
			g2d.setColor(Color.RED);
			g2d.fillArc(getPieCenterX(), getPieCenterY(), getPieWidth(), getPieHeight(), 90, -this.arc);
		}

		private void recalculateArc() {
			double percentage = (100 / totalCards) * wrongCards;
			double arc = 360.0 / 100.0 * percentage;
			this.arc = (int) arc;
		}

		private int getPieCenterX() {
			return this.getSize().width / 2 - getPieWidth() / 2;
		}

		private int getPieCenterY() {
			return this.getSize().height / 2 - getPieHeight() / 2;
		}

		private int getPieWidth() {
			return getWidth() - marginX * 2;
		}

		private int getPieHeight() {
			return getHeight() - marginY * 2;
		}

		public void setData(int totalCards, int wrongCards) {
			this.totalCards = totalCards;
			this.wrongCards = wrongCards;
			recalculateArc();
			repaint();
		}
	}

	private void tabStatistik() {
		this.boxWerte = new BoxLabel();
		this.boxDiagramm = new BoxLabel();
		

		this.labelWerte = new JLabel("Behälter für die Werfelder");
		this.labelDiagramm = new JLabel("Behälter für das Diagramm");
		this.labelDiagramm2 = new DiagrammBasic();

		u.getUserDaten();
		this.d = new Daten();

		int zahl = 0;

		int a = new Integer(zahl);
		int b = new Integer(zahl);
		int c = new Integer(zahl);

		// d.getAntwortenKorrekt();
		d.getAntwortenFalsch();
		d.getAntwortenTotal();

		a = d.getAntwortenKorrekt();
		b = d.getAntwortenFalsch();
		c = d.getAntwortenTotal();

		u.setUserDaten(d);

		// a=12;
		// b=12;
		// c=a+b;

		//
		String[] columns = { "Antworten Korrekt", "Antworten Falsch", "Antworten Total" };
		Object[][] data = { { "" + a, "" + b, "" + c } }; // parameter einsetzten

		String[] timesoll = { "Zuletzt gelernt" };
		Object[][] timeist = {
				{ now.get(Calendar.DATE) + "." + now.get(Calendar.MONTH) + "." + now.get(Calendar.YEAR) } }; // Calendar.YEAR

		// Gritt = new JPanel();

		jt = new JTable(data, columns);
		jt.isCellEditable(1, 1);
		jt2 = new JTable(timeist, timesoll);
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

		this.labelDiagramm = new JLabel();
		labelDiagramm.setPreferredSize(new Dimension(300, 300));
		labelDiagramm.setBackground(Color.RED);
		labelDiagramm.setBounds(200, 200, 200, 200);
		add(labelDiagramm);

	}

}
