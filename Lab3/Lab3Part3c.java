/*
 * CSE1310-005 Lab 3 Part 3c
*/
package lab3part3c;

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
public class Lab3Part3c 
{
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
        for(int loc = 0;loc < count;loc++)
        {
            robotKind = RrobotKind[loc];
            RrobotKind[loc] = robotKind.substring(0, 1).toUpperCase() + robotKind.substring(1);
            System.out.print("\n" + RrobotKind[loc] + " robot ");
            System.out.print((loc+1) + ": ");
            System.out.print(RrobotName[loc] + " debuted ");
            System.out.print(RrobotYear[loc] + " in ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("the book");
                    break;
                case 'M':
                    System.out.print("the movie");
                    break;
                case 'P':
                    System.out.print("the play");
                    break;
                case 'R':
                    System.out.print("real life from");
                    break;
                case 'T':
                    System.out.print("the TV show");
                    break;
                default:
                    System.out.print("in the (Invalid Source)");
            }
            System.out.print(" \"" + RrobotSourceTitle[loc] + "\"");
            System.out.print(" at the cost of " + RrobotCost[loc]);
        }
        
        System.out.println("\n");
        RoboTable(RrobotName, RrobotYear, RrobotCost, RrobotSource, RrobotSourceTitle, RrobotKind, count);
        double [] robotCostValue = new double[robotAmountMax];
        for(int loc = 0; loc < count;loc++)
        {
            robotCost = RrobotCost[loc];
            if(2 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 0)
                {
                    RrobotCost[loc] = robotCost.substring(0,1);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 0)
                {
                    RrobotCost[loc] = robotCost.substring(0,1);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 0)
                {
                    RrobotCost[loc] = robotCost.substring(0,1);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
            if(3 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,2);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,2);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,2);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
            if(4 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,3);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,3);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 1)
                {
                    RrobotCost[loc] = robotCost.substring(0,3);
                    robotCostValue[loc] = Double.parseDouble(RrobotCost[loc]);
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
        }
        for(int loc = 0;loc < count;loc++)
        {
            System.out.print("\n" + RrobotKind[loc] + " robot ");
            System.out.print((loc+1) + ": ");
            System.out.print(RrobotName[loc] + " debuted ");
            System.out.print(RrobotYear[loc] + " in ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("the book");
                    break;
                case 'M':
                    System.out.print("the movie");
                    break;
                case 'P':
                    System.out.print("the play");
                    break;
                case 'R':
                    System.out.print("real life from");
                    break;
                case 'T':
                    System.out.print("the TV show");
                    break;
                default:
                    System.out.print("in the (Invalid Source)");
            }
            System.out.print(" \"" + RrobotSourceTitle[loc] + "\"");
            System.out.print(" at the cost of $" + robotCostValue[loc]);
        }
        System.out.println("");
        
    }
    
    public static void RoboTable(String [] Name, int [] Year, String [] Cost, char [] Source, String [] Title, String [] Cat, int count)
    {
        System.out.println("Table of Robot Info");
        int nl = 15; // name length
        int catl = 19; // category length
        String vname = "NAME";
        String vyear = "YEAR";
        String vcost = "COST";
        String vsource = "SOURCE";
        String vcat = "CATEGORY";
        String vtitle = "TITLE";
        for(int c = 0;c < (nl-vname.length());c++) //start for title
        {
            System.out.print(" ");
        }
        System.out.print(vname);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
        }
        System.out.print(vyear);
        for(int c = 0;c < 3;c++)
        {
            System.out.print(" ");
        }
        System.out.print(vcost);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
        }
        System.out.print(vsource);
        for(int c = 0;c < (catl-vcat.length());c++)
        {
            System.out.print(" ");
        }
        System.out.print(vcat);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
        }
        System.out.println(vtitle);
        for(int loc = 0; loc < count;loc++) //start for data inputs
        {
            for(int c = 0;c < (nl-Name[loc].length());c++)
            {
                System.out.print(" ");
            }
            System.out.print(Name[loc]);
            for(int c = 0; c < 2;c++)
            {
                System.out.print(" ");
            }
            System.out.print(Year[loc]);
            for(int c = 0;c < 3;c++)
            {
                System.out.print(" ");
            }
            switch(Cost[loc].length())
            {
                case 4:
                    System.out.print(Cost[loc]);
                    for(int c = 0; c < 2;c++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(Source[loc]);
                    break;
                case 3:
                    System.out.print(Cost[loc]);
                    for(int c = 0; c < 3;c++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(Source[loc]);
                    break;
                case 2:
                    System.out.print(Cost[loc]);
                    for(int c = 0; c < 4;c++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(Source[loc]);
                    break;
                default:
                    System.out.print(Cost[loc]);
                    for(int c = 0; c < 6;c++)
                    {
                        System.out.print(" ");
                    }
            }
            for(int c = 0;c < (catl-Cat[loc].length()+5);c++)
            {
                System.out.print(" ");
            }
            System.out.print(Cat[loc]);
            for(int c = 0; c < 2;c++)
            {
                System.out.print(" ");
            }
            System.out.println(Title[loc]);
        }
        
    }
    
}
