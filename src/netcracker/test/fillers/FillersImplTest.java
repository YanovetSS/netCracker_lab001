package netcracker.test.fillers;

import netcracker.Lab01.fillers.Fillers;
import netcracker.Lab01.fillers.FillersImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FillersImplTest {
    int[] expectedArray;
    int size;
    Fillers fillers = new FillersImpl();

    @Before
    public void setUp() throws Exception {
        size = 10;
    }

    //sorted int Array
    @Test
    public void createSortedIntArray() throws Exception {
        expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = fillers.createSortedIntArray(size);
        assertArrayEquals(expectedArray, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSorterArrayNegativeSize() {
        fillers.createSortedIntArray(-10);
    }

    @Test
    public void testSorterArrayForNotNullValue() {
        int[] actual = fillers.createSortedIntArray(size);
        assertNotNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSorterArrayForZeroSizeAndNullPointer() {
        fillers.createSortedIntArray(0);
    }

    //sorted int array with random numeric
    @Test
    public void createSortedIntArrayWithRandomNumeric() throws Exception {
        expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 200000};
        int[] actual = fillers.createSortedIntArrayWithRandomNumeric(size);
        assertArrayEquals(expectedArray, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSorterArrayWithRandomNumericNegativeSize() {
        fillers.createSortedIntArrayWithRandomNumeric(-10);
    }

    @Test
    public void testSorterArrayWithRandomNumericForNotNullValue() {
        int[] actual = fillers.createSortedIntArray(size);
        assertNotNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSorterArrayWithRundomNuumericForZeroSizeAndNullPointer() {
        fillers.createSortedIntArray(0);
    }

    //  sorted int array with reverse order
    @Test(expected = IllegalArgumentException.class)
    public void testSorterArrayWithReverseOrderNegativeSize() {
        fillers.createSortedIntArrayWithReversyOrder(-10);
    }

    @Test
    public void testSorterArrayWithReverseOrderForNotNullValue() {
        int[] actual = fillers.createSortedIntArrayWithReversyOrder(size);
        assertNotNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSorterArrayWithReverseOrderForZeroSizeAndNullPointer() {
        fillers.createSortedIntArrayWithReversyOrder(0);
    }

    //  random int array
    @Test(expected = IllegalArgumentException.class)
    public void testSorterRandomArrayOrderNegativeSize() {
        fillers.createRandomIntArray(-10);
    }

    @Test
    public void testSorterRandomArrayForNotNullValue() {
        int[] actual = fillers.createRandomIntArray(size);
        assertNotNull(actual);

    }

    @Test(expected = NullPointerException.class)
    public void testSorterRandomArrayForZeroSizeAndNullPointer() {
        fillers.createRandomIntArray(0);
    }
}