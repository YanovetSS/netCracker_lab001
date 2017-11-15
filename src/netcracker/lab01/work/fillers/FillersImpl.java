package netcracker.lab01.work.fillers;

import netcracker.lab01.work.fillers.annotations.Filler;

import java.util.Random;

/**
 * A class contains four method who annotated @Filler, this methods create four different arrays.
 * A class is implements one interface with name Fillers.
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see Filler
 * @see Fillers
 * @since 1.5
 */
public class FillersImpl implements Fillers {
    /**
     * A method annotation Filler and works with size value. This value create arrays.lenght().
     * Method create sorted int[] array.
     *
     * @param size
     * @return int[] array
     */
    @Filler(comments = "create Sorted int[]")
    public int[] createSortedIntArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative sizes,size must be larger then zero");
        }
        int[] sortedIntArray = new int[size];
        if (sortedIntArray == null || sortedIntArray.length == 0) {
            throw new NullPointerException("SortedIntArray = null or array.lenght=0");
        }
        for (int i = 0; i < sortedIntArray.length; i++) {
            sortedIntArray[i] = i + 1;
        }
        return sortedIntArray;
    }

    /**
     * A method annotation Filler and works with size value. This value create arrays.lenght().
     * Method create sorted int[] array with random numeric.
     *
     * @param size
     * @return int[] array
     */
    @Filler(comments = "create Sorted int[] with random numeric end")
    public int[] createSortedIntArrayWithRandomNumeric(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative sizes,size must be larger then zero");
        }
        int[] sortedIntArrayWithRandomNumericOnEnd = new int[size];
        if (sortedIntArrayWithRandomNumericOnEnd == null || sortedIntArrayWithRandomNumericOnEnd.length == 0) {
            throw new NullPointerException("SortedIntArrayWithRandomNumeric = null or array.lenght=0");
        }
        for (int i = 0; i < sortedIntArrayWithRandomNumericOnEnd.length; i++) {
            sortedIntArrayWithRandomNumericOnEnd[i] = i + 1;
        }
        sortedIntArrayWithRandomNumericOnEnd[size - 1] = 200000;
        return sortedIntArrayWithRandomNumericOnEnd;
    }

    /**
     * A method annotation Filler and works with size value. This value create arrays.lenght().
     * Method create sorted int[] array with reversy order.
     *
     * @param size
     * @return int[] array
     */
    @Filler(comments = "create Sorted int[] with reversy order")
    public int[] createSortedIntArrayWithReversyOrder(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative sizes,size must be larger then zero");
        }
        int[] m = new int[size];
        if (m == null || m.length == 0) {
            throw new NullPointerException("SortedIntArrayWithReversyOrder = null or array.size =0");
        }
        for (int i = 0; i < m.length; i++) {
            m[i] = i + 1;
        }
        int i, tmp, hLenght = m.length >> 1;
        for (i = 0; i < hLenght / 2; ++i) {
            tmp = m[i];
            m[i] = m[m.length - i - 1];
            m[m.length - i - 1] = tmp;
        }
        return m;
    }

    /**
     * A method annotation Filler and works with size value. This value create arrays.lenght().
     * Method create random int[] array;
     *
     * @param size
     * @return int[] array
     */
    @Filler(comments = "create Random int[]")
    public int[] createRandomIntArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative sizes,size must be larger then zero");
        }
        Random number = new Random();
        int[] randomArray = new int[size];
        if (randomArray == null || randomArray.length == 0) {
            throw new NullPointerException("RandomIntArray = null or array.lenght=0");
        }
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = number.nextInt(100);
        }
        return randomArray;
    }
}
