package SaveAndLoad;

import java.io.File;
import java.util.ArrayList;

import Model.Karte;
import Model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Controller.UserSammlung;

public class AbspeichernLaden {

	public AbspeichernLaden() {
	}

	public File karteSpeichern(Karte karte) {
		try {
			File xmlfile = new File("karte.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(karte, xmlfile);

			return xmlfile;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}

	}

	public Karte karteLaden(File xmlFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

			Karte gelesen = (Karte) jaxbMarshaller.unmarshal(xmlFile);

			return gelesen;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}
	}

	public File userSpeichern(UserSammlung userliste) {
		try {
			File xmlfile = new File("Benutzer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(UserSammlung.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(userliste, xmlfile);

			return xmlfile;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;

		}
	}

	public UserSammlung userLaden(File xmlFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserSammlung.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

			UserSammlung gelesen = (UserSammlung) jaxbMarshaller.unmarshal(xmlFile);

			return gelesen;

		} catch (JAXBException ex) {
			System.out.println(ex);
			return null;
		}
	}
	
}
