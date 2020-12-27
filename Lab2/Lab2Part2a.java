/*
 * CSE1310-005 Lab 2 Part 2a
 */
package lab2part2a;

import java.util.Scanner;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab2Part2a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        int shoeSize;
        int mult1st = 5;
        int addTo = 50;
        int multBy = 20;
        int addCount = 1019;
        int year;
        Scanner typeobject = new Scanner(System.in);
        
        System.out.println("Enter your shoe size and round up if you wear a half-size.");
        System.out.print("Shoe size: ");
        shoeSize = typeobject.nextInt();
        
        System.out.print("We’re now going to multiply the shoe size by five: ");
        mult1st = mult1st * shoeSize;
        System.out.println(mult1st);
        
        System.out.print("we’re now going to add fifty to the previous value: ");
        addTo = addTo + mult1st;
        System.out.println(addTo);
        
        System.out.print("We’re now going to multiply the last value by twenty: ");
        multBy = addTo * multBy;
        System.out.println(multBy);
        
        System.out.print("We're now going to add 1019 to the last value: ");
        addCount = multBy + addCount;
        System.out.println(addCount);
        
        System.out.println("Enter the year that you are born.");
        System.out.print("Year: ");
        year = typeobject.nextInt();
        
        System.out.println("We're now going to subtract this year from the previous value.");
        addCount = addCount - year;
        
        System.out.println("We have now created a number that starts with their shoe size and ends with their age.");
        System.out.println("And your number is " + addCount);
        
    }
    
}