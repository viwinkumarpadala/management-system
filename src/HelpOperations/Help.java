/*
    Objective: Contains all the Helper functions and printHelp functions 
*/

package HelpOperations;
public class Help {
    // This method prints all the help
    public static void printAllHelp(){
        System.out.println("Try to access something for help like: \n");
        System.out.println("-create -help: (For help in creating vehicle in various ways)");
        System.out.println("-update -help: (For help in updating vehicle in various ways)");
        System.out.println("-delete -help: (For help in deleting vehicle in various ways)");
        System.out.println("-search -help: (For help in deleting vehicle in various ways)");
        System.out.println("-sort -help: (For help in printing vehicle in various ways)\n\n");
        System.out.println("-h for entire command list\n-v for version of the program\n-credits for the people contributed to the program\n");
    }

    public static void printCreateHelp(){
        System.out.println("Creation Help: ---------\n");
        System.out.println("Command Line Manual Vehicle creation:");
        System.out.println("-create: \n-b for bike, -c for car and -a for auto followed by attributes:");
        System.out.println("model price onroadInterest milege engineNumber dateofMan\n\n"); 
        System.out.println("CSV Vehicle creation:");
        System.out.println("Simply enter: -create -b (Takes from bike.csv)\n-----------\n\n");
    }

    public static void printDeleteHelp(){
        System.out.println("Deletion Help: ---------\n");
        System.out.println("Command Line Manual Vehicle deletion:");
        System.out.println("-delete: \n-b for bike, -c for car and -a for auto followed by any of attributes with the value:");
        System.out.println("m(model) p(price) ori(onroadInterest) mil(milege) en(engineNumber) dom(dateofMan)\n\n"); 
        System.out.println("CSV Vehicle deletion:");
        System.out.println("Enter the engineNumber in the .csv you want to delete and give -delete -x\n\n");
        System.out.println("Complete truncation: \ngive -delete -x -all for truncating table and clearing .csv\n---------------------\n\n");

    }

    public static void printUpdateHelp(){
        System.out.println("Updation Help: ---------\n");
        System.out.println("Command Line Manual Vehicle Updation:");
        System.out.println("-update: \n-b for bike, -c for car and -a for auto followed by newAttibute newVal where OldAttribute OldVal from attributes:");
        System.out.println("m(model) p(price) ori(onroadInterest) mil(milege) en(engineNumber) dom(dateofMan)\n\n"); 
        System.out.println("CSV Vehicle updation:");
        System.out.println("Enter a new vehicle in .csv with the same engineNumber, and give the command: -update -x\n-----------\n\n");
    }

    public static void printSortHelp(){
        System.out.println("Sort Help: ---------\n");
        System.out.println("Command Line Manual Vehicle Sort:");
        System.out.println("-sort -x attibute o (where o -> i for increasing order and o -> d for decreasing order)\n\n---------------------\n\n");
    }

    public static void printSearchHelp(){
        System.out.println("Search Help: ---------\n");
        System.out.println("Command Line Manual Vehicle Search:");
        System.out.println("-search -x attibute val (for without order)\n-search -x attibute val o(where o -> i for increasing order and o -> d for decreasing order)\n\n------------------------\n");
    }

    public static void printPrintHelp(){
        System.out.println("Print Help: ---------\n");
        System.out.println("-print -x (b for bike, c for car, a for auto)");
        System.out.println("-print -all for all the vehicles");
        System.out.println("-print -stats -x (for aggregate operations like sum, count, etc) and -print -stats -all for all vehicles");
        System.out.println("-----------------\n\n");
    }

    public static int checkCreationArguments(String args[]){
        if(args.length != 8){
            System.out.println("error");
            return 0;
        }else{
            return 1;
        }
    }
    public static int checkUpdationArguments(String args[]){
        if(args.length != 6){
            System.out.println("error");
            return 0;
        }else{
            return 1;
        }
    }

    public static int checkDeletionArguments(String args[]){
        if(args.length != 4){
            System.out.println("error");
            return 0;
        }else{
            return 1;
        }
    }

    public static String inShort(String s){
        String res = null;
        switch(s){
            case "en":
            res = "engineNumber";
            break;
            case "dom":
            res = "dateofMan";
            break;
            case "m":
            res = "model";
            break;
            case "ori":
            res = "onroadInterest";
            break;
            case "p":
            res = "price";
            break;
            case "mil":
            res = "milege";
            break;
            case "gt":
            res = ">";
            break;
            case "lt":
            res = "<";
            break;
            case "eq":
            res = "=";
            break;
            case "i":
            res = "ASC";
            break;
            case "d":
            res = "DESC";
            break;
        }
        return res;
    }


    public static void printCredits() {
        System.out.println("First Created as an OOPS Mini Project:\n\nContributors: \n");
        System.out.println("Bargav Koduri");
        System.out.println("Charan Devarkonda");
        System.out.println("Sai Nithin Gubba");
        System.out.println("Prem Rathan");
        System.out.println("Rohith Boppey\n\n\n");
    }

    
    
}