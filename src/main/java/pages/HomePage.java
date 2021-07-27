package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;


public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='s']")
    WebElement searchField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchText(String text){
        Actions actions = new Actions(driver);
        searchButton.click();
        searchField.sendKeys(text);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }
}
