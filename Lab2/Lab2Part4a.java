/*
 * CSE1310-005 Lab 2 Part 4a
 */
package lab2part4a;

import java.util.Scanner;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab2Part4a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int d, e, dde, deed;
        Scanner inputval = new Scanner(System.in);
        String again = "Y";
        System.out.println("We need to find values for d and e that will make the following equation true: (DD)^E = DEED");
        while ("Y".equals(again))
        {
            System.out.print("Input an int value for d: ");
            d = inputval.nextInt();
            System.out.print("Input an int value for e: ");
            e = inputval.nextInt();
            dde = (int)Math.pow((d*10)+d, e);
            System.out.println("(dd)^e = (" + d + d + ")^(" + e + ") = " + dde);
            deed = (d*1000)+(e*100)+(e*10)+(d*1);
            System.out.println("deed = (" + d*1000 + ")+(" + e*100 +")+(" + e*10 + ")+(" + d + ") = " + d+e+e+d);
            if (dde == deed)
            {
                System.out.println("Values d = " + d + " and e = " + e + " make the equation true!  (^-^)");
                System.out.println("dde (" + dde + ") = deed (" + deed + ")");
            }
            else
            {
                System.out.println("Values d = " + d + " and e = " + e + " do not make the equation true. (>-<)");
            }
            System.out.println("Do you want to try again? (Y/N)");
            again = inputval.next();
            if ("Y".equals(again))
            {
                 System.out.println("You got this! (^-^)");
            }
        }
         System.out.println("Program is now complete! (^-^)");   
    }  
    
}
