package Markers;

import zoo.Dog;
import zoo.Pup;

/**
 * This interface is for animals that support sexual reproduction
 * @author vlad.verenich
 */
@FunctionalInterface
public interface SexualReproduction {
    Pup leadOffspring(Dog female);
}
