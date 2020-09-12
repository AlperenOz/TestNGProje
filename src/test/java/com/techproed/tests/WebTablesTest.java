package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {
    /*
    thead >> table head
    tbody >> table body
    tr    >> table roll, satir
    td    >> table data

    =note=
    / vs // in xpath

    / >> the child of the tag, bir altindaki, bu sadece child a bakar
        ; e.g. //tbody/tr/td

    // >> alttaki her elemena bakar, yani bu child olabilir torun
          olabilir vs. e.g. //tbody//td ; bu tr lere bkmadan direkt td lara gider
     */


    public void logIn(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        WebElement UserNameBox = driver.findElement(By.name("UserName"));
        UserNameBox.sendKeys("manager2");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void table() throws InterruptedException {
        logIn();
        Thread.sleep(2000);//wait 2 sec to load
        driver.findElement(By.partialLinkText("Rooms")).click();


        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        System.out.println("============================================");

        List<WebElement> ths = driver.findElements(By.xpath("//thead/tr/th"));
        for(WebElement w: ths) {
            System.out.println(w.getText());
        }
    }
    @Test
    public void alltheRolls(){
        logIn();

        //all the rolls
        List<WebElement> allRolls = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w: allRolls){
            System.out.println(w.getText());
        }

        System.out.println("=========================================");

        //all the table data, just put /td
        List<WebElement> allData = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement w: allData){
            System.out.println(w.getText());
        }
    }
    @Test
    public void specificColumn(){
        logIn();

        //her tr in 4. data sini alirsak 4. sutun (column) yazilir
        List<WebElement> forthColumn = driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for (WebElement w: forthColumn) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void run(){
        logIn();
        cellsPrint(3,5);
        cellsPrint(1,6);
        cellsPrint(9,3);
        cellsPrint(5,4);
    }

    public void cellsPrint(int roll, int colmn){

        //istedigin satiri sutunu sec
        String xpathValue = "//tbody/tr["+roll+"]/td["+colmn+"]";

        WebElement specificCell = driver.findElement(By.xpath(xpathValue));
        System.out.println(specificCell.getText());
    }

}
