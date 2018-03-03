package Viewer.GuiMain;

import Viewer.Anmeldung.*;
import Viewer.Buttons.KarteiAuswahlButton;
import Viewer.Popup.Lernen;
import Viewer.Popup.Lernen_Test;
import Viewer.Tab.TabKartei;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import Controller.KarteiController;
import Model.Karte;
import Model.Kartei;
import Model.Training;
import Model.User;

public class GUI_Nur_Lernen {
	
	private KarteiController test;


		public static void main(String[] args)
		{
			testing();



		}
		
		public static void testing()
		{
			User u = new User("marius", "123", "Deutsch");
			
			KarteiController test = new KarteiController();
			test.karteiErstellen("Deutsch", "Englisch", u);
			test.karteiErstellen("Deutsch", "Französisch", u);
			
			ArrayList<Kartei> karteiensammlung = u.getUserKarteien();
			Kartei kk1 = karteiensammlung.get(0);
			Kartei kk2 = karteiensammlung.get(1);
			
			test.karteInKarteiAblegen("Haus", "House", kk1);
			test.karteInKarteiAblegen("Feuer", "Fire", kk1);
			test.karteInKarteiAblegen("Wasser", "Water", kk1);
		
			test.karteInKarteiAblegen("Haus", "Maison", kk2);
			test.karteInKarteiAblegen("Feuer", "Feux", kk2);
			test.karteInKarteiAblegen("Wasser", "Eau", kk2);
			
			Lernen_Test lF = new Lernen_Test(u, 1);



			
			
		}
	}
