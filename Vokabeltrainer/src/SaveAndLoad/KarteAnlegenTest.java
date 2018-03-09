package SaveAndLoad;

import java.io.File;
import Model.Karte;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht
 * 
 * @author Marius Brändle St.Gallen / Duc Thach, Daniel Strassmann, Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class KarteAnlegenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		AbspeichernLaden saveHandler = new AbspeichernLaden();

		Karte karte = new Karte("hallo", "hello");
		File savedKarte = saveHandler.karteSpeichern(karte);
		Karte geladeneKarte = saveHandler.karteLaden(savedKarte);

		if (karte.getFrage().equals(geladeneKarte.getFrage())) {
			System.out.println("Frage identisch");
		} else {
			System.out.println("Frage nicht identisch");
		}
	}

}
