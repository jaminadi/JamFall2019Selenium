package com.automation.tests.day25_excel_io;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {
        //we need to get the file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value); // execute
        System.out.println(secondCellValue);// username

        int lastCell = firstRow.getLastCellNum();

        System.out.println("######################");

        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) + " |");
        }

        //last row is 16, not 15 --> index is 15 because it starts from 0, so we can add + 1
        int numberOfRows = workSheet.getLastRowNum();
        //returns the quantity of rows in total
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

        System.out.println("\nIndex of last row: " + numberOfRows);
        System.out.println("Number of rows: " + numberOfRows2);

        System.out.println("######################");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }


    }
}
