package Model;

import java.util.ArrayList;

public class Box {

	private int id;
	private ArrayList<Karte> sammlung;
	
	public Box() {
		
		sammlung = new ArrayList<Karte>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Karte> getSammlung() {
		return sammlung;
	}

	public void setSammlung(ArrayList<Karte> sammlung) {
		this.sammlung = sammlung;
	}


}
