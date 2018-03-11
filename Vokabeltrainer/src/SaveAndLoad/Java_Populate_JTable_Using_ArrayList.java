package SaveAndLoad;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Karte;

/**
 * Diese Klasse wird für die Statistik veranschaung gebraucht
 * 
 * @author Marius Brändle St.Gallen / Duc Thach, Daniel Strassmann, Thomas Brunner
 * @version 1.0 09.3.2018
 */

public class Java_Populate_JTable_Using_ArrayList extends javax.swing.JFrame {

	/**
	 * Creates new form Java_Populate_JTable_Using_ArrayList
	 */
	public Java_Populate_JTable_Using_ArrayList() {
		initComponents();

		// use the addRowToJTable
		addRowToJTable();

	}

	// create a list of users
	public ArrayList ListKarte() {
		ArrayList<Karte> kartenliste = new ArrayList<Karte>();
		Karte k1 = new Karte("Hallo", "hello");
		Karte k2 = new Karte("Hund", "dog");
		Karte k3 = new Karte("Katze", "cat");
		Karte k4 = new Karte("Maus", "mouse");
		Karte k5 = new Karte("eins", "one");
		Karte k6 = new Karte("Ficken", "föck");
		kartenliste.add(k1);
		kartenliste.add(k2);
		kartenliste.add(k3);
		kartenliste.add(k4);
		kartenliste.add(k5);
		kartenliste.add(k6);
		return kartenliste;
	}

	// added rows from arraylist to jtable
	public void addRowToJTable() {
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		ArrayList<Karte> kartenliste = ListKarte();
		Object rowData[] = new Object[2];
		for (int i = 0; i < kartenliste.size(); i++) {
			rowData[0] = kartenliste.get(i).getFrage();
			rowData[1] = kartenliste.get(i).getAntwort();
			model.addRow(rowData);
		}

	}

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {

           },
           new String [] {
               "Id", "First Name", "Last Name", "Age"
           }
       ));
       jScrollPane1.setViewportView(jTable1);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(32, 32, 32)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(61, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(14, Short.MAX_VALUE))
       );

       pack();
   }// </editor-fold>                        

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new Java_Populate_JTable_Using_ArrayList().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   // End of variables declaration                   
}