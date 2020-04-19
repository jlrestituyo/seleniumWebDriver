package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


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
    private By confirmationMessage = By.xpath("//*[@id=\"center_column\"]/p");

    public ContactUs(WebDriver driver){
        this.driver = driver;
    }

    public void sendForm(String header, String email, String orderReference, String file){
        setHeader(header);
        setEmail(email);
        setOrderReference(orderReference);
        //setFile(file);
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

    public String getUrl(){
        return this.url;
    }






}
