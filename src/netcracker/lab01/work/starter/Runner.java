package netcracker.lab01.work.starter;


import netcracker.lab01.work.analyzer.Analyzer;
import netcracker.lab01.work.analyzer.ExcelWork;
import netcracker.lab01.work.analyzer.InnerResults;
import netcracker.lab01.work.analyzer.ProjectReflection;
import netcracker.lab01.work.fillers.FillersImpl;
import netcracker.lab01.work.fillers.annotations.Filler;
import netcracker.lab01.work.sorters.impl.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * A class have main method and run all system
 *
 * @author Nazar Yanovets
 * @version 1.1
 * @since 1.5
 */
public class Runner {
    public static void main(String[] args) throws IOException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        init();
        Analyzer nw = new Analyzer();

        ExcelWork excelWork = new ExcelWork();
        ProjectReflection ref = new ProjectReflection();
        Map<Integer, List<InnerResults>> map = nw.getAnalyzerMapTime();
        excelWork.printTableExcel(map);
        excelWork.printGraphExcel(ref.getListSizeWhereWeHaveMethodWhoAnnotatedFiller(FillersImpl.class, Filler.class), map);

    }

    /**
     * A method realize pattern who has name singleton and do init.
     *
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void init() throws InstantiationException, IllegalAccessException {
        BubbleSortBeginToEnd bubbleSortBeginToEnd = AbstractSorter.singleTone(BubbleSortBeginToEnd.class);
        BubbleSortEndToBegin bubbleSortEndToBegin = AbstractSorter.singleTone(BubbleSortEndToBegin.class);
        ExchangeSort exchangeSort = AbstractSorter.singleTone(ExchangeSort.class);
        MergeSort mergeSort = AbstractSorter.singleTone(MergeSort.class);
        QuickSort quickSort = AbstractSorter.singleTone(QuickSort.class);
        StandartArraysSort standartArraysSort = AbstractSorter.singleTone(StandartArraysSort.class);
    }
}
