package datasource;

import database.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static String filePath = "/Users/mirouflyer/Desktop/ FrameWorkProject/Team10FinalFramework/Walmart/src/test/resources/secret.properties";
    static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public static void insertDataInDB(){
        List<String> list = getItemValue();
       // connectToSqlDB.insertDataFromArrayListToSqlTable(list,"WalmartItemList","items",filePath);
        connectToSqlDB.insertDataFromArrayListToSqlTable(list,"WalmartMenuItemList","items",filePath);

    }

    public static List<String> getItemValue(){
        List<String> itemList = new ArrayList<String>();
        itemList.add("Laptop");
        itemList.add(("Selenium Book"));
        itemList.add(("Samsung S10"));
        itemList.add("Honey");
        itemList.add("Bleach");
        itemList.add("Toys");
//        itemList.add("NitendoDs");
//        itemList.add("Headset");

        return itemList;
    }

    public List<String> getItemListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException{
        List<String> list = new ArrayList<String>();
        list = connectToSqlDB.readDataBase("WalmartItemList","items",filePath);
        return list ;
    }

    public List<String> getItemListFromDB1() throws Exception, IOException, SQLException, ClassNotFoundException{
        List<String> list = new ArrayList<String>();
        list = connectToSqlDB.readDataBase("WalmartMenuItemList","items",filePath);
        return list ;
    }

    public static void main(String[] args) throws  Exception, IOException, SQLException, ClassNotFoundException {
       // insertDataInDB();


        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        List<String> list = connectToSqlDB.readDataBase("WalmartItemList","items",filePath);
        for(String st:list){
            System.out.println(st);
        }
    }
}
