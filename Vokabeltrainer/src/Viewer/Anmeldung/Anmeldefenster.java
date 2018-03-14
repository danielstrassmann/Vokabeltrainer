package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.AbspeichernLaden;
import Controller.UserSammlung;
import Model.User;
import Viewer.Menu.HauptmenuNeu;

/**
 * Diese Klasse wird für die Anmeldung gebraucht
 * 
 * @author Duc Thach St.Gallen / Marius Brändle, Daniel Strassmann, Thomas
 *         Brunner
 * @version 1.0 09.3.2018
 */

public class Anmeldefenster extends UserSammlung

{

	/**
	 * JFrame
	 * 
	 */
	
	private JFrame loginfenster;
	private JFrame frmLoginSystem;

	/**
	 * Labels
	 * 
	 */
	
	private JLabel usernameid;
	private JLabel userpassword;
	private JLabel frameTitle;

	/**
	 * Buttons
	 * 
	 */
	
	private JButton anmeldeButton;
	private JButton registrieren;
	private JButton exitButton;

	/**
	 * TextFelder
	 * 
	 */
	
	private JTextField loginUsername;
	private JPasswordField loginPassword;

	/**
	 * JPanels
	 * 
	 */
	
	private JPanel userpw;
	private JPanel titelframe;
	private JPanel buttonBereich;
	private JPanel loginBereich;

	/**
	 * Spezial
	 * 
	 */
	
	public String ub;
	Integer index = null;
	private AbspeichernLaden saveHandler;
	private User u;
	ArrayList<User> l;
	private UserSammlung userliste;

	private String frameTitelString;
	private String anmeldenButtonString;
	private String registrierenButtonString;
	private String exitString;
	private String benutzernameString;
	private String passwortString;
	private String anmeldedatenString;
	private String wirklichSchliessenString;
	private String loginDatenfalschString;

	public Anmeldefenster() {
		setSprache();
		add();
	}

	/**
	 * Sprache setzten
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
		ResourceBundle r = ResourceBundle.getBundle("Controller.Bundle", l);
		this.frameTitelString = r.getString("vokabeltrainer");
		this.anmeldenButtonString = r.getString("anmelden");
		this.registrierenButtonString = r.getString("registrieren");
		this.exitString = r.getString("exit");
		this.benutzernameString = r.getString("benutzername");
		this.passwortString = r.getString("passwort");
		this.anmeldedatenString = r.getString("anmeldedaten");
		this.wirklichSchliessenString = r.getString("wirklichSchliessen");
		this.loginDatenfalschString = r.getString("loginFalsch");

	}

	/**
	 *Userliste laden
	 * 
	 */
	
	public void add() {
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		this.userliste = saveHandler.userLaden(new File("users.xml"));
		
		l = userliste.getUserliste();
		//System.out.println(l); 
		
		/**
		 *GUI-Elements
		 * 
		 */
		
		this.loginfenster = new JFrame(frameTitelString);
		loginfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginfenster.setLocationRelativeTo(null);

		this.anmeldeButton = new JButton(anmeldenButtonString);
		this.registrieren = new JButton(registrierenButtonString);
		this.exitButton = new JButton(exitString);
		anmeldeButton.addActionListener(new anmbtn());
		registrieren.addActionListener(new regbtn());
		exitButton.addActionListener(new exitbtn());

		this.usernameid = new JLabel(benutzernameString + "       ");
		this.userpassword = new JLabel(passwortString + "          ");
		this.frameTitle = new JLabel("              " + anmeldedatenString + "      ");

		this.loginUsername = new JTextField();
		this.loginPassword = new JPasswordField();

		this.userpw = new JPanel();
		this.titelframe = new JPanel();
		this.buttonBereich = new JPanel();
		this.loginBereich = new JPanel();

		/**
		 *  Login Fenster zeichnen
		 *  
		 */

		loginfenster.setResizable(false);
		loginfenster.setLayout(new BorderLayout(10, 10));

		/**
		 * Textfelder beschreibbar
		 * 
		 */

		loginUsername.setEditable(true);
		loginPassword.setEditable(true);

		/**
		 * KeyListener
		 * 
		 */

		loginPassword.addKeyListener(new keyList());

		/**
		 * Layout für Panels
		 * 
		 */

		titelframe.setBounds(250, 1, 86, 20);
		userpw.setLayout(new GridLayout(2, 2, 30, 20));

		/**
		 * ButtonPanels hinzufügen
		 * 
		 */

		buttonBereich.add(anmeldeButton);
		buttonBereich.add(registrieren);
		buttonBereich.add(exitButton);

		/**
		 * Titel des Fensters (Label)
		 * 
		 */

		titelframe.add(frameTitle);

		/**
		 * Add der loginbemerkung (Labels)
		 * 
		 */

		userpw.add(usernameid);
		userpw.add(loginUsername);
		userpw.add(userpassword);
		userpw.add(loginPassword);

		/**
		 * Gestaltung des Loginfenster
		 * 
		 */

		loginBereich.add(userpw);
		loginfenster.add(titelframe, BorderLayout.NORTH);
		loginfenster.add(buttonBereich, BorderLayout.SOUTH);
		loginfenster.add(loginBereich, BorderLayout.CENTER);

		/** 
		 * Grösse und Sichtbarkeit des Loginfensters
		 * 
		 */

		loginfenster.setSize(500, 200);
		loginfenster.setVisible(true);

	}


	public void paint() {

	}

	/**
	 * passiert nach der Login Validation und oeffnet das Hauptmenu
	 * 
	 */

	private void doLogin() {
		AbspeichernLaden loadHandler = new AbspeichernLaden();
		loadHandler.karteienLaden(u);
		HauptmenuNeu guiNeu = new HauptmenuNeu(u, userliste);

		loginfenster.setVisible(false);

	}

	/**
	 * Exit Button und Schliesst das Programm
	 * 
	 */

	class exitbtn implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			frmLoginSystem = new JFrame(exitString);
			if (JOptionPane.showConfirmDialog(frmLoginSystem, wirklichSchliessenString, frameTitelString,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * Registrierungs Knopf oeffnet das Registrierungsfenster
	 * 
	 */

	class regbtn implements ActionListener {
		//
		public void actionPerformed(ActionEvent e) {

			Registrierung gui = new Registrierung(userliste);
			gui.paint();

		}
	}

	/**
	 * User Laden 
	 * 
	 */

	public void userLoading() {

		String ub = loginUsername.getText();
		//System.out.println(l);
		//System.out.println("list size is: " + l.size());
		boolean erfolg = false;

		for (int i = 0; i < l.size(); i++) {

			index = i;

			if ((loginPassword.getText() != null && (loginUsername.getText() != null
					&& (loginUsername.getText().equals(l.get(index).getBenutzername())
							&& (loginPassword.getText().equals(l.get(index).getPasswort())))))) {
				u = l.get(index);

				doLogin();
				//System.out.println(u);
				erfolg = true;
				return;
			}
		}

		if (erfolg == false) {
			frmLoginSystem = new JFrame(loginDatenfalschString);
			JOptionPane.showConfirmDialog(frmLoginSystem, loginDatenfalschString, frameTitelString,
					JOptionPane.PLAIN_MESSAGE);
			return;
		}
	}

	/**
	 * Kontroll Methode zeigt den eingeloggten Benutzer
	 * 
	 */

	public void eingeloggterBenutzer() {

		//System.out.println(u);
	}

	/**
	 * Anmelde Button
	 * 
	 */

	class anmbtn implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			userLoading();
		}
	}

	class keyList implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				userLoading();
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}
	}


	/**
	 * Main Startpunkt des Programms
	 * @param args neues Anmeldefenster
	 */
	public static void main(String[] args) {
		Anmeldefenster gui = new Anmeldefenster();
		gui.paint();
	}
}
