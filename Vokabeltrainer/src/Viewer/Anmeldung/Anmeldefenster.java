package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.File;

import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.UserSammlung;
import Model.User;
import SaveAndLoad.AbspeichernLaden;
import Viewer.Menu.HauptmenuNeu;
import Viewer.Buttons.*;


/**
 * Diese Klasse wird für die Anmeldung gebraucht
 * 
 * @author Duc Thach St.Gallen / Marius Brändle, Daniel Strassmann, Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class Anmeldefenster extends UserSammlung

{
		
	// JFrame
	
	private JFrame loginfenster;
	private JFrame frmLoginSystem;
	
	// Labels
	
	private JLabel usernameid;
	private JLabel userpassword;
	private JLabel frameTitle;
//	private JLabel spracheBez;
	
	// Buttons
	
	private JButton anmeldeButton;
	private JButton registrieren;
	private JButton exitButton;
	
	// TextFelder
	
	private JTextField loginUsername;
	private JPasswordField loginPassword;
	
	// JPanels
	
	private JPanel userpw;
	private JPanel titelframe;
	private JPanel buttonBereich;
	private JPanel loginBereich;
	
	// Spezial
	
	public String ub;
	Integer index = null;
	private AbspeichernLaden saveHandler;
	private User u;
	ArrayList<User> l;
	private UserSammlung userliste;
	

	public Anmeldefenster() {

		//Essenziell
		
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		this.userliste = saveHandler.userLaden(new File("users.xml"));
		l = userliste.getUserliste();
		System.out.println(l);

		// GUI-Elements

		this.loginfenster = new JFrame("Vokabeltrainer");
		loginfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginfenster.setLocationRelativeTo(null);

		this.anmeldeButton = new JButton("Anmelden");
		this.registrieren = new JButton("Registrieren");
		this.exitButton = new JButton("Exit");
		anmeldeButton.addActionListener(new anmbtn());
		registrieren.addActionListener(new regbtn());
		exitButton.addActionListener(new exitbtn());

		this.usernameid = new JLabel("Benutzername       ");
		this.userpassword = new JLabel("Password          ");
		this.frameTitle = new JLabel("              Anmeldedaten:      ");

		this.loginUsername = new JTextField();
		this.loginPassword = new JPasswordField();

		this.userpw = new JPanel();
		this.titelframe = new JPanel();
		this.buttonBereich = new JPanel();
		this.loginBereich = new JPanel();

//		BenutzerspracheButton bsb = new BenutzerspracheButton();
//		this.spracheBez = new JLabel();
//		this.spracheBez.setText("Benutzersprache");

		// login_Fenster_Zeichnen

		loginfenster.setResizable(false);
		loginfenster.setLayout(new BorderLayout(10, 10));

		// Textfelder beschreibbar

		loginUsername.setEditable(true);
		loginPassword.setEditable(true);

		//KeyListener
		
		loginPassword.addKeyListener(new keyList());

		// layout für Panels

		titelframe.setBounds(250, 1, 86, 20);
		userpw.setLayout(new GridLayout(2, 2, 30, 20));

		// ButtonPanel

		buttonBereich.add(anmeldeButton);
		buttonBereich.add(registrieren);
		buttonBereich.add(exitButton);

		// titel

		titelframe.add(frameTitle);
//		titelframe.add(spracheBez);
//		titelframe.add(bsb, BorderLayout.PAGE_END);

		// Add der loginbemerkung

		userpw.add(usernameid);
		userpw.add(loginUsername);
		userpw.add(userpassword);
		userpw.add(loginPassword);

		// Gestaltung des loginfenster

		loginBereich.add(userpw);
		loginfenster.add(titelframe, BorderLayout.NORTH);
		loginfenster.add(buttonBereich, BorderLayout.SOUTH);
		loginfenster.add(loginBereich, BorderLayout.CENTER);

		// Grösse und Sichtbarkeit
		
		loginfenster.setSize(500, 200);
		loginfenster.setVisible(true);
		
	}

	public void paint() {

	}

	//passiert nach der Login Validation
	
	private void doLogin() {
		AbspeichernLaden loadHandler = new AbspeichernLaden();
		loadHandler.karteienLaden(u);
		HauptmenuNeu guiNeu = new HauptmenuNeu(u);

		
		loginfenster.setVisible(false);

	}

	//Exit Button
	
	class exitbtn implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {

			frmLoginSystem = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frmLoginSystem, "Wirklich Schliessen?", "Vokabeltrainer",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
	}

	//Registrierungs Knopf
	
	class regbtn implements ActionListener {
		//
		public void actionPerformed(ActionEvent e) {

			Registrierung gui = new Registrierung(userliste);
			gui.paint();

		}
	}

	//User Laden
	
	public void userLoading() {

		String ub = loginUsername.getText();
		System.out.println(l);
		System.out.println("list size is: " + l.size());
		boolean erfolg = false;

		for (int i = 0; i < l.size(); i++) {

			index = i;

			if ((loginPassword.getText() != null && (loginUsername.getText() != null
					&& (loginUsername.getText().equals(l.get(index).getBenutzername())
							&& (loginPassword.getText().equals(l.get(index).getPasswort())))))) {
				u = l.get(index);

				doLogin();
				System.out.println(u);
				erfolg = true;
				return;

			}
		}

		if (erfolg == false) {
			frmLoginSystem = new JFrame("Login Daten nicht Korrekt");
			JOptionPane.showConfirmDialog(frmLoginSystem, "Login Daten Falsch", "Vokabeltrainer",
					JOptionPane.PLAIN_MESSAGE);

			return;

		}
	}

	//Kontroll Methode
	
	public void eingeloggterBenutzer() {

		System.out.println(u);

	}

	//Anmelde Button
	
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

	//MAIN Startpunkt des Programmes
	
	public static void main(String[] args) {

		Anmeldefenster gui = new Anmeldefenster();
		gui.paint();

	}

}
