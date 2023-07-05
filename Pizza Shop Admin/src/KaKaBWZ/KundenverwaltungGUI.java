package KaKaBWZ;

import org.bson.Document;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KundenverwaltungGUI extends JFrame implements ActionListener {

    //Panels
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel secondbuttonPanel;

    //Buttons
    private JButton abbrechenbtn;
    private JButton kundenhinzubtn;
    private JButton kundenupdatebtn;
    private JButton kundeloschenbn;

    //Labels
    private JLabel kundelistTextlabel;
    private JLabel errorTextlabel;

    //Lists
    private JList kundeList;

    //Constructor
    KundenverwaltungGUI(){
        //Options
        setTitle("Kunden verwalten");
        setSize(480,320);
        setVisible(true);

        //Instanzieren
        Persistence persistence = new Persistence();
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        secondbuttonPanel = new JPanel();
        kundenhinzubtn = new JButton("Kunde hinzufügen");
        kundenupdatebtn = new JButton("Kunde updaten");
        kundeloschenbn = new JButton("Kunde löschen");
        abbrechenbtn = new JButton("Abbrechen");

        kundelistTextlabel = new JLabel("Kunden:");
        errorTextlabel = new JLabel("");

        //Kunden in JList anzeigen
        kundeList = new JList<>(persistence.kundearrayList.toArray(new String[0]));

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));
        buttonPanel.setLayout(new GridLayout(4, 1, 5, 5));
        secondbuttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        kundenhinzubtn.addActionListener(this);
        kundenupdatebtn.addActionListener(this);
        kundeloschenbn.addActionListener(this);
        abbrechenbtn.addActionListener(this);

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(kundeList, BorderLayout.CENTER);
        mainPanel.add(secondbuttonPanel, BorderLayout.SOUTH);
        mainPanel.add(kundelistTextlabel, BorderLayout.NORTH);
        buttonPanel.add(kundenhinzubtn);
        buttonPanel.add(kundenupdatebtn);
        buttonPanel.add(kundeloschenbn);
        secondbuttonPanel.add(abbrechenbtn);
        secondbuttonPanel.add(errorTextlabel);

        //Colors
        errorTextlabel.setForeground(Color.red);
        kundenhinzubtn.setBackground(Color.lightGray);
        kundenupdatebtn.setBackground(Color.lightGray);
        kundeloschenbn.setBackground(Color.lightGray);
        abbrechenbtn.setBackground(Color.lightGray);

        kundenhinzubtn.setBorder(new LineBorder(Color.BLACK));
        kundenupdatebtn.setBorder(new LineBorder(Color.BLACK));
        kundeloschenbn.setBorder(new LineBorder(Color.BLACK));
        abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        kundeList.setBorder(new LineBorder(Color.BLACK));

    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Kunde hinzufügen
        if(e.getSource() == kundenhinzubtn){
            //Instanzieren
            NeuerKundeGUI neuerKundeGUI = new NeuerKundeGUI();
            dispose();
        }

        //Kunde updaten
        if(e.getSource() == kundenupdatebtn){
            //Instanzieren
            NeuerKundeGUI neuerKundeGUI = new NeuerKundeGUI();
            dispose();
        }

        //Kunde löschen
        if(e.getSource() == kundeloschenbn){
            //löschen
            if (kundeList.getSelectedIndex() != -1) {
                //Reseting error
                errorTextlabel.setText("");

                //Connect to MongoDB
                Datenbankverbindung datenbankverbindung = new Datenbankverbindung();

                // Abrufen des aktuellen kundennamen
                String kundenName = (String) kundeList.getSelectedValue();
                datenbankverbindung.collectionkunde.deleteOne(new Document("nachname", kundenName));

                //Datenbank aktualisieren
                Persistence persistence = new Persistence();
                dispose();
                KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI();
            }
            else {
                errorTextlabel.setText("Error: Nichts selektiert");
            }
        }

        //Abbrechen
        if(e.getSource() == abbrechenbtn){
            //Close
            dispose();
        }
    }
}
