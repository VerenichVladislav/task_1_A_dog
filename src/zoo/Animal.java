package zoo;

/**
 * This class is common for creating any animal
 * @author vlad.verenich
 */
public class Animal {
    private String name;
    private int age;
    private String habitat;
    private String type;
    private String realm;
    private int hungerIndex;
    private int indexOfSleep;
    private int moodIndicator;
    private boolean survivability;

    /**
    Below, getters and setters for all class fields
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public int getHungerIndex() {
        return hungerIndex;
    }

    public void setHungerIndex(int hungerIndex) {
        this.hungerIndex = hungerIndex;
    }

    public int getIndexOfSleep() {
        return indexOfSleep;
    }

    public void setIndexOfSleep(int indexOfSleep) {
        this.indexOfSleep = indexOfSleep;
    }

    public int getMoodIndicator() {
        return moodIndicator;
    }

    public void setMoodIndicator(int moodIndicator) {
        this.moodIndicator = moodIndicator;
    }

    public boolean isSurvivability() {
        return survivability;
    }

    public void setSurvivability(boolean survivability) {
        this.survivability = survivability;
    }

    /**
     * All possible variants of constructors
     */
    public Animal() {
        this.hungerIndex = 5;
        this.indexOfSleep = 5;
        this.moodIndicator = 5;
        this.survivability = true;
    }

    public Animal(String name, int age, String habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.hungerIndex = 5;
        this.indexOfSleep = 5;
        this.moodIndicator = 5;
        this.survivability = true;
    }

    public Animal(String name, int age, String habitat, String realm) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.realm = realm;
        this.hungerIndex = 5;
        this.indexOfSleep = 5;
        this.moodIndicator = 5;
        this.survivability = true;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hungerIndex = 5;
        this.indexOfSleep = 5;
        this.moodIndicator = 5;
        this.survivability = true;
    }

    public Animal(String name, int age, String habitat, String type, String realm) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.type = type;
        this.realm = realm;
        this.hungerIndex = 5;
        this.indexOfSleep = 5;
        this.moodIndicator = 5;
        this.survivability = true;
    }

    /**
     * Overridden methods equals, hashCode and toString
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (hungerIndex != animal.hungerIndex) return false;
        if (indexOfSleep != animal.indexOfSleep) return false;
        if (moodIndicator != animal.moodIndicator) return false;
        if (survivability != animal.survivability) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (habitat != null ? !habitat.equals(animal.habitat) : animal.habitat != null) return false;
        if (type != null ? !type.equals(animal.type) : animal.type != null) return false;
        return realm != null ? realm.equals(animal.realm) : animal.realm == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (habitat != null ? habitat.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (realm != null ? realm.hashCode() : 0);
        result = 31 * result + hungerIndex;
        result = 31 * result + indexOfSleep;
        result = 31 * result + moodIndicator;
        result = 31 * result + (survivability ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", habitat='" + habitat + '\'' +
                ", type='" + type + '\'' +
                ", realm='" + realm + '\'' +
                ", hungerIndex=" + hungerIndex +
                ", indexOfSleep=" + indexOfSleep +
                ", moodIndicator=" + moodIndicator +
                ", survivability=" + survivability +
                '}';
    }

    /**
     * The animal eats
     * Increases the satiety of the animal
     */
    public void eat(){
        if(isSurvivability()){
        System.out.println(this.name + " is eating!");
        this.hungerIndex++;
        this.indexOfSleep--;
        info();
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     * Checks the viability of an animal
     * Access modifier - private
     */
    private void dead(){
        if (this.indexOfSleep * this.hungerIndex * this.moodIndicator == 0) this.setSurvivability(false);
    }

    /**
     * The animal sleep
     * Increases the sleep parameter of the animal
     */
    public void sleep(){
        if(isSurvivability()) {
            System.out.println(this.name + " is sleeping!");
            this.indexOfSleep++;
            this.hungerIndex--;
            info();
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     * Displays information on the vital indicators of the animal
     * Access modifier - package (non - modifier)
     */
    void info(){
        System.out.println("Rate of hunger: " + this.getHungerIndex());
        System.out.println("Sleep indicator: " + this.getIndexOfSleep());
        System.out.println("Mood score: " + this.getMoodIndicator());
        dead();
        if (!isSurvivability()) System.out.println("The animal died!");
        System.out.println("-------------------------------");
    }
}
