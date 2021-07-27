package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class DemoQaShopTests {

    private ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<>();

    @Step("Allure log: {0}")
    public void allureLog(String message) {
        System.out.println(message);
    }

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
        WEBDRIVER_CONTAINER.remove();
    }

    public WebDriver getDriver() {
        return WEBDRIVER_CONTAINER.get();
    }

    public void setDriver(WebDriver driver) {
        WEBDRIVER_CONTAINER.set(driver);
    }

    @Test
    public void test_A() {
        ArticlesBylsharmPage articlesBylsharmPage = new ArticlesBylsharmPage(getDriver());
        ArticlePage articlePage = new ArticlePage(getDriver());
        ErrorPage errorPage = new ErrorPage(getDriver());

        allureLog("Open web page");
        getDriver().get("http://shop.demoqa.com/author/lsharm/");
        allureLog("Click Read More button");
        articlesBylsharmPage.clickReadMoreButton();
        allureLog("Create comment");
        articlePage.leaveComment();
        allureLog("Checking message");
        Assert.assertEquals(errorPage.getMessageError(), "Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");
    }

    @Test
    public void test_B() {

        HomePage homePage = new HomePage(getDriver());
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        getDriver().manage().window().maximize();

        getDriver().get("http://shop.demoqa.com/author/lsharm/");
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

    @Parameters("stringsForTest")
    @Test(dataProvider = "stringsForTest", dataProviderClass = DataProviderClass.class)
    public void test_forHW20(String fullName, String email, String currentAddress, String permanentAddress) {

        FillFormPage fillFormPage = new FillFormPage(getDriver());

        getDriver().get("https://demoqa.com/text-box");

        fillFormPage.fillFullName(fullName);
        fillFormPage.fillEmail(email);
        fillFormPage.fillCurrentAddress(currentAddress);
        fillFormPage.fillPermanentAddress(permanentAddress);
        fillFormPage.submitForm();
    }
}
