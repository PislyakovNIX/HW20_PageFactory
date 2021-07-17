package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlesBylsharmPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='The New Marc Jacobs Gotham Saddle Bag']")
    WebElement readMoreButton;

    public ArticlesBylsharmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickReadMoreButton(){
        readMoreButton.click();
    }
}
