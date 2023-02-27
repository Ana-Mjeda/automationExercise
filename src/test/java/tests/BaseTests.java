package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected final String baseURL = "https://automationexercise.com";

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AccountCreatedPage accountCreatedPage;
    protected AccountDeletedPage accountDeletedPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        accountCreatedPage = new AccountCreatedPage(driver, driverWait);
        accountDeletedPage = new AccountDeletedPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
