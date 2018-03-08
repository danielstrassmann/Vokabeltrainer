package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Daten;
import Model.User;

public class TabStatistik extends JPanel {
	private JTable jt;
	private Daten d;
	private User u;
	
	private int a;
	private int b;
	private int c;

	private DiagrammBasic labelDiagramm;

	JTable jt2;
	int zahl;
	Calendar now = Calendar.getInstance();

	public TabStatistik(User u) {
		this.u = u;


		tabStatistik();
		initGui();
	}

	private void initGui() {
		labelDiagramm.setSize(400, 400);

		add(labelDiagramm, BorderLayout.CENTER);

		setVisible(true);

	}
	
	void statistikAktualisieren() {
		this.d = u.getUserDaten();
		
		this.a = d.getAntwortenKorrekt();
		this.b = d.getAntwortenFalsch();
		this.c = d.getAntwortenTotal();
		
		labelDiagramm.setData(c, b);
	}

	private void tabStatistik() {
		this.labelDiagramm = new DiagrammBasic();

		statistikAktualisieren();


		String[] columns = { "Antworten Korrekt", "Antworten Falsch", "Antworten Total" };
		Object[][] data = { { "" + a, "" + b, "" + c } }; // parameter einsetzten

		// String[] timesoll = { "Zuletzt gelernt" };
		// Object[][] timeist = {
		// { now.get(Calendar.DATE) + "." + now.get(Calendar.MONTH) + "." +
		// now.get(Calendar.YEAR) } }; // Calendar.YEAR

		jt = new JTable(data, columns);
		jt.isCellEditable(1, 1);
		// jt2 = new JTable(timeist, timesoll);
		jt.setPreferredScrollableViewportSize(new Dimension(450, 16));
		jt.setFillsViewportHeight(true);
		jt.setEnabled(false);

		JScrollPane jps = new JScrollPane(jt);
		add(jps);



	}

	public class DiagrammBasic extends Canvas {

		private int marginX;
		private int marginY;
		private int totalCards;
		private int wrongCards;
		private int arc;

		public DiagrammBasic() {
			super();
			marginX = 0;
			marginY = 0;
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
			if (totalCards == 0) {
				if (wrongCards == 0) {
					wrongCards = 100;
				}

				totalCards = 100;
			}
			this.totalCards = totalCards;
			this.wrongCards = wrongCards;
			recalculateArc();
			repaint();
		}
	}

}
