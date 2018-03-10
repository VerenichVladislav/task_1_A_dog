package zoo;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class allows you to create descendants of dogs - puppies
 * @author vlad.verenich
 */
public class Pup extends Dog {
    private ArrayList<Dog> parent;
    /**
     * Below, getters and setters for all class fields
     * All possible variants of constructors
     * Overridden methods equals, hashCode and toString
     */
    public ArrayList<Dog> getParent() {
        return parent;
    }

    public void setParent(ArrayList<Dog> parent) {
        this.parent = parent;
    }

    public Pup(String sex) {
        super(sex);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pup pup = (Pup) o;

        return parent != null ? parent.equals(pup.parent) : pup.parent == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pup{" +
                "name = " + this.getName() +
                ", age = " + this.getAge() +
                ", sex = " + this.getSex() +
                '}';
    }
    /**
     * The puppy is studying
     * Changes the viability of pup
     * In the new version, it will be possible to study specific commands
     */
    public void school(){
        System.out.println(this.getName() + " is trained!");
        this.setEducability(this.getEducability() + 1);
        this.setMoodIndicator(this.getMoodIndicator() - 2);
        this.setIndexOfSleep(this.getIndexOfSleep() - 2);
        this.setHungerIndex(this.getHungerIndex() - 1);
        info();
    }
    /**
     * Creates a random name for the puppy
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
     * The puppy is jumping
     * Changes the viability of pup
     */
    public void jump(){
        System.out.println(this.getName() + " jumps!");
        this.setMoodIndicator(this.getMoodIndicator() + 1);
        this.setIndexOfSleep(this.getIndexOfSleep() - 1);
        this.setHungerIndex(this.getHungerIndex() - 1);
        info();
    }
    /**
     * The puppy is biting
     * Changes the viability of pup
     */
    public void bite(){
        System.out.println(this.getName() + " bites!");
        this.setMoodIndicator(this.getMoodIndicator() + 3);
        this.setIndexOfSleep(this.getIndexOfSleep() - 1);
        this.setHungerIndex(this.getHungerIndex() - 1);
        info();
    }


}
