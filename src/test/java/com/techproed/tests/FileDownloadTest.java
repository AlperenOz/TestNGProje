package com.techproed.tests;

import com.google.common.base.Verify;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    /*
    TO CHECK THE FILE/FOLDER EXISTS

    Files.exists(Paths.get("path of the file"));

    burasi Java ile alakali, selenium la degil
     */

    @Test
    public void isFileExist(){
        System.out.println(System.getProperty("user.dir"));
        //the current path >> C:\Users\xx\IdeaProjects\TestNGProje

        System.out.println(System.getProperty("user.home"));
        //the main folder of the user >> C:\Users\xx

        String pomxmlPath = System.getProperty("user.dir") + "/pom.xml";

        boolean isExist = Files.exists(Paths.get(pomxmlPath));
        System.out.println(isExist);//true

        Assert.assertTrue(isExist);//pass
        Verify.verify(Files.exists(Paths.get(pomxmlPath)));//pass,
    }

    //PC DEN INTERNETE FILE UPLOAD
    @Test
    public void fileUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        chooseFileButton.sendKeys("C:\\Users\\xx\\Pictures\\WP\\19660_en_1.jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedText = driver.findElement(By.tagName("h3"));
        System.out.println(fileUploadedText.getText());

        Assert.assertTrue(fileUploadedText.isDisplayed());
    }
    @Test
    public void fileDownload(){
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement img_7 = driver.findElement(By.partialLinkText("IMG_7"));
        img_7.click();

        //10 sn bekle ki img i indirsin
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isExists = Files.exists(Paths.get("C:\\Users\\xx\\Downloads\\IMG_7684.jpg"));
        Assert.assertTrue(isExists);
    }
}
