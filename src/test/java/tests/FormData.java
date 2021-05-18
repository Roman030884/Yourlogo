package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import utils.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;

public class FormData extends BaseTest {

    public Object[][] readExcel() throws IOException {
        FileInputStream fileForm = new FileInputStream("src/test/resources/credentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileForm);
        XSSFSheet sheet = workbook.getSheet("FormData");
        int totalRows = sheet.getLastRowNum();
        int totalColums = sheet.getRow(0).getPhysicalNumberOfCells();

        Object data[][] = new Object[totalRows][totalColums];
        for (int i = 0; i < totalRows; i++) {
            data[i][0] = sheet.getRow(i + 1).getCell(0).toString();
            data[i][1] = sheet.getRow(i + 1).getCell(1).toString();
            String pass = sheet.getRow(i + 1).getCell(2).toString();
            data[i][2] = pass.substring(0, pass.length() - 2);
            data[i][3] = sheet.getRow(i + 1).getCell(3).toString();
            data[i][4] = sheet.getRow(i + 1).getCell(4).toString();
            String zip = sheet.getRow(i + 1).getCell(5).toString();
            data[i][5] = zip.substring(0, zip.length() - 2);
            String mobile = sheet.getRow(i + 1).getCell(6).toString();
            data[i][6] = mobile.substring(0, mobile.length() - 2);
            data[i][7] = sheet.getRow(i + 1).getCell(7).toString();
            data[i][8] = sheet.getRow(i + 1).getCell(8).toString();
        }
        return data;
    }

    @DataProvider(name = "FormAccountDataProvider")
    public Object[][] excelFormData() throws IOException {
        return new FormData().readExcel();
    }
}