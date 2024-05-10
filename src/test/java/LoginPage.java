import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameLocator = By.id("login-usr");
    private By passwordLocator = By.id("login-psw");
    private By loginButtonLocator = By.id("login-submit");

    public void login() {
        this.waitAndReturnElement(usernameLocator).sendKeys("testingselenium309@gmail.com");

        this.waitAndReturnElement(passwordLocator).sendKeys("C7V43WgyeIWHWYFgI13V");

        this.waitAndReturnElement(loginButtonLocator).click();
    }
}