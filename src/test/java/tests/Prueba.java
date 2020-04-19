package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import javax.swing.*;


public class Prueba {
    WebDriver driver;
    HomePage homePage;
    ContactUs contactUs;


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


        homePage.clickContactUsLink();
        contactUs = new ContactUs(driver);
        Assert.assertEquals(driver.getCurrentUrl(),contactUs.getUrl());
        contactUs.sendForm(header, email, order, file);

        //JOptionPane.showMessageDialog(null, contactUs.getConfirmationMessage());
    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
