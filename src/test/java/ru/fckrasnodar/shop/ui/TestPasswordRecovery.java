package ru.fckrasnodar.shop.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordRecovery extends TestBase {
    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickLinkUserAccount();
    }

    @Test
    @DisplayName("Check forgot password")
    public void openLoginPageForgotPasswordClickGetText() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage.clickLinkForgotPassword();

        assertAll(
                () -> assertEquals("Email", passwordRecoveryPage.getForgotPasswordFormEmailText()),
                () -> assertTrue(passwordRecoveryPage.getDisplayedEmailText(), "Email"),
                () -> assertEquals("ВОССТАНОВЛЕНИЕ ПАРОЛЯ", passwordRecoveryPage.getHeaderForgotPasswordText())
        );
    }

    @Test
    @DisplayName("Input wrong email and receive the appropriate message")
    public void inputEmailWrongEmailClickRecoveryPasswordGetText() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage.clickLinkForgotPassword();
        passwordRecoveryPage.sendInputEmailRecoveryPassword("test@test");
        passwordRecoveryPage.clickButtonRecoveryPassword();

        assertEquals("Пользователь с этим email-адресом не найден.", passwordRecoveryPage.getErrorMessageEmailText());
    }

    @Test
    @DisplayName("Input numbers in email and receive the appropriate message")
    public void inputEmailNumbersClickRecoveryPasswordGetText() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage.clickLinkForgotPassword();
        passwordRecoveryPage.sendInputEmailRecoveryPassword("00000");
        passwordRecoveryPage.clickButtonRecoveryPassword();

        assertEquals("Проверьте правильность адреса", passwordRecoveryPage.getErrorMessageEmailText());
    }

    @Test
    @DisplayName("Input empty field email and receive appropriate message")
    public void inputEmailEmptyFieldClickRecoveryPasswordGetText() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage.clickLinkForgotPassword();
        passwordRecoveryPage.sendInputEmailRecoveryPassword("");
        passwordRecoveryPage.clickButtonRecoveryPassword();

        assertEquals("Введите свой email-адрес.", passwordRecoveryPage.getErrorMessageEmailText());
    }

    @Test
    @DisplayName("Input correct email and receive appropriate message")
    public void inputCorrectEmailClickRecoveryPasswordGetText() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage.clickLinkForgotPassword();
        passwordRecoveryPage.sendInputEmailRecoveryPassword("test@test.com");
        passwordRecoveryPage.clickButtonRecoveryPassword();

        assertAll(
                () -> assertTrue(passwordRecoveryPage.getRecoveryPasswordInfoMessageText().contains("Проверьте входящую почту для адреса")),
                () -> assertTrue(passwordRecoveryPage.getRecoveryPasswordInfoMessageText().contains("мы отправили вам сообщение со ссылкой для восстановления пароля."))
        );
    }
}
