package Markers;

import zoo.Pup;

/**
 * This interface is for animals that support only single-sex reproduction
 * @author vlad.verenich
 */
@FunctionalInterface
public interface AsexualReproduction {
    Pup reproduce();
}
