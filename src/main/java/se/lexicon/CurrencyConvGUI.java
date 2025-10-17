package se.lexicon;

import javax.swing.*;
import java.awt.*;

public class CurrencyConvGUI extends JFrame {
    private final JComboBox<String> from;
    private final JComboBox<String> to;
    private final JTextField amountField;
    //private final JTextArea resultArea;
    private final CurrencyConverterMethods converter;

    public CurrencyConvGUI(){
            super("Currency Exchange" + "\uD83D\uDCB1");
            converter = new CurrencyConverterMethods();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500,500);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout(10,10));

            JLabel titleLbl=new JLabel("Currency Converter",SwingConstants.CENTER);
            titleLbl.setFont(new Font("Arial",Font.BOLD,18));
            add(titleLbl,BorderLayout.NORTH);

            JPanel inputPanel=new JPanel(new GridLayout(3,2,8,8));

            inputPanel.add(new JLabel("From Currency"));
            from=new JComboBox<>(new String[]{"SEK","USD","Euro"});
            inputPanel.add(from);

            inputPanel.add(new JLabel("To Currency"));
            to=new JComboBox<>(new String[]{"USD","SEK","Euro"});
            inputPanel.add(from);

            inputPanel.add(new JLabel("Amount: "));
            amountField=new JTextField();
            inputPanel.add(amountField);

            add(inputPanel,BorderLayout.CENTER);

            JPanel btnPanel=new JPanel();
            JButton convButton=new JButton("Convert");
            JButton clearBtn=new JButton("Clear");
            JButton exitBtn=new JButton("Exit");

            btnPanel.add(convButton);
            btnPanel.add(clearBtn);
            btnPanel.add(exitBtn);
            add(btnPanel,BorderLayout.SOUTH);


    }
}
