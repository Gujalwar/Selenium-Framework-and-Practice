package pom.eurotech.test.day20_DDF;

import org.testng.annotations.Test;
import pom.eurotech.utilities.ExcelUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {
    @Test
    public void readExcelFile() {


        //Create am object from ExcelUtil
        //it accepts two arguments
        //Argument 1: location of file path
        //Argument 2: sheet that we want to open (sheetName)

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xlsx","Login Test");

        //how many rows in the sheet
        System.out.println("testData.rowCount() = " + testData.rowCount());

        //how many columns in the sheet
        System.out.println("testData.columnCount() = " + testData.columnCount());

        //get all columns names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());

        //get all data in list of maps

        List<Map<String, String>> dataList = testData.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }

        //get print Gulcan's company "Amazon"
        String gulcansCompany = dataList.get(2).get("Company");
        System.out.println("gulcansCompany = " + gulcansCompany);

        //get Erkan's Title "Intern"
        System.out.println("dataList.get(5).get(\"Title\") = " + dataList.get(5).get("Title"));

        //get Nihan's name "Nihan"
        System.out.println("dataList.get(3).get(\"Name\") = " + dataList.get(3).get("Name"));

        //get array
        String[][] dataArray = testData.getDataArray();
        System.out.println("dataArray = " + Arrays.deepToString(dataArray));
    }
}

