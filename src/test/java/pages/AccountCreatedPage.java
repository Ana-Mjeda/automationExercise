package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement accountCreated;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAccountCreated() {
        return accountCreated;
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
