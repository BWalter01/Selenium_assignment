import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    public CartPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public String getBodyText() {
        return waitAndReturnElement(bodyLocator).getText();
    }
}