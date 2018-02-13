package SaveAndLoad;

 import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTableRow {

    public static void main(String[] args){
        
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Frage","Antwort"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
      //  table.setBackground(Color.LIGHT_GRAY);
       // table.setForeground(Color.black);
       // Font font = new Font("",1,22);
       // table.setFont(font);
       // table.setRowHeight(30);
        
        // create JTextFields
        JTextField textFrage = new JTextField();
        JTextField textAntwort = new JTextField();
        //JTextField textLname = new JTextField();
      //  JTextField textAge = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Neu");
        JButton btnDelete = new JButton("Löschen");
        JButton btnUpdate = new JButton("Ändern");     
        
        textFrage.setBounds(20, 220, 100, 25);
        textAntwort.setBounds(20, 250, 100, 25);
        //textLname.setBounds(20, 280, 100, 25);
     //   textAge.setBounds(20, 310, 100, 25);
        
        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(textFrage);
        frame.add(textAntwort);
      //  frame.add(textLname);
      //  frame.add(textAge);
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        
        // create an array of objects to set the row data
        Object[] row = new Object[2];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textFrage.getText();
                row[1] = textAntwort.getText();
               // row[2] = textLname.getText();
               // row[3] = textAge.getText();
                
                // add row to the model
                model.addRow(row);
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textFrage.setText(model.getValueAt(i, 0).toString());
            textAntwort.setText(model.getValueAt(i, 1).toString());
      //      textLname.setText(model.getValueAt(i, 2).toString());
         //   textAge.setText(model.getValueAt(i, 3).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textFrage.getText(), i, 0);
                   model.setValueAt(textAntwort.getText(), i, 1);
                 //  model.setValueAt(textLname.getText(), i, 2);
                 //  model.setValueAt(textAge.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}