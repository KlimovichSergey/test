package ru.fckrasnodar.shop.gui;

import org.junit.jupiter.api.*;

public class TestLoginPage extends TestBase {

    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickLinkUserAccount();
    }

    @Test
    @DisplayName("Check of all required field inscriptions in personal account")
    public void searchLoginPagePresenceOfText() {
        LoginPage loginPage = new LoginPage();

        Assertions.assertEquals("ВХОД", loginPage.getInputProfileText());
        Assertions.assertEquals("Email",loginPage.getFieldEmailText());
        Assertions.assertEquals("Пароль",loginPage.getFieldPasswordText());
        Assertions.assertEquals("Регистрация",loginPage.getRegistrationFormText());
        Assertions.assertEquals("Регистрация в магазине только сделает процесс покупок проще и удобнее.",loginPage.getRegistrationFormInformationalText());
        Assertions.assertEquals("Запомнить меня",loginPage.getRememberMeText());
        Assertions.assertEquals("Забыли пароль?",loginPage.getForgotPasswordText());
    }

    @Test
    @DisplayName("Checking the information text when filling in non-valid values of the email and password fields")
    public void fillLoginPageInformationNonValidGetText(){
        LoginPage loginPage = new LoginPage();
        loginPage.sendKeysLoginPlaceHolderEmail("test");
        loginPage.sendKeysPlaceHolderPassword("@#Test./*");
        loginPage.clickButtonLoginSubmit();

        Assertions.assertEquals("Неправильное имя пользователя или пароль.",loginPage.getSubmitErrorText());
    }

    @Test
    @DisplayName("Checking the text of information in the absence of values of email and password fields")
    public void fillLoginPageInformationAbsenceValuesOfFieldsGetText(){
        LoginPage loginPage = new LoginPage();
        loginPage.sendKeysLoginPlaceHolderEmail("");
        loginPage.sendKeysPlaceHolderPassword("");
        loginPage.clickButtonLoginSubmit();

        Assertions.assertEquals("Введите свой email-адрес.",loginPage.getEmailErrorText());
        Assertions.assertEquals("Пароль обязателен",loginPage.getPasswordErrorText());
    }

    @Test
    @DisplayName("Checking the text of information in the absence of values of email fields")
    public void fillLoginPageInformationAbsenceValuesOfFieldsEmailGetText(){
        LoginPage loginPage = new LoginPage();
        loginPage.sendKeysLoginPlaceHolderEmail("");
        loginPage.sendKeysPlaceHolderPassword("1234");
        loginPage.clickButtonLoginSubmit();

        Assertions.assertEquals("Введите свой email-адрес.",loginPage.getEmailErrorText());
    }

    @Test
    @DisplayName("Checking the text of information in the absence of values of password fields and click checkbox remember")
    public void fillLoginPageInformationAbsenceValuesOfFieldsPasswordGetText(){
        LoginPage loginPage = new LoginPage();
        loginPage.sendKeysLoginPlaceHolderEmail("test@test.com");
        loginPage.sendKeysPlaceHolderPassword("");
        loginPage.clickCheckBoxRemember();
        loginPage.clickButtonLoginSubmit();

        Assertions.assertEquals("Пароль обязателен",loginPage.getPasswordErrorText());
    }
}
