package Viewer.Tab;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

	/**
	 * 
	 * TabStatistik erstellen
	 * 
	 * @param u
	 *            Alle Daten des Users fliessen in die TabStatistik ein.
	 */
	public TabStatistik(User u) {
		this.u = u;
		setSprache();
		tabStatistik();
		initGui();
	}

	/**
	 * 
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundls den einzelnen
	 * Datenfelder zu.
	 * 
	 */
	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.anzahlRichtigString = r.getString("anzahlRichtig");
		this.anzahlFalschString = r.getString("anzahlFalsch");
		this.totalKartenString = r.getString("totalKarten");
		this.richtigString = r.getString("richtig");
		this.falschString = r.getString("falsch");
	}

	/**
	 * 
	 * Aktualisiert die Sprache des ausgewählten Sprachcodes.
	 * 
	 */
	public void spracheAktualisieren() {
		setSprache();
		this.labelWertRichtig.setText(anzahlRichtigString + " " + a);
		this.labelWertFalsch.setText(anzahlFalschString + " " + b);
		this.labelWertTotal.setText(totalKartenString + " " + c);
		this.labelWertProzentRichtig.setText(prozentRichtig + "% " + richtigString);
	}

	/**
	 * 
	 * Initialisiert das GUI
	 * 
	 */
	private void initGui() {
		labelDiagramm.setSize(500, 500);

		boxLabelWertRichtig.setPreferredSize(new Dimension(200, 50));
		boxLabelWertFalsch.setPreferredSize(new Dimension(200, 50));
		boxLabelWertTotal.setPreferredSize(new Dimension(200, 50));
		boxLabelWertProzentRichtig.setPreferredSize(new Dimension(200, 50));
		boxLabelWertProzentFalsch.setPreferredSize(new Dimension(200, 50));

		boxLabelWertProzentRichtig.setBackground(new Color(100, 200, 100));
		boxLabelWertProzentRichtig.setOpaque(true);
		boxLabelWertProzentFalsch.setBackground(new Color(204, 0, 0));
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

	/**
	 * 
	 * Aktualisiert alle Daten der Statistik. Dies wird immer ausgeführt, wenn das
	 * TabStatistik ausgewählt wird.
	 * 
	 */
	public void statistikAktualisieren() {
		this.d = u.getUserDaten();

		this.a = d.getAntwortenKorrekt();
		this.b = d.getAntwortenFalsch();
		this.c = d.getAntwortenTotal();

		berechnenProzentFalsch(b, c);

		this.prozentRichtig = 100 - prozentFalsch;

		spracheAktualisieren();

		labelDiagramm.setData(c, b);

	}

	/**
	 * 
	 * Berechnet den Prozentwert aus den Anzahl Falschen und den Total gelernten
	 * Karten aus. Zusätzlich wird abgefangen, dass keine Division durch 0
	 * stattfindet.
	 * 
	 * @param b
	 *            Anzahl Falsch gelöste Karten
	 * @param c
	 *            Total gelöste Karten
	 */
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

	/**
	 * 
	 * Erstellt alle Felder, welche für das TabStatistik benötigt werden.
	 * 
	 */

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

	/**
	 * 
	 * In dieser Inneren Klasse wird das Diagramm erstellt und gezeichnet.
	 * 
	 */
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

			g2d.setColor(new Color(100, 200, 100));
			g2d.fillOval(getPieCenterX(), getPieCenterY(), getPieWidth(), getPieHeight());
			g2d.setColor(new Color(204, 0, 0));
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

		/**
		 * Hier wird abgefangen, dass es eine Division durch 0 gibt.
		 * 
		 * @param totalCards
		 *            Anzahl gelernte Karten
		 * @param wrongCards
		 *            Anzahl falsch gelöste Karten
		 */
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
