package netcracker.test.sorters.impl;

import netcracker.Lab01.analyzer.ProjectReflection;
import netcracker.Lab01.sorters.impl.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.ReflectPermission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SorterTest {
    private Set<AbstractSorter> sorters;
    private ProjectReflection pr = new ProjectReflection();
    private int[] notSortedArray;
    private int[] sortedArray;
    private SwapSorter swapSorter;

    @Before
    public void setUp() {

        notSortedArray = new int[]{1, 10, 6, 8, 22};
        sortedArray = notSortedArray.clone();
        Arrays.sort(sortedArray);

        sorters = new HashSet<>();
        sorters.add(AbstractSorter.singleTone(MergeSort.class));
        sorters.add(AbstractSorter.singleTone(QuickSort.class));
        sorters.add(AbstractSorter.singleTone(StandartArraysSort.class));
        sorters.add(AbstractSorter.singleTone(BubbleSortEndToBegin.class));
        sorters.add(AbstractSorter.singleTone(BubbleSortBeginToEnd.class));
        sorters.add(AbstractSorter.singleTone(ExchangeSort.class));
    }

    @Test
    public void testForIfSortersWorkGood() {
        for (AbstractSorter sorter : sorters) {
            sorter.methodSort(notSortedArray);
            assertArrayEquals(sortedArray, notSortedArray);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSortersInputForNull() {
        int[] nullArray = null;
        for (AbstractSorter sorter : sorters) {
            sorter.methodSort(nullArray);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortersInputForClearArray() {
        int[] cleArray = {};
        for (AbstractSorter sorter : sorters) {
            sorter.methodSort(cleArray);
        }
    }

    @Test
    public void testSingleTone() {
        Object object = AbstractSorter.singleTone(Object.class);
    }


    @Test(expected = NullPointerException.class)
    public void testSwapSorterForNullPointer() {
        swapSorter.swap(notSortedArray, -1, -1);
    }
}
