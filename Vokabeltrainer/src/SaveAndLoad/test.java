package SaveAndLoad;

import java.util.ArrayList;

import Model.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userliste = new ArrayList<User>();
		
		userliste.add(new User("Daniel","eli","de"));
		userliste.add(new User("Thomas","eli", "de"));
		userliste.add(new User("Marius","eli", "de"));
		userliste.add(new User("Duc","eli", "de"));
		
		System.out.println(userliste);

	}

}
