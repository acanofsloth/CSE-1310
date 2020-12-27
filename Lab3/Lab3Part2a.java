/*
 * CSE1310-005 Lab 3 Part 2a
 */
package lab3part2a;

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
public class Lab3Part2a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String newFileName = "robotInfoL3.txt";
        String robotName; 
        int robotYear; 
        String robotKind; 
        char robotSource; 
        String robotCost; 
        String robotSourceTitle;
        
        Scanner inputFile;
        File inFile = new File(newFileName);
        try  // This is to handle the possible error of a file not being found
        {
            inputFile = new Scanner(inFile);
            System.out.println("File found\n");
        }
        catch (FileNotFoundException fnfe)
        {
            inputFile = new Scanner(System.in);
            System.out.println("Input file " + newFileName + " not found");
        }
        
        while(inputFile.hasNext())
        {
            robotName = inputFile.next();

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
            
            robotKind = inputFile.next();
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
            robotCost = inputFile.next(); 
            robotSourceTitle = inputFile.nextLine();
            System.out.println("Robot Name: " + robotName);
            System.out.println("Year: " + robotYear);
            System.out.println("Category: " + robotKind);
            System.out.println("Source: " + robotSource);
            System.out.println("Cost: " + robotCost);
            System.out.println("Source Title: " + robotSourceTitle + "\n");
        }
    }
    
}
