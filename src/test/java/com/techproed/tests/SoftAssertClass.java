package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertClass {
    /*
    SoftAssert vs HardAssert

    SoftAssert >> Verify
    HardAssert >> Assert

    1)SoftAssert de test fail olsa bile kod calismaya devam eder
    2)SoftAssert de object olusturulmak zorunda
    3)SoftAssert de birden fazla dogrulama(verification) yapilabilir
     */

    WebDriver driver;
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

    @Test
    public void test01(){
        driver.get("http://amazon.com");

        String title = driver.getTitle();
        SoftAssert sa = new SoftAssert();

        sa.assertTrue(title.contains("shop"));
        sa.assertEquals("amazooon",title);
        sa.assertFalse(title.contains("sacmalik!!"));

        //assertAll yapmazsak test her zaman pass gorunur!
        //we need assertAll() to reach into conclusion
        //assertAll kendinden onceki softAssert leri kontrol eder.
        //eger hepsi pass ise test pass olur, eger en az bir tane bile fail varsa test fail
        // asaigda run kisminda testin nerede fail oldugunu yazar
        //yani hardAssert gibi
        sa.assertAll();
    }

    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert sa = new SoftAssert();

        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        sa.assertTrue(driver.getTitle().toLowerCase().contains("address"));//does the title have "address" in it? PASS

        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");
        sa.assertTrue(passwordBox.getText().equals("yanlisPassword"));//sifreyi dogru yazabildik mi?
        passwordBox.submit();

        WebElement signOutLink = driver.findElement(By.partialLinkText("out"));


        sa.assertAll();//kesinlikle olmali
                       //ayni hardAssert gibi



    }
}
