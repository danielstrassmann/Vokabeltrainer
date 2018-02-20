package SaveAndLoad;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Karte;

public class Gui_Tab_Kartei {

	static ArrayList<Karte> kartenliste = new ArrayList<Karte>();

	public static ArrayList ListKarte() {

		Karte k1 = new Karte("Hallo", "hello");
		Karte k2 = new Karte("Hund", "dog");
		Karte k3 = new Karte("Katze", "cat");
		Karte k4 = new Karte("Maus", "mouse");
		Karte k5 = new Karte("eins", "one");
		Karte k6 = new Karte("Baum", "tree");
		Karte k7 = new Karte("tisch", "tisch");
		Karte k8 = new Karte("Hallo", "hello");
		Karte k9 = new Karte("Hund", "dog");
		Karte k10 = new Karte("Katze", "cat");
		Karte k11 = new Karte("Maus", "mouse");
		Karte k12 = new Karte("eins", "one");
		Karte k13 = new Karte("Baum", "tree");
		Karte k14 = new Karte("tisch", "tisch");
		kartenliste.add(k1);
		kartenliste.add(k2);
		kartenliste.add(k3);
		kartenliste.add(k4);
		kartenliste.add(k5);
		kartenliste.add(k6);
		kartenliste.add(k7);
		kartenliste.add(k8);
		kartenliste.add(k9);
		kartenliste.add(k10);
		kartenliste.add(k11);
		kartenliste.add(k12);
		kartenliste.add(k13);
		kartenliste.add(k14);
		return kartenliste;

	}

	/*
	 * public void addRowToJTable() { DefaultTableModel model = (DefaultTableModel)
	 * JTable (table.getModel()); ArrayList<Karte> kartenliste = ListKarte(); Object
	 * rowData[] = new Object[2]; for (int i = 0; i < kartenliste.size(); i++) {
	 * rowData[0] = kartenliste.get(i).getFrage(); rowData[1] =
	 * kartenliste.get(i).getAntwort(); model.addRow(rowData); } }
	 */

	public static void main(String[] args) {

		// erstelle JFrame and JTable
		JFrame frame = new JFrame();
		JTable table = new JTable();

		// erstelle tablemodel DefaultTableModel für Array und definiere Spalten
		Object[] columns = { "Frage", "Antwort" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		// setze das Model
		table.setModel(model);

		// Change A JTable Background Color, Font Size, Font Color, Row Height
		// table.setBackground(Color.LIGHT_GRAY);
		// table.setForeground(Color.black);
		// Font font = new Font("",1,22);
		// table.setFont(font);
		// table.setRowHeight(30);

		// erstelle JTextFields
		JTextField textFrage = new JTextField();
		JTextField textAntwort = new JTextField();


		// erstelle JButtons
		JButton btnAdd = new JButton("Neu");
		JButton btnDelete = new JButton("Löschen");
		JButton btnUpdate = new JButton("Ändern");

		textFrage.setBounds(20, 220, 100, 25);
		textAntwort.setBounds(20, 250, 100, 25);

		btnAdd.setBounds(150, 220, 100, 25);
		btnUpdate.setBounds(150, 265, 100, 25);
		btnDelete.setBounds(150, 310, 100, 25);

		// erstelle JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		frame.setLayout(null);

		frame.add(pane);

		// füge JTextFields auf dem jframe hinzu
		frame.add(textFrage);
		frame.add(textAntwort);

		// füge JButtons auf dem jframe hinzu
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnUpdate);

		// fügt ArrayList Karten hinzu
	ArrayList<Karte> kartenliste = ListKarte();
		Object rowData[] = new Object[2];
		for (int i = 0; i < kartenliste.size(); i++) {
			rowData[0] = kartenliste.get(i).getFrage();
			rowData[1] = kartenliste.get(i).getAntwort();
			model.addRow(rowData);}

			// erstelle eine Array und fügt es dem Model hinzu
			Object[] row = new Object[2];

			// button add row --> Button Neu
			btnAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					row[0] = textFrage.getText();
					row[1] = textAntwort.getText();

					// fügt neue Karte im Model hinzu
					model.addRow(row);
				}
			});

			// button remove row --> Button löschen
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();
					if (i >= 0) {
						// lösche eine row vom jtable
						model.removeRow(i);
					} else {
						System.out.println("Delete Error");
					}
				}
			});

			// übertrage Felder vom selektierten row in die JTextFields
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();

					textFrage.setText(model.getValueAt(i, 0).toString());
					textAntwort.setText(model.getValueAt(i, 1).toString());
				}
			});

			// button update row --> Button Ändern
			btnUpdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// i = der Index von der selektierten row
					int i = table.getSelectedRow();

					if (i >= 0) {
						model.setValueAt(textFrage.getText(), i, 0);
						model.setValueAt(textAntwort.getText(), i, 1);

					} else {
						System.out.println("Update Error");
					}
				}
			});

			frame.setSize(900, 400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

		}
	}

