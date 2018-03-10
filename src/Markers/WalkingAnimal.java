package Markers;

/**
 * This interface for animals that can only move with
 * their feet (do not know how to fly)
 * @author vlad.verenich
 */
@FunctionalInterface
public interface WalkingAnimal {
    void walk();
}
