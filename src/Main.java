import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OpenFile openFile = new OpenFile();
        CloseFile closeFile = new CloseFile();
        SaveFile saveFile = new SaveFile();
        SaveAs saveAs = new SaveAs();
        Help help = new Help();
        AddPlanet addPlanet = new AddPlanet();
        CreateJedi createJedi = new CreateJedi();
        RemoveJedi removeJedi = new RemoveJedi();
        PromoteJedi promoteJedi = new PromoteJedi();
        DemoteJedi demoteJedi = new DemoteJedi();
        PrintPlanet printPlanet = new PrintPlanet();
        PrintJedi printJedi = new PrintJedi();
        PrintTwoPlanets printTwoPlanets = new PrintTwoPlanets();
        FileOperations fileOperations = new FileOperations();
        GetMostUsedSaber getMostUsedSaber = new GetMostUsedSaber();
        GetStrongestJedi getStrongestJedi = new GetStrongestJedi();
        GetYoungestJedi getYoungestJedi = new GetYoungestJedi();
        help.help();

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            switch (command.split(" ")[0]) {
                case "open":
                    if (fileOperations.getFileName() == null) {
                        openFile.open(fileOperations,scanner);
                    } else {
                        System.out.println("Error: A file is already open. Close it first.");
                    }
                    break;
                case "close":
                    closeFile.close(fileOperations);
                    break;
                case "save":
                    saveFile.save(fileOperations);
                    break;
                case "save_as":
                    String[] partsSaveAs = command.split(" ", 2);
                    if (partsSaveAs.length == 2) {
                        String fileName = partsSaveAs[1];
                        saveAs.saveAs(fileOperations,fileName);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: save_as <file>");
                    }
                    break;
                case "help":
                    help.help();
                    break;
                case "exit":
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                case "add_planet":
                    String[] partsAddPlanet = command.split(" ", 2);
                    if (partsAddPlanet.length == 2) {
                        addPlanet.addPlanet(fileOperations,partsAddPlanet[1]);
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
                            createJedi.createJedi(fileOperations,planetName, jediName, jediRank, jediAge, saberColor, jediStrength);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: create_jedi <planet_name> <jedi_name> <rank> <age> <saber_color> <strength>");
                    }
                    break;
                case "remove_jedi":
                    String[] partsRemoveJedi = command.split(" ", 3);
                    if (partsRemoveJedi.length == 3) {
                     removeJedi.removeJedi(fileOperations,partsRemoveJedi[1], partsRemoveJedi[2]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: remove_jedi <jedi_name> <planet_name>");
                    }
                    break;
                case "promote_jedi":
                    String[] partsPromoteJedi = command.split(" ", 3);
                    if (partsPromoteJedi.length == 3) {
                        try {
                            double multiplier = Double.parseDouble(partsPromoteJedi[2]);
                          promoteJedi.promoteJedi(fileOperations,partsPromoteJedi[1], multiplier);
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
                            demoteJedi.demoteJedi(fileOperations,partsDemoteJedi[1], multiplier);
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
                      printPlanet.print(fileOperations,partsPrintPlanet[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_planet <planet_name>");
                    }
                    break;
                case "print_jedi":
                    String[] partsPrintJedi = command.split(" ", 2);
                    if (partsPrintJedi.length == 2) {
                     printJedi.print(fileOperations,partsPrintJedi[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_jedi <jedi_name>");
                    }
                    break;
                case "print_two_planets":
                    String[] partsPrintTwoPlanets = command.split(" ", 2);
                    if (partsPrintTwoPlanets.length == 2 && partsPrintTwoPlanets[1].contains("+")) {
                        String[] planets = partsPrintTwoPlanets[1].split("\\+");
                        if (planets.length == 2) {
                        printTwoPlanets.printTwoPlanets(fileOperations,planets[0].trim(), planets[1].trim());
                        } else {
                            System.out.println("Error: Invalid command format. Usage: print_two_planets <planet_name1> + <planet_name2>");
                        }
                    } else {
                        System.out.println("Error: Invalid command format. Usage: print_two_planets <planet_name1> + <planet_name2>");
                    }
                    break;
                case "get_most_used_saber_color_by_planet_and_rank":
                    String[] partsGetMostUsedSaberColor = command.split(" ", 2);
                    if (partsGetMostUsedSaberColor.length == 3) {
                        getMostUsedSaber.getMostUsedSaberColor(fileOperations,partsGetMostUsedSaberColor[1],partsGetMostUsedSaberColor[2].toUpperCase());
                    } else {
                        System.out.println("Error: Invalid command format. Usage: get_most_used_saber_color <planet_name> <jedi_rank>");
                    }
                    break;
                case "get_most_used_saber_color_by_planet":
                    String[] partsGetMostUsedSaberColorByPlanet = command.split(" ", 2);
                    if (partsGetMostUsedSaberColorByPlanet.length == 2) {
                        getMostUsedSaber.getMostUsedSaberColor(fileOperations,partsGetMostUsedSaberColorByPlanet[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: get_most_used_saber_color <planet_name>");
                    }
                    break;

                case "get_strongest_jedi":
                    String[] partsGetStrongestJedi = command.split(" ",2);
                    if (partsGetStrongestJedi.length == 2) {
                        getStrongestJedi.getStrongestJedi(fileOperations,partsGetStrongestJedi[1]);
                    } else {
                        System.out.println("Error: Invalid command format. Usage: get_strongest_jedi <planet_name>");
                    }
                    break;
                case "get_youngest_jedi":
                    String[] partsGetYoungestJedi = command.split(" ",2);
                    if (partsGetYoungestJedi.length == 3) {
                        getYoungestJedi.getYoungestJedi(fileOperations, partsGetYoungestJedi[1], partsGetYoungestJedi[2].toUpperCase());
                    } else {
                        System.out.println("Error: Invalid command format. Usage: get_youngest_jedi <planet_name> <jedi_rank>");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid command.");
                    break;
            }
        }
    }
}
