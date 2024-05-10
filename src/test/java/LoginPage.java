import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {

    private By usernameLocator = By.id("login-usr");
    private By passwordLocator = By.id("login-psw");
    private By loginButtonLocator = By.id("login-submit");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        this.waitAndReturnElement(usernameLocator).sendKeys("testingselenium309@gmail.com");

        this.waitAndReturnElement(passwordLocator).sendKeys("C7V43WgyeIWHWYFgI13V");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        implicitWait();
        js.executeScript("arguments[0].click();", loginButton);

    }
}