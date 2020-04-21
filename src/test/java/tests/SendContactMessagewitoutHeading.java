package tests;

import myUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUs;
import pages.HomePage;
import java.io.*;
import java.util.List;



public class SendContactMessagewitoutHeading {
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
            String header = "";
            String email = record[1];
            String order = record[2];
            File file = new File(record[3].trim());
            String message = record[4];

            homePage.clickContactUsLink();
            contactUs = new ContactUs(driver);
            Assert.assertEquals(driver.getCurrentUrl(), contactUs.getUrl());
            contactUs.sendForm(header, email, order, file.getAbsolutePath(), message);
            Assert.assertTrue(contactUs.isPresentAlertErrorSubject());
        }

    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
