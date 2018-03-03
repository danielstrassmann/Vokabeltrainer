package Controller;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import Model.User;
@XmlRootElement
public class UserSammlung {

	public ArrayList<User> userliste = new ArrayList<User>();
	public ArrayList<eingeloggterUser> eingeloggterUser = new ArrayList<>();
	public User eingeloggterUser;
	
	
	
	public UserSammlung() {
	}
	

	

	public ArrayList<User> getUserliste() {
		return userliste;
	}

	public void setUserliste(ArrayList<User> userliste) {
		this.userliste = userliste;
	}

	
	
}
