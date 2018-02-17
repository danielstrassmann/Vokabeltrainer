package Viewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyButtonListener  extends JFrame implements ActionListener
{
	
	    JButton button1;
	    JButton button2;
	    JButton button3;
	    JLabel label;
	    JPanel panel;
	 
	    public MyButtonListener(){
	        this.setTitle("ActionListener Beispiel");
	        this.setSize(400, 200);
	        panel = new JPanel();
	 
	        // Leeres JLabel-Objekt wird erzeugt
	        label = new JLabel();
	 
	        //Drei Buttons werden erstellt
	        button1 = new JButton("Button 1");
	        button2 = new JButton ("Button 2");
	        button3 = new JButton ("Button 3");
	 
	        //Buttons werden dem Listener zugeordnet
	        button1.addActionListener(this);
	        button2.addActionListener(this);
	        button3.addActionListener(this);
	 
	        //Buttons werden dem JPanel hinzugef�gt
	        panel.add(button1);
	        panel.add(button2);
	        panel.add(button3);
	 
	        //JLabel wird dem Panel hinzugef�gt
	        panel.add(label);
	        this.add(panel);
	    }
	 
	    public static void main(String[] args)
	    {
	        // Ein neues Objekt der Klasse BeispielListener wird erzeugt
	        // und sichtbar gemacht
	        MyButtonListener bl = new MyButtonListener();
	        bl.setVisible(true);
	    }
	 
	    public void actionPerformed (ActionEvent ae){
	        // Die Quelle wird mit getSource() abgefragt und mit den
	        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
	        // der Buttons ist, wird der Text des JLabels entsprechend ge�ndert
	        if(ae.getSource() == this.button1){
	            label.setText(("Button 1 wurde bet�tigt"));
	        }
	        else if(ae.getSource() == this.button2){
	            label.setText("Button 2 wurde bet�tigt");
	        }
	        else if (ae.getSource() == this.button3){
	            label.setText(("Button 3 wurde bet�tigt"));
	        }
	    }
	}
