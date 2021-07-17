package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//td[@class='product-name']//*")
    WebElement productTitle;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyThatProductIsInTheCart(String expectedTitle){
        Assert.assertEquals(productTitle.getText(), expectedTitle);
    }
}
