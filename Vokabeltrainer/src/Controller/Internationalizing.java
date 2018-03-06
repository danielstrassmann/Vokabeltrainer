package Controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalizing {

	private String sprache;

	private String str;

	// Zeigt ein Beispiel, wie es in den Viewer-Klassen implementiert werden muss
	public Internationalizing() {
		// in jeder Viewer-Klasse braucht es einen Listener vom Hauptmen�, welcher die
		// Sprache richtig setzt, je nachdem welche Sprache im Hauptmen� aktiv ist
		sprache = "FR";
		// Locale ist eine Zentrale Java-Klasse, hier muss man DE, FR, IT, oder EN
		// vom Attribut Locale �bergeben
		Locale l = new Locale(sprache);
		// RescourceBundle ist eine Zentrale Java-Klasse
		// Hier muss ein Objekt r instanziert werden um Bezeichnungen aus den
		// properties-Files auszulesen
		// In get-Methode Proberties-Pfad & Attribut l von Locale �bergeben
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle", l);
		// str steht f�r entsprechender Text im UI
		// auslesen von Attribut r mittels Keyword im properties-File
		str = r.getString("karteiErstellen");

	}

	// Testing, einfach ausf�hren und schauen was passiert
	// Hier wird das keyword karteiErstellen ausgelesen
	public static void main(String[] args) {

		Internationalizing test = new Internationalizing();
		System.out.println(test.str);

	}

}
