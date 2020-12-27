/*
 * CSE1310-005 Lab 3 Part 1c
 */
package lab3part1c;

import java.util.Scanner;

/**
 * Martinez Ivan
 * UTA Fall 2019
 * @author marti
 */
public class Lab3Part1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ddeDEED();
        System.out.println("\n");
        showSize();
        System.out.println("\n");
        lastFourDigits();
        
    }
    
    public static void ddeDEED()
    {
        int dde, deed;
        System.out.println("Let's see which #'s for e and d, from 0-9, will make the following equation true: (DD)^E = DEED");
        for (int e = 0; e <= 9;e++)
        { 
            for (int d = 0; d <= 9; d++)
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
        }
        System.out.println("\nPuzzle #1 is complete!");
    }
    
    public static void showSize()
    {
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
        
        int age;
        int size;
        age = addCount%100;
        size = addCount/100;
        System.out.println("Value of Age: " + age);
        System.out.println("Value of Size: " + size);
        
        System.out.println("\nPuzzle #2 is complete!");
    }
    
    public static void lastFourDigits()
    {
        int nNumber, nSquared;
        System.out.println("Lets see which four digit # for n, from 0-9999, will keep the last four digits equal to n when n^2\n");
        for(int nPlace1 = 0;nPlace1 <= 9;nPlace1++)
        {
            for(int nPlace2 = 0;nPlace2 <= 9;nPlace2++)
            {
                for(int nPlace3 = 0;nPlace3 <= 9;nPlace3++)
                {
                    for(int nPlace4 = 0;nPlace4 <= 9;nPlace4++)
                    {
                        nNumber = (nPlace1*1000)+(nPlace2*100)+(nPlace3*10)+nPlace4;
                        nSquared = (int)Math.pow((double)nNumber,2);
                        if(nNumber == (nSquared%10000))
                        {
                            System.out.println("Value "+nPlace1+""+nPlace2+""+nPlace3+""+nPlace4+" will remain the same for the last 4 digits of n^2\n"+nPlace1+""+nPlace2+""+nPlace3+""+nPlace4+" = "+nSquared);
                        }
                    }
                }
            }
        }
        
        System.out.println("\nPuzzle #3 is complete!");
    }
}
