package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DependsOnMethodsTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    //dependsOnMethods()
    //amazon calistigi zaman once googleTest calisacak, sonra amazon
    //yani amazonTest() depends on googleTest(), they are linked
    //ayni method cagirmak gibi

    @Test (dependsOnMethods = "googleTest")
    public void amazonTest(){
        //googleTest();
        //ayni bunun gibi yani
        driver.get("http://amazon.com");
    }
    @Test (dependsOnMethods = "fbTest")
    public void googleTest(){
        driver.get("http://google.com");
    }

    @Test
    public void fbTest(){
        driver.get("http://facebook.com");
    }
}
