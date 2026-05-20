package Jedi;

/**
 * The {@code Jedi.Jedi} class represents a Jedi.Jedi character with attributes such as name, rank, age, lightsaber color, and strength.
 * It provides methods to promote and demote the Jedi.Jedi's rank.
 */
public class Jedi {
    private String jediName;
    private Rank rank;
    private int age;
    private String lightSaberColor;
    private int strength;

    /**
     * Constructs a Jedi.Jedi object with the specified attributes.
     *
     * @param jediName        the name of the Jedi.Jedi
     * @param rank            the rank of the Jedi.Jedi (must be from the {@code Jedi.Rank} enum)
     * @param age             the age of the Jedi.Jedi
     * @param lightSaberColor the color of the Jedi.Jedi's lightsaber
     * @param strength        the strength of the Jedi.Jedi
     */
    public Jedi(String jediName, Rank rank, int age, String lightSaberColor, int strength) {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightSaberColor = lightSaberColor;
        this.strength = strength;
    }

    /**
     * Returns the name of the Jedi.Jedi.
     *
     * @return the name of the Jedi.Jedi
     */
    public String getJediName() {
        return jediName;
    }

    /**
     * Sets the name of the Jedi.Jedi.
     *
     * @param jediName the new name of the Jedi.Jedi
     */
    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    /**
     * Returns the rank of the Jedi.Jedi.
     *
     * @return the rank of the Jedi.Jedi
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns the age of the Jedi.Jedi.
     *
     * @return the age of the Jedi.Jedi
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the lightsaber color of the Jedi.Jedi.
     *
     * @return the lightsaber color of the Jedi.Jedi
     */
    public String getLightSaberColor() {
        return lightSaberColor;
    }

    /**
     * Returns the strength of the Jedi.Jedi.
     *
     * @return the strength of the Jedi.Jedi
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Promotes the Jedi.Jedi to the next rank if possible.
     *
     * @return {@code true} if the Jedi.Jedi was successfully promoted; {@code false} otherwise
     */
    public boolean promote() {
        Rank[] ranks = Rank.values();
        int currentIndex = this.rank.ordinal();
        if (currentIndex < ranks.length - 1) {
            this.rank = ranks[currentIndex + 1];
            return true;
        }
        return false;
    }

    /**
     * Demotes the Jedi.Jedi to the previous rank if possible.
     *
     * @return {@code true} if the Jedi.Jedi was successfully demoted; {@code false} otherwise
     */
    public boolean demote() {
        int currentIndex = this.rank.ordinal();
        if (currentIndex > 0) {
            this.rank = Rank.values()[currentIndex - 1];
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the Jedi.Jedi object.
     *
     * @return a string representation of the Jedi.Jedi object
     */
    @Override
    public String toString() {
        return "Jedi.Jedi{" +
                "jediName='" + jediName + '\'' +
                ", rank=" + rank +
                ", age=" + age +
                ", lightSaberColor='" + lightSaberColor + '\'' +
                ", strength=" + strength +
                '}';
    }
}