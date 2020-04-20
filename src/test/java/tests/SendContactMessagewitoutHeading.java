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

import java.util.concurrent.TimeUnit;


public class SendContactMessagewitoutHeading {
    WebDriver driver;
    HomePage homePage;
    ContactUs contactUs;
    Utils myUtil = new Utils();


    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test(testName = "Send Contact Message")
    public void sendContactMessage(){

        String header = "";
        String email = "fulanito@mail.com";
        String order = "234234";
        String file = "/Users/jrestituyo/IdeaProjects/seleniumWebDriver/fileToUpload.txt";
        String message = "this is a message";


        homePage.clickContactUsLink();
        contactUs = new ContactUs(driver);
        Assert.assertEquals(driver.getCurrentUrl(),contactUs.getUrl());
        contactUs.sendForm(header, email, order, file, message);
        Assert.assertTrue(contactUs.isPresentAlertErrorSubject());


    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
