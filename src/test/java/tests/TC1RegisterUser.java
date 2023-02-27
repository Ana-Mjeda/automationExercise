package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC1RegisterUser extends BaseTests {

    private HomePage homePage;

    private LoginPage loginPage;

    private SignUpPage signUpPage;

    private AccountCreatedPage accountCreatedPage;

    private AccountDeletedPage accountDeletedPage;

    private Faker faker = new Faker();

    private String name = faker.name().fullName();

    private String email = faker.internet().emailAddress();

    private String password = faker.internet().password();

    private String lastName = faker.name().lastName();

    private String address = faker.address().streetAddress();

    private String country = "Australia";

    private String state = faker.address().state();

    private String city = faker.address().city();

    private String zipcode = faker.address().zipCode();

    private String number = faker.phoneNumber().phoneNumber();

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        accountCreatedPage = new AccountCreatedPage(driver, driverWait);
        accountDeletedPage = new AccountDeletedPage(driver, driverWait);
    }

    @Test
    public void registerUser() {

        Assert.assertTrue(driver.getCurrentUrl().contains(baseURL));
        homePage.clickSignUpButton();

        loginPage.waitForLoginUrl();
        Assert.assertEquals(loginPage.getNewUserSignupText().getText(), "New User Signup!");
        loginPage.fillSignUpForm(name, email);
        signUpPage.waitForSignUpUrl();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Assert.assertEquals(signUpPage.getEnterAccountText().getText(), "ENTER ACCOUNT INFORMATION");
        signUpPage.fillSignUpForm(Title.MRS, password, "27", "March", "2001");
        signUpPage.clickNewsletter();
        signUpPage.clickSpecialOffers();
        signUpPage.fillAddressInformation(name, lastName, address, country, state, city, zipcode, number);

        Assert.assertEquals(accountCreatedPage.getAccountCreated().getText(), "ACCOUNT CREATED!");
        accountCreatedPage.clickContinueButton();
        driver.navigate().refresh();
        accountCreatedPage.clickContinueButton();
        Assert.assertEquals(homePage.getLoggedInAs().getText(), "Logged in as " + name);

        homePage.clickDeleteButton();
        Assert.assertEquals(accountDeletedPage.getAccountDeleted().getText(), "ACCOUNT DELETED!");

    }

}
