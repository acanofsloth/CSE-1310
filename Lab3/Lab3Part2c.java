/*
 * CSE1310-005 Lab 3 Part 2c
 */
package lab3part2c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Martinez Ivan
 * UTA Fall 2019
 * @author marti
 */
public class Lab3Part2c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String newFileName = "robotInfoL3.txt";
        String robotName; 
        int robotYear; 
        String robotKind; 
        char robotSource; 
        String robotCost; 
        String robotSourceTitle;
        
        final int robotAmountMax = 30;
        int count = 0;
        
        String[] RrobotName = new String[robotAmountMax];
        int[] RrobotYear = new int[robotAmountMax];
        String[] RrobotKind = new String[robotAmountMax];
        char[] RrobotSource = new char[robotAmountMax];
        String[] RrobotCost = new String[robotAmountMax];
        String[] RrobotSourceTitle = new String[robotAmountMax];
        
        Scanner inputFile;
        File inFile = new File(newFileName);
        try  // This is to handle the possible error of a file not being found
        {
            inputFile = new Scanner(inFile);
            System.out.println("File found");
        }
        catch (FileNotFoundException fnfe)
        {
            inputFile = new Scanner(System.in);
            System.out.println("Input file " + newFileName + " not found");
        }
        
        while(inputFile.hasNext())
        {
            robotName = inputFile.next();
            RrobotName[count] = robotName;

            try
            {
                robotYear = inputFile.nextInt();  
            }
            catch (InputMismatchException ime)
            {
                robotYear = -1;
                robotName = inputFile.next();
                System.out.println("\n-- Input year value " + robotName + " was not valid");
            }
            catch (NoSuchElementException nsee)
            {
                robotYear = 0;
                System.out.println("\n-- Missing input data");
            }
            RrobotYear[count] = robotYear;
            robotKind = inputFile.next();
            RrobotKind[count] = robotKind;
            try
            {
                robotSource = inputFile.next().charAt(0); 
            }
            catch (InputMismatchException ime)
            {
                robotSource = 'N';
                robotName = inputFile.next();
                System.out.println("\n-- Input Source value " + robotName + " was not valid");
            }
            catch (NoSuchElementException nsee)
            {
                robotSource = 'Z';
                System.out.println("\n-- Missing input data");
            }
            RrobotSource[count] = robotSource;
            robotCost = inputFile.next(); 
            RrobotCost[count] = robotCost;
            robotSourceTitle = inputFile.nextLine();
            RrobotSourceTitle[count] = robotSourceTitle;           
            System.out.println("\nRobot Name: " + RrobotName[count]);
            System.out.println("Year: " + RrobotYear[count]);
            System.out.println("Category: " + RrobotKind[count]);
            System.out.println("Source: " + RrobotSource[count]);
            System.out.println("Cost: " + RrobotCost[count]);
            System.out.println("Source Title: " + RrobotSourceTitle[count]);
            count++;
        }
        for(int loc = 0; loc < count;loc++)
        {
            System.out.print("\n" + RrobotName[loc] + " is a robot "); 
            if(RrobotYear[loc] > 0)
            {
                System.out.print("introduced in " + RrobotYear[loc] + " ");
            }
            else
            {
                System.out.print("was introduced in (invalid years) ");
            }
            System.out.print("and is a " + RrobotKind[loc] + " robot ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("in the book of");
                    break;
                case 'M':
                    System.out.print("in the movie of");
                    break;
                case 'P':
                    System.out.print("in the play of");
                    break;
                case 'R':
                    System.out.print("in real life at");
                    break;
                case 'T':
                    System.out.print("on TV show of");
                    break;
                default:
                    System.out.print("in the (Invalid Source) of");
            }
            System.out.print(RrobotSourceTitle[loc]);
            System.out.println(" That cost " + RrobotCost[loc] + ".");
        }
    }
    
}
