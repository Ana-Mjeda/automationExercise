package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.FakerUtil;

public class TC2LoginUserWithCorrectEmailAndPassword extends BaseTests {

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
    public void loginUserWithCorrectEmailAndPassword() {
        Assert.assertTrue(driver.getCurrentUrl().contains(baseURL));
        homePage.clickSignUpButton();

        loginPage.fillSignUpForm(name, email);
        signUpPage.fillSignUpForm(Title.MRS, password, "27", "March", "2001");
        scroll();
        signUpPage.fillAddressInformation(name, lastName, address, country, state, city, zipcode, number);
        accountCreatedPage.clickContinueButton();
        driver.navigate().refresh();
        accountCreatedPage.clickContinueButton();
        homePage.clickLogoutButton();

        loginPage.waitForLoginUrl();
        Assert.assertEquals(loginPage.getLoginToYourAccount().getText(), "Login to your account");
        loginPage.fillLoginForm(email, password);
        Assert.assertEquals(homePage.getLoggedInAs().getText(), "Logged in as " + name);

        homePage.clickDeleteButton();
        Assert.assertEquals(accountDeletedPage.getAccountDeleted().getText(), "ACCOUNT DELETED!");
    }
}
