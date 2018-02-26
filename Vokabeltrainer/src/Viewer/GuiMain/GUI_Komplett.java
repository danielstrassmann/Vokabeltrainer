package Viewer.GuiMain;

import Viewer.Anmeldung.*;
import Viewer.Buttons.KarteiAuswahlButton;
import Viewer.Tab.TabKartei;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import Controller.KarteiController;
import Model.Karte;
import Model.Kartei;
import Model.User;

public class GUI_Komplett {


		public static void main(String[] args)
		{
			Anmeldefenster start = new Anmeldefenster();
			testing();

		}
		
		public static void testing()
		{
			User marius = new User("marius", "123", "Deutsch");
			Kartei deEn = new Kartei("Deutsch", "Englisch");
			Karte karteMbr = new Karte("Haus", "house");
		}
	}
