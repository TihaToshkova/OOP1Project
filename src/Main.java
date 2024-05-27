import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOperations = new FileOperations();

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            switch (command.split(" ")[0]) {
                case "open":
                    if (fileOperations.getFileName() == null) {
                        fileOperations.open(scanner);
                    } else {
                        System.out.println("Error: A file is already open. Close it first.");
                    }
                    break;
                case "close":
                    fileOperations.close();
                    break;
                case "save":
                    fileOperations.save();
                    break;
                case "save_as":
                    String[] partsSaveAs = command.split(" ", 2);
                    if (partsSaveAs.length == 2) {
                        fileOperations.saveAs(partsSaveAs[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: save_as <file>");
                    }
                    break;
                case "help":
                    fileOperations.help();
                    break;
                case "exit":
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                case "add_planet":
                    String[] partsAddPlanet = command.split(" ", 2);
                    if (partsAddPlanet.length == 2) {
                        fileOperations.addPlanet(partsAddPlanet[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: add_planet <name>");
                    }
                    break;
                case "create_jedi":
                    String[] partsCreateJedi = command.split(" ");
                    if (partsCreateJedi.length == 7) {
                        String planetName = partsCreateJedi[1];
                        String jediName = partsCreateJedi[2];

                            String jediRank = partsCreateJedi[3].toUpperCase();
                            int jediAge = Integer.parseInt(partsCreateJedi[4]);
                            String saberColor = partsCreateJedi[5];
                            int jediStrength = Integer.parseInt(partsCreateJedi[6]);
                            fileOperations.createJedi(planetName, jediName, jediRank, jediAge, saberColor, jediStrength);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: create_jedi <planet_name> <jedi_name> <rank> <age> <saber_color> <strength>");
                    }
                    break;
                case "remove_jedi":
                    String[] partsRemoveJedi = command.split(" ", 3);
                    if (partsRemoveJedi.length == 3) {
                        fileOperations.removeJedi(partsRemoveJedi[1], partsRemoveJedi[2]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: remove_jedi <jedi_name> <planet_name>");
                    }
                    break;
                case "promote_jedi":
                    String[] partsPromoteJedi = command.split(" ", 3);
                    if (partsPromoteJedi.length == 3) {
                        try {
                            double multiplier = Double.parseDouble(partsPromoteJedi[2]);
                            fileOperations.promoteJedi(partsPromoteJedi[1], multiplier);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid multiplier format. Usage: promote_jedi <jedi_name> <multiplier>");
                        }
                    } else {
                        System.out.println("Error: Invalid command format. Usage: promote_jedi <jedi_name> <multiplier>");
                    }
                    break;
                case "demote_jedi":
                    String[] partsDemoteJedi = command.split(" ", 3);
                    if (partsDemoteJedi.length == 3) {
                        try {
                            double multiplier = Double.parseDouble(partsDemoteJedi[2]);
                            fileOperations.demoteJedi(partsDemoteJedi[1], multiplier);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid multiplier format. Usage: demote_jedi <jedi_name> <multiplier>");
                        }
                    } else {
                        System.out.println("Error: Invalid command format. Usage: demote_jedi <jedi_name> <multiplier>");
                    }
                    break;
                case "print_planet":
                    String[] partsPrintPlanet = command.split(" ", 2);
                    if (partsPrintPlanet.length == 2) {
                        fileOperations.printPlanet(partsPrintPlanet[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_planet <planet_name>");
                    }
                    break;
                case "print_jedi":
                    String[] partsPrintJedi = command.split(" ", 2);
                    if (partsPrintJedi.length == 2) {
                        fileOperations.printJedi(partsPrintJedi[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_jedi <jedi_name>");
                    }
                    break;
                case "print_two_planets":
                    String[] partsPrintTwoPlanets = command.split(" ", 2);
                    if (partsPrintTwoPlanets.length == 2 && partsPrintTwoPlanets[1].contains("+")) {
                        String[] planets = partsPrintTwoPlanets[1].split("\\+");
                        if (planets.length == 2) {
                            fileOperations.printTwoPlanets(planets[0].trim(), planets[1].trim());
                        } else {
                            System.out.println("Error: Invalid command format. Usage: print_two_planets <planet_name1> + <planet_name2>");
                        }
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_two_planets <planet_name1> + <planet_name2>");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid command.");
                    break;
            }
        }
    }
}
