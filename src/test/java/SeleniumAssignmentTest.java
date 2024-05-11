import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


        Assert.assertTrue(mainPage.getPageTitle().contains("Kockashop"));

        WebElement tooltip = mainPage.testHoverOnElement();
        // Assert that the tooltip is displayed
        Assert.assertTrue(tooltip.isDisplayed());
        CartPage cartPage = mainPage.getCartPage();
        Assert.assertTrue(cartPage.getBodyText().contains("kosár"));
        mainPage.navigateBack();


        mainPage.logout();

//        mainPage.openTheSearchBar();
//        SearchResultPage searchResultPage = mainPage.search("Students");
//        mainPage.typeIntoSearchBar("Students\n");By.xpath("//title")
//        Assert.assertTrue(searchResultPage.getBodyText().contains("FOUND"));
//        Assert.assertTrue(searchResultPage.getBodyText().contains("Current Students"));
//
//        searchResultPage.clickByTest("Current Students");
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}