package UtilityMethods;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {
    private static final String FILE_PATH = "test-output/TestResults.xlsx";
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("Results");
    private static int rowNum = 0;

    static {
        Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Mobile Number");
        header.createCell(1).setCellValue("Test Type");
        header.createCell(2).setCellValue("Result");
    }

    public static void writeResult(String number, String type, String result) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(number);
        row.createCell(1).setCellValue(type);
        row.createCell(2).setCellValue(result);
    }

    public static void saveExcel() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
            workbook.write(fileOut);
        }
    }
}
