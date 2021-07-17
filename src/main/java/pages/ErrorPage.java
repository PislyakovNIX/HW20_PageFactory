package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='wp-die-message']")
    WebElement errorMessage;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessageError(){
        return errorMessage.getText();
    }
}
