/*
 * CSE1310-005 Lab 2 Part 3
 */
package lab2part3;

import java.util.Scanner;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab2Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xPlus, xMinus, a, b, c, bSquared, rad, denom, numPlus, numMinus; //Establish all my double variables: xPlus, xMinus, a, b, c, bSquared, rad, denom, numPlus, numMinus;
        
        Scanner inputvar = new Scanner(System.in); // Add a Scanner and ask the user to type in variables for a, b, and c;
        System.out.print("Please type in a variable for a: ");
        a = inputvar.nextInt();
        System.out.print("Please type in a variable for b: ");
        b = inputvar.nextInt();
        System.out.print("Please type in a variable for c: ");
        c = inputvar.nextInt();
        
        System.out.println("Value of a = " +a);
        System.out.println("Value of b = " +b);
        System.out.println("Value of c = " +c);
        
        numPlus = -b; //Save numPlus to be equal to -b;
        System.out.println("We will establish numPlus as -b or -(" +b + "). numPlus = " + numPlus);
        
        numMinus = -b; //Save numMinus to be equal to -b;
        System.out.println("We will establish numMinus as -b or -(" +b + "). numMinus = " + numMinus);
        
        denom = 2*a; //Multiply a by 2 and save it in denom;
        System.out.println("We will now solve for the denominator, which is 2a or 2(" +a + "). denom = " + denom);
        
        bSquared = Math.pow(b , 2); //Square the value of b and save it in bSquared;
        System.out.println("bSquared is equal to b^2 or (" +b+ ")^2. bSquard = " +bSquared);
        
        rad = 4*a*c; //Multiply the values of a, c and 4 together and save it in rad;
        System.out.println("Solve for a portion of the radical and save it in rad. You will multiply 4*a*b or 4("+ a +")*("+ c +"). rad = " + rad);
        
        System.out.print("We will solve for the the rest of the inside of the radical. bSquared - rad or (" + bSquared +") - (" + rad + "). rad = ");
	rad = bSquared - rad; //Solve for the inside of the rad by subtracting rad from bSquared and save it in rad;        
	System.out.println(rad);

        rad = Math.sqrt(Math.abs(rad)); //Solve for the rad by square rooting rad and save it in rad;
        System.out.println("We will now square root the inside of the radical and solve for the radical. sqrt(rad) or sqrt(" + rad + "). rad = " + rad);
        
        numPlus = numPlus + rad;//Add xPlus to rad and save it in numPlus;
        System.out.println("We will now solve for the numerator for xPlus. numPlus + rad or (" + numPlus + ") + (" + rad + "). numPlus = " + numPlus);
        
        numMinus = numMinus - rad;//Subtract xMinus to rad and save it in numPlus;
        System.out.println("We will now solve for the numerator for xMinus. numMinus - rad or (" + numMinus + ") - (" + rad + "). numMinus = " + numMinus);
        
        xPlus = numPlus / denom; //Divide numPlus by denom and save it in xPlus;
        System.out.println("We will now divide to solve for xPlus. numPlus / denom or (" + numPlus + ") / (" + denom + ")");
        xMinus = numMinus / denom;//Divide numMinus by denom and save it in xMinus;
        System.out.println("We will now divide to solve for xMinus. numMinus / denom or (" + numMinus + ") / (" + denom + ")");
        System.out.println("Results from xPlus is " + xPlus);//Print out results of numPlus describing this is the result of b+;
        System.out.println("Results from xMinus is " + xMinus);//Print out the results of numMinus describing this is the result of b-;    
    }
    
}
