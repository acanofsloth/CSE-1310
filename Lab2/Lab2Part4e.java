/*
 * CSE1310-005 Lab 2 Part 4e
 */
package lab2part4e;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab2Part4e {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int d = 0, e = 0, dde, deed;
        System.out.println("Let's see which #'s for e and d, from 0-9, will make the following equation true: (DD)^E = DEED");
        for (e = 0; e <= 9;e++)
        { 
            for (d = 0; d <= 9; d++)
            {
                dde = (int)Math.pow((d*10)+d, e);
                System.out.println("(dd)^e = (" + d + d + ")^(" + e + ") = " + dde);
                deed = (d*1000)+(e*100)+(e*10)+(d*1);
                System.out.println("deed = (" + d*1000 + ")+(" + e*100 +")+(" + e*10 + ")+(" + d + ") = " + d+e+e+d);  
                if (dde == deed)
                {
                    System.out.println("Values e = " + e + " and d = " + d + " make the equation true!");
                    System.out.println("dde (" + dde + ") = deed (" + deed + ")");
                }
                else
                {
                    System.out.println("Values d = " + d + " and e = " + e + " do not make the equation true.");
                }
            }
            d = 0;
        }
        System.out.println("Program is complete!");
    }
    
}
