package Viewer.Tab;

import javax.swing.JLabel;

/**
 * Diese Klasse wird für die Box veranschaung gebraucht
 * 
 * @author Marius Brändle St.Gallen
 * @version 1.0 09.3.2018
 */

public class BoxLabel extends JLabel{
	private int id;
	
	public BoxLabel() {
		super();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
