/**
 * The {@code Help} class provides a method to print out a list of supported commands and their descriptions.
 * <p>
 * This class implements the {@code HelpInterface} interface.
 * </p>
 */
public class Help implements HelpInterface {

    /**
     * Prints the list of supported commands and their descriptions to the console.
     * <p>
     * This method outputs information about each supported command, including how to use it and a brief
     * description of its functionality.
     * </p>
     */
    public void execute() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>       - opens <file>");
        System.out.println("close             - closes currently opened file");
        System.out.println("save              - saves the currently open file");
        System.out.println("save_as <file>     - saves the currently open file in <file>");
        System.out.println("help              - prints this information");
        System.out.println("exit              - exits the program");
        System.out.println("add_planet <name>  - adds a new planet");
        System.out.println("create_jedi <planet_name> <jedi_name> <rank> <age> <saber_color> <strength>");
        System.out.println("                  - creates a new jedi on a planet");
        System.out.println("remove_jedi <jedi_name> <planet_name>");
        System.out.println("                  - removes a jedi from a planet");
        System.out.println("promote_jedi <jedi_name> <multiplier>");
        System.out.println("                  - promotes a jedi");
        System.out.println("demote_jedi <jedi_name> <multiplier>");
        System.out.println("                  - demotes a jedi");
        System.out.println("print <planet_name>");
        System.out.println("                  - prints all jedis on a planet");
        System.out.println("print <jedi_name>");
        System.out.println("                  - prints details of a jedi");
        System.out.println("print <planet_name1> + <planet_name2>");
        System.out.println("                  - prints all jedis on two planets sorted lexicographically");
        System.out.println("get_most_used_saber_color <planet_name> - Get the most used saber color on a planet.");
        System.out.println("get_most_used_saber_color_by_rank <planet_name> <jedi_rank> - Get the most used saber color by rank on a planet.");
        System.out.println("get_strongest_jedi <planet_name> - Get the strongest Jedi on a planet.");
        System.out.println("get_youngest_jedi <planet_name> <jedi_rank> - Get the youngest Jedi by rank on a planet.");
    }
}
