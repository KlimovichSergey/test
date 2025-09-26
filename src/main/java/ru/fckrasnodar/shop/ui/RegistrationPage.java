package ru.fckrasnodar.shop.ui;

import org.openqa.selenium.By;
import ru.fckrasnodar.shop.singleton.WebDriver;

public class RegistrationPage {
    private final String BUTTON_REGISTRATION_FORM = "//div[@class='login-form-register']//button";
    private final String HEADER_PAGE_TEXT = "//div[@class='s-profile-wrapper s-steps-wrapper']//h1";
    private final String FIELD_LAST_NAME_TEXT = "//div[@data-field-id='lastname']//div[@class='wa-name']";
    private final String FIELD_FIRST_NAME_TEXT = "//div[@data-field-id='firstname']//div[@class='wa-name']";
    private final String FIELD_MIDDLE_NAME_TEXT = "//div[@data-field-id='middlename']//div[@class='wa-name']";
    private final String FIELD_PHONE_TEXT = "//div[@data-field-id='phone']//div[@class='wa-name']";
    private final String FIELD_EMAIL_TEXT = "//div[@data-field-id='email']//div[@class='wa-name']";
    private final String FIELD_BIRTHDAY_TEXT = "//div[@data-field-id='birthday']//div[@class='wa-name']";
    private final String FIELD_PASSWORD_TEXT = "//div[@data-field-id='password']//div[@class='wa-name']";
    private final String FIELD_CONFIRM_PASSWORD_TEXT = "//div[@data-field-id='password_confirm']//div[@class='wa-name']";
    private final String FIELD_TERM_ACCEPTED_TEXT = "//div[@class='wa-value']//label";
    private final String FIELD_QUESTION_SIGN_UP_TEXT = "//div[@class='wa-login-url']";
    private final String BUTTON_SUBMIT = "//div[@class='wa-buttons-wrapper']//input";
    private final String ACCEPTED_CHECK_BOX = "//div[@class='wa-value']//label//input[@name='data[terms_accepted]']";
    private final String LAST_NAME_ERROR_MESSAGE_TEXT = "//div[@data-field-id='lastname']//em[@class='wa-error-msg']";
    private final String FIRST_NAME_ERROR_MESSAGE_TEXT = "//div[@data-field-id='firstname']//em[@class='wa-error-msg']";
    private final String PHONE_ERROR_MESSAGE_TEXT = "//div[@data-field-id='phone']//em[@class='wa-error-msg']";
    private final String REGISTR_EMAIL_ERROR_MESSAGE_TEXT = "//div[@data-field-id='email']//em[@class='wa-error-msg']";
    private final String PASSWORD_ERROR_MESSAGE_TEXT = "//div[@data-field-id='password']//em[@class='wa-error-msg']";
    private final String PASSWORD_CONFIRM_ERROR_MESSAGE_TEXT = "//div[@data-field-id='password_confirm']//em[@class='wa-error-msg']";
    private final String PLACE_HOLDER_LAST_NAME = "//input[@name='data[lastname]']";
    private final String PLACE_HOLDER_FIRST_NAME = "//input[@name='data[firstname]']";
    private final String PLACE_HOLDER_PHONE = "//input[@name='data[phone]']";
    private final String PLACE_HOLDER_EMAIL = "//input[@name='data[email]']";
    private final String PLACE_HOLDER_PASSWORD = "//input[@name='data[password]']";
    private final String PLACE_HOLDER_PASSWORD_CONFIRM = "//input[@name='data[password_confirm]']";
    private final String PLACE_HOLDER_MIDDLE_NAME = "//input[@name='data[middlename]']";
    private final String INVALID_EMAIL_TEXT = "//div[@class='wa-value']//em[@data-error-code='invalid']";
    private final String NO_MATCH_PASSWORD_CONFIRM_TEXT = "//div[@class='wa-value']//em[@data-error-code='not_match']";
    private final String NO_TERM_ACCEPTED_TEXT = "//div[@class='wa-value']//em[@data-error-code='0']";
    private final String SIGN_UP_ERROR_MESSAGE_TEXT = "//div[@class='wa-uncaught-errors']//em";
    private final String EMAIL_EXISTS_TEXT = "//div[@data-field-id='email']//em[@data-error-code='exists']";
    private final String LINK_SELECT_DAY = "//div[@data-field-id='birthday']//span[@class='fake-select'][1]";
    private final String BIRTHDAY_PLACE_HOLDER_DAY = "//span[@class='fake-select focused']//span[text()='15']";
    private final String TEST_DAY_TEXT = "//div[@class='wa-value']//strong[text()='15']";
    private final String LINK_SELECT_MONTH = "//div[@data-field-id='birthday']//span[@class='fake-select'][2]";
    private final String BIRTHDAY_PLACE_HOLDER_MONTH = "//span[@class='fake-select focused']//span[text()='Апрель']";
    private final String TEST_MONTH_TEXT = "//div[@class='wa-value']//strong[text()='Апрель']";
    private final String BIRTHDAY_PLACE_HOLDER_YEAR = "//div[@data-field-id='birthday']//input[@name='data[birthday][year]']";
    org.openqa.selenium.WebDriver driver;

    public RegistrationPage(){
        this.driver = WebDriver.getDriver();
    }

    public void clickButtonRegistrationForm(){
        WebDriver.getDriver().findElement(By.xpath(BUTTON_REGISTRATION_FORM)).click();
    }

    public String getHeaderPageText(){
        return WebDriver.getDriver().findElement(By.xpath(HEADER_PAGE_TEXT)).getText();
    }

    public String getFieldLastNameText(){
        return WebDriver.getDriver().findElement(By.xpath(FIELD_LAST_NAME_TEXT)).getText();
    }

    public String getFieldFirstNameText(){
        return WebDriver.getDriver().findElement(By.xpath(FIELD_FIRST_NAME_TEXT)).getText();
    }

    public String getFieldMiddleNameText(){
        return WebDriver.getDriver().findElement(By.xpath(FIELD_MIDDLE_NAME_TEXT)).getText();
    }

    public String getFieldPhoneText(){
        return WebDriver.getDriver().findElement(By.xpath(FIELD_PHONE_TEXT)).getText();
    }

    public String getFieldEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_EMAIL_TEXT)).getText();
    }

    public String getFieldBirthdayText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_BIRTHDAY_TEXT)).getText();
    }

    public String getFieldPasswordText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_PASSWORD_TEXT)).getText();
    }

    public String getFieldConfirmPasswordText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_CONFIRM_PASSWORD_TEXT)).getText();
    }

    public String getFieldTermAcceptedText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_TERM_ACCEPTED_TEXT)).getText();
    }

    public String getFieldQuestionSignUpeText() {
        return WebDriver.getDriver().findElement(By.xpath(FIELD_QUESTION_SIGN_UP_TEXT)).getText();
    }

    public void clickButtonSubmit(){
        WebDriver.getDriver().findElement(By.xpath(BUTTON_SUBMIT)).click();
    }

    public void clickAcceptedCheckBox(){
        WebDriver.getDriver().findElement(By.xpath(ACCEPTED_CHECK_BOX)).click();
    }

    public String getLastNameErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(LAST_NAME_ERROR_MESSAGE_TEXT)).getText();
    }

    public String getFirstNameErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(FIRST_NAME_ERROR_MESSAGE_TEXT)).getText();
    }

    public String getPhoneErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(PHONE_ERROR_MESSAGE_TEXT)).getText();
    }

    public String getEmailErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(REGISTR_EMAIL_ERROR_MESSAGE_TEXT)).getText();
    }

    public String getPasswordErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(PASSWORD_ERROR_MESSAGE_TEXT)).getText();
    }

    public String getPasswordConfirmErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(PASSWORD_CONFIRM_ERROR_MESSAGE_TEXT)).getText();
    }

    public void sendKeysPlaceHolderLastName(String lastName) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_LAST_NAME)).sendKeys(lastName);
    }

    public void sendKeysPlaceHolderFirstName(String firstName) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_FIRST_NAME)).sendKeys(firstName);
    }

    public void sendKeysPlaceHolderMiddleName(String middleName) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_MIDDLE_NAME)).sendKeys(middleName);
    }

    public void sendKeysPlaceHolderPhone(String phone) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_PHONE)).sendKeys(phone);
    }

    public void sendKeysPlaceHolderEmail(String email) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_EMAIL)).sendKeys(email);
    }

    public void sendKeysPlaceHolderPassword(String password) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_PASSWORD)).sendKeys(password);
    }

    public void sendKeysPlaceHolderPasswordConfirm(String passwordConfirm) {
        WebDriver.getDriver().findElement(By.xpath(PLACE_HOLDER_PASSWORD_CONFIRM)).sendKeys(passwordConfirm);
    }

    public String getInvalidEmailText() {
        return WebDriver.getDriver().findElement(By.xpath(INVALID_EMAIL_TEXT)).getText();
    }

    public String getNoMatchPasswordConfirmText() {
        return WebDriver.getDriver().findElement(By.xpath(NO_MATCH_PASSWORD_CONFIRM_TEXT)).getText();
    }

    public String getNoTermAcceptedText() {
        return WebDriver.getDriver().findElement(By.xpath(NO_TERM_ACCEPTED_TEXT)).getText();
    }

    public String getSingUpErrorMessageText() {
        return WebDriver.getDriver().findElement(By.xpath(SIGN_UP_ERROR_MESSAGE_TEXT)).getText();
    }

    public void clickLinkSelectDay() {
        WebDriver.getDriver().findElement(By.xpath(LINK_SELECT_DAY)).click();
    }

    public void clickBirthdayPlaceHolderDay() {
        WebDriver.getDriver().findElement(By.xpath(BIRTHDAY_PLACE_HOLDER_DAY)).click();
    }

    public String getTestDayText() {
        return WebDriver.getDriver().findElement(By.xpath(TEST_DAY_TEXT)).getText();
    }

    public void clickLinkSelectMonth() {
        WebDriver.getDriver().findElement(By.xpath(LINK_SELECT_MONTH)).click();
    }

    public void clickBirthdayPlaceHolderMonth() {
        WebDriver.getDriver().findElement(By.xpath(BIRTHDAY_PLACE_HOLDER_MONTH)).click();
    }

    public String getTestMonthText() {
        return WebDriver.getDriver().findElement(By.xpath(TEST_MONTH_TEXT)).getText();
    }

    public void sendKeysBirthdayPlaceHolderYear(String yearBirthday) {
        WebDriver.getDriver().findElement(By.xpath(BIRTHDAY_PLACE_HOLDER_YEAR)).sendKeys(yearBirthday);
    }

    public String getEmailExistText() {
        return WebDriver.getDriver().findElement(By.xpath(EMAIL_EXISTS_TEXT)).getText();
    }
}
