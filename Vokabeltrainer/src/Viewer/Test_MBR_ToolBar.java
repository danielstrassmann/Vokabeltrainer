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
     // Erstellung einer Men�leiste
     JMenuBar menu = new JMenuBar();
     // Men� wird hinzugef�gt
     menu.add(new JMenu("Datei"));

     //Toolbar wird erstellt
     JToolBar tbar = new JToolBar();
     //Gr��e der Toolbar wird gesetzt
     tbar.setSize(230, 20);

     // Schaltfl�chen werden erzeugt und unserer JToolBar hinzugef�gt
     tbar.add(new JButton("Drehen"));
     tbar.add(new JButton("Verkleinern"));
     tbar.add(new JButton("Vergr��ern"));

     // Men�leiste wird f�r den Dialog gesetzt
     meinJDialog.setJMenuBar(menu);

     //Unsere Toolbar wird zum Dialog hinzugef�gt
     meinJDialog.add(tbar);

     JPanel panel = new JPanel();
     panel.setBackground(Color.YELLOW);
     meinJDialog.add(panel);

     // Wir lassen unseren Dialog anzeigen
     meinJDialog.setVisible(true);

 }
}


