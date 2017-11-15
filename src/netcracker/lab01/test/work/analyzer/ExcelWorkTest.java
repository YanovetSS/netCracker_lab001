package netcracker.lab01.test.work.analyzer;

import netcracker.lab01.work.analyzer.ExcelWork;
import org.apache.poi.ss.usermodel.CellValue;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ExcelWorkTest {
    private ExcelWork excelWork;

    @Test(expected = NullPointerException.class)
    public void printTableExcelTestForNull() throws Exception {
        Map map = new HashMap();
        map = null;
        excelWork.printTableExcel(map);
    }

    @Test(expected = NullPointerException.class)
    public void printGraphExcelTestForNull() throws Exception {
        excelWork.printGraphExcel(2, null);
    }

    @Test(expected = NullPointerException.class)
    public void printGraphExcelTestForIlegal() throws Exception {
        Map map = new HashMap();
        excelWork.printGraphExcel(100, map);
    }


    @Test
    public void getCellValue() throws Exception {
        CellValue cellValue = excelWork.getCellValue(1, 4);
        assertEquals(cellValue.getStringValue(), "Час");
    }
}