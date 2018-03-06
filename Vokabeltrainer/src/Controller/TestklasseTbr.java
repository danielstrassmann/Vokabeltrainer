package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Karte;
import Model.Kartei;
import Model.User;
import Viewer.Buttons.KarteiAuswahlButton;
import Viewer.Menu.HauptmenuNeu;
import Viewer.Menuleisten.MenuleisteOben;
import Viewer.Tab.TabKartei;


public class TestklasseTbr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// neuer User erstellen mit User-Konstruktor
		User u = new User("brunnert", "eli", "deutsch");

		// Neue Kartei erstellen mittels Methode vom KarteiController
		KarteiController test = new KarteiController();
		test.karteiErstellen("Deutsch", "Englisch", u);
		test.karteiErstellen("Franz", "Englisch", u);

		// Get ArrayList vom zuvor instanzierten User
		ArrayList<Kartei> karteiliste;
		karteiliste = u.getUserKarteien();

		// Zuvor erstellte Kartei aus ArrayList auslesen
		Kartei kk = new Kartei();
		kk = karteiliste.get(0);


		
		// TEST FÜR KARTEI: Attribute vom Objekt ausgeben um zu prüfen, ob alles klappt
		System.out.println("TEST für Kartei:");
		System.out.println("-----------------");
		System.out.println("Die Kartei " + kk.getFrage() + "-" + kk.getAntwort() + " besitzt die Id " + kk.getId());
		System.out.println("");
		System.out.println("");
		

		
		
				
		// Karten in erstellte Kartei ablegen
		test.karteInKarteiAblegen("Haus", "House", kk);
		test.karteInKarteiAblegen("Wasser", "Water", kk);
		test.karteInKarteiAblegen("Feuer", "Fire", kk);
		
		
		// Get ArrayList von der Klasse Kartei
		ArrayList<Karte> kartenliste;
		kartenliste = kk.getSammlung();

		
		// Karten aus ArrayList in Klasse Kartei auslesen
		Karte k1 = kartenliste.get(0);
		Karte k2 = kartenliste.get(1); 
		Karte k3 = kartenliste.get(2);
		
		
		
		// TEST FÜR KARTEN: Attribute von Objekten ausgeben und prüfen, ob alles klappt
		System.out.println("TEST für Karten:");
		System.out.println("-----------------");
		System.out.println("Die Karte mit der Id " + k1.getId() + " hat die Frage [" + k1.getFrage() + "] und die Antwort [" + k1.getAntwort() + "]");
		System.out.println("Die Karte mit der Id " + k2.getId() + " hat die Frage [" + k2.getFrage() + "] und die Antwort [" + k2.getAntwort() + "]");
		System.out.println("Die Karte mit der Id " + k3.getId() + " hat die Frage [" + k3.getFrage() + "] und die Antwort [" + k3.getAntwort() + "]");
		
		JFrame frame = new JFrame();
		
		MenuleisteOben mlo;
		TabKartei tb = new TabKartei(u, mlo);
	//	panel.setBackground(Color.red);
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(tb);
		frame.setLayout(new BorderLayout(10,10));
	
		//HauptmenuNeu guiNeu = new HauptmenuNeu();
		KarteiAuswahlButton kab = new KarteiAuswahlButton(tb);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel.setBounds(20, 450, 400, 40);
		panel.add(kab,BorderLayout.PAGE_START);
		
		
		frame.add(panel);
		frame.add(tb);
		
kab.comboboxKarteiAbfuellen(u);
//tb.tableKarteiabfuellen(kk);

	}

}
