package com.clara;

import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        char checkNumber = ccNumber.charAt((ccNumber.length()-1));

        boolean isValid = isValidCreditCard(ccNumber, checkNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc, char cn) {
        String card = cc;
        String checkString = "" + cn;
        int check = Integer.valueOf(checkString);
        card = card.substring(0, ( card.length() -1));
        String cardReverse = new StringBuilder(card).reverse().toString();

        char [] ccArray = cardReverse.toCharArray();
        int [] isWorking = new int[ccArray.length];
        int sumOfDigits = 0;

        for(int i=0; i<ccArray.length; i+=2)
        {
            isWorking[i] = Character.getNumericValue( ccArray[i]);
        }
        for (int j=0; j<isWorking.length; j++)
        {
            if ( (j % 2)==0)
            {
                isWorking[j] = isWorking[j]*2;
            }
        }
        for (int k=0; 1<isWorking.length; k++)
        {
            if (isWorking[k]>9)
            {
                isWorking[k] = isWorking[k]-9;
            }
        }
        for (int l = 0; l < isWorking.length; l++)
        {
            sumOfDigits+= isWorking[l];
        }
        if(sumOfDigits % 10 == check)
        {
            return true;
        }
        else
        {
            return false;
        }


    }




}
