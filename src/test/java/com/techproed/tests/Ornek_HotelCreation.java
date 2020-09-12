package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

public class Ornek_HotelCreation extends TestBase {

    @BeforeMethod
    public void logIn(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement UserNameBox = driver.findElement(By.name("UserName"));
        UserNameBox.sendKeys("manager2");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void hotelCreation(){
        WebElement code = driver.findElement(By.id("Code"));
        code.sendKeys("208A");

        WebElement name = driver.findElement(By.id("Name"));
        name.sendKeys("Euphoria");

        WebElement address = driver.findElement(By.id("Address"));
        address.sendKeys("9 Harbour St E, Collingwood, ON L9Y 5B5");

        WebElement phone = driver.findElement(By.id("Phone"));
        phone.sendKeys("645322322");

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("euphoriaHotel@gmail.com");

        WebElement IDGroup = driver.findElement(By.id("IDGroup"));
        Select sel = new Select(IDGroup);
        sel.selectByIndex(1);//Type2

        driver.findElement(By.id("btnSubmit")).click();

        //alert yarim sn gec ciktigi icin beklememiz lazim
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));

        Assert.assertTrue(alert.isDisplayed());

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

    }

}
