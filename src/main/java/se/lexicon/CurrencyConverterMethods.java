package se.lexicon;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyConverterMethods {


    //Hardcoded Currency values
    public double convertCurrency(String from,String to,double amount){
        double result=0;
        if(from.equals("SEK") && to.equals("USD")){
            result = amount * 0.11;
        }
        else if(from.equals("USD")&& to.equals("SEK")){
            result = amount * 9.46;
        }
        else if(from.equals("SEK")&& to.equals("Euro")){
            result = amount * 0.91;
        }
        else if(from.equals("Euro")&& to.equals("SEK")){
            result = amount * 11.03;
        }
        else{
            System.out.println("Conversion is not supported.");
        }

        return result;
    }


}
