package netcracker.Lab01.sorters.impl;

/**
 * A class realize swap and extends AbstractSorter
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @since 1.1
 */
abstract public class SwapSorter extends AbstractSorter {
    private int tmp;

    /**
     * A method works with int[] array and two int value and do some verification.
     *
     * @param array
     * @param firstIndex
     * @param secondIndex
     */
    protected void swap(int[] array, int firstIndex, int secondIndex) {
        if (array.length < 0 || firstIndex < 0 || secondIndex < 0) {
            throw new IllegalArgumentException("Negative sizes or index,size and index must be larger then zero");
        }
        tmp = array[firstIndex];
        if (array == null) {
            throw new NullPointerException("Swap:array = null");
        }
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }


}
