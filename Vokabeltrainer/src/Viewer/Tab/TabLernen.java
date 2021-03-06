package Viewer.Tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.Popup.KeineKarten;
import Viewer.Popup.Lernen;

/**
 * Diese Klasse wird f�r das Lernen gebraucht. Diese Klasse generiert den Inhalt
 * des Tab "Lernen". Aus dieser Klasse wird das Popup-Fenster" Lernen
 * aufgerufen. Diese Klasse wird von der Klasse "Tabs" aufgerufen
 * 
 * @author Marius Br�ndle St.Gallen / Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class TabLernen extends JPanel implements ActionListener {

	Border margin;
	Border margin1;
	Border margin2;
	Border margin3;
	Border margin4;
	Border margin5;
	Border marginRed;
	Border border;

	private BoxLabel boxLabel1;
	private BoxLabel boxLabel2;
	private BoxLabel boxLabel3;
	private BoxLabel boxLabel4;
	private BoxLabel boxLabel5;

	private JLabel box1;
	private JLabel box2;
	private JLabel box3;
	private JLabel box4;
	private JLabel box5;

	private JFrame parent;
	private User u;

	private KeineKarten fehlerdialog;

	private String boxString;

	/**
	 * 
	 * TabStatistik erstellen
	 * 
	 * @param u
	 *            aktueller eingeloggter Benutzer. genutzt f�r richtige Sprache und aktuelle Kartei
	 * 
	 * @param parent
	 *            Definition ob parent/child.
	 */

	public TabLernen(User u, JFrame parent) {
		this.parent = parent;
		this.u = u;
		setSprache();
		tabLernen();
		initGui();
	}

	/**
	 * 
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 * 
	 */
	private void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.boxString = r.getString("box");
	}

	/**
	 * 
	 * Erstellt alle Felder, welche f�r das TabStatistik ben�tigt werden.
	 * 
	 */

	private void tabLernen() {
		this.boxLabel1 = new BoxLabel();
		this.boxLabel2 = new BoxLabel();
		this.boxLabel3 = new BoxLabel();
		this.boxLabel4 = new BoxLabel();
		this.boxLabel5 = new BoxLabel();

		this.box1 = new JLabel(boxString + " 1");
		this.box2 = new JLabel(boxString + " 2");
		this.box3 = new JLabel(boxString + " 3");
		this.box4 = new JLabel(boxString + " 4");
		this.box5 = new JLabel(boxString + " 5");

		boxLabel1.setId(1);
		boxLabel2.setId(2);
		boxLabel3.setId(3);
		boxLabel4.setId(4);
		boxLabel5.setId(5);

		boxLabel1.addMouseListener(new boxMausKlick());
		boxLabel2.addMouseListener(new boxMausKlick());
		boxLabel3.addMouseListener(new boxMausKlick());
		boxLabel4.addMouseListener(new boxMausKlick());
		boxLabel5.addMouseListener(new boxMausKlick());

	}

	/**
	 * 
	 * Initialisiert das GUI.
	 * 
	 */
	private void initGui() {
		Border border = getBorder();
		margin1 = new LineBorder(new Color(100, 100, 100), 15);
		margin2 = new LineBorder(new Color(100, 120, 100), 15);
		margin3 = new LineBorder(new Color(100, 140, 100), 15);
		margin4 = new LineBorder(new Color(100, 160, 100), 15);
		margin5 = new LineBorder(new Color(100, 180, 100), 15);
		marginRed = new LineBorder(new Color(100, 50, 50), 15);

		boxLabel1.setBorder(new CompoundBorder(border, margin1));
		boxLabel2.setBorder(new CompoundBorder(border, margin2));
		boxLabel3.setBorder(new CompoundBorder(border, margin3));
		boxLabel4.setBorder(new CompoundBorder(border, margin4));
		boxLabel5.setBorder(new CompoundBorder(border, margin5));

		boxLabel1.setPreferredSize(new Dimension(200, 700));
		boxLabel2.setPreferredSize(new Dimension(200, 700));
		boxLabel3.setPreferredSize(new Dimension(200, 700));
		boxLabel4.setPreferredSize(new Dimension(200, 700));
		boxLabel5.setPreferredSize(new Dimension(200, 700));

		boxLabel1.setBackground(new Color(100, 120, 100));
		boxLabel1.setOpaque(true);
		boxLabel2.setBackground(new Color(100, 140, 100));
		boxLabel2.setOpaque(true);
		boxLabel3.setBackground(new Color(100, 160, 100));
		boxLabel3.setOpaque(true);
		boxLabel4.setBackground(new Color(100, 180, 100));
		boxLabel4.setOpaque(true);
		boxLabel5.setBackground(new Color(100, 200, 100));
		boxLabel5.setOpaque(true);

		box1.setBounds(50, 350, 300, 25);
		box2.setBounds(50, 350, 300, 25);
		box3.setBounds(50, 350, 300, 25);
		box4.setBounds(50, 350, 300, 25);
		box5.setBounds(50, 350, 300, 25);

		box1.setFont(new Font("Arial", Font.BOLD, 30));
		box2.setFont(new Font("Arial", Font.BOLD, 30));
		box3.setFont(new Font("Arial", Font.BOLD, 30));
		box4.setFont(new Font("Arial", Font.BOLD, 30));
		box5.setFont(new Font("Arial", Font.BOLD, 30));

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

	}

	public void spracheAktualisieren() {
		setSprache();
		this.box1.setText(boxString + " 1");
		this.box2.setText(boxString + " 2");
		this.box3.setText(boxString + " 3");
		this.box4.setText(boxString + " 4");
		this.box5.setText(boxString + " 5");
	}

	/**
	 * 
	 * Diese Innere Klasse ist zust�ndig f�r den Mausklick, welcher auf die "Box"
	 * erfolgen soll.
	 * 
	 */
	class boxMausKlick implements MouseListener {
		public void mouseClicked(MouseEvent s) {

			BoxLabel source = (BoxLabel) s.getSource();

			/**
			 * Ceck ob Box Karten enth�lt
			 * 
			 */

			Kartei kk = u.getAktiveKartei();

			/**
			 * Check ob User �berhaupt eine Kartei angelegt hat
			 * 
			 */
			if (kk == null) {
				fehlerdialog = new KeineKarten(u);
				return;

			}

			ArrayList<Karte> kartenliste;
			kartenliste = kk.getSammlung();
			int counter = 0;

			for (Karte k : kartenliste) {

				if (k.getBox() == source.getId()) {
					counter++;
				}

			}

			/**
			 * Kein Karten mit ausgew�hlter Box gefunden Infomeldung kommt, Methodenabbruch
			 * 
			 */
			if (counter == 0) {

				fehlerdialog = new KeineKarten(u);
				return;
			}

			Lernen lernenFenster = new Lernen(u, parent, source.getId());
			parent.setEnabled(false);
			lernenFenster.setAlwaysOnTop(true);

			if (source.getId() == 1) {
				boxLabel1.setBorder(new CompoundBorder(border, marginRed));
			}
			if (source.getId() == 2) {
				boxLabel2.setBorder(new CompoundBorder(border, marginRed));
			}
			if (source.getId() == 3) {
				boxLabel3.setBorder(new CompoundBorder(border, marginRed));
			}
			if (source.getId() == 4) {
				boxLabel4.setBorder(new CompoundBorder(border, marginRed));
			}
			if (source.getId() == 5) {
				boxLabel5.setBorder(new CompoundBorder(border, marginRed));
			} else {

			}

			lernenFenster.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					lernenFenster.exitLernen();
					exitForm();

				}
			});

			lernenFenster.getButtonAbbrechen().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent evt) {
					exitForm();
					lernenFenster.exitLernen();
					lernenFenster.dispose();
				}

			});
		}

		/**
		 * 
		 * Was passiert, wenn das neu ge�ffnete Fenster wieder geschlossen wird.
		 * 
		 */
		private void exitForm() {
			boxLabel1.setBorder(new CompoundBorder(border, margin1));
			boxLabel2.setBorder(new CompoundBorder(border, margin2));
			boxLabel3.setBorder(new CompoundBorder(border, margin3));
			boxLabel4.setBorder(new CompoundBorder(border, margin4));
			boxLabel5.setBorder(new CompoundBorder(border, margin5));

			parent.setEnabled(true);

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
