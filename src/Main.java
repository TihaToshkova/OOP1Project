import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations();
        CommandHandler commandHandler = new CommandHandler(fileOperations);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            commandHandler.handleCommand(command, scanner);

            if (command.equals("exit")) {
                break;
            }
        }
        scanner.close();
    }
}
