package SaveAndLoad;


import java.io.File;
import Model.Karte;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class Abspeichern {
	
	public Abspeichern ()
	{}
	
	public static void karteSpeichern (){
		try 
		{
	File xmlfile = new File ("karte.xml");
	JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	   jaxbMarshaller.marshal(Karte.class, xmlfile);
	
		}
		catch(JAXBException ex)
		{
		   System.out.println(ex);
		}

	}

}



