package org.example.testng.DDT;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {


    // Workbook, Sheet, Row,and Column, Cells

//    Open Stream
//    Understand Workbook
//    Sheet
//    Row, Column
//    Cells
//    Close Stream - give data to the Object[][]


    static Workbook book;
    static Sheet sheet;


    public static String FILE_NAME = "src/test/resources/TestData (2).xlsx";

    public static Object[][] getTestData(String sheetName) throws IOException {
        // Write the logic to read the excel file and convert this to array

        FileInputStream file = null;
        file = new FileInputStream(FILE_NAME);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);

        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i  < sheet.getLastRowNum() ; i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum() ; j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }

        }

        return data;
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestData("Sheet1");
    }

















}
