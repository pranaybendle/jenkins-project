package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String[]> getData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));
            Sheet sheet = wb.getSheet(sheetName);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                String username = row.getCell(0).toString();
                String password = row.getCell(1).toString();
                String expected = row.getCell(2).toString();

                data.add(new String[]{username, password, expected});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}