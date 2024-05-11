import org.openqa.selenium.By;
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

    public String testMainPageAfterLogin() {
        return waitAndReturnElement(By.xpath("//h2[@class='h-open' and text()='Kiemelt témák']")).getText();
    }

    public void logout() {
        By logoutButtonLocator = By.xpath("//a[text()='Kilépés']");
        clickOnButton(logoutButtonLocator);
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public WebElement testHoverOnElement() {
        Actions actions = new Actions(this.driver);

        WebElement elementToHover = waitAndReturnElement(By.id("top4-btn"));

        implicitWait();
        actions.moveToElement(elementToHover).perform();

        WebElement tooltip = waitAndReturnElement(By.xpath("//a[@href='/rendeleseim' and text()='Rendeléseim']"));

        return tooltip;
    }

    public SearchResultPage search(String keys) {
        By searchBarLocator = By.xpath("//input[@type='text' and @name='search']");
        WebElement searchBar = this.waitAndReturnElement(searchBarLocator);

        clickOnButton(searchBarLocator);

        searchBar.clear();
        searchBar.sendKeys(keys);

        waitForSearchResultDropDown();

        By searchButtonLocator = By.id("btn_search");
        clickOnButton(searchButtonLocator);

        return new SearchResultPage(this.driver);
    }

    public String readDropDown() {
        By locator = By.xpath("//a[@href='/rendeleseim' and text()='Rendeléseim']");
        return this.waitAndReturnElement(locator).getText();
    }

    public CartPage getCartPage() {
        By locator = By.xpath("//a[@href='/kosar']");
        this.waitAndReturnElement(locator).click();
        return new CartPage(this.driver);
    }

    public WishListPage getWishListPage() {
        By locator = By.xpath("//a[@title='Kevenceim']");
        this.waitAndReturnElement(locator).click();
        return new WishListPage(this.driver);
    }

    public NewProductsPage getNewProductsPage() {
        By locator = By.xpath("//a[text()='Újdonságok']");
        this.waitAndReturnElement(locator).click();
        return new NewProductsPage(this.driver);
    }
}