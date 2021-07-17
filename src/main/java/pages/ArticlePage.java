package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='author']")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//textarea[@id='comment']")
    WebElement commentField;

    @FindBy(xpath = "//input[@id='submit']")
    WebElement submitButton;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void leaveComment(){
        nameField.sendKeys("John");
        emailField.sendKeys("test@fff.com");
        commentField.sendKeys("Lorem ipsum");
        submitButton.click();

    }


}
