package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitlyWaitTest extends TestBase {
    /*
    ImplicitlyWait her elementi bulana kadar bekler. Bulamazsa throws exception.
    Tumu element ler icin kullanilir


    EXPLICITLY WAIT

    -** Sadece bir WebElement icin kullanilir, ona atanir.
    -** Kullanmak icin WebDriverWait den object olusturmali **-
    -** WebDriverWait constructor ina beklemesini istedgimiz driver i ve ne kadar beklenilcekese yaz **-
    e.g. WebDriverWait wait = new WebDriverWait(driver,10);

    -** wait i kullanarak beklmeme condition ini belirle (bunu ezberle)
    e.g. wait.until(ExpectedCondtions.visibilityOfElementLocated(By.id("id")));

    -** bu condition/method u WebElement e ata
    WebElement element = wait.until(.....)));

    -cok daha dinamik

    Thread.sleep()              vs                 explicitlyWait()
  1) Bekleme suresi static                      1) bekleme suresi dynamic
        yani 10 sn denirse 10 sn bekler             eger condition a ulasirsa daha beklemez
  2)condition yok                               2)condition a bagli tamamen
  3)Java ya ait bir code, tum code lari         3)Selenium a ait, selenium u bekltir
    bekletir

     */


    @Test
    public void implicitlyWaitTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
        Assert.assertTrue(element.isDisplayed());
    }
    @Test
    public void explicitWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //Create the object
        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();



        WebElement message =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //id si "message" olan eleman gorunur olana kadar 20 sn bekle

        System.out.println(message.getText());


    }

}
