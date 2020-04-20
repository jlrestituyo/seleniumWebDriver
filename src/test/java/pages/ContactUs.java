package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ContactUs {
    public WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=contact";


    //Locators of Contact us page
    private By subjectHeading = By.name("id_contact");
    private By email = By.name("from");
    private By orderReference = By.name("id_order");
    private By file = By.name("fileUpload");
    private By message = By.name("message");
    private By sendButton = By.name("submitMessage");
    private By sendSuccessfully = By.xpath("//*[contains(text(),'successfully')]");
    private By alertErrorSubject = By.xpath("//*[contains(text(),'select a subject')]");
    private By alertErrorOrder = By.xpath("//*[contains(text(),'select a subject')]");
    private By alertErrorEmail = By.xpath("//*[contains(text(),'Invalid email')]");
    private By alertErrorFile = By.xpath("//*[contains(text(),'Bad file')]");
    private By alertErrorMessage = By.xpath("//*[contains(text(),'message cannot be blank')]");

    public ContactUs(WebDriver driver){
        this.driver = driver;
    }

    public void sendForm(String header, String email, String orderReference, String file, String message){
        setHeader(header);
        setEmail(email);
        setOrderReference(orderReference);
        setFile(file);
        setMessage(message);
        clickSendButton();
    }


    public void setHeader(String headerText){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(subjectHeading));
        Select header = new Select(driver.findElement(subjectHeading));
        if(headerText.equals("")){

        }else {
            header.selectByVisibleText(headerText);
        }
    }

    public void setEmail(String emailText){
        driver.findElement(email).sendKeys(emailText);
    }

    public void setOrderReference(String orderReferenceText){
        driver.findElement(orderReference).sendKeys(orderReferenceText);
    }

    public void setFile(String filePath){
        ((JavascriptExecutor) driver).executeScript("arguments[0].enabled = true", driver.findElement(file));
        driver.findElement(file).sendKeys(filePath);

    }

    public void setMessage(String messageText){
        driver.findElement(message).sendKeys(messageText);
    }

    public void clickSendButton(){
        driver.findElement(sendButton).click();
    }

    public boolean isPresentConfirmationMessage(){
        return driver.findElements(sendSuccessfully).size() > 0;
    }

    public boolean isPresentAlertErrorSubject(){
        return driver.findElements(alertErrorSubject).size() > 0;
    }

    public boolean isPresentAlertErrorEmail(){
        return driver.findElements(alertErrorEmail).size() > 0;
    }

    public boolean isPresentAlertErrorOrder(){
        return driver.findElements(alertErrorOrder).size() > 0;
    }

    public boolean isPresentAlertErrorFile(){
        return driver.findElements(alertErrorFile).size() > 0;
    }

    public boolean isPresentAlertErrorMessage(){
        return driver.findElements(alertErrorMessage).size() > 0;
    }

    public String getUrl(){
        return this.url;
    }



}
