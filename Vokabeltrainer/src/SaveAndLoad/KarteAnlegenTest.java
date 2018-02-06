package SaveAndLoad;

import Model.Karte;

public class KarteAnlegenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				/*try
				{
				Karte karte = new Karte ("hallo", "hello");
				File xmlfile = new File("karte.xml");
				   JAXBContext jaxbContext = JAXBContext.newInstance(Karte.class);
				   Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				   
				   jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				   jaxbMarshaller.marshal(karte, xmlfile);
				   

				}
				catch(JAXBException ex)
				{
				   System.out.println(ex);
				}
				*/
				Karte karte = new Karte ("hallo", "hello");
				Abspeichern.karteSpeichern();

			}

		

	}




