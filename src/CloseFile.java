import java.util.Map;

public class CloseFile implements CloseFileInterface{
    public void close(FileOperations fileOperations) {
        if (fileOperations.getFileName() == null) {
            System.out.println("No file is currently open.");
        } else {
            fileOperations.setFileName(null);
            fileOperations.clearPlanetsAndJedis();
            System.out.println("File closed.");
        }
    }
}
