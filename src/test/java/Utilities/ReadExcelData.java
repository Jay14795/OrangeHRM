package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
public class ReadExcelData {
    @DataProvider(name = "Valid_Login") // Change the name as per the sheet name
    public Object[][] getvalidLoginData() throws IOException {
        // Read the login data from the Excel spreadsheet
        Sheet sheetName = getSheetName("Valid_Login"); // Change the Sheet name as per needed
        int totalRows = sheetName.getLastRowNum();
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();
        String testData[][] = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
            }
        }
        return testData;
    }

    
    @DataProvider(name = "Invalid_Login") // Change the name as per the sheet name
    public Object[][] getInvalidLoginData() throws IOException {
        // Read the login data from the Excel spreadsheet
        Sheet sheetName = getSheetName("Invalid_Login"); // Change the Sheet name as per needed
        int totalRows = sheetName.getLastRowNum();
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();
        String testData[][] = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
            }
        }
        return testData;
    }

    
    private Sheet getSheetName(String sheetName) {
        // Read the data from the Excel spreadsheet
        File f = new File(System.getProperty("user.dir") + "/src/test/java/TestData/Data.xlsx");
        try (FileInputStream fis = new FileInputStream(f); Workbook wb = WorkbookFactory.create(fis)) {
            return wb.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

