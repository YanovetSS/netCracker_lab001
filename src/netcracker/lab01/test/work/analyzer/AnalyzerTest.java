package netcracker.lab01.test.work.analyzer;

import netcracker.lab01.work.analyzer.Analyzer;
import org.junit.Test;

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