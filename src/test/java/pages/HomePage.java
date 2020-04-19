package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    public WebDriver driver;
    private String url = "http://automationpractice.com/index.php";

    //Locators of Home Page

    private By logo = By.xpath("//*[@id=\"header_logo\"]/a/img");
    private By contactUs = By.xpath("//*[@id=\"contact-link\"]/a");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public void clickContactUsLink(){
        driver.findElement(contactUs).click();
    }

    public String getUrl(){
        return this.url;
    }







}