package SaveAndLoad;

import java.util.ArrayList;

import Model.User;

public class UserSammlung {

	ArrayList<User> userliste = new ArrayList<User>();

	public ArrayList<User> getUserliste() {
		return userliste;
	}

	public void setRecords(ArrayList<User> userliste) {
		this.userliste = userliste;
	}

}
