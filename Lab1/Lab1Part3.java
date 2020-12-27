/*
 * CSE1310-005 Lab 1 Part 3
 */
package lab1part3;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab1Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        // Correctly find the surface area of the rectangular prism
        int a = 3;
        int b = 4;
        int c = 2;
        int d = 5;
        System.out.print("\nOriginal fractions are ");
        System.out.println(a+ "/"+ b + " and " + c + "/" + d );
        
        int num1st = a * d;
        int num2nd = b * c;
        int denom = b * d;
        
        System.out.print("\nThe terms in the numerator are ");
        System.out.println(num1st + " and " + num2nd + " and the denominator is " + denom);
        
        double fractionSum; //Single line of code to fix program
        
        fractionSum = (num1st + num2nd)/ (double) denom;
        System.out.print("\nThe equation for the sum of two fractions is ");
        System.out.println("(" + num1st + " + "+num2nd+")/"+denom +"  =  "
                      +(num1st + num2nd)+"/"+denom);
        System.out.println("\nThe sum of the two fractions is "+fractionSum);
}

    
}
