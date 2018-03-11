package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.UserSammlung;
import Model.User;
import SaveAndLoad.AbspeichernLaden;

/**
 * Diese Klasse wird für die Registrierung gebraucht
 * 
 * @author Duc Thach St.Gallen / Daniel Strassmann, Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class Registrierung extends UserSammlung {

	// JFrames

	private JFrame registrierungsfenster;
	private JFrame frmregiSystem;

	// JPanels

	private JPanel userinterface;
	private JPanel linkeseite;
	private JPanel rechteseite;
	private JPanel buttons;

	// JButtons

	private JButton btnok;
	private JButton btnexit;

	// JTextField mit Label

	private JLabel r_lblname;
	private JTextField r_txtname;

	// JPasswordField mit Label

	private JLabel r_lblpasswort;
	private JPasswordField r_txtpasswort;

	// JPasswordField mit Label

	private JLabel r_lblpasswort2;
	private JPasswordField r_txtpasswort2;

	// SprachBox

	private JLabel benutzersp;
	private JComboBox benutzerSprache;
	private JPanel spracheAuswahlPanel;

	// UserSammlung

	private UserSammlung userliste;

	private String frameTitelString;
	private String nameString;
	private String passwortString;
	private String passwortbestaetigenString;
	private String sprachauswaehlenString;
	private String erfolgreichString;
	private String vokabeltrainerString;
	private String passwortFalschString;

	public Registrierung(UserSammlung l) {
		setSprache();
		addr();
		userliste = l;
	}

	public void setSprache() {
		String sprachcode = new String("DE");
	
		if (System.getProperty("user.language").equals("en")) {
			sprachcode = "EN";
		}
		if (System.getProperty("user.language").equals("fr")) {
			sprachcode = "FR";
		}
		if (System.getProperty("user.language").equals("it")) {
			sprachcode = "IT";
		} else {
			sprachcode = "DE";
			
		}
		Locale l = new Locale(sprachcode);
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.frameTitelString = r.getString("registrieren");
		this.nameString = r.getString("benutzername");
		this.passwortString = r.getString("passwort");
		this.passwortbestaetigenString = r.getString("passwortBestaetigen");
		this.sprachauswaehlenString = r.getString("benutzersprache");
		this.erfolgreichString = r.getString("erfolgreichRegistriert");
		this.vokabeltrainerString = r.getString("vokabeltrainer");
		this.passwortFalschString = r.getString("passwortFalsch");

	}

	public void addr() {

		// Registrierungsfenster

		this.registrierungsfenster = new JFrame(frameTitelString);
		registrierungsfenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		registrierungsfenster.setLocationRelativeTo(null);
		this.linkeseite = new JPanel();
		this.rechteseite = new JPanel();
		this.buttons = new JPanel();
		this.userinterface = new JPanel();

		// bestaetigungs Button

		this.btnok = new JButton("OK");
		btnok.addActionListener(new regibtn());

		// exit Button

		this.btnexit = new JButton("Exit");
		btnexit.addActionListener(new exitbtn());

		// JFrame Objekte Generieren

		this.r_lblname = new JLabel("   "+ nameString);
		this.r_lblpasswort = new JLabel("   "+ passwortString);
		this.r_lblpasswort2 = new JLabel("   "+ passwortbestaetigenString);
		this.benutzersp = new JLabel("   "+ sprachauswaehlenString);
		this.r_txtname = new JTextField("");
		this.r_txtpasswort = new JPasswordField("");
		this.r_txtpasswort2 = new JPasswordField("");
		this.spracheAuswahlPanel = new JPanel();
		String spracheAuswahlListe[] = { "Deutsch", "English", "Francais", "Italiano " };
		this.benutzerSprache = new JComboBox(spracheAuswahlListe);

	}

	public void paint() {

		// JFrame einstellungen

		registrierungsfenster.setResizable(false);
		registrierungsfenster.setLayout(new BorderLayout(1, 1));

		// textfelder bearbeitbar

		r_txtname.setEditable(true);
		r_txtpasswort.setEditable(true);
		r_txtpasswort2.setEditable(true);

		// layout_für_Panels

		userinterface.setLayout(new GridLayout(1, 2, 10, 10));
		rechteseite.setLayout(new GridLayout(4, 1, 10, 10));
		linkeseite.setLayout(new GridLayout(4, 1, 10, 10));

		// ButtonPanels

		buttons.add(btnok);
		buttons.add(btnexit);

		linkeseite.add(r_lblname);
		linkeseite.add(r_lblpasswort);
		linkeseite.add(r_lblpasswort2);
		linkeseite.add(benutzersp);

		// Add Objekte an Panels und JFrame

		rechteseite.add(r_txtname);
		rechteseite.add(r_txtpasswort);
		rechteseite.add(r_txtpasswort2);
		spracheAuswahlPanel.add(benutzerSprache);
		rechteseite.add(spracheAuswahlPanel);
		userinterface.add(linkeseite);
		userinterface.add(rechteseite);

		// Gestaltung_loginfenster

		registrierungsfenster.add(buttons, BorderLayout.SOUTH);
		registrierungsfenster.add(userinterface, BorderLayout.CENTER);
		registrierungsfenster.setSize(500, 220);
		registrierungsfenster.setVisible(true);

	}

	class regibtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			registrieren();

		}

		public void registrieren() {

			ArrayList<User> l;
			AbspeichernLaden saveHandler = new AbspeichernLaden();
			User user1 = new User(null, null, null);
			l = userliste.getUserliste();
			String a = new String(r_txtpasswort.getText());
			String b = new String(r_txtpasswort2.getText());

			user1.setBenutzername(r_txtname.getText());
			user1.setPasswort(r_txtpasswort.getText());

			if (benutzerSprache.getSelectedItem().equals("English")) {
				user1.setBenutzersprache("EN");
			} else if (benutzerSprache.getSelectedItem().equals("Francais")) {
				user1.setBenutzersprache("FR");
			} else if (benutzerSprache.getSelectedItem().equals("Italiano")) {
				user1.setBenutzersprache("IT");
			} else
				user1.setBenutzersprache("DE");

			frmregiSystem = new JFrame(frameTitelString);

			if (a != null && a.equals(b)) {
				JOptionPane.showConfirmDialog(frmregiSystem, erfolgreichString, vokabeltrainerString + " Optimus",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
				userliste.getUserliste().add(user1);
				l = userliste.getUserliste();
				userliste.setUserliste(l);

				File savedUser = saveHandler.userSpeichern(userliste);
				saveHandler.karteienSpeichern(user1);

				registrierungsfenster.dispose();
				return;
			}

			else

				r_txtpasswort.setText(null);
			r_txtpasswort2.setText(null);

			JOptionPane.showConfirmDialog(frmregiSystem, passwortFalschString, vokabeltrainerString + " Optimus",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void exit() {

		System.exit(0);
	}

	class exitbtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			exit();

		}
	}
}
