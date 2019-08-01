package GUI;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {
    public InfoFrame() throws HeadlessException {

        JLabel  lLine1, lLine2, lLine3, lLine4, lContact;
        JPanel panel;

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        setSize(400,300);
        setTitle("Pomoc");
        setLocation(700,240);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);



        lLine1 = new JLabel("    Program ma za zadanie wyszukać w wybranym folderze ");
        lLine1.setBounds(10, 40, 500, 20);
        panel.add(lLine1);
        lLine2 = new JLabel(("(oraz w jego podfolderach) pliki z wybranym rozszerzeniem."));
        lLine2.setBounds(10, 60,500,20);
        panel.add(lLine2);
        lLine3 = new JLabel(("Następnie w plikach tych wyszukuję określonego bajtu"));
        lLine3.setBounds(10, 80,500,20);
        panel.add(lLine3);
        lLine4 = new JLabel((" i zamienia go na inny wcześniej podany."));
        lLine4.setBounds(10, 100,500,20);
        panel.add(lLine4);


        lContact = new JLabel("Program wykonał: Jakub Belka");
        lContact.setBounds(10,200,500, 25);
        panel.add(lContact);

        setVisible(true);
    }

}
