package Controller;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import Model.User;

@XmlRootElement
public class UserSammlung {

	public ArrayList<User> userliste = new ArrayList<User>();

	public UserSammlung() {
	}

	public ArrayList<User> getUserliste() {
		return userliste;
	}

	public void setUserliste(ArrayList<User> userliste) {
		this.userliste = userliste;
	}

}
