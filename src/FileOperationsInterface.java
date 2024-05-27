import java.util.Scanner;

public interface FileOperationsInterface {
    void open(Scanner scanner);

    void close();

    void save();

    void help();

    void saveAs(String newFileName);

    void addPlanet(String planetName);

    void createJedi(String planetName, String jediName, String jediRank, int jediAge, String saberColor, int jediStrength);

    void removeJedi(String jediName, String planetName);

    void promoteJedi(String jediName, double multiplier);

    void demoteJedi(String jediName, double multiplier);

    void getStrongestJedi(String planetName);

    void getYoungestJedi(String planetName, String jediRank);

    void getMostUsedSaberColor(String planetName, Rank rank);

    void getMostUsedSaberColor(String planetName);

    void printPlanet(String planetName);

    void printJedi(String jediName);

    void printTwoPlanets(String planet1Name, String planet2Name);
}
