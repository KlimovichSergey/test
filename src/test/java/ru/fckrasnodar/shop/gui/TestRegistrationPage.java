package ru.fckrasnodar.shop.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRegistrationPage extends TestBase {

    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickLinkUserAccount();
    }

    @Test
    @DisplayName("Click button form registration and searching text field")
    public void openRegistrationFormGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();

        Assertions.assertEquals("РЕГИСТРАЦИЯ", registrationPage.getHeaderPageText());
        Assertions.assertEquals("Фамилия *", registrationPage.getFieldLastNameText());
        Assertions.assertEquals("Имя *", registrationPage.getFieldFirstNameText());
        Assertions.assertEquals("Отчество", registrationPage.getFieldMiddleNameText());
        Assertions.assertEquals("Телефон *", registrationPage.getFieldPhoneText());
        Assertions.assertEquals("Email *", registrationPage.getFieldEmailText());
        Assertions.assertEquals("День рождения", registrationPage.getFieldBirthdayText());
        Assertions.assertEquals("Пароль *", registrationPage.getFieldPasswordText());
        Assertions.assertEquals("Подтвердите пароль *", registrationPage.getFieldConfirmPasswordText());
        Assertions.assertEquals("Я даю своё согласие на обработку моих персональных данных и принимаю Пользовательское соглашение", registrationPage.getFieldTermAcceptedText());
        Assertions.assertEquals("Уже регистрировались? Вход", registrationPage.getFieldQuestionSignUpeText());
    }

    @Test
    @DisplayName("Click submit to give consent to the processing of my personal data without filling in fields")
    public void clickMyPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Поле обязательное", registrationPage.getLastNameErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getFirstNameErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getPhoneErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getEmailErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getPasswordErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getPasswordConfirmErrorMessageText());
    }

    @Test
    @DisplayName("Enter incorrect values in required fields (*) and submit user and don't accepted personal data")
    public void inputRequiredFieldClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("@#$%^^Po&&12344");
        registrationPage.sendKeysPlaceHolderFirstName("Ww@54$#@");
        registrationPage.sendKeysPlaceHolderPhone("0000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@Test");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("hh@!43FR");
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Email-адрес введен неправильно", registrationPage.getInvalidEmailText());
        Assertions.assertEquals("Пароли не совпадают", registrationPage.getNoMatchPasswordConfirmText());
        Assertions.assertEquals("Подтвердите согласие", registrationPage.getNoTermAcceptedText());
    }

    @Test
    @DisplayName("Enter empty last name(*) and first name(*), and input incorrect email(*), don't accepted personal data and submit user")
    public void inputEmailPasswordPhoneConfirmPasswordClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("");
        registrationPage.sendKeysPlaceHolderFirstName("");
        registrationPage.sendKeysPlaceHolderPhone("0000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@Test");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("hh@!43FR");
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Поле обязательное", registrationPage.getLastNameErrorMessageText());
        Assertions.assertEquals("Поле обязательное", registrationPage.getFirstNameErrorMessageText());
        Assertions.assertEquals("Email-адрес введен неправильно", registrationPage.getInvalidEmailText());
        Assertions.assertEquals("Пароли не совпадают", registrationPage.getNoMatchPasswordConfirmText());
    }

    @Test
    @DisplayName("Registration user incorrect last name(*) and first name(*), email(*), don't accepted personal data and submit user")
    public void inputIncorrectLastNameFirstNameClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("@#$%^^Po&&12344");
        registrationPage.sendKeysPlaceHolderFirstName("Ww@54$#@");
        registrationPage.sendKeysPlaceHolderPhone("0000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@test10.com");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Подтвердите согласие", registrationPage.getNoTermAcceptedText());
    }

    @Test
    @DisplayName("Register the user  correct fill in all required fields(*) and accepted personal data")
    public void inputFillAllRequiredFieldsAcceptPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("Test");
        registrationPage.sendKeysPlaceHolderFirstName("Test");
        registrationPage.sendKeysPlaceHolderPhone("9000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@test10.com");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Неправильная дата", registrationPage.getSingUpErrorMessageText());
    }

    @Test
    @DisplayName("Register the user correct fill in all fields and don't accepted personal data")
    public void inputFieldsClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("Test");
        registrationPage.sendKeysPlaceHolderFirstName("Test");
        registrationPage.sendKeysPlaceHolderMiddleName("Test");
        registrationPage.sendKeysPlaceHolderPhone("9000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@test10.com");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickLinkSelectDay();
        registrationPage.clickBirthdayPlaceHolderDay();
        registrationPage.clickLinkSelectMonth();
        registrationPage.clickBirthdayPlaceHolderMonth();
        registrationPage.sendKeysBirthdayPlaceHolderYear("0000");
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Подтвердите согласие", registrationPage.getNoTermAcceptedText());
        Assertions.assertEquals("15",registrationPage.getTestDayText());
        Assertions.assertEquals("АПРЕЛЬ",registrationPage.getTestMonthText());
    }

    @Test
    @DisplayName("Register the user with exists Email and accepted personal data")
    public void inputFieldClickPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("Test");
        registrationPage.sendKeysPlaceHolderFirstName("Test");
        registrationPage.sendKeysPlaceHolderMiddleName("Test");
        registrationPage.sendKeysPlaceHolderPhone("9000000000");
        registrationPage.sendKeysPlaceHolderEmail("test@test9.com");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickLinkSelectDay();
        registrationPage.clickBirthdayPlaceHolderDay();
        registrationPage.clickLinkSelectMonth();
        registrationPage.clickBirthdayPlaceHolderMonth();
        registrationPage.sendKeysBirthdayPlaceHolderYear("0000");
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Пользователь с таким же значением поля «Email» уже зарегистрирован.",registrationPage.getEmailExistText());
    }
}
