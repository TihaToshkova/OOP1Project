public class DemoteJedi implements DemoteJediInterface{
    public void demoteJedi(FileOperations fileOperations,String jediName, double multiplier) {
        if (multiplier <= 0) {
            System.out.println("Error: Multiplier must be a positive number.");
            return;
        }

        for (Planet planet : fileOperations.getPlanets().values()) {
            for (Jedi jedi : planet.getPopulation()) {
                if (jedi.getJediName().equals(jediName)) {
                    if (jedi.demote()) {
                        System.out.println("Jedi " + jediName + " demoted successfully.");
                    } else {
                        System.out.println("Error: Could not demote Jedi " + jediName + ".");
                    }
                    return;
                }
            }
        }
        System.out.println("Error: Jedi " + jediName + " not found on any planet.");
    }
}
