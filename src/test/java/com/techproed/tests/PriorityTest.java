package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTest {
    private WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    //TESTLERN CALISMA SIRASI ALFABETIK SIRAYA GORE!
    //BU YUZDEN PRIORITY KULLANACAGIZ


    @Test (priority = 1)
    public void dropDowntest(){
        driver.navigate().to("http://amazon.com");
    }
    @Test (priority = 2)
    public void titleTest(){
        driver.get("http://facebook.com");
    }

    @Test ()
    public void googleSearchTest(){
        driver.get("http://google.com");
    }



}
