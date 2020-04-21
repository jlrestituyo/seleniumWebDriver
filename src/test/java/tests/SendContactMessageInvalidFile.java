package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import myUtils.*;
import java.io.*;

import java.util.List;


public class SendContactMessageInvalidFile {
    WebDriver driver;
    HomePage homePage;
    ContactUs contactUs;
    Utils myUtil = new Utils();
    List<String[]> records = null;

    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        myUtil = new Utils();
        records = myUtil.readCSVFile("data_source.csv");
    }


    @Test(testName = "Send Contact Message")
    public void sendContactMessage() {

        for (String[] record : records) {
            String header = record[0];
            String email = record[1];
            String order = record[2];
            String fileStr = record[3];
            fileStr = fileStr.substring(0,fileStr.length() - 3)+"jlr";
            File file = new File(fileStr.trim());
            String message = record[4];

            homePage.clickContactUsLink();
            contactUs = new ContactUs(driver);
            Assert.assertEquals(driver.getCurrentUrl(), contactUs.getUrl());
            contactUs.sendForm(header, email, order, file.getAbsolutePath(), message);
            Assert.assertTrue(contactUs.isPresentAlertErrorFile());
        }

    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
