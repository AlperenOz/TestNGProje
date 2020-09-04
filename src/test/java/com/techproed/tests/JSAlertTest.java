package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
/*

HTML Alert lerine inspect yapip isimize devam edebiliriz,
fakat JS Alert lerine inspect yapilamaz ve de sayfada islem yapabilmek icin once alert lerin
halledilmesi gerkir. JSALert lar sanki baska bir sayfaymis gibi halledilir:

driver.switchTo()alert().

switchTo().alert().getText() = get text of the alert
switchTo().alert().sendKeys() = alert a mesaji gonder
switchTo().alert().accept() = to click the "OK" button in the alert
switchTo().alert().dismiss() = to click the "Cancel" button in the alert

== note ==
surekli driver.switchTo().alert() demek yerine Alert Interface indan object de
cagirilabilir.

Alert alert = driver.switchTo().alert();
alert.accept();
alert.sendKeys("Alert object is initialized");
alert.dismiss();
alert.getText();
 */



public class JSAlertTest {
    private WebDriver driver;
    @BeforeClass
    public void startup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void JsAlert(){
        //<button onclick="jsAlert()">Click for JS Alert</button>

        //we got the JSAlert and clicked
        WebElement JSAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSAlertButton.click();

        //Unlike HTMLAlerts, JSAlerts CANNOT BE INSPECTED. So, alert e tiklayabilmek
        //icin JSALert e gecis yapmamiz gerek

        //switchTo().alert()

        //to tget the alert message in string
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        //to click the "OK" button in the alert
        driver.switchTo().alert().accept();
    }
    @Test
    public void JSConfirm(){
        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement JSAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSAlertButton.click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();

        //Assert kismi
        WebElement resultText = driver.findElement(By.id("result"));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(resultText.getText().contains("Cancel"));//pass
        sa.assertAll();//pass
    }
    @Test
    public void JSPrompt(){

        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        System.out.println(driver.switchTo().alert().getText());

        String message = "message to the prompt";
        driver.switchTo().alert().sendKeys(message);//
        driver.switchTo().alert().accept();//

        WebElement resultText = driver.findElement(By.id("result"));
        String result = resultText.getText();//You entered: message to the prompt
        Assert.assertTrue(result.contains(message));
    }
    @Test
    public void alertKucukBilgi(){
        //ISTERSEK ALERT INTERFACE INDAN DEGER OLUSTURUP ONUN UZERINDEN GIT!
        //boylece surekli switchTo dememize gerek kalmaz

        //Alert interface inden ata
        Alert alert = driver.switchTo().alert();

        alert.accept();
        alert.sendKeys("Alert object is initialized");
        alert.dismiss();
        alert.getText();
    }
}
