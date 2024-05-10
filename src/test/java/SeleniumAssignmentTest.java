import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumAssignmentTest {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
//        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
    }

    @Test
    public void testSelenium() {
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.getFooterText().contains("LEGO"));

        mainPage.acceptNecessaryCookies();
        LoginPage loginPage = mainPage.getLoginPage();
        loginPage.login();

        mainPage.logout();

        mainPage.openTheSearchBar();
//        SearchResultPage searchResultPage = mainPage.search("Students");
//        mainPage.typeIntoSearchBar("Students\n");
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