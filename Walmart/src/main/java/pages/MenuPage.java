package pages;

import base.CommonAPI;
import database.ConnectToSqlDB;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuPage extends CommonAPI {


    public static void readMenuText(WebDriver driver1,String filePath) throws  Exception, IOException, SQLException, ClassNotFoundException {
        List<String> actualData = new ArrayList<String>();
        List<String> listOfMenu = CommonAPI.getTextFromWebElements("#SearchDropdown-list");
        System.out.println("List of Walmar Menu from the Website of Walmart:");
        for(String data:listOfMenu){
            System.out.println(data);
        }
        System.out.println("********************************************************\n");

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToSqlTable(listOfMenu,"WalmartMenuItemList","items",filePath);
        actualData = connectToSqlDB.readDataBase("WalmartMenuItemList","items", filePath);
        System.out.println("List of Walmart Menu from Mysql Databae :");
        for(String data : actualData){
            System.out.println(data);
        }
        Assert.assertEquals(listOfMenu,actualData);
    }

}
