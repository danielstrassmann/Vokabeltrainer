package Viewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Anmeldefenster{
	
	//Frame
	private JFrame loginfenster;
	//Labels
	private JLabel usernameid;
	private JLabel userpassword;
	//Buttons 
	private JButton anmeldeButton;
	private JButton registrieren;
	private JButton exitButton;
	//TextFelder
	private JTextField loginUsername;
	private JTextField loginPassword;
	//JPanels
	private JPanel userpw;
	private JPanel userpwEingabe;
	private JPanel buttonBereich;
	                         
	private SpringLayout layout;
	
public Anmeldefenster() 
{
    SpringLayout layout = new SpringLayout();
	//GUI-Elements
	this.loginfenster = new JFrame("Login Vokabeltrainer");
	loginfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	this.anmeldeButton = new JButton("Anmelden");
	this.registrieren = new JButton("Registrieren");
	this.exitButton = new JButton("Exit");
	
	this.usernameid = new JLabel("Username");
	this.userpassword = new JLabel("Password");
	
	this.loginUsername = new JTextField();
	this.loginPassword = new JTextField();
	
	this.userpw = new JPanel();
	this.userpwEingabe = new JPanel();
	this.buttonBereich = new JPanel();
	}

	public  void paint() {
		//login_Fenster_Zeichnen
		loginfenster.setResizable(false);
		loginfenster.setLayout(new BorderLayout(1,45));
		loginUsername.setEditable(true);
		loginUsername.setSize(10,10);
		loginPassword.setEditable(true);
		loginPassword.setSize(10,10);
		 
		//layout_für_Panels
		userpwEingabe.setLayout(new GridLayout(2,2,-10,20));
		userpw.setLayout(new GridLayout(2,2,-300,20));
		userpw.setLocation(0, -300);
		
		//ButtonPanel
		buttonBereich.add(anmeldeButton);
		buttonBereich.add(registrieren);
		buttonBereich.add(exitButton);		
		
		//Add von_loginbemerkung
		userpw.add(usernameid);
		userpw.add(loginUsername);
		userpw.add(userpassword);
		userpw.add(loginPassword);
		
		//Gestaltung_loginfenster
		loginfenster.add(userpwEingabe);
		loginfenster.add(userpw,BorderLayout.NORTH);
		loginfenster.add(buttonBereich,BorderLayout.CENTER);
		loginfenster.setSize(500, 200);
		loginfenster.setVisible(true);
		
		//
			     
		

}
	public static void main(String[] args) 
	{
		Anmeldefenster gui = new Anmeldefenster();
		gui.paint();
	}

}