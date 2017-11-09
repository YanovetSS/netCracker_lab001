package netcracker.Lab01.sorters.impl;

/**
 * A class realize sorting method is called excange sort
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @since 1.1
 */
public class ExchangeSort extends SwapSorter {
    public void methodSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new NumberFormatException();
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * Realize protected constructor
     */
    protected ExchangeSort() {
    }
}
