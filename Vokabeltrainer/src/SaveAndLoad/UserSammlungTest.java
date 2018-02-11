package SaveAndLoad;

import java.util.ArrayList;

import Model.User;

public class UserSammlungTest {

	private ArrayList<User> userliste;

	public UserSammlungTest() {
		userliste = new ArrayList<User>();
	}

	public void benutzerHinzufügen( )
	{
		userliste.add(new User("Daniel", "eli", "de" ));
	}
	
	public void zeigeUser()
	{
		System.out.println(userliste);
	}
}
