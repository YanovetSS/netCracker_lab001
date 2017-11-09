package netcracker.Lab01.analyzer;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * A class has a set of methods for work with Excel
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see org.apache.poi
 * @since 1.5
 */
public class ExcelWork {

    private XSSFWorkbook workbook = getWorkBook();
    private Analyzer newAnalyzer = new Analyzer();
    private ProjectReflection ref = new ProjectReflection();

    public ExcelWork() throws IOException {
    }

    /**
     * A method takes example workbook and create new workbook in system.
     *
     * @return Workbook
     * @throws IOException
     */
    public static XSSFWorkbook getWorkBook() throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook("D:\\Навчання!\\NetCracker\\Laba1\\true.xlsx");
        FileOutputStream fos = new FileOutputStream("D:\\Навчання!\\NetCracker\\Laba1\\excel.xlsx");
        wb.write(fos);
        fos.close();
        return wb;
    }

    /**
     * A method work with Map and inputs time sorting result to the Excel document.
     * Build table in Excel document.
     *
     * @param results
     * @throws IOException
     */
    public void printTableExcel(Map<Integer, List<InnerResults>> results) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Навчання!\\NetCracker\\Laba1\\excel.xlsx");
        int iniColumn = 4;
        for (Map.Entry<Integer, List<InnerResults>> result : results.entrySet()) {
            int columnCount = iniColumn;
            for (InnerResults analysisResult : result.getValue()) {
                int initRow = 2;
                XSSFSheet sheet = getOrCreateSheet(workbook, analysisResult.getMethod().getName());
                XSSFRow row = sheet.getRow(0);
                XSSFCell cell = row.createCell(columnCount);
                cell.setCellValue(result.getKey());
                System.out.println(analysisResult);
                for (Long time : analysisResult.getExecutionTime()) {
                    row = sheet.getRow(initRow++);
                    cell = row.createCell(columnCount);
                    cell.setCellValue(time);
                }
            }
            iniColumn++;
        }
        workbook.write(fos);
        fos.close();
    }

    /**
     * A method works with workbook and return sheet if it exists or create new one if it doesn't .
     *
     * @param workbook
     * @param name
     * @return Sheet
     */
    private XSSFSheet getOrCreateSheet(XSSFWorkbook workbook, String name) {
        XSSFSheet sheet = workbook.getSheet(name.substring(6));
        if (sheet == null) {
            sheet = workbook.createSheet(name.substring(6));
        }
        return sheet;
    }

    /**
     * A method work with map and print graphs in excel document.
     *
     * @param sheetCount
     * @param map
     * @throws IOException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void printGraphExcel(int sheetCount, Map<Integer, List<InnerResults>> map) throws IOException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
        FileOutputStream fos = new FileOutputStream("D:\\Навчання!\\NetCracker\\Laba1\\excel.xlsx");
        XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 10, 13, 25);
            XSSFChart chart = drawing.createChart(anchor);
            XSSFChartLegend legend = chart.getOrCreateLegend();
            legend.setPosition(LegendPosition.LEFT);
            LineChartData data = chart.getChartDataFactory().createLineChartData();
            ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ChartAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
            for (int j = 0; j < 6; j++) {
                ChartDataSource xs = DataSources.fromNumericCellRange(sheet,
                        new CellRangeAddress(0, 0, 4, 3 + map.keySet().size()));
                ChartDataSource ys = DataSources.fromNumericCellRange(sheet,
                        new CellRangeAddress(2 + j, 2 + j, 4, 3 + map.keySet().size()));

                LineChartSeries series = data.addSeries(xs, ys);
                CellReference cellReference = new CellReference(j + 2, 1);
                Row row = sheet.getRow(cellReference.getRow());
                Cell cell = row.getCell(cellReference.getCol());
                CellValue cellValue = evaluator.evaluate(cell);
                series.setTitle(cellValue.getStringValue());
            }
            chart.plot(data, bottomAxis, leftAxis);
        }
        workbook.write(fos);
        fos.close();
    }

    /**
     * A method  work with excel document and get value of cell
     *
     * @throws IOException
     */
    public void getCellValue(int pRow, int pCol) throws IOException {
        FileInputStream fos = new FileInputStream("D:\\Навчання!\\NetCracker\\Laba1\\excel.xlsx");
        workbook = new XSSFWorkbook(fos);
        XSSFSheet sheet = workbook.getSheetAt(1);
        XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        CellReference cellReference = new CellReference(pRow, pCol);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        CellValue cellValue = evaluator.evaluate(cell);
        switch (cellValue.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cellValue.getBooleanValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                System.out.println(cellValue.getNumberValue());
                break;
            case Cell.CELL_TYPE_STRING:
                System.out.println(cellValue.getStringValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                break;
            case Cell.CELL_TYPE_ERROR:
                break;
        }
    }
}

