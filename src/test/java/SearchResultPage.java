import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends PageBase {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        waitAndReturnElement(bodyLocator);
    }

    public String getBodyText() {
        return waitAndReturnElement(bodyLocator).getText();
    }
}