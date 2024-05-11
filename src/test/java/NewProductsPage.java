import org.openqa.selenium.WebDriver;

public class NewProductsPage extends PageBase {

    public NewProductsPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public String getBodyText() {
        return waitAndReturnElement(bodyLocator).getText();
    }
}