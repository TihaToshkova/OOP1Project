import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
    private String fileName;
    private String content;

    public void open(Scanner scanner)
    {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try {
            File file = new File(fileName);
            if (!file.exists())
            {
                file.createNewFile();
                System.out.println("File created successfully.");
            }

            StringBuilder sb = new StringBuilder();
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
            this.fileName = fileName;
            this.content = sb.toString();
            System.out.println("Successfully opened " + fileName);
        } catch (IOException e)
        {
            System.out.println("Error: Could not open file.");
        } finally
        {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public void close()
    {
        if (fileName != null)
        {
            fileName = null;
            content = null;
            System.out.println("Successfully closed file.");
        } else
        {
            System.out.println("Error: No file is currently open.");
        }
    }

    public void save()
    {
        if (fileName != null)
        {
            try (FileWriter writer = new FileWriter(fileName))
            {
                writer.write(content);
                System.out.println("Changes saved successfully to " + fileName);
            } catch (IOException e)
            {
                System.out.println("Error: Could not save changes to file.");
            }
        } else
        {
            System.out.println("Error: No file is currently open.");
        }
    }
}
