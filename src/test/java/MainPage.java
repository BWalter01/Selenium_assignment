import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class MainPage extends PageBase{

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://kockashop.hu/");
        setCookies();
    }

    public String getFooterText() {
        return this.waitAndReturnElement(By.className("footer")).getText();
    }

    public void acceptNecessaryCookies() {
        By locator = By.xpath("//button[text()='Elengedhetetlen sütik elfogadása']");
        this.waitAndReturnElement(locator).click();
    }

    public LoginPage getLoginPage() {
        By locator = By.xpath("//a[text()='Belépés']");
        this.waitAndReturnElement(locator).click();
        return new LoginPage(this.driver);
    }

    public void logout() {
        By locator = By.xpath("//a[text()='Fiókom']");
        this.waitAndReturnElement(locator).click();

        locator = By.xpath("//a[text()='Kilépés']");
        this.waitAndReturnElement(locator).click();
    }



    public void openTheSearchBar() {
        this.waitAndReturnElement(By.className("search-bar-toggler")).click();
    }

    public void typeIntoSearchBar(String keys) {
        this.waitAndReturnElement(By.name("search")).sendKeys(keys);
    }

    public SearchResultPage search(String keys) {
        this.waitAndReturnElement(By.className("search-field")).sendKeys(keys + "\n");
        return new SearchResultPage(this.driver);
    }
}