/*
    Objective: This is the MAIN Program from which you will operate. Main method reads args and direct accordingly
*/

package MainVehicleManagement;

import HelpOperations.Help;
import Operations.CreateVehicle;
import Operations.DeleteAllMain;
import Operations.DeleteVehicleFromDatabase;
import Operations.PrintFinalAggregates;
import Operations.SearchVehicleInDatabase;
import Operations.SortVehicles;
import Operations.UpdateVehicle;
import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;
import VehicleClass.auto;
import VehicleClass.bike;
import VehicleClass.car;

public class OOPS_VehicleManagement {
    private final static double Appversion = 1.0;

    public static void main(String[] args) {
        VehicleDBMS v = new VehicleDBMS();
        System.out.println("\n\n-------------Welcome to OOPS Vehicle Management Project-------------------\n");
        try {
            switch (args[0]) {
                case "-create": {
                    switch (args[1]) {
                        case "-b": {
                            CreateVehicle.create(args, bike.getFilename(), bike.getTablename());
                            break;
                        }
                        case "-c": {
                            CreateVehicle.create(args, car.getFilename(), car.getTablename());
                            break;
                        }
                        case "-a": {
                            CreateVehicle.create(args, auto.getFilename(), auto.getTablename());
                            break;
                        }
                        default: {
                            Help.printCreateHelp();
                            break;
                        }
                    }
                    break;
                }
                case "-update": {
                    switch (args[1]) {
                        case "-b": {
                            UpdateVehicle.update(args, bike.getFilename(), bike.getTablename());
                            break;
                        }
                        case "-c": {
                            UpdateVehicle.update(args, car.getFilename(), car.getTablename());
                            break;
                        }
                        case "-a": {
                            UpdateVehicle.update(args, auto.getFilename(), auto.getTablename());
                            break;
                        }
                        case "-help": {
                            Help.printUpdateHelp();
                            break;
                        }
                        default: {
                            HelpOperations.Help.printUpdateHelp();
                            break;
                        }
                    }
                    break;
                }

                case "-delete": {
                    switch (args[1]) {
                        case "-b": {
                            if (args.length == 3) {
                                switch (args[2]) {
                                    case "-all": {
                                        DeleteAllMain.deleteall(bike.getTablename(), bike.getFilename());
                                        break;
                                    }
                                }
                            } else {
                                DeleteVehicleFromDatabase.delete(args, bike.getFilename(), bike.getTablename());
                                break;
                            }
                            break;
                        }
                        case "-c": {
                            if (args.length == 3) {
                                switch (args[2]) {
                                    case "-all": {
                                        DeleteAllMain.deleteall(car.getTablename(), car.getFilename());
                                        break;
                                    }
                                }
                            } else {
                                DeleteVehicleFromDatabase.delete(args, car.getFilename(), car.getTablename());
                                break;
                            }
                            break;
                        }
                        case "-a": {
                            if (args.length == 3) {
                                switch (args[2]) {
                                    case "-all": {
                                        DeleteAllMain.deleteall(auto.getTablename(), auto.getFilename());
                                        break;
                                    }
                                }
                            } else {
                                DeleteVehicleFromDatabase.delete(args, auto.getFilename(), auto.getTablename());
                                break;
                            }
                            break;
                        }
                        default: {
                            HelpOperations.Help.printDeleteHelp();
                            break;
                        }
                    }
                    break;
                }

                case "-search": {
                    switch (args[1]) {
                        case "-b": {
                            SearchVehicleInDatabase.search(args, bike.getTablename());
                            break;
                        }
                        case "-c": {
                            SearchVehicleInDatabase.search(args, car.getTablename());
                            break;
                        }
                        case "-a": {
                            SearchVehicleInDatabase.search(args, auto.getTablename());
                            break;
                        }
                        default: {
                            HelpOperations.Help.printSearchHelp();
                            break;
                        }
                    }
                    break;
                }
                case "-sort": {
                    switch (args[1]) {
                        case "-b": {
                            SortVehicles.sort(args, bike.getTablename());
                            break;
                        }
                        case "-c": {
                            SortVehicles.sort(args, car.getTablename());
                            break;
                        }
                        case "-a": {
                            SortVehicles.sort(args, auto.getTablename());
                            break;
                        }
                        default: {
                            HelpOperations.Help.printSortHelp();
                            break;
                        }
                    }
                    break;
                }
                case "-print": {
                    switch (args[1]) {
                        case "-all": {
                            System.out.println("\nBIKES: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(bike.getTablename()));
                            System.out.println("\n\n\nCARS: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(car.getTablename()));
                            System.out.println("\n\n\nAUTOS: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(auto.getTablename()));
                            break;
                        }
                        case "-b": {
                            System.out.println("\nBIKES: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(bike.getTablename()));
                            break;
                        }
                        case "-c": {
                            System.out.println("\nCARS: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(car.getTablename()));
                            break;
                        }
                        case "-a": {
                            System.out.println("\nAUTOS: ---------: \n");
                            VehicleParent.printListofVehicles(v.printVehicleContent(auto.getTablename()));
                            break;
                        }
                        case "-stats": {
                            switch (args[2]) {
                                case "-all": {
                                    System.out.println("\nBIKES: ---------: \n");
                                    PrintFinalAggregates.print(bike.getTablename());
                                    System.out.println("\n\n\nCARS: ---------: \n");
                                    PrintFinalAggregates.print(car.getTablename());
                                    System.out.println("\n\n\nAUTOS: ---------: \n");
                                    PrintFinalAggregates.print(auto.getTablename());
                                    break;
                                }
                                case "-b": {
                                    PrintFinalAggregates.print(bike.getTablename());
                                    break;
                                }
                                case "-c": {
                                    PrintFinalAggregates.print(car.getTablename());
                                    break;
                                }
                                case "-a": {
                                    PrintFinalAggregates.print(auto.getTablename());
                                    break;
                                }
                                default: {
                                    Help.printPrintHelp();
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                            Help.printPrintHelp();
                            break;
                        }
                    }
                    break;
                }

                case "-h": {
                    System.out.println("Detailed Help: --------\n\n");
                    Help.printCreateHelp();
                    Help.printUpdateHelp();
                    Help.printDeleteHelp();
                    Help.printPrintHelp();
                    Help.printSortHelp();
                    Help.printSearchHelp();
                    System.out.println(
                            "-v for version of the program\n-credits for the people contributed to the program\n");
                    break;
                }

                case "-v": {
                    System.out.println("Version: " + Appversion);
                    break;
                }

                case "-credits": {
                    Help.printCredits();
                    break;
                }

                default: {
                    Help.printAllHelp();
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unknown error occured! (Could be Wrong number of inputs)\n");
            Help.printAllHelp();
        }

    }
}
