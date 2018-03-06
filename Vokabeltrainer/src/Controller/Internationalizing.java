package Controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalizing {
	
	
	private String sprache;
	
	private String str;
	
	
	// Zeigt ein Beispiel, wie es in den Viewer-Klassen implementiert werden muss
	public Internationalizing() {
		sprache = "FR";
		Locale l = new Locale(sprache);
		ResourceBundle r = ResourceBundle.getBundle("Controller/Bundle",l);
		str = r.getString("karteiErstellen");
		
	}
	
	
	
	// Testing
	public static void main(String[] args) {
		
		Internationalizing test = new Internationalizing();
		System.out.println(test.str);
		
	}
	
	
	}


