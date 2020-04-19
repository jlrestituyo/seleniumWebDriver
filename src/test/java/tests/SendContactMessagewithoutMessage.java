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


public class SendContactMessagewithoutMessage {
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

        String header = "Webmaster";
        String email = "fulanito@mail.com";
        String order = "999";
        String file = "logo.png";
        String message = "";


        homePage.clickContactUsLink();
        contactUs = new ContactUs(driver);

        //TODO Change this for a wait proper method
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),contactUs.getUrl());
        contactUs.sendForm(header, email, order, file, message);
        Assert.assertTrue(contactUs.isPresentAlertErrorMessage());


    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
