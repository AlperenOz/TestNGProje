package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {
    //Day 14, sept 6 2020

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement signInHover = driver.findElement(By.id("nav-link-accountList"));

        Actions act = new Actions(driver);
        act.moveToElement(signInHover);//use perform, but this time it worked

        driver.findElement(By.partialLinkText("Start")).click();

        Assert.assertEquals("Amazon Registration",driver.getTitle() );
    }
    @Test (dependsOnMethods = "test01")
    public void createAccunt(){
       WebElement name =  driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Michael Jackson");

        WebElement emailBox = driver.findElement(By.id("ap_email"));
        emailBox.sendKeys("rastgeleemail@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("ap_password"));
        passwordBox.sendKeys("randompassword!123");

        WebElement rePasswordBox = driver.findElement(By.id("ap_password_check"));
        rePasswordBox.sendKeys("randompassword!1234");

        driver.findElement(By.id("continue")).click();



    }

}
