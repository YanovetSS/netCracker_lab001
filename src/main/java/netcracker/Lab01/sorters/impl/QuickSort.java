package netcracker.Lab01.sorters.impl;

/**
 * A class realize sorting method is called quick sort
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @since 1.1
 */
public class QuickSort extends AbstractSorter {
    private int[] numbers;
    private int number;

    /**
     * A method works with int[] array value and does verifications.
     *
     * @param array
     */
    public void methodSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new NumberFormatException();
        }
        this.numbers = array;
        number = array.length;
        quickSort(0, number - 1);
    }

    /**
     * A method works with two int value and does verifications where a number is
     *
     * @param low
     * @param hight
     */
    private void quickSort(int low, int hight) {
        int i = low;
        int j = hight;
        int pivot = numbers[low + (hight - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        //Recursion
        if (low < j) {
            quickSort(low, j);
        }
        if (i < hight) {
            quickSort(i, hight);
        }
    }

    /**
     * A method works with two int value and do swap
     *
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    /**
     * Realize protected constructor
     */
    protected QuickSort() {
    }
}
