package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import myUtils.*;


public class SendContactMessageInvalidFile {
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
        String file = "/Users/jrestituyo/IdeaProjects/seleniumWebDriver/invalidFile.jlr";
        String message = "This is a test message";


        homePage.clickContactUsLink();
        contactUs = new ContactUs(driver);
        Assert.assertEquals(driver.getCurrentUrl(),contactUs.getUrl());
        contactUs.sendForm(header, email, order, file, message);
        Assert.assertTrue(contactUs.isPresentAlertErrorFile());


    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
