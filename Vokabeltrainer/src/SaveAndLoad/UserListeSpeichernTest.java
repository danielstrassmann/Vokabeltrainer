package SaveAndLoad;

import java.io.File;
import java.io.FileWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import Controller.UserSammlung;
import Model.Karte;
import Model.User;

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
		
	}
}