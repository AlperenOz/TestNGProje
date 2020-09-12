package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {
    /*
    http://fhctrip-qa.com/admin/HotelRoomAdmin e git
    tbody da kac roll var yazdir
    3. roll daki data lari yazdir
     */

    public void logIn(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        WebElement UserNameBox = driver.findElement(By.name("UserName"));
        UserNameBox.sendKeys("manager2");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test(){
        logIn();

        List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(list.size());

        List<WebElement> thirdRoll = driver.findElements(By.xpath("//tbody/tr[3]"));
        for (WebElement w: thirdRoll) {
            System.out.println(w.getText());
        }

    }

}
