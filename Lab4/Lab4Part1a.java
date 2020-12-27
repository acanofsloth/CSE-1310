/*
 * CSE1310-005 Lab 4 Part 1a
 */
package lab4part1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Ivan Martinez
 * UTA Fall 2019
 * @author marti
 */
public class Lab4Part1a 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String newFileName = "robotsInfoHW.txt";
        String newOutFile = "Lab4Part1a.out";
        String robotName; 
        int robotYear; 
        String robotKind; 
        char robotSource; 
        String robotCost; 
        String robotSourceTitle;
        
        final int robotAmountMax = 30;
        int count = 0;
        int run;
        
        String[] RrobotName = new String[robotAmountMax];
        int[] RrobotYear = new int[robotAmountMax];
        String[] RrobotKind = new String[robotAmountMax];
        char[] RrobotSource = new char[robotAmountMax];
        String[] RrobotCost = new String[robotAmountMax];
        String[] RrobotSourceTitle = new String[robotAmountMax];
        PrintWriter OutFile = new PrintWriter(newOutFile); 
        Scanner inputFile;
        File inFile = new File(newFileName);
        try  // This is to handle the possible error of a file not being found
        {
            inputFile = new Scanner(inFile);
            System.out.println("File found");
            OutFile.println("File found");
            run = 1;
        }
        catch (FileNotFoundException fnfe)
        {
            inputFile = new Scanner(System.in);
            System.out.println("Input file " + newFileName + " not found");
            OutFile.println("Input file " + newFileName + " not found");
            run = 0;
        }
        
        if(run == 1)
        {
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
                System.out.println("\n-- Input year value " + robotName + " was not valid");
                OutFile.println("\n-- Input year value " + robotName + " was not valid");
            }
            catch (NoSuchElementException nsee)
            {
                robotYear = 0;
                System.out.println("\n-- Missing input data");
                OutFile.println("\n-- Missing input data");
            }
            RrobotYear[count] = robotYear;
            robotKind = inputFile.next();
            RrobotKind[count] = robotKind;
            robotSourceTitle = inputFile.next();
            robotSource = robotSourceTitle.charAt(0);
            if(robotSource == 'M' || robotSource == 'B' || robotSource == 'R' || robotSource == 'P' || robotSource == 'T')
            {
                RrobotSource[count] = robotSourceTitle.charAt(0);
                robotCost = inputFile.next(); 
                RrobotCost[count] = robotCost;   
            }
            else
            {
                System.out.println("\n-- Input Source value " + robotName + " was not valid");
                OutFile.println("\n-- Input Source value " + robotName + " was not valid");
                RrobotSource[count] = 'X';
                RrobotCost[count] = robotSourceTitle;  
            }
            robotSourceTitle = inputFile.nextLine();
            RrobotSourceTitle[count] = robotSourceTitle;           
            System.out.println("\nRobot Name: " + RrobotName[count]);
            OutFile.println("\nRobot Name: " + RrobotName[count]);
            System.out.println("Year: " + RrobotYear[count]);
            OutFile.println("Year: " + RrobotYear[count]);
            System.out.println("Category: " + RrobotKind[count]);
            OutFile.println("Category: " + RrobotKind[count]);
            System.out.println("Source: " + RrobotSource[count]);
            OutFile.println("Source: " + RrobotSource[count]);
            System.out.println("Cost: " + RrobotCost[count]);
            OutFile.println("Cost: " + RrobotCost[count]);
            System.out.println("Source Title: " + RrobotSourceTitle[count]);
            OutFile.println("Source Title: " + RrobotSourceTitle[count]);
            count++;
        }
        for(int loc = 0; loc < count;loc++)
        {
            System.out.print("\n" + RrobotName[loc] + " is a robot "); 
            OutFile.print("\n" + RrobotName[loc] + " is a robot ");
            if(RrobotYear[loc] > 0)
            {
                System.out.print("introduced in " + RrobotYear[loc] + " ");
                OutFile.print("introduced in " + RrobotYear[loc] + " ");
            }
            else
            {
                System.out.print("was introduced in (invalid years) ");
                OutFile.print("was introduced in (invalid years) ");
            }
            System.out.print("and is a " + RrobotKind[loc] + " robot ");
            OutFile.print("and is a " + RrobotKind[loc] + " robot ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("in the book of");
                    OutFile.print("in the book of");
                    break;
                case 'M':
                    System.out.print("in the movie of");
                    OutFile.print("in the movie of");
                    break;
                case 'P':
                    System.out.print("in the play of");
                    OutFile.print("in the play of");
                    break;
                case 'R':
                    System.out.print("in real life at");
                    OutFile.print("in real life at");
                    break;
                case 'T':
                    System.out.print("on TV show of");
                    OutFile.print("on TV show of");
                    break;
                default:
                    System.out.print("in the (Invalid Source) of");
                    OutFile.print("in the (Invalid Source) of");
            }
            System.out.print(RrobotSourceTitle[loc]);
            OutFile.print(RrobotSourceTitle[loc]);
            System.out.println(" That cost " + RrobotCost[loc] + ".");
            OutFile.println(" That cost " + RrobotCost[loc] + ".");
        }
        for(int loc = 0;loc < count;loc++)
        {
            robotKind = RrobotKind[loc];
            RrobotKind[loc] = robotKind.substring(0, 1).toUpperCase() + robotKind.substring(1);
            System.out.print("\n" + RrobotKind[loc] + " robot ");
            OutFile.print("\n" + RrobotKind[loc] + " robot ");
            System.out.print((loc+1) + ": ");
            OutFile.print((loc+1) + ": ");
            System.out.print(RrobotName[loc] + " debuted ");
            OutFile.print(RrobotName[loc] + " debuted ");
            System.out.print(RrobotYear[loc] + " in ");
            OutFile.print(RrobotYear[loc] + " in ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("the book");
                    OutFile.print("the book");
                    break;
                case 'M':
                    System.out.print("the movie");
                    OutFile.print("the movie");
                    break;
                case 'P':
                    System.out.print("the play");
                    OutFile.print("the play");
                    break;
                case 'R':
                    System.out.print("real life from");
                    OutFile.print("real life from");
                    break;
                case 'T':
                    System.out.print("the TV show");
                    OutFile.print("the TV show");
                    break;
                default:
                    System.out.print("in the (Invalid Source)");
                    OutFile.print("in the (Invalid Source)");
            }
            System.out.print(" \"" + RrobotSourceTitle[loc] + "\"");
            OutFile.print(" \"" + RrobotSourceTitle[loc] + "\"");
            System.out.print(" at the cost of " + RrobotCost[loc]);
            OutFile.print(" at the cost of " + RrobotCost[loc]);
        }
        
        System.out.println("\n");
        OutFile.println("\n");
        
        RoboTable(RrobotName, RrobotYear, RrobotCost, RrobotSource, RrobotSourceTitle, RrobotKind, count, newOutFile);
        double [] robotCostValue = new double[robotAmountMax];
        for(int loc = 0; loc < count;loc++)
        {
            robotCost = RrobotCost[loc];
            if(2 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 0)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,1));
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 0)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,1));
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 0)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,1));
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
            if(3 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 0)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,2));
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 0)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,2));
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 0)
                {
                    RrobotCost[loc] = robotCost.substring(0,2);
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,2));
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
            if(4 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,3));
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,3));
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,3));
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
                
            }
            if(5 == RrobotCost[loc].length())
            {
                if(RrobotCost[loc].indexOf("K") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,4));
                    robotCostValue[loc] = robotCostValue[loc]*1000;
                }
                if(RrobotCost[loc].indexOf("M") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,4));
                    robotCostValue[loc] = robotCostValue[loc]*1000000;
                }
                if(RrobotCost[loc].indexOf("B") > 1)
                {
                    robotCostValue[loc] = Double.parseDouble(robotCost.substring(0,4));
                    robotCostValue[loc] = robotCostValue[loc]*1000000000;
                }
            }
        }
        for(int loc = 0;loc < count;loc++)
        {
            System.out.print("\n" + RrobotKind[loc] + " robot ");
            OutFile.print("\n" + RrobotKind[loc] + " robot ");
            System.out.print((loc+1) + ": ");
            OutFile.print((loc+1) + ": ");
            System.out.print(RrobotName[loc] + " debuted ");
            OutFile.print(RrobotName[loc] + " debuted ");
            System.out.print(RrobotYear[loc] + " in ");
            OutFile.print(RrobotYear[loc] + " in ");
            switch(RrobotSource[loc])
            {
                case 'B': 
                    System.out.print("the book");
                    OutFile.print("the book");
                    break;
                case 'M':
                    System.out.print("the movie");
                    OutFile.print("the movie");
                    break;
                case 'P':
                    System.out.print("the play");
                    OutFile.print("the play");
                    break;
                case 'R':
                    System.out.print("real life from");
                    OutFile.print("real life from");
                    break;
                case 'T':
                    System.out.print("the TV show");
                    OutFile.print("the TV show");
                    break;
                default:
                    System.out.print("in the (Invalid Source)");
                    OutFile.print("in the (Invalid Source)");
            }
            System.out.print(" \"" + RrobotSourceTitle[loc] + "\"");
            OutFile.print(" \"" + RrobotSourceTitle[loc] + "\"");
            System.out.print(" at the cost of $" + robotCostValue[loc]);
            OutFile.print(" at the cost of $" + robotCostValue[loc]);
        }
        System.out.println("");
        OutFile.println("");
        
        double temp;
        for(int d = 0; d < count;d++)
        {
            for(int i = 1; i < (count-d);i++)
            {
                if(robotCostValue[i-1] > robotCostValue[i])
                {
                    temp = robotCostValue[i];
                    robotCostValue[i] = robotCostValue[i-1];
                    robotCostValue[i-1] = temp;
                    
                    robotName = RrobotName[i];
                    RrobotName[i] = RrobotName[i-1];
                    RrobotName[i-1] = robotName;                           
                    
                    robotYear = RrobotYear[i];
                    RrobotYear[i] = RrobotYear[i-1];
                    RrobotYear[i-1] = robotYear;
                    
                    robotKind = RrobotKind[i];
                    RrobotKind[i] = RrobotKind[i-1];
                    RrobotKind[i-1] = robotKind;
                    
                    robotSource = RrobotSource[i];
                    RrobotSource[i] = RrobotSource[i-1];
                    RrobotSource[i-1] = robotSource;
                    
                    robotCost = RrobotCost[i];
                    RrobotCost[i] = RrobotCost[i-1];
                    RrobotCost[i-1] = robotCost;
                    
                    robotSourceTitle = RrobotSourceTitle[i];
                    RrobotSourceTitle[i] = RrobotSourceTitle[i-1];
                    RrobotSourceTitle[i-1] = robotSourceTitle;
                }
            }
        }
        System.out.println("");
        OutFile.println("");
        RoboTable(RrobotName, RrobotYear, RrobotCost, RrobotSource, RrobotSourceTitle, RrobotKind, count, newOutFile);
        }
    }
    
    public static void RoboTable(String [] Name, int [] Year, String [] Cost, char [] Source, String [] Title, String [] Cat, int count, String newOutFile) throws FileNotFoundException
    {
        PrintWriter OutFile = new PrintWriter(newOutFile);
        System.out.println("Table of Robot Info");
        OutFile.println("Table of Robot Info");
        OutFile.println("Table of Robot Info");
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
            OutFile.print(" ");
        }
        System.out.print(vname);
        OutFile.print(vname);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.print(vyear);
        OutFile.print(vyear);
        for(int c = 0;c < 3;c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.print(vcost);
        OutFile.print(vcost);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.print(vsource);
        OutFile.print(vsource);
        for(int c = 0;c < (catl-vcat.length());c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.print(vcat);
        OutFile.print(vcat);
        for(int c = 0;c < 2;c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.println(vtitle);
        OutFile.println(vtitle);
        for(int loc = 0; loc < count;loc++) //start for data inputs
        {
            for(int c = 0;c < (nl-Name[loc].length());c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(Name[loc]);
            OutFile.print(Name[loc]);
            for(int c = 0; c < 2;c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(Year[loc]);
            OutFile.print(Year[loc]);
            for(int c = 0;c < 3;c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            switch(Cost[loc].length())
            {
                case 5:
                    System.out.print(Cost[loc]);
                    OutFile.print(Cost[loc]);
                    System.out.print(" ");
                    OutFile.print(" ");
                    System.out.print(Source[loc]);
                    OutFile.print(Source[loc]);
                    break;
                case 4:
                    System.out.print(Cost[loc]);
                    OutFile.print(Cost[loc]);
                    for(int c = 0; c < 2;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(Source[loc]);
                    OutFile.print(Source[loc]);
                    break;
                case 3:
                    System.out.print(Cost[loc]);
                    OutFile.print(Cost[loc]);
                    for(int c = 0; c < 3;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(Source[loc]);
                    OutFile.print(Source[loc]);
                    break;
                case 2:
                    System.out.print(Cost[loc]);
                    OutFile.print(Cost[loc]);
                    for(int c = 0; c < 4;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(Source[loc]);
                    OutFile.print(Source[loc]);
                    break;
                default:
                    System.out.print(Cost[loc]);
                    OutFile.print(Cost[loc]);
                    for(int c = 0; c < 6;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
            }
            for(int c = 0;c < (catl-Cat[loc].length()+5);c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(Cat[loc]);
            OutFile.print(Cat[loc]);
            System.out.println(" " +Title[loc]);
            OutFile.println(" " +Title[loc]);
        }
        
    }
    
}
