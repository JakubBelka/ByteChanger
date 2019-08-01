package GUI;
import BinaryFile.BinaryFile;
import BinaryFile.ByteChanger;
import BinaryFile.FileFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {

    JButton startButton, cleanButton, exitButton, chooseButton;
    JLabel lfolder, ltype, lbyte1, lbyte2,lresult, lwarning;
    JTextField tfolder, tbyte1, tbyte2,tresult;
    JPanel panel;
    byte byte1, byte2;
    JOptionPane JOPWarning, JOPDone;
    JFileChooser fc;
    TypeBox typeBox;
    File directory;
    String fileType;

    JMenuBar menuBar;
    JMenu menuMore;
    JMenuItem mHelp, mInfo;


    public MainFrame() throws HeadlessException {
        setSize(400,650);
        setTitle("byte changer");
        setLocation(700,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuMore = new JMenu("Więcej...");
        menuBar.add(menuMore);


        mInfo = new JMenuItem("O programie");
        menuMore.add(mInfo);
        mInfo.addActionListener(this);
        mInfo.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));

        menuMore.addSeparator();

        mHelp = new JMenuItem("Pomoc");
        menuMore.add(mHelp);
        mHelp.addActionListener(this);
        mHelp.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));




        lfolder = new JLabel("Wybierz folder: ");
        lfolder.setBounds(10,20,130, 25);
        panel.add(lfolder);

        tfolder = new JTextField();
        tfolder.setBounds(10,60,200, 25);
        panel.add(tfolder);

        ltype = new JLabel("Wybierz rozszerzenie: ");
        ltype.setBounds(10,100,130, 25);
        panel.add(ltype);

        //................................
        typeBox = new TypeBox();
        typeBox.setBounds(10,140,200, 25);
        panel.add(typeBox);
        typeBox.addActionListener(this);

        lbyte1 = new JLabel("Podaj szukany bajt: ");
        lbyte1.setBounds(10,180,130, 25);
        panel.add(lbyte1);

        tbyte1 = new JTextField();
        tbyte1.setBounds(10,220,200, 25);
        panel.add(tbyte1);

        lbyte2 = new JLabel("Wpisz nowy bajt:");
        lbyte2.setBounds(10,260,130, 25);
        panel.add(lbyte2);

        tbyte2 = new JTextField();
        tbyte2.setBounds(10,300,200, 25);
        panel.add(tbyte2);

        lwarning = new JLabel("Uwaga! Format zapisu bajtu: (-128,127) ");
        lwarning.setBounds(10,325,250, 25);
        lwarning.setForeground(Color.RED);
        panel.add(lwarning);


        lresult = new JLabel("WYNIK:");
        lresult.setBounds(10,375,130, 25);
        panel.add(lresult);

        tresult = new JTextField();
        tresult.setBounds(10,400,360, 50);
        tresult.setBackground(Color.LIGHT_GRAY);
        tresult.setForeground(Color.RED);
        Font font = new Font("SansSerif", Font.BOLD, 15);
        tresult.setFont(font);
        panel.add(tresult);



        //Przycisk START!
        startButton = new JButton("START");
        startButton.setBounds(20, 520,85,40);
        panel.add(startButton);
        startButton.addActionListener(this);

        //Przycisk KONIEC!
        exitButton = new JButton("EXIT");
        exitButton.setBounds(270, 520,85,40);
        panel.add(exitButton);
        exitButton.addActionListener(this);

        //Przycisk czysc!
        cleanButton = new JButton("CLEAN");
        cleanButton.setBounds(140, 520,85,40);
        panel.add(cleanButton);
        cleanButton.addActionListener(this);

        //Przycisk choose!
        chooseButton = new JButton("...");
        chooseButton.setBounds(215,59,25,25);
        panel.add(chooseButton);
        chooseButton.addActionListener(this);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource = e.getSource();

        if (actionSource == startButton) {
                try {
                    byte1 = Byte.parseByte(tbyte1.getText());
                    byte2 = Byte.parseByte((tbyte2.getText()));
                    fileType = typeBox.getSelectedItem().toString();

                    ByteChanger bc = new ByteChanger(byte1, byte2);
                    FileFinder.findFile(directory, fileType);


                    int answer = JOptionPane.showConfirmDialog(null, "Dalsze " +
                            "działanie programu spowoduje trwałe zmiany w poniższych plikach: "+ FileFinder.getFilesName() +
                            "\n Czy chcesz kontynuować?","Uwaga!",JOptionPane.YES_NO_OPTION);

                        if(answer==JOptionPane.YES_OPTION) {
                             for (int i = 0; i < FileFinder.filePathToChange.size(); i++) {
                                 BinaryFile file = new BinaryFile(FileFinder.filePathToChange.get(i));
                                 file.writeFile(bc.changeBytes(file.readFileToTab()));
                                 }
                             tresult.setText("Znalezionych plików: " + FileFinder.filePathToChange.size() + "   Wykonano " + bc.nrOfOperations + " operacji.");
                             FileFinder.cleanList();
                             JOPDone.showMessageDialog(null, "Zadanie wykonane", "Good job!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            FileFinder.cleanList();
                        }
                }
                catch (Exception ex) {
                    JOPWarning.showMessageDialog(null, "Coś poszło nie tak, spróbuj ponownie. \n W razie problemów skorzystaj z zakładki POMOC lub użyj skrótu CTRL+P.", "Uwaga!", JOptionPane.ERROR_MESSAGE);
                }

        }

         if (actionSource==exitButton){

            dispose();
        }
        else if(actionSource==cleanButton){
            FileFinder.cleanList();
            tresult.setText("");
            tfolder.setText("");
            tbyte1.setText("");
            tbyte2.setText("");
            panel.setVisible(true);
        }
        else if(actionSource==chooseButton){
            fc = new JFileChooser();
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                   directory = fc.getSelectedFile();
                    tfolder.setText(directory.getPath());
                }
        }
        else if(actionSource==mHelp){
           HelpFrame helpFrame = new HelpFrame();

         }
         else if(actionSource==mInfo){
             InfoFrame infoFrame = new InfoFrame();
         }
        }



    }



