package GUI;

import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame {
    public HelpFrame() throws HeadlessException {

        JLabel lHeading, lHeading2, lstep1, lstep2, lstep3, lstep4, lInformation, lContact;
        JPanel panel;

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        setSize(600,400);
        setTitle("Pomoc");
        setLocation(700,240);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);



        lHeading = new JLabel("Jak korzystać z programu: ");
        lHeading.setBounds(10,10,250, 25);
        lHeading.setForeground(Color.BLUE);
        Font font = new Font("SansSerif", Font.BOLD, 18);
        lHeading.setFont(font);
        panel.add(lHeading);



        lstep1 = new JLabel("1. Wybierz folder, w którym chcesz dokonać zamiany bajtów.");
        lstep1.setBounds(10, 40, 500, 25);
        panel.add(lstep1);
        lstep2 = new JLabel(("2. Wybierz rozszerzenie interesujących Cię plików."));
        lstep2.setBounds(10, 65,500,25);
        panel.add(lstep2);
        lstep3 = new JLabel(("3. Wybierz szukany bajt"));
        lstep3.setBounds(10, 90,500,25);
        panel.add(lstep3);
        lstep4 = new JLabel((".4 Wybierz nowy bajt"));
        lstep4.setBounds(10, 115,500,25);
        panel.add(lstep4);


        lHeading2 = new JLabel("Uwaga! ");
        lHeading2.setBounds(10,150,250, 25);
        lHeading2.setForeground(Color.RED);
        panel.add(lHeading2);

        lInformation = new JLabel("Bajt podawany jest w formacie liczby z zakresu (-128,127)");
        lInformation.setBounds(10,170,500, 25);
        panel.add(lInformation);

        lContact = new JLabel("W razie problemów prosimy o kontakt na kuba.belka7@gmail.com");
        lContact.setBounds(10,290,500, 25);
        panel.add(lContact);

        setVisible(true);
}}
