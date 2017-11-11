package netcracker.Lab01.sorters.impl;

import java.util.Arrays;

/**
 * A class realize sorting method is called standard library {@link java.util.Arrays}
 *
 * @author Nazar Yanovets
 * @see Arrays
 * @since 1.1
 * @version 1.0
 */
public class StandartArraysSort extends AbstractSorter {

    public void methodSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new NumberFormatException();
        }
        Arrays.sort(array);
    }

    /**
     * Realize protected constructor
     */
    protected StandartArraysSort() {
    }
}
