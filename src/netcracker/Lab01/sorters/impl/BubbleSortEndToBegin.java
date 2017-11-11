package netcracker.Lab01.sorters.impl;

/**
 * A class realize sorting method is called bubbleSort
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @since 1.1
 */
public class BubbleSortEndToBegin extends SwapSorter {
    public void methodSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new NumberFormatException();
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = array.length - 1; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * Realize protected constructor
     */
    protected BubbleSortEndToBegin() {
    }
}
