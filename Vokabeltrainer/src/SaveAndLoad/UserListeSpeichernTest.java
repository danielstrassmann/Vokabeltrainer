package SaveAndLoad;

import java.io.File;
import java.io.FileWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import Controller.UserSammlung;
import Model.Karte;
import Model.User;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht
 * 
 * @author Marius Brändle St.Gallen / Duc Thach, Daniel Strassmann, Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class UserListeSpeichernTest {
	public static void main(String args[]) throws Exception {

		AbspeichernLaden saveHandler = new AbspeichernLaden();

		User user1 = new User();
		user1.setBenutzername("Peter");
		user1.setPasswort("eli");
		user1.setBenutzersprache("de");

		User user2 = new User();
		user2.setBenutzername("Klaus");
		user2.setPasswort("eli");
		user2.setBenutzersprache("de");

		UserSammlung userliste = new UserSammlung();
		userliste.getUserliste().add(user1);
		userliste.getUserliste().add(user2);

		File savedUser = saveHandler.userSpeichern(userliste);
		
		UserSammlung loadedUser = saveHandler.userLaden(savedUser);
		if(loadedUser == null || loadedUser.getUserliste() == null || loadedUser.getUserliste().size() != 2) {
			System.out.println("falsch");
		}
		
	}
}