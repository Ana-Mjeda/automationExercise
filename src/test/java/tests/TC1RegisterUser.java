package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Title;
import utils.FakerUtil;

public class TC1RegisterUser extends BaseTests {

    String name = FakerUtil.name();

    String lastName = FakerUtil.lastName();

    String address = FakerUtil.address();

    String email = FakerUtil.email();

    String password = FakerUtil.password();

    String city = FakerUtil.city();

    String state = FakerUtil.state();

    String zipcode = FakerUtil.zipcode();

    String number = FakerUtil.number();

    private String country = "Australia";

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test
    public void registerUser() {

        Assert.assertTrue(driver.getCurrentUrl().contains(baseURL));
        homePage.clickSignUpButton();

        loginPage.waitForLoginUrl();
        Assert.assertEquals(loginPage.getNewUserSignupText().getText(), "New User Signup!");
        loginPage.fillSignUpForm(name, email);
        signUpPage.waitForSignUpUrl();

        scroll();
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
