package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExceLFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream); // create(inputStream,password "psw can be entered here")
        inputStream.close();

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);//2nd row
        Cell cell = row.getCell(5);//get result column

        System.out.println("Before: " + cell.getStringCellValue());
        cell.setCellValue("FAILED");//I am changing from n/a to passed
        System.out.println("After: " + cell.getStringCellValue());

        Row firstRow = sheet.getRow(0); // get first row
        Cell newCell = firstRow.createCell(6);//create new cell
        newCell.setCellValue("Date of execution");//give the name to this cell

        //write date and time info into second row, last column

        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);//create a cell
        newCell2.setCellValue(LocalDateTime.now().toString());//I will set current date and time info into new cell


        // I create if  I want to write something into the file
        //don't forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);//write changes
        workbook.close();//close when everything is done
        outputStream.close();
        /**
         * Close the underlying input resource (File or Stream),
         *  from which the Workbook was read.
         *
         * <p>Once this has been called, no further
         *  operations, updates or reads should be performed on the
         *  Workbook.
         */

//        Row row13 = sheet.getRow(13);
//        Cell cell1 = row13.getCell(row.getLastCellNum()-2);
//        System.out.println(cell1.getStringCellValue());

    }
}
