package Viewer.Popup;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JLabel;

import Model.User;

/**
 * Diese Klasse wird für das Popup gebraucht, wenn in der Kartei keine Karten
 * mehr vorhanden sind
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class KeineKarten extends JDialog {

	private User u;

	private JLabel labelKeineKarten;
	private JLabel bitteBoxWechseln;

	private String dialogTitelString;
	private String keineKartenString;
	private String boxWechselnString;

	public KeineKarten(User u) {
		setSprache();
		initComponents();
		initGui();
	}

	public void setSprache() {
		Locale l = new Locale(u.getBenutzersprache());
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		this.dialogTitelString = r.getString("boxLeer");
		this.keineKartenString = r.getString("keineKarten");
		this.boxWechselnString = r.getString("bitteboxWechseln");
	}

	public void initComponents() {
		this.labelKeineKarten = new JLabel(keineKartenString);
		this.bitteBoxWechseln = new JLabel(boxWechselnString);
	}

	public void initGui() {
		setLayout(null);
		setSize(300, 100);
		setResizable(false);
		setTitle(dialogTitelString);
		setVisible(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		this.labelKeineKarten.setBounds(20, 1, 290, 30);
		this.bitteBoxWechseln.setBounds(20, 35, 290, 30);

		add(labelKeineKarten);
		add(bitteBoxWechseln);
	}
}
