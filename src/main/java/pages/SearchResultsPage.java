package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='filter_size']")
    WebElement sizeFilter;

    @FindBy(xpath = "//div[contains(@class,'noo-product-item')]")
    WebElement firstProduct;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSize(String size){
        Select select = new Select(sizeFilter);
        select.selectByVisibleText(size);
    }

    public void clickOnFirstProduct(){
        firstProduct.click();
    }
}
