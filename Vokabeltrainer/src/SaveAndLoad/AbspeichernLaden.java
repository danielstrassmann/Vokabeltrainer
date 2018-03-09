package SaveAndLoad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Daten;
import Model.Karte;
import Model.Kartei;
import Model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Controller.UserSammlung;

/**
 * Diese Klasse wird für das Abspeicher und Laden von Daten/Objekten gebraucht
 * 
 * @author Daniel Strassmann St.Gallen
 * @version 1.0 09.3.2018
 */

public class AbspeichernLaden {

	public AbspeichernLaden() {
	}

	
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
	
	public File karteSpeichern(Karte karte) {
		try {
			File karteXmlFile = new File("karte.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(karte, karteXmlFile);

			return karteXmlFile;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}

	}

	public Karte karteLaden(File karteXmlFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

			Karte gelesen = (Karte) jaxbMarshaller.unmarshal(karteXmlFile);

			return gelesen;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}
	}

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
	
	
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	private static class KarteienSpeicherObjekt {
				
		ArrayList<Kartei> karteien;
		Daten daten;
		
		KarteienSpeicherObjekt(){
			
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
