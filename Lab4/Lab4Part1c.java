/*
 * CSE1310-005 Lab 4 Part 1c
 */
package lab4part1c;

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
public class Lab4Part1c 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String newFileName = "robotsInfoHW.txt";
        String newOutFile = "Lab4Part1c.out";
        String robotName; 
        int robotYear; 
        String robotKind; 
        char robotSource; 
        String robotCost; 
        String robotSourceTitle;
        
        final int robotAmountMax = 30;
        int count = 0;
        int run;
        
        int [][] RobotInt2D = new int[robotAmountMax][2];
        double [][] RobotDouble2D = new double[robotAmountMax][3];
        char [][] RobotChar2D = new char[robotAmountMax][2];
        String [][] RobotString2D = new String[robotAmountMax][5];
        
        final int iName = 0, iCategory = 1, iTitle = 2, iActor = 3, iCost = 4, iYear = 0, iCostValue = 1, iSource = 0, iImplemented = 1, iCostd = 0, iHeight = 1, iWeight = 2;
        
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
            RobotString2D[count][iName] = robotName;

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
            RobotInt2D[count][iYear] = robotYear;
            robotKind = inputFile.next();
            RobotString2D[count][iCategory] = robotKind;
            robotSourceTitle = inputFile.next();
            robotSource = robotSourceTitle.charAt(0);
            if(robotSource == 'M' || robotSource == 'B' || robotSource == 'R' || robotSource == 'P' || robotSource == 'T')
            {
                RobotChar2D[count][iSource] = robotSourceTitle.charAt(0);
                robotCost = inputFile.next(); 
                RobotString2D[count][iCost] = robotCost;   
            }
            else
            {
                System.out.println("\n-- Input Source value " + robotName + " was not valid");
                OutFile.println("\n-- Input Source value " + robotName + " was not valid");
                RobotChar2D[count][iSource] = 'X';
                RobotString2D[count][iCost] = robotSourceTitle;  
            }
            robotSourceTitle = inputFile.nextLine();
            RobotString2D[count][iTitle] = robotSourceTitle;           
            System.out.println("\nRobot Name: " + RobotString2D[count][iName]);
            OutFile.println("\nRobot Name: " + RobotString2D[count][iName]);
            System.out.println("Year: " + RobotInt2D[count][iYear]);
            OutFile.println("Year: " + RobotInt2D[count][iYear]);
            System.out.println("Category: " + RobotString2D[count][iCategory]);
            OutFile.println("Category: " + RobotString2D[count][iCategory]);
            System.out.println("Source: " + RobotChar2D[count][iSource]);
            OutFile.println("Source: " + RobotChar2D[count][iSource]);
            System.out.println("Cost: " + RobotString2D[count][iCost]);
            OutFile.println("Cost: " + RobotString2D[count][iCost]);
            System.out.println("Source Title: " + RobotString2D[count][iTitle]);
            OutFile.println("Source Title: " + RobotString2D[count][iTitle]);
            count++;
        }
        for(int loc = 0; loc < count;loc++)
        {
            System.out.print("\n" + RobotString2D[loc][iName] + " is a robot "); 
            OutFile.print("\n" + RobotString2D[loc][iName] + " is a robot ");
            if(RobotInt2D[loc][iYear] > 0)
            {
                System.out.print("introduced in " + RobotInt2D[loc][iYear] + " ");
                OutFile.print("introduced in " + RobotInt2D[loc][iYear] + " ");
            }
            else
            {
                System.out.print("was introduced in (invalid years) ");
                OutFile.print("was introduced in (invalid years) ");
            }
            System.out.print("and is a " + RobotChar2D[loc][iSource] + " robot ");
            OutFile.print("and is a " + RobotChar2D[loc][iSource] + " robot ");
            switch(RobotChar2D[loc][iSource])
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
            System.out.print(RobotString2D[loc][iTitle]);
            OutFile.print(RobotString2D[loc][iTitle]);
            System.out.println(" That cost " + RobotString2D[loc][iCost] + ".");
            OutFile.println(" That cost " + RobotString2D[loc][iCost] + ".");
        }
        for(int loc = 0;loc < count;loc++)
        {
            robotKind = RobotString2D[loc][iCategory];
            RobotString2D[loc][iCategory] = robotKind.substring(0, 1).toUpperCase() + robotKind.substring(1);
            System.out.print("\n" + RobotString2D[loc][iCategory] + " robot ");
            OutFile.print("\n" + RobotString2D[loc][iCategory] + " robot ");
            System.out.print((loc+1) + ": ");
            OutFile.print((loc+1) + ": ");
            System.out.print(RobotString2D[loc][iName] + " debuted ");
            OutFile.print(RobotString2D[loc][iName] + " debuted ");
            System.out.print(RobotInt2D[loc][iYear] + " in ");
            OutFile.print(RobotInt2D[loc][iYear] + " in ");
            switch(RobotChar2D[loc][iSource])
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
            System.out.print(" \"" + RobotString2D[loc][iTitle] + "\"");
            OutFile.print(" \"" + RobotString2D[loc][iTitle] + "\"");
            System.out.print(" at the cost of " + RobotString2D[loc][iCost]);
            OutFile.print(" at the cost of " + RobotString2D[loc][iCost]);
        }
        
        System.out.println("\n");
        OutFile.println("\n");
        
        for(int loc = 0; loc < count;loc++)
        {
            robotCost = RobotString2D[loc][iCost];
            if(2 == RobotString2D[loc][iCost].length())
            {
                if(RobotString2D[loc][iCost].indexOf("K") > 0)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,1));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("M") > 0)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,1));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("B") > 0)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,1));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
            }
            if(3 == RobotString2D[loc][iCost].length())
            {
                if(RobotString2D[loc][iCost].indexOf("K") > 0)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,2));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("M") > 0)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,2));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("B") > 0)
                {
                    RobotString2D[loc][iCost] = robotCost.substring(0,2);
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,2));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
            }
            if(4 == RobotString2D[loc][iCost].length())
            {
                if(RobotString2D[loc][iCost].indexOf("K") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,3));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("M") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,3));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("B") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,3));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                
            }
            if(5 == RobotString2D[loc][iCost].length())
            {
                if(RobotString2D[loc][iCost].indexOf("K") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,4));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("M") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,4));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
                if(RobotString2D[loc][iCost].indexOf("B") > 1)
                {
                    RobotDouble2D[loc][iCostd] = Double.parseDouble(robotCost.substring(0,4));
                    RobotDouble2D[loc][iCostd] = RobotDouble2D[loc][iCostd]*1000000000;
                    RobotInt2D[loc][iCostValue] = (int) RobotDouble2D[loc][iCostd];
                }
            }
            
        }
        
        RoboTable(RobotString2D, RobotInt2D, RobotDouble2D, RobotChar2D, count, newOutFile); 
        
        for(int loc = 0;loc < count;loc++)
        {
            System.out.print("\n" + RobotString2D[loc][iCategory] + " robot ");
            OutFile.print("\n" + RobotString2D[loc][iCategory] + " robot ");
            System.out.print((loc+1) + ": ");
            OutFile.print((loc+1) + ": "); 
            System.out.print(RobotString2D[loc][iName] + " debuted ");
            OutFile.print(RobotString2D[loc][iName] + " debuted ");
            System.out.print(RobotInt2D[loc][iYear] + " in ");
            OutFile.print(RobotInt2D[loc][iYear] + " in ");
            switch(RobotChar2D[loc][iSource])
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
            System.out.print(" \"" + RobotString2D[loc][iTitle] + "\"");
            OutFile.print(" \"" + RobotString2D[loc][iTitle] + "\"");
            System.out.print(" at the cost of $" + RobotInt2D[loc][iCostValue]);
            OutFile.print(" at the cost of $" + RobotInt2D[loc][iCostValue]);
        }
        System.out.println("");
        OutFile.println("");
        
        int temp;
        double tempd;
        for(int d = 0; d < count;d++)
        {
            for(int i = 1; i < (count-d);i++)
            {
                if(RobotInt2D[i-1][iCostValue] > RobotInt2D[i][iCostValue])
                {
                    temp = RobotInt2D[i][iCostValue];
                    RobotInt2D[i][iCostValue] = RobotInt2D[i-1][iCostValue];
                    RobotInt2D[i-1][iCostValue] = temp;
                    
                    tempd = RobotDouble2D[i][iCostd];
                    RobotDouble2D[i][iCostd] = RobotDouble2D[i-1][iCostd];
                    RobotDouble2D[i-1][iCostd] = tempd;
                    
                    robotName = RobotString2D[i][iName];
                    RobotString2D[i][iName] = RobotString2D[i-1][iName];
                    RobotString2D[i-1][iName] = robotName;                           
                    
                    robotYear = RobotInt2D[i][iYear];
                    RobotInt2D[i][iYear] = RobotInt2D[i-1][iYear];
                    RobotInt2D[i-1][iYear] = robotYear; 
                    
                    robotKind = RobotString2D[i][iCategory];
                    RobotString2D[i][iCategory] = RobotString2D[i-1][iCategory];
                    RobotString2D[i-1][iCategory] = robotKind;
                    
                    robotSource = RobotChar2D[i][iSource];
                    RobotChar2D[i][iSource] = RobotChar2D[i-1][iSource];
                    RobotChar2D[i-1][iSource] = robotSource;
                    
                    robotCost = RobotString2D[i][iCost];
                    RobotString2D[i][iCost] = RobotString2D[i-1][iCost];
                    RobotString2D[i-1][iCost] = robotCost;
                    
                    robotSourceTitle = RobotString2D[i][iTitle];
                    RobotString2D[i][iTitle] = RobotString2D[i-1][iTitle];
                    RobotString2D[i-1][iTitle] = robotSourceTitle;
                }
            }
        }
        System.out.println("");
        OutFile.println("");
        RoboTable(RobotString2D, RobotInt2D, RobotDouble2D, RobotChar2D, count, newOutFile);

        }
    }
    
    public static void RoboTable(String RobotString2D[][], int RobotInt2D[][], double RobotDouble2D[][], char RobotChar2D[][] , int count, String newOutFile) throws FileNotFoundException
    {
        PrintWriter OutFile = new PrintWriter(newOutFile);
        System.out.println("Table of Robot Info");
        OutFile.println("Table of Robot Info");
        OutFile.println("Table of Robot Info");
        int nl = 15; // name length
        int catl = 19; // category length
        int titlel = 36; // title length
        int tempargmt = 30; // title has not been split, so for prettynes I will add space to make decimals readable
        String vname = "NAME";
        String vyear = "YEAR";
        String vcost = "COST";
        String vsource = "SOURCE";
        String vcat = "CATEGORY";
        String vtitle = "TITLE";
        String vdecimal = "DECIMAL";
        final int iName = 0, iCategory = 1, iTitle = 2, iActor = 3, iCost = 4, iYear = 0, iCostValue = 1, iSource = 0, iImplemented = 1, iCostd = 0, iHeight = 1, iWeight = 2;
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
        System.out.print(vtitle);
        OutFile.print(vtitle);
        for(int c = 0; c < (titlel-vtitle.length()+tempargmt);c++)
        {
            System.out.print(" ");
            OutFile.print(" ");
        }
        System.out.println(vdecimal);
        OutFile.println(vdecimal);
        for(int loc = 0; loc < count;loc++) //start for data inputs
        {
            for(int c = 0;c < (nl-RobotString2D[loc][iName].length());c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(RobotString2D[loc][iName]);
            OutFile.print(RobotString2D[loc][iName]);
            for(int c = 0; c < 2;c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(RobotInt2D[loc][iYear]);
            OutFile.print(RobotInt2D[loc][iYear]);
            for(int c = 0;c < 3;c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            switch(RobotString2D[loc][iCost].length())
            {
                case 5:
                    System.out.print(RobotString2D[loc][iCost]);
                    OutFile.print(RobotString2D[loc][iCost]);
                    System.out.print(" ");
                    OutFile.print(" ");
                    System.out.print(RobotChar2D[loc][iSource]);
                    OutFile.print(RobotChar2D[loc][iSource]);
                    break;
                case 4:
                    System.out.print(RobotString2D[loc][iCost]);
                    OutFile.print(RobotString2D[loc][iCost]);
                    for(int c = 0; c < 2;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(RobotChar2D[loc][iSource]);
                    OutFile.print(RobotChar2D[loc][iSource]);
                    break;
                case 3:
                    System.out.print(RobotString2D[loc][iCost]);
                    OutFile.print(RobotString2D[loc][iCost]);
                    for(int c = 0; c < 3;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(RobotChar2D[loc][iSource]);
                    OutFile.print(RobotChar2D[loc][iSource]);
                    break;
                case 2:
                    System.out.print(RobotString2D[loc][iCost]);
                    OutFile.print(RobotString2D[loc][iCost]);
                    for(int c = 0; c < 4;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
                    System.out.print(RobotChar2D[loc][iSource]);
                    OutFile.print(RobotChar2D[loc][iSource]);
                    break;
                default:
                    System.out.print(RobotString2D[loc][iCost]);
                    OutFile.print(RobotString2D[loc][iCost]);
                    for(int c = 0; c < 6;c++)
                    {
                        System.out.print(" ");
                        OutFile.print(" ");
                    }
            }
            for(int c = 0;c < (catl-RobotString2D[loc][iCategory].length()+5);c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.print(RobotString2D[loc][iCategory]);
            OutFile.print(RobotString2D[loc][iCategory]);
            System.out.print(" " +RobotString2D[loc][iTitle]);
            OutFile.print(" " +RobotString2D[loc][iTitle]);
            for(int c = 0;c < (titlel-RobotString2D[loc][iTitle].length()+tempargmt);c++)
            {
                System.out.print(" ");
                OutFile.print(" ");
            }
            System.out.println(" "+RobotDouble2D[loc][iCostd]);
            OutFile.println(" "+RobotDouble2D[loc][iCostd]);
        }
        
    }
    
}
