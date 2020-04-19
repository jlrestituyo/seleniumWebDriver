package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    protected static WebDriver driver;


    //Locators of Home Page
    private By promoLink = By.xpath("//*[@id=\"header\"]/div[1]/div/div/a/img");
    private By logo = By.xpath("//*[@id=\"header_logo\"]/a/img");


    public HomePage(WebDriver driver){
        this.driver = driver; 
    }

    public By getPromoLink(){
        return this.promoLink;
    }

    public By getLogo(){
        return this.logo;
    }





}