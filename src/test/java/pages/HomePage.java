package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement signUpAndLoginButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    private WebElement loggedInAs;

    @FindBy(className = "trash")
    private WebElement deleteButton;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickSignUpButton() {
        signUpAndLoginButton.click();
    }

    public WebElement getLoggedInAs() {
        return loggedInAs;
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }
}
