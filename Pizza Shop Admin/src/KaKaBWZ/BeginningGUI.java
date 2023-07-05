package KaKaBWZ;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginningGUI extends JFrame implements ActionListener {

    //Panels
    private JPanel mainPanel;
    private JPanel buttonPanel;

    //Buttons
    private JButton bestellungbtn;
    private JButton adminKundenbtn;
    private JButton adminPizzenbtn;

    //Labels
    private JLabel firstTextlabel;

    //Constructor
    BeginningGUI(){
        //Options
        setTitle("Pizza Shop - Administrator");
        setSize(330,215);
        setVisible(true);

        //only here
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instanzieren
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        bestellungbtn = new JButton("Admin ~ Bestellung verwalten");
        adminKundenbtn = new JButton("Admin ~ Kunden verwalten");
        adminPizzenbtn = new JButton("Admin ~ Pizzen verwalten");
        firstTextlabel = new JLabel("Wählen Sie:");

        //Options
        getContentPane().setLayout(new BorderLayout(5, 5));
        mainPanel.setLayout(new BorderLayout(20, 10));
        buttonPanel.setLayout(new GridLayout(3, 1, 5, 5));
        bestellungbtn.addActionListener(this);
        adminKundenbtn.addActionListener(this);
        adminPizzenbtn.addActionListener(this);

        //Objects
        getContentPane().add(mainPanel);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(firstTextlabel, BorderLayout.NORTH);
        buttonPanel.add(bestellungbtn);
        buttonPanel.add(adminKundenbtn);
        buttonPanel.add(adminPizzenbtn);

        //Colors
        bestellungbtn.setBackground(Color.lightGray);
        adminKundenbtn.setBackground(Color.lightGray);
        adminPizzenbtn.setBackground(Color.lightGray);

        bestellungbtn.setBorder(new LineBorder(Color.BLACK));
        adminKundenbtn.setBorder(new LineBorder(Color.BLACK));
        adminPizzenbtn.setBorder(new LineBorder(Color.BLACK));

    }

    //Button click
    @Override
    public void actionPerformed(ActionEvent e) {
        //Admin ~ Bestellung verwalten
        if(e.getSource() == bestellungbtn){
            //Instanzieren
            BestellungverwaltungGUI bestellungverwaltungGUI = new BestellungverwaltungGUI();
        }

        //Admin ~ Kunden verwalten
        if(e.getSource() == adminKundenbtn){
            //Instanzieren
            KundenverwaltungGUI kundenverwaltungGUI = new KundenverwaltungGUI();
        }

        //Admin ~ Pizzen verwalten
        if(e.getSource() == adminPizzenbtn){
            //Instanzieren
            PizzaverwaltungGUI pizzaverwaltungGUI = new PizzaverwaltungGUI();
        }
    }
}
