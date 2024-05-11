import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumAssignmentTest {

    private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
    }

    @Test
    public void testSelenium() {
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.getFooterText().contains("LEGO"));

        LoginPage loginPage = mainPage.getLoginPage();
        loginPage.login();

        mainPage.waitAfterLogin();

        Assert.assertTrue(mainPage.getPageTitle().contains("Kockashop"));

        SearchResultPage searchResultPage = mainPage.search("Csillagromboló");

        Assert.assertTrue(searchResultPage.getBodyText().contains("Találatok"));
        Assert.assertTrue(searchResultPage.getBodyText().contains("Csillagromboló"));

        mainPage.navigateBack();

        CartPage cartPage = mainPage.getCartPage();
        Assert.assertTrue(cartPage.getBodyText().contains("kosár"));
        mainPage.navigateBack();

        WishListPage wishListPage = mainPage.getWishListPage();
        Assert.assertTrue(wishListPage.getBodyText().contains("Kedvenceim"));
        mainPage.navigateBack();

        NewProductsPage newProductsPage = mainPage.getNewProductsPage();
        Assert.assertTrue(newProductsPage.getBodyText().contains("Újdonságok"));
        mainPage.navigateBack();

        Assert.assertTrue(mainPage.testHoverOnElement().isDisplayed());

        Assert.assertEquals(mainPage.readDropDown(), "Rendeléseim");

        mainPage.logout();
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}