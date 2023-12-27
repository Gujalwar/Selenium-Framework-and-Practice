package pom.eurotech.test.day20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDAtaProvider {
    @DataProvider
    public Object[][] testData(){

        String [][] data ={
                {"Game Of Thrones","9"},
                {"Friends","8"},
                {"Prison Break","9"},
                {"Dexter","7"},
                {"Breaking Bad","10"},
                {"Homeland","6"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void testTv(String tvSeries,String rating) {

        System.out.println("Tv Series "+tvSeries+ "has rating "+rating);

    }
}

