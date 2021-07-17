package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class DemoQaShopTests {

    private WebDriver driver;

    @BeforeMethod
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        setDriver(driver);
    }

    @AfterMethod
    public void driverQuit() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void test_A(){
        ArticlesBylsharmPage articlesBylsharmPage = new ArticlesBylsharmPage(driver);
        ArticlePage articlePage = new ArticlePage(driver);
        ErrorPage errorPage = new ErrorPage(driver);

        driver.get("http://shop.demoqa.com/author/lsharm/");
        articlesBylsharmPage.clickReadMoreButton();
        articlePage.leaveComment();
        Assert.assertEquals(errorPage.getMessageError(), "Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");
    }

    @Test
    public void test_B(){

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        getDriver().manage().window().maximize();

        driver.get("http://shop.demoqa.com/author/lsharm/");
        homePage.searchText("Blue");
        searchResultsPage.chooseSize("37");
        searchResultsPage.clickOnFirstProduct();
        productPage.chooseColorFirstOptionInDropdown();
        productPage.chooseSizeFirstOptionInDropdown();
        productPage.clickAddToCartButton();
        productPage.clickOnViewCartButton();

        String expectedTitle = (productPage.getProductName()).toUpperCase();
        cartPage.verifyThatProductIsInTheCart(expectedTitle);

        System.out.println();
    }
}
