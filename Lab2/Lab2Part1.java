/*
 * CSE1310-005 Lab 2 Part 1
 */
package lab2part1;

import java.util.Scanner;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab2Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Correctly find the surface area of the rectangular prism
        int a;
        int b;
        int c;
        int d;
        Scanner inputKybd = new Scanner(System.in);
        System.out.print("Please enter a number ");
        a = inputKybd.nextInt();
        System.out.print("Please enter another number ");
        b = inputKybd.nextInt();     
        System.out.print("Please enter a third number ");
        c = inputKybd.nextInt();     
        System.out.print("Please enter a fourth number ");
        d = inputKybd.nextInt();

        System.out.print("Original fractions are ");
        System.out.println(a+ "/"+ b + " and " + c + "/" + d );
        
        int num1st = a * d;
        int num2nd = b * c;
        int denom = b * d;
        
        System.out.print("The terms in the numerator are ");
        System.out.println(num1st + " and " + num2nd + " and the denominator is " + denom);
        
        double fractionSum; //Single line of code to fix program
        
        fractionSum = (num1st + num2nd)/ (double) denom;
        System.out.print("The equation for the sum of two fractions is ");
        System.out.println("(" + num1st + " + "+num2nd+")/"+denom +"  =  "
                      +(num1st + num2nd)+"/"+denom);
        System.out.println("The sum of the two fractions is "+fractionSum);
    }
    
}
