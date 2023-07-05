package KaKaBWZ;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestellungverwaltungGUI extends JFrame implements ActionListener {

    //Datenbank
    Datenbankverbindung datenbankverbindung;

    //Panels
    private JPanel mainPanel;
    private JPanel buttonPanel;

    //Buttons
    private JButton abbrechenbtn;
    private JButton bestellunghinzubtn;

    //Labels
    private JLabel bestellungenlistTextlabel;

    //Lists
    private JList bestellungList;

    //Constructor
    BestellungverwaltungGUI(){
        //Options
        setTitle("Bestellungen verwalten");
        setSize(480,320);
        setVisible(true);

        //Instanzieren
        Persistence persistence = new Persistence();
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        bestellunghinzubtn = new JButton("Bestellung hinzufügen");
        abbrechenbtn = new JButton("Abbrechen");

        bestellungenlistTextlabel = new JLabel("Bestellungen:");

        //Kunden in JList anzeigen
        bestellungList = new JList<>(persistence.bestellungenarrayList.toArray(new String[0]));

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        bestellunghinzubtn.addActionListener(this);
        abbrechenbtn.addActionListener(this);

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(bestellungList, BorderLayout.CENTER);
        mainPanel.add(bestellungenlistTextlabel, BorderLayout.NORTH);
        buttonPanel.add(abbrechenbtn);
        buttonPanel.add(bestellunghinzubtn);

        //Colors
        bestellunghinzubtn.setBackground(Color.lightGray);
        abbrechenbtn.setBackground(Color.lightGray);

        bestellunghinzubtn.setBorder(new LineBorder(Color.BLACK));
        abbrechenbtn.setBorder(new LineBorder(Color.BLACK));
        bestellungList.setBorder(new LineBorder(Color.BLACK));

    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e){
        //Bestellung hinzufügen
        if(e.getSource() == bestellunghinzubtn){
            //Instanzieren
            NeueBestellungenGUI bestellungenGUI = new NeueBestellungenGUI();
            dispose();
        }

        //Abbrechen
        if(e.getSource() == abbrechenbtn){
            //Close
            dispose();
        }
    }
}
