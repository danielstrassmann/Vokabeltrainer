package Viewer;

import java.awt.*;
import java.awt.event.*;

public class TwoListener implements MouseMotionListener,
                                    MouseListener {
   private Frame f;
   private TextField tf;
      
   public TwoListener() {
      f = new Frame("Two listeners example");
      tf = new TextField(30);
   }
      
   public void launchFrame() {
      Label label = new Label("Click and drag the mouse");
          
      // Hinzuf�gen der Komponenten zum Frame
      f.add(label, BorderLayout.NORTH);
      f.add(tf, BorderLayout.SOUTH);
          
      // Hinzuf�gen der Listener
      f.addMouseMotionListener(this);
      f.addMouseListener(this);
          
      f.setSize(300, 200);
      f.setVisible(true);
   }
      
   // Implementieren der Methoden f�r den
   // MouseMotionListeners und den MouseListener
   public void mouseDragged(MouseEvent e) {
      String s = "Mouse dragging:  X = " + e.getX()
          + " Y = " + e.getY();
          
      tf.setText(s);
   }
      
   public void mouseEntered(MouseEvent e) {
      String s = "The mouse entered";
          
      tf.setText(s);
   }
      
   public void mouseExited(MouseEvent e) {
      String s = "The mouse has left the building";
          
      tf.setText(s);
   }
      
   // Nicht verwendete Methode des MouseMotionListeners.
   // Alle Methoden des Interfaces m�ssen implementiert
   // werden, auch dann, wenn Sie nicht verwendet werden.
   public void mouseMoved(MouseEvent e) {}
      
   // Nicht verwendete Methoden des MouseListeners.
   public void mousePressed(MouseEvent e) {}
      
   public void mouseClicked(MouseEvent e) {}
      
   public void mouseReleased(MouseEvent e) {}
      
   public static void main(String args[]) {
      TwoListener two = new TwoListener();
      two.launchFrame();
   }
}