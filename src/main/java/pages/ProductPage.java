package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//td[@class='product-name']//*")
    WebElement productName;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement colorDropDown;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement sizeDropDown;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[normalize-space()='View cart']")
    WebElement viewCartButton;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSizeFirstOptionInDropdown(){
        Select select = new Select(sizeDropDown);
        select.selectByIndex(1);
    }

    public void chooseColorFirstOptionInDropdown(){
        Select select = new Select(colorDropDown);
        select.selectByIndex(1);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnViewCartButton(){
        viewCartButton.click();
    }

    public String getProductName(){
        return productName.getText();
    }
}
