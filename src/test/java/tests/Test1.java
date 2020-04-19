package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class Test1 {
    WebDriver driver;
    HomePage hp;


    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        hp = new HomePage(driver);
    }

    @Test(testName = "Prueba1")
    public void prueba(){
        driver.findElement(hp.getPromoLink()).click();
    }

    @AfterClass
    public void cleanUp(){
        if(driver != null){
            //driver.quit();
        }
    }

}
