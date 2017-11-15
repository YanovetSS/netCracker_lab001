package netcracker.test.analyzer;

import netcracker.Lab01.analyzer.Analyzer;
import netcracker.Lab01.sorters.impl.ExchangeSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class AnalyzerTest {
    private Analyzer analyzer = new Analyzer();

    @Test(expected = NullPointerException.class)
    public void printAllResultsOnConsoleTestForNull() throws Exception {
        analyzer.printAllResultsOnConsole(null);
    }

    @Test(expected = NullPointerException.class)
    public void printInnerStatisticsMap() throws Exception {
        analyzer.printInnerStatisticsMap(null);
    }

}