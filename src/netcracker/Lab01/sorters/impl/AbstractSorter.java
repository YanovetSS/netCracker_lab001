package netcracker.Lab01.sorters.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * A Class is the chairman of hierarchy sortings class
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see Map
 * @see Exception
 * @since 1.5
 */
public abstract class AbstractSorter {
    public abstract void methodSort(int[] array);

    public static Map<Class, Object> counter = new HashMap<Class, Object>();

    /**
     * A method works with Class<T> value. Realize java pattern - singletone.
     *
     * @param clazz
     * @param <T>
     * @return instance
     */
    public static <T> T singleTone(Class<T> clazz) {
        T singleton = (T) counter.get(clazz.getName());
        if (singleton == null) {
            try {
                singleton = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            counter.put(clazz, singleton);
        }
        return singleton;
    }
}
