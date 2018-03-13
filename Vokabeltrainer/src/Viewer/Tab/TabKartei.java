package Viewer.Tab;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controller.AbspeichernLaden;
import Controller.KarteiController;
import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.Menuleisten.MenuleisteOben;

/**
 * Diese Klasse wird für die Kartei veranschaung gebraucht.Diese Klasse
 * generiert den Inhalt des Tab "Kartei". In dieser Klasse kann man die in der
 * Kartei angehängten Lernkarten bearbeiten, hinzufügen oder löschen. Diese
 * Klasse wird von der Klasse "Tabs" aufgerufen.
 * 
 * @author Daniel Strassmann St.Gallen / Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class TabKartei extends JPanel implements ActionListener, MouseListener {

	private JTable tableKartei;

	private JScrollPane scrollPaneKartei;

	private DefaultTableModel modelKartei;

	private JTextField textFrage;
	private JTextField textAntwort;

	private JButton buttonNeu;
	private JButton buttonAendern;
	private JButton buttonLoeschen;

	private JLabel labelTitel;
	private JLabel labelFrage;
	private JLabel labelAntwort;
	private JLabel labelMutation;

	private int selektierteRow;
	private Kartei kk;

	private KarteiController kc;

	private MenuleisteOben mlo;
	private User u;

	private String buttonNeuString;
	private String buttonAendernString;
	private String buttonLoeschenString;
	private String karteiTitelString;
	private String bezFrageString;
	private String bezAntwortString;
	private String frageString;
	private String antwortString;
	private String boxString;
	private String falschAnlegenString;
	private String richtigAnlegenString;
	private String falschAendernString;
	private String richtigAendernString;
	private String falschLoeschenString;
	private String richtigLoeschenString;

	/**
	 * TabKartei erstellen
	 * 
	 * @param u
	 *            aktuell eingelogter Benutzer. Wird für Sprache und aktive Kartei
	 *            verwendet
	 * @param mlo
	 *            wird für Listerner genutzt, damit der Wechsel der Kartei auch in
	 *            TabKartei üebrgeben wird
	 */
	public TabKartei(User u, MenuleisteOben mlo) {
		this.u = u;
		this.mlo = mlo;
		this.kk = u.getAktiveKartei();
		this.kc = new KarteiController(this.u);
		setSprache();
		initComponents();
		initGui();
		bindListener();
		tableKarteiabfuellen(kk);

	}

	/**
	 * Weisst die einzelnen SprachStrings aus den Sprachen-Bundles den einzelnen
	 * Datenfelder zu.
	 */
	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.buttonNeuString = r.getString("neueKarte");
		this.buttonAendernString = r.getString("karteAendern");
		this.buttonLoeschenString = r.getString("karteLoeschen");
		this.karteiTitelString = r.getString("karteiTitel");
		this.bezFrageString = r.getString("karteFrageEingeben");
		this.bezAntwortString = r.getString("karteAntwortEingeben");
		this.frageString = r.getString("frage");
		this.antwortString = r.getString("antwort");
		this.boxString = r.getString("aktuelleBox");
		this.falschAnlegenString = r.getString("falschAnlegen");
		this.richtigAnlegenString = r.getString("richtigAnlegen");
		this.falschAendernString = r.getString("falschAendern");
		this.richtigAendernString = r.getString("richtigAendern");
		this.falschLoeschenString = r.getString("falschLoeschen");
		this.richtigLoeschenString = r.getString("richtigLoeschen");
	}

	/**
	 * Aktualisiert die Sprache des ausgewählten Sprachcodes.
	 */
	public void spracheAktualisieren() {
		setSprache();
		this.buttonNeu.setText(buttonNeuString);
		this.buttonAendern.setText(buttonAendernString);
		this.buttonLoeschen.setText(buttonLoeschenString);

		this.labelTitel.setText(karteiTitelString);
		this.labelFrage.setText(bezFrageString);
		this.labelAntwort.setText(bezAntwortString);

		Object[] spalten = { frageString, antwortString, boxString };
		this.modelKartei.setColumnIdentifiers(spalten);
		this.scrollPaneKartei.repaint();

	}

	/**
	 * Initaliziere Komponenten und setze Grössen und Positionen
	 */

	private void initComponents() {

		this.textFrage = new JTextField();
		this.textAntwort = new JTextField();

		this.buttonNeu = new JButton();
		this.buttonAendern = new JButton();
		this.buttonLoeschen = new JButton();

		this.buttonNeu.setText(buttonNeuString);
		this.buttonAendern.setText(buttonAendernString);
		this.buttonLoeschen.setText(buttonLoeschenString);

		this.labelTitel = new JLabel();
		this.labelFrage = new JLabel();
		this.labelAntwort = new JLabel();
		this.labelMutation = new JLabel("");

		this.labelTitel.setText(karteiTitelString);
		this.labelFrage.setText(bezFrageString);
		this.labelAntwort.setText(bezAntwortString);

		this.textFrage.setBounds(20, 465, 160, 25);
		this.textAntwort.setBounds(20, 525, 160, 25);

		this.buttonNeu.setBounds(250, 445, 120, 25);
		this.buttonAendern.setBounds(250, 485, 120, 25);
		this.buttonLoeschen.setBounds(250, 525, 120, 25);

		this.labelTitel.setBounds(20, 0, 250, 25);
		this.labelFrage.setBounds(20, 440, 200, 25);
		this.labelAntwort.setBounds(20, 500, 200, 25);
		this.labelMutation.setBounds(390, 445, 200, 25);
	}

	/**
	 * Initialisiert das GUI.Initaliziere Table und setze DefaultTablemodel.
	 * Komponenten auf Panel hinzufügen
	 */

	private void initGui() {

		setLayout(null);

		this.tableKartei = new JTable();
		this.scrollPaneKartei = new JScrollPane(tableKartei, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Object[] spalten = { frageString, antwortString, boxString };
		this.modelKartei = new DefaultTableModel();

		this.modelKartei.setColumnIdentifiers(spalten);

		this.tableKartei.setModel(modelKartei);

		this.scrollPaneKartei.setBounds(20, 30, 1000, 400);

		add(this.scrollPaneKartei);

		add(this.buttonNeu);
		add(this.buttonAendern);
		add(this.buttonLoeschen);

		add(this.labelTitel);
		add(this.labelFrage);
		add(this.labelAntwort);
		add(this.labelMutation);

		add(this.textFrage);
		add(this.textAntwort);

	}

	/**
	 * Listeners den Buttons und Table hinzufügen
	 */
	private void bindListener() {
		buttonNeu.addActionListener(this);
		buttonAendern.addActionListener(this);
		buttonLoeschen.addActionListener(this);
		tableKartei.addMouseListener(this);
		mlo.addItemChangeListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Kartei kk = (Kartei) event.getItemSelectable().getSelectedObjects()[0];
					tableKarteiabfuellen(kk);

				}

			}
		});

	}

	public void karteiAktualisierne() {
		tableKarteiabfuellen(this.kk);
	}

	/**
	 * selektierte Kartei in Tabele abfüllen
	 * @param kk aktuelle Kartei
	 */
	public void tableKarteiabfuellen(Kartei kk) {
		this.kk = kk;
		modelKartei.setRowCount(0);
		textFrage.setText("");
		textAntwort.setText("");
		if (kk != null) {
			ArrayList<Karte> kartenSammlung = kk.getSammlung();
			Object kartenInTable[] = new Object[3];
			for (int i = 0; i < kartenSammlung.size(); i++) {
				Karte k = kartenSammlung.get(i);
				kartenInTable[0] = k.getFrage();
				kartenInTable[1] = k.getAntwort();
				kartenInTable[2] = k.getBox();
				modelKartei.addRow(kartenInTable);
			}
		}
	}

	/**
	 * MouseListener. fügt gewählte Row in Textfields Frage und Antwort ab
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		selektierteRow = tableKartei.getSelectedRow();

		textFrage.setText(modelKartei.getValueAt(selektierteRow, 0).toString());
		textAntwort.setText(modelKartei.getValueAt(selektierteRow, 1).toString());

	}

	/**
	 * ActionListener. Fügt neue Karten hinzu, Ändert gewählte Karte, löscht
	 * gewählte Karte
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		/**
		 * neue Karte hinzufügen
		 */
		if (e.getSource() == this.buttonNeu) {
			if (textFrage.getText().equals("") || textAntwort.getText().equals("")) {
				this.labelMutation.setBounds(390, 445, 400, 25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText(falschAnlegenString);
			} else {
				String frageHinzu = textFrage.getText();
				String antwortHinzu = textAntwort.getText();
				kc.karteInKarteiAblegen(frageHinzu, antwortHinzu, kk);
				tableKarteiabfuellen(kk);
				this.labelMutation.setBounds(390, 445, 400, 25);
				this.labelMutation.setForeground(new Color(0, 102, 0));
				this.labelMutation.setText(richtigAnlegenString);
				saveHandler.karteienSpeichern(u);
			}
			/**
			 * Karte ändern
			 */
		} else if (e.getSource() == this.buttonAendern) {
			if (textFrage.getText().equals("")) {
				this.labelMutation.setBounds(390, 485, 400, 25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText(falschAendernString);
			} else {
				Karte karte = kk.getIndex(selektierteRow);
				karte.setFrage(textFrage.getText());
				karte.setAntwort(textAntwort.getText());
				tableKarteiabfuellen(kk);
				this.labelMutation.setBounds(390, 485, 400, 25);
				this.labelMutation.setForeground(new Color(0, 102, 0));
				this.labelMutation.setText(richtigAendernString);
				saveHandler.karteienSpeichern(u);
			}
		}
		/**
		 * Karte löschen
		 */
		else if (e.getSource() == this.buttonLoeschen) {
			if (textFrage.getText().equals("")) {
				this.labelMutation.setBounds(390, 525, 400, 25);
				this.labelMutation.setForeground(Color.red);
				this.labelMutation.setText(falschLoeschenString);
			} else {
				Karte karte = kk.remove(selektierteRow);
				tableKarteiabfuellen(kk);
				this.labelMutation.setBounds(390, 525, 400, 25);
				this.labelMutation.setForeground(new Color(0, 102, 0));
				this.labelMutation.setText(richtigLoeschenString);
				saveHandler.karteienSpeichern(u);

			}
		}
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
