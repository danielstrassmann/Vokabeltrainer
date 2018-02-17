package Viewer;
//Import-Anweisungen
import java.awt.Color;
import javax.swing.*;

public class Test_MBR_ToolBar
{
 // main-Methode
 public static void main(String[] args)
 {
     // Erzeugung eines neuen Dialoges
     JDialog meinJDialog = new JDialog();
     meinJDialog.setTitle("JToolBar Beispiel");
     meinJDialog.setSize(450,300);
     // Erstellung einer Menüleiste
     JMenuBar menu = new JMenuBar();
     // Menü wird hinzugefügt
     menu.add(new JMenu("Datei"));

     //Toolbar wird erstellt
     JToolBar tbar = new JToolBar();
     //Größe der Toolbar wird gesetzt
     tbar.setSize(230, 20);

     // Schaltflächen werden erzeugt und unserer JToolBar hinzugefügt
     tbar.add(new JButton("Drehen"));
     tbar.add(new JButton("Verkleinern"));
     tbar.add(new JButton("Vergrößern"));

     // Menüleiste wird für den Dialog gesetzt
     meinJDialog.setJMenuBar(menu);

     //Unsere Toolbar wird zum Dialog hinzugefügt
     meinJDialog.add(tbar);

     JPanel panel = new JPanel();
     panel.setBackground(Color.YELLOW);
     meinJDialog.add(panel);

     // Wir lassen unseren Dialog anzeigen
     meinJDialog.setVisible(true);

 }
}


