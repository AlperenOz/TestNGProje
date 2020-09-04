package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameTest {
    /*
    IFrame de islem yapmak istiyorsak IFrame e gecis yapmak zorundayiz.
    switchTo i frame demeden webelement bulamayiz code fail verir

    switchTo().frame().

    -- switchTo().frame(index) >> sayfada kac tane iframe varsa ona gore,
                                  ilkinin indexi 0, ikincinin 1 ...

    -- switchTo().frame("id of the frame")

    -- switchTo().frame(WebElement of the frame)


     //TO QUIT IFRAME
     you have to quit iframe otherwise you stuck there

    1)switchTo().defaultContent() >> web page in main body sine geri don
    2)switchTo().parentFrame() >> son girilen iframe in parent webelement ina geri don

    defaultContent daha cok kullanilir

     */

    private WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iFrameIndex(){
        driver.switchTo().frame(0);//get the iframe with the index 0, the first one

        WebElement prg = driver.findElement(By.xpath("//p"));
        prg.clear();//to clean it up
        prg.sendKeys("Hello IFrame!");

    }
    @Test
    public void iFrameID(){
        driver.switchTo().frame("mce_0_ifr");
        WebElement prg = driver.findElement(By.xpath("//p"));
        prg.clear();
        prg.sendKeys("Hello IFrame!");
    }
    @Test
    public void iFrameWE(){
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement prg = driver.findElement(By.xpath("//p"));
        prg.clear();
        prg.sendKeys("Hello IFrame!");


        //Get out of iFrame!!
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement ES = driver.findElement(By.partialLinkText("Elemental"));
        ES.click();
    }

}
