package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillFormPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement fullNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement emailField;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddressField;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    WebElement permanentAddressField;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;

    public FillFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFullName(String fullName){
        fullNameField.sendKeys(fullName);
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);
    }

    public void fillCurrentAddress(String currentAddress){
        currentAddressField.sendKeys(currentAddress);
    }

    public void fillPermanentAddress(String permanentAddress){
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void submitForm(){
        submitButton.click();
    }
}
