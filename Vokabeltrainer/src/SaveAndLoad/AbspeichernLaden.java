package SaveAndLoad;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Controller.UserSammlung;
import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.User;

/**
 * In dieser Klasse wird das gesamte Speichern und Laden von den beiden
 * XML-Files durchgeführt.
 * 
 * @author Daniel Strassmann St.Gallen
 * @version 1.0 09.3.2018
 */
public class AbspeichernLaden {

	public AbspeichernLaden() {
	}

	/**
	 * Diese Methode legt pro User sein spezifisches XML-File an. die Bezeichnung
	 * vom Xml wird durch den Benutzernamen festgelegt.
	 * 
	 * @param u
	 *            wird für die Vergabe des Benutzernames gebraucht.
	 */
	public void karteienSpeichern(User u) {
		KarteienSpeicherObjekt daten = new KarteienSpeicherObjekt(u.getUserKarteien(), u.getUserDaten());

		try {
			File karteiXmlFile = new File(u.getBenutzername() + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(KarteienSpeicherObjekt.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(daten, karteiXmlFile);

		} catch (JAXBException ex) {
			System.out.println(ex);
		}

	}

	/**
	 * Diese Methode lädt das File vom User, welcher sich einlogen will.
	 * 
	 * @param u
	 *            wird für die Bezeichnung des zu suchenden XML-File verwendet.
	 */
	public void karteienLaden(User u) {
		File karteiXmlFile = new File(u.getBenutzername() + ".xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(KarteienSpeicherObjekt.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

			KarteienSpeicherObjekt gelesen = (KarteienSpeicherObjekt) jaxbMarshaller.unmarshal(karteiXmlFile);

			u.setUserKarteien(gelesen.getKarteien());
			u.setUserDaten(gelesen.getDaten());

		} catch (JAXBException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Diese Methode erstellt das XML-File mit allen Usern, welche sich in der
	 * Applikation registriert haben
	 * 
	 * @param userliste
	 *            der UserSammlung übergibt der Methode alle User, die gespeichert
	 *            werden müssen
	 * @return
	 */
	public File userSpeichern(UserSammlung userliste) {
		try {
			File userXmlFile = new File("users.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(UserSammlung.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(userliste, userXmlFile);

			return userXmlFile;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;

		}
	}

	/**
	 * Diese Methode lädt beim Programmstart alle User vom XML in die Applikation
	 * zurück.
	 * 
	 * @param userXmlFile
	 *            ist das zu ladende XML-File
	 * @return
	 */
	public UserSammlung userLaden(File userXmlFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserSammlung.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

			UserSammlung gelesen = (UserSammlung) jaxbMarshaller.unmarshal(userXmlFile);

			return gelesen;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}
	}

	/**
	 * diese innere Klasse wird für das Erstellen des XML's jeden einzelnen Users
	 * benötigt. Dadurch in der Klasse User Annotation für die userliste-XML gesetzt
	 * werden, konnte diese Klasse nicht mehr verwendet werden, um das eigene XML
	 * für jeden User aufzubauen. Darum diese innere Klasse
	 * 
	 * @author Daniel Strassmann, St.Gallen
	 * @version 1.0 09.3.2018
	 *
	 */
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	private static class KarteienSpeicherObjekt {

		ArrayList<Kartei> karteien;
		Daten daten;

		KarteienSpeicherObjekt() {

		}

		public KarteienSpeicherObjekt(ArrayList<Kartei> karteien, Daten daten) {
			this.karteien = karteien;
			this.daten = daten;
		}

		@XmlElement
		public ArrayList<Kartei> getKarteien() {
			return karteien;
		}

		public void setKarteien(ArrayList<Kartei> karteien) {
			this.karteien = karteien;
		}

		@XmlElement
		public Daten getDaten() {
			return daten;
		}

		public void setDaten(Daten daten) {
			this.daten = daten;
		}
	}

}
