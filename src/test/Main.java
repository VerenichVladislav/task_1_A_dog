package test;

import zoo.Animal;
import zoo.Dog;
import zoo.Pup;

/**
 * This class is for testing all application methods
 * @author vlad.verenich
 */
public class Main {
    public static void main(String[] args) {
        Dog dog_matilda = new Dog("Female", "Matilda");
        Dog doh_rafael = new Dog("Male", "Rafael");
        Pup pup = doh_rafael.leadOffspring(dog_matilda);
        pup.getParent().stream().forEach(System.out::println);
        pup.jump();
        pup.sleep();
        pup.woof();
        pup.walk();
        pup.run();
        pup.play();
        pup.eat();


    }
}
