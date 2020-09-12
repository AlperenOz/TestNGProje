package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {

    /*
    to double click, drag and drop, scroll down and overall MOUSE & KEYBOARD ACTIONS >> ActionsClass

    *** to use Actions CREATE AN OBJECT from Actions and put driver into it
    Actions act = new Actions(driver);

    *** HAVE TO USE .perform(), otherwise nothing happens (google it)

    MOUSE ACTIONS

    doubleClick() >> to double click
    clickAndHold() >> cursor i serbest birakmadan uzun tiklama
    dragAndDrop() >> to drag and drop an element
    moveToElement() >> to move the cursot to an element without clicking
    contextClick() >> right click
    Scroll Up-Down

    KEYBOARD ACTIONS

    sendKeys() >> to use keys in the keyboard, we use Keys Class inside
    e.g. sendKeys(Keys.TAB).perform(); >> presses TAB
    keyUp() >> tusu serbest birakma (release)
    keyDown() >> to press the key
     */


    @Test
    public void rightClick(){
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement hotSpotBox = driver.findElement(By.id("hot-spot"));

        Actions act = new Actions(driver);

        //RIGHT CLICK
        act.contextClick(hotSpotBox).perform();

        driver.switchTo().alert().accept();
    }

    @Test
    public void doubleClick(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        //DOUBLE CLICK
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();
    }
    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");

        WebElement signInHidden = driver.findElement(By.id("nav-link-accountList"));

        //HOVER OVER
        Actions act = new Actions(driver);
        act.moveToElement(signInHidden).perform();
    }
    @Test
    public void upDownPage() {
        driver.get("http://amazon.com");

        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();//bir tik asagi iner

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        act.sendKeys(Keys.END).perform();//goes to the end of the page
        act.sendKeys(Keys.PAGE_UP).perform();//bir tik yukari cikar
        act.sendKeys(Keys.ARROW_UP).perform();//klavyedeki yukari oka basar
    }
    @Test
    public void keyUpDown(){
        driver.get("http://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        //Keys.SHIFT tusa basar ama birakmaz, bizim onu birakmamiz lazim
        //searchBox.sendKeys(Keys.SHIFT + "hello google");
        //shift e basili tuttu

        Actions act = new Actions(driver);
        act.moveToElement(searchBox).click()
                //shift e basili
                .keyDown(Keys.SHIFT).sendKeys("hey there")
                //shift ten kaldirildi
                .keyUp(Keys.SHIFT).sendKeys(" how are you doin?")
                .perform();
    }
    @Test
    public void dragnDrop(){
        driver.get("http://google.com");
        WebElement googleLogo = driver.findElement(By.id("hplogo"));
        WebElement searchBox = driver.findElement(By.name("q"));

        Actions act = new Actions(driver);
        //logo yu al searchbox a tasi
        act.dragAndDrop(googleLogo,searchBox).perform();
        //google izin vermedi ama normalde olur

    }



}
