package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    private By confirmationMessage = By.xpath("//*[contains(text(),'successfully')]");
    private By alertError = By.xpath("//*[text()='There is 1 error']");

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
        Select header = new Select(driver.findElement(subjectHeading));
        header.selectByVisibleText(headerText);
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
        return driver.findElements(confirmationMessage).size() > 0;
    }

    public boolean isPresentAlertErrorMessage(){
        return driver.findElements(alertError).size() > 0;
    }

    public String getUrl(){
        return this.url;
    }


    public List<WebElement> getAllWebElements(){
        List<WebElement> listOfElements = null;
        listOfElements.add(driver.findElement(subjectHeading));
        listOfElements.add(driver.findElement(email));
        listOfElements.add(driver.findElement(orderReference));
        listOfElements.add(driver.findElement(file));
        listOfElements.add(driver.findElement(message));
        listOfElements.add(driver.findElement(sendButton));
        listOfElements.add(driver.findElement(confirmationMessage));
        listOfElements.add(driver.findElement(alertError));

        return listOfElements;

    }



}
