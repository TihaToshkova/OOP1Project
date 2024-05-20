public class Jedi {
    private String jediName;
    private Rank rank;
    private int age;
    private String lightsaberColor;
    private int strength;

    public Jedi(String jediName, Rank rank, int age, String lightsaberColor, int strength)
    {
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
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

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLightsaberColor() {
        return lightsaberColor;
    }

    public void setLightsaberColor(String lightsaberColor) {
        this.lightsaberColor = lightsaberColor;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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
                ", light saber color='" + lightsaberColor + '\'' +
                ", strength=" + strength +
                '}';
    }
}
