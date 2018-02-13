package Controller;

import Model.Box;

public class BoxSammlung {
	
	private Box[] boxliste;
	private Box box1;
	private Box box2;
	private Box box3;
	private Box box4;
	private Box box5;
	
	// 5 Boxen werden instanziert und in eine Array "Box" platziert
	public BoxSammlung() {
		
		boxliste = new Box [5];
		
		box1 = new Box();
		box1.setId(1);
		boxliste[0] = box1;
		
		box2 = new Box();
		box2.setId(2);
		boxliste[1] = box2;
		
		box3 = new Box();
		box3.setId(3);
		boxliste[2] = box3;
		
		box4 = new Box();
		box4.setId(4);
		boxliste[3] = box4;
		
		box5 = new Box();
		box5.setId(5);
		boxliste[4] = box5;
	}

}
