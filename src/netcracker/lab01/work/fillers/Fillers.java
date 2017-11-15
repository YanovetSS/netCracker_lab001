package netcracker.lab01.work.fillers;

/**
 * Interface contains four method and have one implementation FillersImpl.
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see FillersImpl
 * @since 1.0
 */
public interface Fillers {
    int[] createSortedIntArray(int size);

    int[] createSortedIntArrayWithRandomNumeric(int size);

    int[] createSortedIntArrayWithReversyOrder(int size);

    int[] createRandomIntArray(int size);

}
