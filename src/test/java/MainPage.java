import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://kockashop.hu/");
        setCookies();
    }

    public String getFooterText() {
        return this.waitAndReturnElement(By.className("footer")).getText();
    }

    public LoginPage getLoginPage() {
        By locator = By.xpath("//a[text()='Belépés']");
        this.waitAndReturnElement(locator).click();
        return new LoginPage(this.driver);
    }

    public void logout() {
        By locator = By.xpath("//a[text()='Kilépés']");

        WebElement logoutButton = this.waitAndReturnElement(locator);

        implicitWait();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutButton);

    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public WebElement testHoverOnElement() {
        // Create an instance of Actions class
        Actions actions = new Actions(this.driver);

        // Find the element to hover over
        WebElement elementToHover = waitAndReturnElement(By.id("top4-btn"));
        // Find the tooltip that should appear when hovering over the element

        implicitWait();
        // Perform the hover action
        actions.moveToElement(elementToHover).perform();

        // Wait for the tooltip to become visible
        WebElement tooltip = waitAndReturnElement(By.xpath("//a[@href='/rendeleseim' and text()='Rendeléseim']"));

        return tooltip;
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