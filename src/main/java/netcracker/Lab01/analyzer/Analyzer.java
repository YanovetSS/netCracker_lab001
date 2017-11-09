package netcracker.Lab01.analyzer;

import netcracker.Lab01.fillers.Fillers;
import netcracker.Lab01.fillers.FillersImpl;
import netcracker.Lab01.fillers.annotations.Filler;
import netcracker.Lab01.sorters.impl.AbstractSorter;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * A class analyses that efficiency of sorting of different methods.
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see org.reflections.Reflections
 * @see Map
 * @see InnerResults
 * @since 1.5
 */
public class Analyzer {

    private Fillers fillers = new FillersImpl();
    private ProjectReflection reflct = new ProjectReflection();

    /**
     * A method on the nature is an access point in the program.
     * At first we enter data, assort, know time, keep it in a structure Map.
     * As a result this method analyses sorting time.
     *
     * @return Map<Integer,List<InnerResults>
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @see InnerResults
     * @see Map
     */
    public Map getAnalyzerMapTime() throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {
        int arraySize;

        long startTime;
        long endTime;
        long timeDiff;
        Map<Integer, List<InnerResults>> map = new LinkedHashMap<>();

        while (true) {
            List<InnerResults> results = new LinkedList<>();
            System.out.print("Hello, enter array size() : -> ");
            Scanner in = new Scanner(System.in);
            arraySize = in.nextInt();
            if (arraySize == -1) {
                break;
            }

            for (Method method : reflct.getAllMethodWhoAnnotatedFiller(FillersImpl.class, Filler.class)) {
                ArrayList arrayList = new ArrayList();
                int[] array = (int[]) method.invoke(fillers, arraySize);
                System.out.println("Filler: " + method.getName());
                for (Class clazz : AbstractSorter.counter.keySet()) {
                    Method method1 = clazz.getMethod("methodSort", int[].class);
                    Object object = AbstractSorter.counter.get(clazz);
                    System.out.println("    sorter name: " + clazz.getSimpleName());
                    startTime = System.nanoTime();
                    method1.invoke(object, array);
                    endTime = System.nanoTime();
                    timeDiff = endTime - startTime;
                    System.out.println("        sotring time : " + timeDiff);
                    arrayList.add(timeDiff);

                }
                results.add(new InnerResults(method, arrayList));
            }
            map.put(arraySize, results);
        }
        return map;
    }

    /**
     * This method works with Map. Print result's in console
     *
     * @param map
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void printAllResultsOnConsole(Map<Integer, Map<Method, List>> map)
            throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
        Analyzer nw = new Analyzer();
        Map<Integer, Map<Method, List>> printMap = map;
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }

    /**
     * This method works with map and print inner map on console
     *
     * @param map
     */
    public void printInnerStatisticsMap(Map<Integer, Map<Method, List>> map) {
        for (Integer parentKey : map.keySet()) {
            Map<Method, List> innerMap = map.get(parentKey);
            for (Map.Entry entry : innerMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " Value: "
                        + entry.getValue());
            }
            System.out.println("Rozmer innerMAp: " + innerMap.size());
        }
    }
}