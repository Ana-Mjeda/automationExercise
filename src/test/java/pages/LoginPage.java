package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginToYourAccount;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    private WebElement loginEmail;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signUpButton;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNewUserSignupText() {
        return newUserSignupText;
    }

    public WebElement getLoginToYourAccount() {
        return loginToYourAccount;
    }

    public void fillSignUpForm(String name, String email) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        signUpButton.click();
    }

    public void fillLoginForm(String email, String password) {
        this.loginEmail.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void waitForLoginUrl() {
        driverWait.until(ExpectedConditions.urlContains("/login"));
    }
}
