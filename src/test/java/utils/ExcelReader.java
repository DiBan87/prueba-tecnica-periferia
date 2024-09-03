package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExcelReader {
    public static Map<String, String> leerDatosFormulario(String filePath, String sheetName) throws IOException {
        Map<String, String> datos = new HashMap<>();

        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        for (Row row : sheet) {
            String key = row.getCell(0).getStringCellValue();
            String value;
            if (Objects.equals(key, "Mobile")) {
                value = String.valueOf((long) row.getCell(1).getNumericCellValue());
            } else {
                value = row.getCell(1).getStringCellValue();
            }
            datos.put(key, value);
        }

        workbook.close();
        file.close();

        return datos;
    }
}
