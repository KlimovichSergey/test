package ru.fckrasnodar.shop.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertAll(
                () -> assertEquals("РЕГИСТРАЦИЯ", registrationPage.getHeaderPageText()),
                () -> assertEquals("Фамилия *", registrationPage.getFieldLastNameText()),
                () -> assertEquals("Имя *", registrationPage.getFieldFirstNameText()),
                () -> assertEquals("Отчество", registrationPage.getFieldMiddleNameText()),
                () -> assertEquals("Телефон *", registrationPage.getFieldPhoneText()),
                () -> assertEquals("Email *", registrationPage.getFieldEmailText()),
                () -> assertEquals("День рождения", registrationPage.getFieldBirthdayText()),
                () -> assertEquals("Пароль *", registrationPage.getFieldPasswordText()),
                () -> assertEquals("Подтвердите пароль *", registrationPage.getFieldConfirmPasswordText()),
                () -> assertEquals("Я даю своё согласие на обработку моих персональных данных и принимаю Пользовательское соглашение", registrationPage.getFieldTermAcceptedText()),
                () -> assertEquals("Уже регистрировались? Вход", registrationPage.getFieldQuestionSignUpeText())
        );
    }

    @Test
    @DisplayName("Click submit to give consent to the processing of my personal data without filling in fields")
    public void clickMyPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        assertAll(
                () -> assertEquals("Поле обязательное", registrationPage.getLastNameErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getFirstNameErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getPhoneErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getEmailErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getPasswordErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getPasswordConfirmErrorMessageText())
        );
    }

    @Test
    @DisplayName("Enter incorrect values in required fields (*) and submit user and don't accepted personal data")
    public void inputRequiredFieldClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName(RandomUser.getRandomLastName());
        registrationPage.sendKeysPlaceHolderFirstName(RandomUser.getRandomFirstName());
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail("test@Test");
        registrationPage.sendKeysPlaceHolderPassword(RandomUser.getRandomPassword());
        registrationPage.sendKeysPlaceHolderPasswordConfirm("hh@!43FR");
        registrationPage.clickButtonSubmit();

        assertAll(
                () -> assertEquals("Email-адрес введен неправильно", registrationPage.getInvalidEmailText()),
                () -> assertEquals("Пароли не совпадают", registrationPage.getNoMatchPasswordConfirmText()),
                () -> assertEquals("Подтвердите согласие", registrationPage.getNoTermAcceptedText())
        );
    }

    @Test
    @DisplayName("Enter empty last name(*) and first name(*), and input incorrect email(*), don't accepted personal data and submit user")
    public void inputEmailPasswordPhoneConfirmPasswordClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName("");
        registrationPage.sendKeysPlaceHolderFirstName("");
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail(RandomUser.getRandomEmail());
        registrationPage.sendKeysPlaceHolderPassword(RandomUser.getRandomPassword());
        registrationPage.sendKeysPlaceHolderPasswordConfirm(RandomUser.getRandomPassword());
        registrationPage.clickButtonSubmit();

        assertAll(
                () -> assertEquals("Поле обязательное", registrationPage.getLastNameErrorMessageText()),
                () -> assertEquals("Поле обязательное", registrationPage.getFirstNameErrorMessageText())
        );
    }

    @Test
    @DisplayName("Registration user incorrect last name(*) and first name(*), email(*), don't accepted personal data and submit user")
    public void inputIncorrectLastNameFirstNameClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName(RandomUser.getRandomLastName());
        registrationPage.sendKeysPlaceHolderFirstName(RandomUser.getRandomFirstName());
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail(RandomUser.getRandomEmail());
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickButtonSubmit();

        assertEquals("Подтвердите согласие", registrationPage.getNoTermAcceptedText());
    }

    @Test
    @DisplayName("Register the user  correct fill in all required fields(*) and accepted personal data")
    public void inputFillAllRequiredFieldsAcceptPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName(RandomUser.getRandomLastName());
        registrationPage.sendKeysPlaceHolderFirstName(RandomUser.getRandomFirstName());
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail(RandomUser.getRandomEmail());
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        assertEquals("Неправильная дата", registrationPage.getSingUpErrorMessageText());
    }

    @Test
    @DisplayName("Register the user correct fill in all fields and don't accepted personal data")
    public void inputFieldsClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName(RandomUser.getRandomLastName());
        registrationPage.sendKeysPlaceHolderFirstName(RandomUser.getRandomFirstName());
        registrationPage.sendKeysPlaceHolderMiddleName(RandomUser.getRandomMiddleName());
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail(RandomUser.getRandomEmail());
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickLinkSelectDay();
        registrationPage.clickBirthdayPlaceHolderDay();
        registrationPage.clickLinkSelectMonth();
        registrationPage.clickBirthdayPlaceHolderMonth();
        registrationPage.sendKeysBirthdayPlaceHolderYear("0000");
        registrationPage.clickButtonSubmit();

        assertAll(
                () -> assertEquals("15", registrationPage.getTestDayText()),
                () -> assertEquals("АПРЕЛЬ", registrationPage.getTestMonthText())
        );
    }

    @Test
    @DisplayName("Register the user with exists Email and accepted personal data")
    public void inputFieldClickPersonalDataClickSubmitGetText() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickButtonRegistrationForm();
        registrationPage.sendKeysPlaceHolderLastName(RandomUser.getRandomLastName());
        registrationPage.sendKeysPlaceHolderFirstName(RandomUser.getRandomFirstName());
        registrationPage.sendKeysPlaceHolderMiddleName(RandomUser.getRandomMiddleName());
        registrationPage.sendKeysPlaceHolderPhone(RandomUser.getRandomNumberPhone());
        registrationPage.sendKeysPlaceHolderEmail("test@test9.com");
        registrationPage.sendKeysPlaceHolderPassword("ggF123!@#");
        registrationPage.sendKeysPlaceHolderPasswordConfirm("ggF123!@#");
        registrationPage.clickLinkSelectDay();
        registrationPage.clickBirthdayPlaceHolderDay();
        registrationPage.clickLinkSelectMonth();
        registrationPage.clickBirthdayPlaceHolderMonth();
        registrationPage.sendKeysBirthdayPlaceHolderYear("2005");
        registrationPage.clickAcceptedCheckBox();
        registrationPage.clickButtonSubmit();

        assertEquals("Пользователь с таким же значением поля «Email» уже зарегистрирован.", registrationPage.getEmailExistText());
    }
}
