import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        By usernameLocator = By.id("login-usr");
        By passwordLocator = By.id("login-psw");
        By loginButtonLocator = By.id("login-submit");

        this.waitAndReturnElement(usernameLocator).sendKeys("testingselenium309@gmail.com");

        this.waitAndReturnElement(passwordLocator).sendKeys("C7V43WgyeIWHWYFgI13V");

        clickOnButton(loginButtonLocator);
    }
}