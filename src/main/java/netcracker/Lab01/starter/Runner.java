package netcracker.Lab01.starter;


import netcracker.Lab01.analyzer.Analyzer;
import netcracker.Lab01.analyzer.ExcelWork;
import netcracker.Lab01.analyzer.InnerResults;
import netcracker.Lab01.analyzer.ProjectReflection;
import netcracker.Lab01.fillers.FillersImpl;
import netcracker.Lab01.fillers.annotations.Filler;
import netcracker.Lab01.sorters.impl.*;

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
