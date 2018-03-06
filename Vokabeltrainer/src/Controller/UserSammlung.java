package Controller;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Model.User;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class UserSammlung {

	public ArrayList<User> userliste = new ArrayList<User>();

	public UserSammlung() {
	}

	@XmlElement
	public ArrayList<User> getUserliste() {
		return userliste;
	}

	public void setUserliste(ArrayList<User> userliste) {
		this.userliste = userliste;
	}

}
