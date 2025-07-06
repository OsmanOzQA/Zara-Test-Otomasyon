package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil(String excelPath) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0); // ilk sayfa
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowIndex, int colIndex) {
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        return cell.toString();
    }
}