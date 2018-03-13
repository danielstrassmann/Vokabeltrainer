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

	/**
	 * JFrames
	 * 
	 */

	private JFrame registrierungsfenster;
	private JFrame frmregiSystem;

	/**
	 * JPanels
	 * 
	 */

	private JPanel userinterface;
	private JPanel linkeseite;
	private JPanel rechteseite;
	private JPanel buttons;

	/**
	 * JButtons
	 * 
	 */

	private JButton btnok;
	private JButton btnexit;

	/**
	 * JTextField mit Label
	 * 
	 */

	private JLabel r_lblname;
	private JTextField r_txtname;

	/**
	 * JPasswordField mit Label
	 * 
	 */

	private JLabel r_lblpasswort;
	private JPasswordField r_txtpasswort;

	/**
	 * JPasswordField mit Label
	 * 
	 */

	private JLabel r_lblpasswort2;
	private JPasswordField r_txtpasswort2;

	/**
	 * SprachBox
	 * 
	 */

	private JLabel benutzersp;
	private JComboBox benutzerSprache;
	private JPanel spracheAuswahlPanel;

	/**
	 * UserSammlung
	 * 
	 */

	private UserSammlung userliste;

	/**
	 * Uebersetzungs Strings
	 * 
	 */
	private String frameTitelString;
	private String nameString;
	private String passwortString;
	private String passwortbestaetigenString;
	private String sprachauswaehlenString;
	private String erfolgreichString;
	private String vokabeltrainerString;
	private String passwortFalschString;
	private String benutzervorhandenString;
	private String invalidString;
	private boolean loginok;
	private boolean bnok;
	Integer index = null;

	/**
	 * Registrierungs Konstruktor
	 * @param l
	 * 			Wird als Userliste für die Abspeicherung gebraucht
	 * 
	 */
	public Registrierung(UserSammlung l) {
		setSprache();
		addr();
		userliste = l;
	}

	/**
	 * Setzten der Usersprache für das UI
	 * 
	 */
	public void setSprache() {
		String sprachcode = new String("DE");
		String systemUsersprache = System.getProperty("user.language");

		if (systemUsersprache.equals("en")) {
			sprachcode = "EN";
		}
		if (systemUsersprache.equals("fr")) {
			sprachcode = "FR";
		}
		if (systemUsersprache.equals("it")) {
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
		this.benutzervorhandenString = r.getString("benutzervorhanden");
		this.invalidString = r.getString("invalid");

	}

	public void addr() {

		/**
		 * Registrierungsfenster
		 * 
		 */

		this.registrierungsfenster = new JFrame(frameTitelString);
		registrierungsfenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		registrierungsfenster.setLocationRelativeTo(null);
		this.linkeseite = new JPanel();
		this.rechteseite = new JPanel();
		this.buttons = new JPanel();
		this.userinterface = new JPanel();

		/**
		 * bestaetigungs Button
		 * 
		 */

		this.btnok = new JButton("OK");
		btnok.addActionListener(new regibtn());

		/**
		 * exit Button
		 * 
		 */

		this.btnexit = new JButton("Exit");
		btnexit.addActionListener(new exitbtn());

		/**
		 * JFrame Objekte Generieren
		 * 
		 */

		this.r_lblname = new JLabel("   " + nameString);
		this.r_lblpasswort = new JLabel("   " + passwortString);
		this.r_lblpasswort2 = new JLabel("   " + passwortbestaetigenString);
		this.benutzersp = new JLabel("   " + sprachauswaehlenString);
		this.r_txtname = new JTextField("");
		this.r_txtpasswort = new JPasswordField("");
		this.r_txtpasswort2 = new JPasswordField("");
		this.spracheAuswahlPanel = new JPanel();
		String spracheAuswahlListe[] = { "Deutsch", "English", "Francais", "Italiano " };
		this.benutzerSprache = new JComboBox(spracheAuswahlListe);

	}

	public void paint() {

		/**
		 * JFrame einstellungen
		 * 
		 */

		registrierungsfenster.setResizable(false);
		registrierungsfenster.setLayout(new BorderLayout(1, 1));

		/**
		 * Textfelder bearbeitbar
		 * 
		 */

		r_txtname.setEditable(true);
		r_txtpasswort.setEditable(true);
		r_txtpasswort2.setEditable(true);

		/**
		 * Layout für Panels
		 * 
		 */

		userinterface.setLayout(new GridLayout(1, 2, 10, 10));
		rechteseite.setLayout(new GridLayout(4, 1, 10, 10));
		linkeseite.setLayout(new GridLayout(4, 1, 10, 10));

		/**
		 * ButtonPanels
		 * 
		 */

		buttons.add(btnok);
		buttons.add(btnexit);

		linkeseite.add(r_lblname);
		linkeseite.add(r_lblpasswort);
		linkeseite.add(r_lblpasswort2);
		linkeseite.add(benutzersp);

		/**
		 * Add Objekte an Panels und JFrame
		 * 
		 */

		rechteseite.add(r_txtname);
		rechteseite.add(r_txtpasswort);
		rechteseite.add(r_txtpasswort2);
		spracheAuswahlPanel.add(benutzerSprache);
		rechteseite.add(spracheAuswahlPanel);
		userinterface.add(linkeseite);
		userinterface.add(rechteseite);

		/**
		 * Gestaltung Loginfenster
		 * 
		 */

		registrierungsfenster.add(buttons, BorderLayout.SOUTH);
		registrierungsfenster.add(userinterface, BorderLayout.CENTER);
		registrierungsfenster.setSize(500, 220);
		registrierungsfenster.setVisible(true);

	}
	
	/**
	 * Registrierungs Button Funktion
	 *
	 */
	
	class regibtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			registrieren();
			

		}
		
		
		/**
		 * Registrierungs Methode mit abspeicherung der neuen Userliste und check ob der Username Gueltig ist.
		 * Kontrolliert vorhandene User (Namenskonflikt)
		 */
		public void registrieren() {

			boolean erfolg = true;
			loginok = false;
			bnok = true;
			ArrayList<User> l; 
			l = userliste.getUserliste();
			AbspeichernLaden saveHandler = new AbspeichernLaden();
			User user1 = new User(null, null, null);
			
			String a = new String(r_txtpasswort.getText());
			String b = new String(r_txtpasswort2.getText());

			user1.setBenutzername(r_txtname.getText());
			user1.setPasswort(r_txtpasswort.getText());
			
			for (int i = 0; i < l.size(); i++) {
				
				index = i;
				
				if (r_txtname.getText().equals(l.get(index).getBenutzername())) {
					frmregiSystem = new JFrame(benutzervorhandenString);
					JOptionPane.showConfirmDialog(frmregiSystem, benutzervorhandenString, frameTitelString,
					JOptionPane.PLAIN_MESSAGE);
					bnok = false;
					
					return;
				} 
			}
			
			if (r_txtname.getText().equals("")) {
				erfolg = false;
				frmregiSystem = new JFrame(invalidString);
				JOptionPane.showConfirmDialog(frmregiSystem, invalidString, frameTitelString,
				JOptionPane.PLAIN_MESSAGE);
			}
			
			userlogging();
			
			if (benutzerSprache.getSelectedItem().equals("English")) {
				user1.setBenutzersprache("EN");
			} else if (benutzerSprache.getSelectedItem().equals("Francais")) {
				user1.setBenutzersprache("FR");
			} else if (benutzerSprache.getSelectedItem().equals("Italiano")) {
				user1.setBenutzersprache("IT");
			} else
				user1.setBenutzersprache("DE");

			frmregiSystem = new JFrame(frameTitelString);
				
		if (loginok == true && bnok == true && a.equals(b) && erfolg == true) {	
				userliste.getUserliste().add(user1);
				l = userliste.getUserliste();
				userliste.setUserliste(l);

				File savedUser = saveHandler.userSpeichern(userliste);
				saveHandler.karteienSpeichern(user1);
				JOptionPane.showConfirmDialog(frmregiSystem, erfolgreichString, vokabeltrainerString,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
				registrierungsfenster.dispose();
				loginok = false;
				return;
			}
		}
	}	

	/**
	 * Checkt ob ein Passwort eingegeben wurde und nicht leerbleibt
	 * 
	 */
	public void userlogging() {
		
		if (r_txtpasswort.getPassword().length > 0) {
			loginok = true;
			return;
			
		} else {
				JOptionPane.showConfirmDialog(frmregiSystem, passwortFalschString, vokabeltrainerString,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
				r_txtpasswort.setText(null);
				r_txtpasswort2.setText(null);
				return;
		}
	}
	
	/**
	 *Exit aus dem Programm
	 * 
	 */
	public void exit() {

		System.exit(0);
	}

	/**
	 * Exit Button Funktion
	 *
	 */
	class exitbtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			exit();

		}
	}
}