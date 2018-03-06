package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

import javax.swing.JPasswordField;

import Viewer.Buttons.*;

public class Anmeldefenster extends UserSammlung

{

	// Frame
	private File f;
	public String ub;
	public String uc;
	Integer index = null;
	private AbspeichernLaden t;
	private Scanner input;
	private JFrame loginfenster;
	private JFrame frmLoginSystem;
	// Labels
	private JLabel usernameid;
	private JLabel userpassword;
	private JLabel frameTitle;
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

	private JLabel spracheBez;

	private User u;
	ArrayList<User> l;
	private UserSammlung userliste;

	public Anmeldefenster() {
		// ArrayListe

		// TODO: Baustelle, UserSammlung mit SaveLoad von Dani laden
		AbspeichernLaden saveHandler = new AbspeichernLaden();
		ArrayList<User> l = new ArrayList<User>();
		// this.userliste = new UserSammlung();
		this.userliste = saveHandler.userLaden(new File("users.xml"));

		l = userliste.getUserliste();
		System.out.println(l);

		// User userTest = new User();
		// userTest = l.get(index);

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
		this.frameTitle = new JLabel("Login Credentials:                  ");

		this.loginUsername = new JTextField();
		this.loginPassword = new JPasswordField();

		this.userpw = new JPanel();
		this.titelframe = new JPanel();
		this.buttonBereich = new JPanel();
		this.loginBereich = new JPanel();

		BenutzerspracheButton bsb = new BenutzerspracheButton();

		this.spracheBez = new JLabel();
		this.spracheBez.setText("Benutzersprache");

		// Paint Paint Paint

		// login_Fenster_Zeichnen
		loginfenster.setResizable(false);
		loginfenster.setLayout(new BorderLayout(10, 10));
		//
		loginUsername.setEditable(true);
		loginPassword.setEditable(true);

		loginPassword.addKeyListener(new keyList());

		// layout_für_Panels
		titelframe.setBounds(250, 1, 86, 20);
		userpw.setLayout(new GridLayout(2, 2, 30, 20));

		// ButtonPanel

		buttonBereich.add(anmeldeButton);
		buttonBereich.add(registrieren);
		buttonBereich.add(exitButton);

		// titel
		titelframe.add(frameTitle);
		titelframe.add(spracheBez);
		titelframe.add(bsb, BorderLayout.PAGE_END);
		// Add von_loginbemerkung
		userpw.add(usernameid);
		userpw.add(loginUsername);
		userpw.add(userpassword);
		userpw.add(loginPassword);

		// Gestaltung_loginfenster
		loginBereich.add(userpw);
		//
		loginfenster.add(titelframe, BorderLayout.NORTH);
		loginfenster.add(buttonBereich, BorderLayout.SOUTH);
		loginfenster.add(loginBereich, BorderLayout.CENTER);

		//
		loginfenster.setSize(500, 200);
		loginfenster.setVisible(true);
		//
	}

	public void paint() {

	}

	private void doLogin() {

		boolean exit = false;

		while (exit != false) {

			HauptmenuNeu guiNeu = new HauptmenuNeu(u);
			loginfenster.dispose();
		}
	}

	class exitbtn implements ActionListener {
		//
		public void actionPerformed(ActionEvent e) {

			frmLoginSystem = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frmLoginSystem, "Wirklich Schliessen?", "Vokabeltrainer",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
	}

	class regbtn implements ActionListener {
		//
		public void actionPerformed(ActionEvent e) {

			Registrierung gui = new Registrierung();
			Registrierung.main(null);

		}
	}

	public void userLoading(UserSammlung userliste) {
		ArrayList<User> l;

		String ub = loginUsername.getText();
		l = userliste.getUserliste();
		System.out.println(l);
		System.out.println("list size is: " + userliste.getUserliste().size());
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).benutzername.contentEquals(ub))
				System.out.println("User auf platz: " + i);
			index = i;
			System.out.println("index zahl " + index);

		}

		if (l.get(index).getBenutzername().equals(loginUsername.getText()))
			System.out.println(index + "ist der neue Index");
		System.out.println("User u equals : " + u);
		System.out.println("Typed: " + loginUsername.getText());
		if ((loginPassword.getText() != null
				&& (loginUsername.getText() != null && (loginUsername.getText().equals(l.get(index).getBenutzername())
						&& (loginPassword.getText().equals(l.get(index).getPasswort())))))) {
			u = l.get(index);
			// TODO: Irgendwo dieses Objekt U speichern, damit es wieder verwendet werden
			// kann
			doLogin();
			eingeloggterBenutzer();
			return;
		} else {
			frmLoginSystem = new JFrame("Login Daten nicht Korrekt");
			JOptionPane.showConfirmDialog(frmLoginSystem, "Login Daten Falsch", "Vokabeltrainer",
					JOptionPane.PLAIN_MESSAGE);

			return;
		}
	}

	public void eingeloggterBenutzer() {

		System.out.println(u);

	}

	class anmbtn implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// loginfenster.dispose();
			// userEinloggen();
			userLoading(userliste);
			// doLogin();
		}
	}

	class keyList implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				// doLogin();
				// userEinloggen();
				userLoading(userliste);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {

		//boolean exit = false;

		//while (!exit) {
			Anmeldefenster gui = new Anmeldefenster();
			gui.paint();

			// HauptmenuNeu menu = new HauptmenuNeu(gui.u);
			// menu.setVisible();

			// exit = menu.exit;
		}

	}
//}
