package ru.fckrasnodar.shop.ui;

import org.openqa.selenium.By;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class LoginPage {
    private final String INPUT_PROFILE_TEXT = "//div[@class='s-profile-wrapper']//h1";
    private final String FIELD_EMAIL_TEXT = "//div[@class='wa-field wa-field-login ']//div[@class='wa-name']";
    private final String LOGIN_INPUT_PLACEHOLDER_EMAIL = "//input[@placeholder='Email']";
    private final String FIELD_PASSWORD_TEXT = "//div[@data-field-id='password']//div[@class='wa-name']";
    private final String REMEMBER_ME_TEXT = "//div[@class='wa-value']//label";
    private final String FORGOT_PASSWORD_TEXT = "//a[@class='wa-login-forgotpassword-url']";
    private final String REGISTRATION_FORM_TEXT = "//div[@class='login-form-register']//h2";
    private final String REGISTRATION_FORM_INFORMATIONAL_TEXT = "//div[@class='login-form-register']//p";
    private final String INPUT_PLACEHOLDER_PASSWORD = "//input[@name='password']";
    private final String BUTTON_LOGIN_SUBMIT = "//input[@class='wa-login-submit']";
    private final String EMAIL_ERROR_TEXT = "//em[@data-name='login']";
    private final String PASSWORD_ERROR_TEXT = "//em[@data-name='password']";
    private final String SUBMIT_ERROR_TEXT = "//em[@data-name='auth']";
    private final String CHECK_BOX_REMEMBER = "//label//input[@type='checkbox']";
    org.openqa.selenium.WebDriver driver;

    public LoginPage() {
        this.driver = WebDriver.getDriver();
    }

    public String getInputProfileText() {
        return WebDriver.getDriver().findElement(By.xpath(INPUT_PROFILE_TEXT)).getText();
    }

    public String getFieldEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_EMAIL_TEXT)).getText();
    }

    public void sendKeysLoginPlaceHolderEmail(String email) {
        WebDriver.getDriver().findElement(By.xpath(LOGIN_INPUT_PLACEHOLDER_EMAIL)).sendKeys(email);
    }

    public String getFieldPasswordText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_PASSWORD_TEXT)).getText();
    }

    public void sendKeysPlaceHolderPassword(String password) {
        WebDriver.getDriver().findElement(By.xpath(INPUT_PLACEHOLDER_PASSWORD)).sendKeys(password);
    }

    public String getRememberMeText() {
        return WebDriver.getDriver().findElement(By.xpath(REMEMBER_ME_TEXT)).getText();
    }

    public String getForgotPasswordText() {
        return WebDriver.getDriver().findElement(By.xpath(FORGOT_PASSWORD_TEXT)).getText();
    }


    public String getRegistrationFormText() {
        return WebDriver.getDriver().findElement(By.xpath(REGISTRATION_FORM_TEXT)).getText();
    }

    public String getRegistrationFormInformationalText() {
        return WebDriver.getDriver().findElement(By.xpath(REGISTRATION_FORM_INFORMATIONAL_TEXT)).getText();
    }

    public void clickButtonLoginSubmit() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_LOGIN_SUBMIT)).click();
    }

    public String getSubmitErrorText() {
        return WebDriver.getDriver().findElement(By.xpath(SUBMIT_ERROR_TEXT)).getText();
    }

    public String getEmailErrorText() {
        return WebDriver.getDriver().findElement(By.xpath(EMAIL_ERROR_TEXT)).getText();
    }

    public String getPasswordErrorText() {
        return WebDriver.getDriver().findElement(By.xpath(PASSWORD_ERROR_TEXT)).getText();
    }

    public void clickCheckBoxRemember() {
        WebDriver.getDriver().findElement(By.xpath(CHECK_BOX_REMEMBER)).click();
    }
}
