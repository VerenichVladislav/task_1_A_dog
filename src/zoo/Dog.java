package zoo;

import Markers.SexualReproduction;
import Markers.WalkingAnimal;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class specifies the type of animal being created as a dog
 * @author vlad.verenich
 */
public class Dog extends Animal implements WalkingAnimal, SexualReproduction{
    private String sex;
    private int educability;
    private String masterName;
    private ArrayList<Dog> posterity;

    /**
     * Below, getters and setters for all class fields
     * All possible variants of constructors
     * Overridden methods equals, hashCode and toString
     */
    public Dog(String sex) {
        this.sex = sex;
        this.educability = 5;
    }
    public Dog(String sex, String name){
        this.sex = sex;
        this.setName(name);
        this.educability = 5;
    }

    public Dog(String sex, String masterName, ArrayList<Dog> posterity) {
        this.sex = sex;
        this.educability = 5;
        this.masterName = masterName;
        this.posterity = posterity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getEducability() {
        return educability;
    }

    public void setEducability(int educability) {
        this.educability = educability;
    }

    public ArrayList<Dog> getPosterity() {
        return posterity;
    }

    public void setPosterity(ArrayList<Dog> posterity) {
        this.posterity = posterity;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dog dog = (Dog) o;

        if (educability != dog.educability) return false;
        if (sex != null ? !sex.equals(dog.sex) : dog.sex != null) return false;
        if (masterName != null ? !masterName.equals(dog.masterName) : dog.masterName != null) return false;
        return posterity != null ? posterity.equals(dog.posterity) : dog.posterity == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + educability;
        result = 31 * result + (masterName != null ? masterName.hashCode() : 0);
        result = 31 * result + (posterity != null ? posterity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name= '" + this.getName() + '\'' +
                ", sex='" + sex + '\'' +
                ", educability=" + educability +
                ", masterName='" + masterName + '\'' +
                ", posterity=" + posterity +
                '}';
    }

    /**
     * Method of voice delivery by a dog
     */
    public void woof(){
        if(this.isSurvivability()) {
            System.out.println("Woof - Woof!");
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     *The dog is playing
     * Changes the viability of dog
     */
    public void play(){
        if(this.isSurvivability()) {
            System.out.println(this.getName() + " plays!");
            this.setMoodIndicator(this.getMoodIndicator() + 2);
            this.setIndexOfSleep(this.getIndexOfSleep() - 1);
            this.setHungerIndex(this.getHungerIndex() - 1);
            info();
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     * The dog is running
     * Changes the viability of dog
     */
    public void run(){
        if(this.isSurvivability()) {
            System.out.println(this.getName() + " runs!");
            this.setMoodIndicator(this.getMoodIndicator() + 1);
            this.setIndexOfSleep(this.getIndexOfSleep() - 1);
            this.setHungerIndex(this.getHungerIndex() - 2);
            info();
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     * The dog is walking
     * Changes the viability of dog
     */
    public void walk(){
        if (this.isSurvivability()) {
            System.out.println(this.getName() + " walks!");
            this.setMoodIndicator(this.getMoodIndicator() + 1);
            this.setIndexOfSleep(this.getIndexOfSleep() - 1);
            this.setHungerIndex(this.getHungerIndex() - 1);
            info();
        } else System.out.println("Animal is already dead!!!");
    }

    /**
     * Creates a name for the puppy
     * The first half of the father's name and the
     * second half of the mother's name are taken
     * @param maleName
     * @param femaleName
     * @return newPupName
     */
    private String createPupName(String maleName, String femaleName){
        Random random = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        String resultName = letters.charAt(random.nextInt(letters.length())) +
                maleName.substring(random.nextInt(maleName.length() / 2), maleName.length() / 2).toLowerCase() +
                femaleName.substring(random.nextInt(femaleName.length() / 2), femaleName.length() - 1).toLowerCase();
        return resultName;

    }

    /**
     * Creates a puppy of two dogs
     * If dogs are single-sexed, then the puppy will not be created
     * Adds a puppy to the offspring of parents
     * Adds dogs to the puppy's parents
     * @param female
     * @return newPup or NULL
     */
    public Pup leadOffspring(Dog female){
        Pup pup;
        System.out.println("Attempt at pairing individuals: ");
        Random random = new Random();
        if (random.nextInt(100) % 2 == 0) pup = new Pup("Male");
        else pup = new Pup("Female");
        pup.setName(createPupName(this.getName(), female.getName()));
        ArrayList<Dog> parent = new ArrayList<>();
        parent.add(this);
        parent.add(female);
        pup.setParent(parent);
        ArrayList<Dog> pups = new ArrayList<>();
        pups.add(pup);
        this.setPosterity(pups);
        female.setPosterity(pups);
        if (this.getSex().equals(female.getSex())){
            System.out.println("Impossible mating. Individuals of the SAME SEX!");
            return null;
        }
        return pup;

    }
}
