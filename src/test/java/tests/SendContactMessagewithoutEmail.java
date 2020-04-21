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

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SendContactMessagewithoutEmail {
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
        records = myUtil.readCSVFile("/Users/jrestituyo/IdeaProjects/seleniumWebDriver/data_source.csv");
    }

    @Test(testName = "Send Contact Message")
    public void sendContactMessage() {

        for (String[] record : records) {
            String header = record[0];
            String email = "";
            String order = record[2];
            String file = record[3];
            String message = record[4];


            homePage.clickContactUsLink();
            contactUs = new ContactUs(driver);

            Assert.assertEquals(driver.getCurrentUrl(), contactUs.getUrl());
            contactUs.sendForm(header, email, order, file, message);
            Assert.assertTrue(contactUs.isPresentAlertErrorEmail());
        }


    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
