package Viewer.Buttons;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.User;



public class BenutzerspracheButton extends JComboBox

{

	User u;
	String value = new String();


		public BenutzerspracheButton()
		{
			benutzerSprache();
			
			
		}
		
		public void benutzerSprache()
		{
			addItem("Deutsch");
			addItem("français");
			addItem("english");
			addItem("italiano");

			setVisible(true);
			setSize(200,200);
		}
		
		public void spracheAendern(User u) 
		
		{
			u.getBenutzersprache();
			
				this.bsp = new BenutzerspracheButton();
				if (String value = (String) benutzerSprache.getSelectedItem().equals("Deutsch"));{
					//Locale l = new Locale(u.getBenutzersprache());
					//ResourceBundle r = ResourceBundle.getBundle("Bundle_Deutsch", l);
				}
				else if (String value = (String) benutzerSprache.getSelectedItem().equals("francais")); {
					//Locale l = new Locale(u.getBenutzersprache());
					//ResourceBundle r = ResourceBundle.getBundle("Bundle_francais", l);
				}
				else if (String value = (String) benutzerSprache.getSelectedItem().equals("english")); {
					//Locale l = new Locale(u.getBenutzersprache());
					//ResourceBundle r = ResourceBundle.getBundle("Bundle_english", l);
				}
				else if (String value = (String) benutzerSprache.getSelectedItem().equals("italiano")); {
					//Locale l = new Locale(u.getBenutzersprache());
					//ResourceBundle r = ResourceBundle.getBundle("Bundle_italiano", l);
				}
				else return
						
								
		}

		class spracheChangeListener implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent langEvent) {
				// TODO Auto-generated method stub
				if (langEvent.getStateChange().equals("Deutsch")) {
					
				}
				
			}
		}
}