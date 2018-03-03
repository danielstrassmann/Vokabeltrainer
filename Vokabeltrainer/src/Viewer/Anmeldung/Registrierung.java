package Viewer.Anmeldung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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

public class Registrierung extends UserSammlung {
	//
	private JFrame registrierungsfenster;
	private JFrame frmregiSystem;
	//
	private JPanel userinterface;
	private JPanel linkeseite;
	private JPanel rechteseite;
	private JPanel buttons;
	//
	private JButton btnok;
	private JButton btnexit;
	//
	private JLabel r_lblname;
	private JTextField r_txtname;
	//
	private JLabel r_lblpasswort;
	private JPasswordField r_txtpasswort;
	//
	private JLabel r_lblpasswort2;
	private JPasswordField r_txtpasswort2;
	//
	private JLabel benutzersp;
	private JComboBox benutzerSprache;

	private JPanel spracheAuswahlPanel;

	public Registrierung(ArrayList<User> userliste) {
		// Registrierungsfenster
		this.registrierungsfenster = new JFrame("Registrieren ");
		registrierungsfenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		registrierungsfenster.setLocationRelativeTo(null);
		this.linkeseite = new JPanel();
		this.rechteseite = new JPanel();
		this.buttons = new JPanel();
		this.userinterface = new JPanel();
		//
		this.btnok = new JButton("OK");
		btnok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ArrayList<User> l;
				AbspeichernLaden saveHandler = new AbspeichernLaden();
				User user1 = new User(null, null, null);
				UserSammlung userliste = new UserSammlung();
				l = userliste.getUserliste();
				String a = new String(r_txtpasswort.getText());
				String b = new String(r_txtpasswort2.getText());
				// System.out.println(a);
				// System.out.println(b);

				user1.setBenutzername(r_txtname.getText());
				user1.setPasswort(r_txtpasswort.getText());
				String value = (String) benutzerSprache.getSelectedItem();
				user1.setBenutzersprache(value);
				frmregiSystem = new JFrame("Registrierung");
				if (a != null && a.equals(b)) {
					JOptionPane.showConfirmDialog(frmregiSystem, "Erfolgreich Registriert", "Vokabeltrainer",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
					userliste.getUserliste().add(user1);
					
					
					File savedUser = saveHandler.userSpeichern(userliste);
					userliste.setUserliste(l);
					// System.out.println(value);
					registrierungsfenster.dispose();
					return;
				}

				else

					r_txtpasswort.setText(null);
					r_txtpasswort2.setText(null);
				
					JOptionPane.showConfirmDialog(frmregiSystem, "Passwort stimmt nicht Überein!", "Vokabeltrainer",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
			}

		});
		// JOptionPane.OK_CANCEL_OPTION,
		this.btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.r_lblname = new JLabel("   Name");
		this.r_lblpasswort = new JLabel("   Passwort");
		this.r_lblpasswort2 = new JLabel("   Passwort bestätigen");
		this.benutzersp = new JLabel("   Sprache Auswählen");
		this.r_txtname = new JTextField("Name");
		this.r_txtpasswort = new JPasswordField("Passwort");
		this.r_txtpasswort2 = new JPasswordField("Passwort");
		this.spracheAuswahlPanel = new JPanel();
		String spracheAuswahlListe[] = { "Deutsch", "Français", "English", "Español " };
		this.benutzerSprache = new JComboBox(spracheAuswahlListe);

	}

	public void paint() {

		registrierungsfenster.setResizable(false);
		registrierungsfenster.setLayout(new BorderLayout(1, 1));
		//
		r_txtname.setEditable(true);
		r_txtpasswort.setEditable(true);
		r_txtpasswort2.setEditable(true);

		// layout_für_Panels
		userinterface.setLayout(new GridLayout(1, 2, 10, 10));
		rechteseite.setLayout(new GridLayout(4, 1, 10, 10));
		linkeseite.setLayout(new GridLayout(4, 1, 10, 10));
		// ButtonPanel
		buttons.add(btnok);
		buttons.add(btnexit);

		linkeseite.add(r_lblname);
		// r_lblname.setBounds(5,50,86, 20);
		linkeseite.add(r_lblpasswort);
		// r_lblpasswort.setBounds(5,90, 86, 20);
		linkeseite.add(r_lblpasswort2);
		linkeseite.add(benutzersp);
		// r_lblpasswort2.setBounds(5,130, 86, 20);
		// Add von_loginbemerkung
		rechteseite.add(r_txtname);
		// r_txtname.setBounds(100,1, 186, 20);
		rechteseite.add(r_txtpasswort);
		// r_txtpasswort.setBounds(10,20, 186, 20);
		rechteseite.add(r_txtpasswort2);
		spracheAuswahlPanel.add(benutzerSprache);
		rechteseite.add(spracheAuswahlPanel);

		// r_txtpasswort2.setBounds(20,20, 1, 2);
		// Gestaltung_loginfenster
		userinterface.add(linkeseite);
		userinterface.add(rechteseite);
		// registrierungsfenster.add(r_lblname);
		// registrierungsfenster.add(r_lblpasswort);
		// registrierungsfenster.add(r_lblpasswort2);
		// registrierungsfenster.add(r_txtname);
		// registrierungsfenster.add(r_txtpasswort);
		// registrierungsfenster.add(r_txtpasswort2);
		// registrierungsfenster.add(linkeseite, BorderLayout.WEST);
		// registrierungsfenster.add(rechteseite, BorderLayout.CENTER);
		registrierungsfenster.add(buttons, BorderLayout.SOUTH);
		registrierungsfenster.add(userinterface, BorderLayout.CENTER);
		// r_txtname.setSize(10,5);
		registrierungsfenster.setSize(500, 220);
		registrierungsfenster.setVisible(true);
		//

	}

	public void benutzerregistrieren() {
		

	}

	public static void main(String[] args) {
		
		Registrierung gui = new Registrierung();
		gui.paint();
	}
}
