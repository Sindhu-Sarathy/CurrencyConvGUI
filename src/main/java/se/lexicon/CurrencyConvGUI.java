package se.lexicon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyConvGUI extends JFrame {
    private final JComboBox<String> fromCurrency;
    private final JComboBox<String> toCurrency;
    private final JTextField amountField;
    private final JTextArea resultArea;
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
            fromCurrency=new JComboBox<>(new String[]{"SEK","USD","Euro"});
            inputPanel.add(fromCurrency);

            inputPanel.add(new JLabel("To Currency"));
            toCurrency=new JComboBox<>(new String[]{"USD","SEK","Euro"});
            inputPanel.add(toCurrency);

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

            resultArea=new JTextArea(4,20);
            resultArea.setEditable(false);
            resultArea.setMargin(new Insets(10,10,10,10));
            add(new JScrollPane(resultArea),BorderLayout.EAST);

            convButton.addActionListener(this::convertCurrency);
            clearBtn.addActionListener(e -> clearFields());
            exitBtn.addActionListener(e -> System.exit(0));
    }

      public void convertCurrency(ActionEvent e){
            try{
                String from=(String) fromCurrency.getSelectedItem();
                String to=(String) toCurrency.getSelectedItem();
                double amount=Double.parseDouble(amountField.getText());

                if(amount<0){
                    JOptionPane.showMessageDialog(this,"Amount cannot be negative.Try Again!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double result=converter.convertCurrency(from,to,amount);
                displayResult(from,to,amount,result);
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Input", JOptionPane.WARNING_MESSAGE);

            }
      }

    private void clearFields() {
        amountField.setText("");
        resultArea.setText("");
        fromCurrency.setSelectedIndex(0);
        toCurrency.setSelectedIndex(0);
    }

    //Displaying the result with date and time
    public void displayResult(String from,String to,double amount,double result){
        DecimalFormat df=new DecimalFormat("0.00");
        String dateTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        resultArea.setText("The Result is : " +df.format(amount)+" "+from+" = "+df.format(result)+ " "+to+"Date and Time:"+dateTime);
    }
}
