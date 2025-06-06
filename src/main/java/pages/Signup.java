package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Signup extends Base {
    // <--------------------------> Locators  <-------------------------->
    // sign up
    private final By loginPagePath = By.xpath("//a[normalize-space()='Signup / Login']");
    private final By nameInput = By.xpath("//input[@placeholder='Name']");
    private final By mailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn = By.xpath("//button[normalize-space()='Signup']");
    // account info page
    private final By titleInput = By.xpath("//input[@id='id_gender1']"); //Mr
    private final By passInput = By.xpath("//input[@id='password']");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By receiveOffersCheckbox = By.id("optin");
    //Address Information
    private final By firstNameInput = By.xpath("//input[@id='first_name']");
    private final By lastNameInput = By.xpath("//input[@id='last_name']");
    private final By companyInput = By.xpath("//input[@id='company']");
    private final By addressStreetInput = By.xpath("//input[@id='address1']");
    private final By address2Input = By.xpath("//input[@id='address2']");
    private final By countryDropdown = By.xpath("//select[@id='country']");
    private final By stateInput = By.xpath("//input[@id='state']");
    private final By cityInput = By.xpath("//input[@id='city']");
    private final By zipcodeInput = By.xpath("//input[@id='zipcode']");
    private final By mobileNumInput = By.xpath("//input[@id='mobile_number']");
    private final By createAccountBtn = By.xpath("//button[normalize-space()='Create Account']");
    private final By confirmMessage = By.xpath("//b[normalize-space()='Account Created!']");
    private final By continueBtn = By.xpath("//a[@class='btn btn-primary']");

    public Signup(WebDriver driver) {
        super(driver);
    }

    public Signup(Actions actions, JavascriptExecutor js) {
        super(actions, js);
    }

    // <--------------------------> Actions methods  <-------------------------->
    //open login and signup page
    public void openLoginAndSignupPage() {
        driver.findElement(loginPagePath).click();
    }

    //methods for sign up first page
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterMail(String mail) {
        driver.findElement(mailInput).sendKeys(mail);
    }

    public void clickSignupBtn() {
        driver.findElement(signupBtn).click();
    }


    // following sign up, entering the user info
    public void selectTitle() {
        driver.findElement(titleInput).click();
    }

    public void enterPass(String pass) {
        driver.findElement(passInput).sendKeys(pass);
    }

    public void selectDay(String berthDay) {
        WebElement dayElement = driver.findElement(dayDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dayElement);
        new Select(driver.findElement(dayDropdown)).selectByVisibleText(berthDay);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(yearDropdown)).selectByVisibleText(year); //??
    }

    public void markNewsCheckbox() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void receiveOfferCheckbox() {
        driver.findElement(receiveOffersCheckbox).click();
    }

    public void nameAndAddresses(String firstName, String lastName, String companyName, String addressStreet, String address2) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(companyInput).sendKeys(companyName);
        driver.findElement(addressStreetInput).sendKeys(addressStreet);
        driver.findElement(address2Input).sendKeys(address2);
    }

    public void setCountryDropdown(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void stateAndCity(String state, String city) {
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
    }

    public void zipCode(String zip) {
        driver.findElement(zipcodeInput).sendKeys(zip);
    }

    public void mobileNumber(String mobilNum) {
        driver.findElement(mobileNumInput).sendKeys(mobilNum);
    }

    public void createAccountBtn() {
        scrollBy(0, 100);
        driver.findElement(createAccountBtn).click();
    }

    public void printSignupConfirmationMessage() {
        WebElement successTitleElement = driver.findElement(confirmMessage);
        String successTitle = successTitleElement.getText();
        System.out.println(successTitle);
    }

    public void clickContinueBtn() {
        driver.findElement(continueBtn).click();
    }


}