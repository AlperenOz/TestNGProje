package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
import java.util.TreeSet;

public class WindowHandleTest extends TestBase {

    /*
    WebDriver object i baslatildiginda her windows a alfanumerik kimlik verir
    bu unique kimlige "window handle" denir
    windows arasinda switch yaparken bu window handle i kullanacagiz
     */

    @Test
    public void multipleWinTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String winHandle1 = driver.getWindowHandle();
        System.out.println(winHandle1);

        driver.findElement(By.partialLinkText("Click")).click();

        Set<String> windHandlesAll = driver.getWindowHandles();//bize set verdi
        System.out.println(windHandlesAll);//now its both of the handles

        //set i array yapip son elemanini aldik
        //son elemani da yeni actigimiz window un handle i
        String winHandleNew = (String) (windHandlesAll.toArray())[windHandlesAll.size()-1];

        driver.switchTo().window(winHandleNew);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue((driver.getCurrentUrl().contains("new")));//pass
        //this to check if we landed on the new page

        driver.switchTo().window(winHandle1);
        sa.assertTrue((driver.getCurrentUrl().contains("new")));//fail

        sa.assertAll();
    }
}
