package Controller;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import Model.User;
@XmlRootElement
public class UserSammlung {

	ArrayList<User> userliste = new ArrayList<User>();

	public ArrayList<User> getUserliste() {
		return userliste;
	}

	public void setUserliste(ArrayList<User> userliste) {
		this.userliste = userliste;
	}

	
	//asd
}
