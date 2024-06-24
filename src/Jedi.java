public class Jedi {
    private String jediName;
    private Rank rank;
    private int age;
    private String lightSaberColor;
    private int strength;

    public Jedi(String jediName, Rank rank, int age, String lightSaberColor, int strength)
    {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightSaberColor = lightSaberColor;
        this.strength = strength;
    }

    public String getJediName() {
        return jediName;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public Rank getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }

    public String getLightSaberColor() {return lightSaberColor;}

    public int getStrength() {
        return strength;
    }

    public boolean promote() {
        Rank[] ranks = Rank.values();
        int currentIndex = this.rank.ordinal();
        if (currentIndex < ranks.length - 1) {
            this.rank = ranks[currentIndex + 1];
            return true;
        }
        return false;
    }

    public boolean demote() {
        int currentIndex = this.rank.ordinal();
        if (currentIndex > 0) {
            this.rank = Rank.values()[currentIndex - 1];
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Jedi{" +
                "jediName='" + jediName + '\'' +
                ", rank=" + rank +
                ", age=" + age +
                ", light saber color='" + lightSaberColor + '\'' +
                ", strength=" + strength +
                '}';
    }
}
