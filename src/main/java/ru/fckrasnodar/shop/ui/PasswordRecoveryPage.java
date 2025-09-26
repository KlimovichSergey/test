package ru.fckrasnodar.shop.ui;

import org.openqa.selenium.By;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class PasswordRecoveryPage {
    private final String LINK_FORGOT_PASSWORD = "//a[@href='/forgotpassword/']";
    private final String HEADER_FORGOT_PASSWORD_TEXT = "//div[@class='s-profile-wrapper']//h1";
    private final String FORGOT_PASSWORD_FORM_EMAIL_TEXT = "//div[@data-field-id='login']//div[@class='wa-name']";
    private final String ERROR_MESSAGE_EMAIL_TEXT = "//em[@data-name='login']";
    private final String INPUT_EMAIL_RECOVERY_PASSWORD = "//div[@class='wa-value']//input[@name='login']";
    private final String BUTTON_RECOVERY_PASSWORD = "//div[@class='wa-forgotpassword-button']";
    private final String RECOVERY_PASSWORD_INFO_MESSAGE_TEXT = "//div[@data-name='sent']";
    org.openqa.selenium.WebDriver driver;

    public PasswordRecoveryPage() {
        this.driver = WebDriver.getDriver();
    }

    public void clickLinkForgotPassword() {
        WebDriver.getDriver().findElement(By.xpath(LINK_FORGOT_PASSWORD)).click();
    }

    public String getForgotPasswordFormEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(FORGOT_PASSWORD_FORM_EMAIL_TEXT)).getText();
    }

    public String getHeaderForgotPasswordText() {
        return WebDriver.getDriver().findElement(By.xpath(HEADER_FORGOT_PASSWORD_TEXT)).getText();
    }

    public void sendInputEmailRecoveryPassword(String email) {
        WebDriver.getDriver().findElement(By.xpath(INPUT_EMAIL_RECOVERY_PASSWORD)).sendKeys(email);
    }

    public String getErrorMessageEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(ERROR_MESSAGE_EMAIL_TEXT)).getText();
    }

    public void clickButtonRecoveryPassword() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_RECOVERY_PASSWORD)).click();
    }

    public String getRecoveryPasswordInfoMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(RECOVERY_PASSWORD_INFO_MESSAGE_TEXT)).getText();
    }

    public boolean getDisplayedEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(INPUT_EMAIL_RECOVERY_PASSWORD)).isDisplayed();
    }
}
