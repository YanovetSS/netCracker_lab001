package netcracker.Lab01.sorters.impl;

/**
 * A class realize sorting method is called merge sort
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @since 1.1
 */
public class MergeSort extends AbstractSorter {
    private int[] numbers;
    private int[] hepler;

    private int number;

    @Override
    public void methodSort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new NumberFormatException();
        }
        this.numbers = array;
        number = array.length;
        this.hepler = new int[number];
        mergeSort(0, number - 1);
    }

    private void mergeSort(int low, int hight) {
        if (low < hight) {
            int middle = low + (hight - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, hight);
            merge(low, middle, hight);
        }

    }

    private void merge(int low, int middle, int hight) {
        for (int i = 0; i <= hight; i++) {
            hepler[i] = numbers[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= hight) {
            if (hepler[i] <= hepler[j]) {
                numbers[k] = hepler[i];
                i++;
            } else {
                numbers[k] = hepler[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = hepler[i];
            k++;
            i++;
        }
    }

    /**
     * Realize protected constructor
     */
    protected MergeSort() {
    }
}
