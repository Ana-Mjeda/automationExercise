package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2")
    private WebElement enterAccountText;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "id_gender1")
    private WebElement mr;

    @FindBy(id = "id_gender2")
    private WebElement mrs;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    private WebElement createAccountButton;

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEnterAccountText() {
        return enterAccountText;
    }

    public void chooseTitle(Title title) {

        switch (title) {
            case MR:
                mr.click();
                break;
            case MRS:
                mrs.click();
                break;
        }
    }

    public void selectDayOfBirth(String dateOfBirth) {
        Select date = new Select(day);
        date.selectByVisibleText(dateOfBirth);
    }

    public void selectMonthOfBirth(String dateOfBirth) {
        Select date = new Select(month);
        date.selectByVisibleText(dateOfBirth);
    }

    public void selectYearOfBirth(String dateOfBirth) {
        Select date = new Select(year);
        date.selectByVisibleText(dateOfBirth);
    }

    public void fillSignUpForm(Title title, String password, String day, String month, String year) {
        chooseTitle(title);
        this.password.sendKeys(password);
        selectDayOfBirth(day);
        selectMonthOfBirth(month);
        selectYearOfBirth(year);
    }

    public void clickNewsletter() {
        newsletterCheckbox.click();
    }

    public void clickSpecialOffers() {
        specialOffersCheckbox.click();
    }

    public void waitForSignUpUrl() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
    }

    public void selectCountry(String text) {
        Select countrySelect = new Select(country);
        countrySelect.selectByValue(text);
    }

    public void fillAddressInformation(String name, String lastName, String address, String country, String state, String city, String zipcode, String number) {
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        selectCountry(country);
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
        this.mobileNumber.sendKeys(number);
        createAccountButton.click();
    }

}
