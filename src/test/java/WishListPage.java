import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase {

    public WishListPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public String getBodyText() {
        return waitAndReturnElement(bodyLocator).getText();
    }
}