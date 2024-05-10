import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By bodyLocator = By.tagName("body");

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void setCookies() {
        Cookie cookie = new Cookie("marketing", "false", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("CookieConsent", "%2718zdd1/pgF1nMYPTTjHndevwZbRT19J0Oci9HXUP2xKGh6LPHqwotQ==%27",
                            ".kockashop.hu", "/", new Date(2025, 6, 14, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("ver", "1", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("preferences", "false", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("CookieConsent",
                            "{stamp:%27haLf70qKjvIaaj6IaFzRIF9UlEk4JMeqD+R++uN+NWK4GnEET7dBCA==%27%2Cnecessary:true%2Cpreferences:false%2Cstatistics:false%2Cmarketing:false%2Cmethod:%27explicit%27%2Cver:1%2Cutc:1715346714921%2Cregion:%27hu%27}",
                            ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 11, 54), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("method", "%27explicit%27", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("necessary", "true", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("utc", "1715343904118", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("mobile", "0", ".kockashop.hu", "/", new Date(2024, 8, 18, 3, 8, 57), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("PHPSESSID", "i0e64ufsopr2nb732snf6lq502", ".kockashop.hu", "/",
                            new Date(2024, 8, 18, 3, 8, 57), false);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("region", "%27hu%27", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        cookie = new Cookie("statistics", "false", ".kockashop.hu", "/", new Date(2025, 5, 10, 3, 9, 4), true);
        this.driver.manage().addCookie(cookie);

        this.driver.navigate().refresh();
    }
}