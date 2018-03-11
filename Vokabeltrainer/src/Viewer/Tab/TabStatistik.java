package Viewer.Tab;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.ScrollPane;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Model.Daten;
import Model.User;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht. Diese Klasse
 * generiert den Inhalt des Tab "Statistik". Diese Klasse wird von der Klasse
 * "Tabs" aufgerufen.
 * 
 * @author Marius Brändle St.Gallen / Duc Thach
 * @version 1.0 09.3.2018
 */

public class TabStatistik extends JPanel {
	private JTable jt;
	private Daten d;
	private User u;

	private int a;
	private int b;
	private int c;

	private int prozentRichtig;
	private int prozentFalsch;

	private DiagrammBasic labelDiagramm;
	private JScrollPane jps;

	private JLabel labelWertRichtig;
	private JLabel labelWertFalsch;
	private JLabel labelWertTotal;
	private JLabel labelWertProzentRichtig;
	private JLabel labelWertProzentFalsch;

	private BoxLabel boxLabelWertRichtig;
	private BoxLabel boxLabelWertFalsch;
	private BoxLabel boxLabelWertTotal;
	private BoxLabel boxLabelWertProzentRichtig;
	private BoxLabel boxLabelWertProzentFalsch;

	JTable jt2;
	Calendar now = Calendar.getInstance();

	private String anzahlRichtigString;
	private String anzahlFalschString;
	private String totalKartenString;
	private String richtigString;
	private String falschString;

	public TabStatistik(User u) {
		this.u = u;
		setSprache();
		tabStatistik();
		initGui();
	}

	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.anzahlRichtigString = r.getString("anzahlRichtig");
		this.anzahlFalschString = r.getString("anzahlFalsch");
		this.totalKartenString = r.getString("totalKarten");
		this.richtigString = r.getString("richtig");
		this.falschString = r.getString("falsch");
	}
	
	public void statistikSpracheAktualisieren() {
		this.labelWertRichtig.setText(anzahlRichtigString + " " + a);
		this.labelWertFalsch.setText(anzahlFalschString + " " + b);
		this.labelWertTotal.setText(totalKartenString + " " + c);
		this.labelWertProzentRichtig.setText(prozentRichtig + "% " + richtigString);
	}

	private void initGui() {
		labelDiagramm.setSize(500, 500);

		boxLabelWertRichtig.setPreferredSize(new Dimension(200, 50));
		boxLabelWertFalsch.setPreferredSize(new Dimension(200, 50));
		boxLabelWertTotal.setPreferredSize(new Dimension(200, 50));
		boxLabelWertProzentRichtig.setPreferredSize(new Dimension(200, 50));
		boxLabelWertProzentFalsch.setPreferredSize(new Dimension(200, 50));

		boxLabelWertProzentRichtig.setBackground(new Color(0, 102, 0));
		boxLabelWertProzentRichtig.setOpaque(true);
		boxLabelWertProzentFalsch.setBackground(Color.RED);
		boxLabelWertProzentFalsch.setOpaque(true);

		labelWertRichtig.setBounds(10, 15, 300, 25);
		labelWertFalsch.setBounds(10, 15, 300, 25);
		labelWertTotal.setBounds(10, 15, 300, 25);
		labelWertProzentFalsch.setBounds(38, 15, 300, 25);
		labelWertProzentRichtig.setBounds(38, 15, 300, 25);

		labelWertRichtig.setFont(new Font("Arial", Font.BOLD, 20));
		labelWertFalsch.setFont(new Font("Arial", Font.BOLD, 20));
		labelWertTotal.setFont(new Font("Arial", Font.BOLD, 20));
		labelWertProzentRichtig.setFont(new Font("Arial", Font.BOLD, 20));
		labelWertProzentFalsch.setFont(new Font("Arial", Font.BOLD, 20));

		Border border = getBorder();
		LineBorder margin = new LineBorder(Color.GRAY, 2);
		boxLabelWertRichtig.setBorder(new CompoundBorder(border, margin));
		boxLabelWertFalsch.setBorder(new CompoundBorder(border, margin));
		boxLabelWertTotal.setBorder(new CompoundBorder(border, margin));
		boxLabelWertProzentFalsch.setBorder(new CompoundBorder(border, margin));
		boxLabelWertProzentRichtig.setBorder(new CompoundBorder(border, margin));

		boxLabelWertRichtig.add(labelWertRichtig);
		boxLabelWertFalsch.add(labelWertFalsch);
		boxLabelWertTotal.add(labelWertTotal);
		boxLabelWertProzentRichtig.add(labelWertProzentRichtig);
		boxLabelWertProzentFalsch.add(labelWertProzentFalsch);

		
		add(boxLabelWertRichtig);
		add(boxLabelWertFalsch);
		add(boxLabelWertTotal);
		add(boxLabelWertProzentRichtig);
		add(boxLabelWertProzentFalsch);
		add(labelDiagramm);

		setVisible(true);
	}

	public void loeschenInhalt() {
		labelDiagramm.setData(0, 0);
		this.labelWertRichtig.setText(anzahlRichtigString + " " + 0);
	}
	
	public void statistikAktualisieren() {
		this.d = u.getUserDaten();

		this.a = d.getAntwortenKorrekt();
		this.b = d.getAntwortenFalsch();
		this.c = d.getAntwortenTotal();

		berechnenProzentFalsch(b, c);

		this.prozentRichtig = 100 - prozentFalsch;

		this.labelWertRichtig.setText(anzahlRichtigString + " " + a);
		this.labelWertFalsch.setText(anzahlFalschString + " " + b);
		this.labelWertTotal.setText(totalKartenString + " " + c);
		this.labelWertProzentRichtig.setText(prozentRichtig + "% " + richtigString);
		
		labelDiagramm.setData(c, b);
		
		
	}
	
	public void berechnenProzentFalsch(int b, int c) {
		if (c == 0) {
			if (b == 0) {
				b = 1;
			}
			c = 1;
			this.prozentFalsch = b * 100 / c;
			this.b = 0;
			this.c = 0;
			this.labelWertProzentFalsch.setText(0 + "% " + falschString);
		} else {

			this.c = c;
			this.b = b;
			this.prozentFalsch = b * 100 / c;
			this.labelWertProzentFalsch.setText(prozentFalsch + "% " + falschString);

		}
	}

	private void tabStatistik() {
		this.labelDiagramm = new DiagrammBasic();

		this.labelWertProzentFalsch = new JLabel();
		this.labelWertRichtig = new JLabel();
		this.labelWertFalsch = new JLabel();
		this.labelWertTotal = new JLabel();
		this.labelWertProzentRichtig = new JLabel();

		this.boxLabelWertRichtig = new BoxLabel();
		this.boxLabelWertFalsch = new BoxLabel();
		this.boxLabelWertTotal = new BoxLabel();
		this.boxLabelWertProzentRichtig = new BoxLabel();
		this.boxLabelWertProzentFalsch = new BoxLabel();

		statistikAktualisieren();

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

			g2d.setColor(new Color(0, 102, 0));
			g2d.fillOval(getPieCenterX(), getPieCenterY(), getPieWidth(), getPieHeight());
			g2d.setColor(Color.RED);
			g2d.fillArc(getPieCenterX(), getPieCenterY(), getPieWidth(), getPieHeight(), 90, -this.arc);
		}

		private void recalculateArc() {
			double percentage = (wrongCards * 100) / totalCards;
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
