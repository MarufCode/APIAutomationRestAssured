package org.example.testng.DDT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class ddt01 {
    // Test Data - From the Excel File
    // Read the Excel file - Apache POI -  Little difficult to understand first time.
    // Fillo Library -  Super Easy



    // test Case - Login where we will inject the username and password

    // Excel -> Yhere is no support directly in Java to read the excel File
    // Apache POI Library -
    // Excel - 2007 xls, 2007-> xlsx, CSV - Comma Separated values


   //  To read The File
    // 1.Open The Workbook
//    2.open the Sheet
//    3.open The Row and Column
//    4.Open the Cell



    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)

    public void testLogin(String username, String password, String ER, String AR){
        System.out.println("username" + " " + username);
        System.out.println("password" + " " + password);
        System.out.println("ER" +" " + ER);
        System.out.println("AR" + " " + AR);
    }

    // Login to app API
    // Write the code to Login POST Request
    //


}
