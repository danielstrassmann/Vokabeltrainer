package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Anmeldefenster{
	
	//Frame
	private JFrame loginfenster;
	private JFrame frmLoginSystem;
	//Labels
	private JLabel usernameid;
	private JLabel userpassword;
	private JLabel frameTitle;
	//Buttons 
	private JButton anmeldeButton;
	private JButton registrieren;
	private JButton exitButton;
	//TextFelder
	private JTextField loginUsername;
	private JPasswordField loginPassword;
	//JPanels
	private JPanel userpw;
	private JPanel titelframe;
	private JPanel buttonBereich;
	private JPanel loginBereich;
 		
public Anmeldefenster() 
{
	//GUI-Elements
	this.loginfenster = new JFrame("Vokabeltrainer");
	loginfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.anmeldeButton = new JButton("Anmelden");
	this.registrieren = new JButton("Registrieren");
	this.exitButton = new JButton("Exit");
	anmeldeButton.addActionListener(null);
	registrieren.addActionListener(new regbtn());
	exitButton.addActionListener(new exitbtn());
	
	this.usernameid = new JLabel("Username");
	this.userpassword = new JLabel("Password");
	this.frameTitle = new JLabel("Login Credentials");
	
	this.loginUsername = new JTextField();
	this.loginPassword = new JPasswordField();
	
	this.userpw = new JPanel();
	this.titelframe = new JPanel();
	this.buttonBereich = new JPanel();
	this.loginBereich = new JPanel();
	
	//Paint Paint Paint
	
	//login_Fenster_Zeichnen
	loginfenster.setResizable(false);
	loginfenster.setLayout(new BorderLayout(10,10));
	//
	loginUsername.setEditable(true);
	loginPassword.setEditable(true);
	
	 
	//layout_für_Panels
	titelframe.setBounds(250,1, 86, 20);
	userpw.setLayout(new GridLayout(2,2,30,20));

	//ButtonPanel
	buttonBereich.add(anmeldeButton);
	buttonBereich.add(registrieren);
	buttonBereich.add(exitButton);		
	//titel
	titelframe.add(frameTitle);
	//Add von_loginbemerkung
	userpw.add(usernameid);
	userpw.add(loginUsername);
	userpw.add(userpassword);
	userpw.add(loginPassword);
	
	//Gestaltung_loginfenster
	loginBereich.add(userpw);
	//
	loginfenster.add(titelframe,BorderLayout.NORTH);
	loginfenster.add(buttonBereich,BorderLayout.SOUTH);
	loginfenster.add(loginBereich,BorderLayout.CENTER);
	//
	loginfenster.setSize(500, 200);
	loginfenster.setVisible(true);
	//
	}

	public  void paint() {

			         
	}
	class exitbtn implements ActionListener {
	    //
		public void actionPerformed(ActionEvent e) {
			
		frmLoginSystem = new JFrame("Exit");
		if (JOptionPane.showConfirmDialog
			(frmLoginSystem,"Wirklich Schliessen?","Vokabeltrainer",JOptionPane.YES_NO_OPTION)== 
			JOptionPane.YES_NO_OPTION) {
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
	
	
	
	public static void main(String[] args) 
	{
		Anmeldefenster gui = new Anmeldefenster();
		gui.paint(); 
	}

}		
