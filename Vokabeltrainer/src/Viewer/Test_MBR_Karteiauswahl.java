package Viewer;
import javax.swing.*;


public class Test_MBR_Karteiauswahl {

	
    public static void main(String[] args) {
        JFrame meinJFrame = new JFrame();
        meinJFrame.setTitle("JComboBox Beispiel");
        meinJFrame.setSize(250, 250);
        JPanel panel = new JPanel();
 
        JLabel frage = new JLabel("Aus welchem Bundesland kommst du?");
        panel.add(frage);
 
        // Array f�r unsere JComboBox
        String comboBoxListe[] = {"Baden-W�rttemberg", "Bayern",
            "Berlin", "Brandenburg", "Bremen",
            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
            "Saarland", "Sachsen", "Sachsen-Anhalt",
            "Schleswig-Holstein", "Th�ringen"};
 
        //JComboBox mit Bundesl�nder-Eintr�gen wird erstellt
        JComboBox bundeslandAuswahl = new JComboBox(comboBoxListe);
 
        //JComboBox wird Panel hinzugef�gt
        panel.add(bundeslandAuswahl);
 
        meinJFrame.add(panel);
        meinJFrame.setVisible(true);
 
    }
    
}
