package ru.fckrasnodar.shop.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCart extends TestBase {

    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
    }

    @Test
    @DisplayName("Check text when going to an empty cart")
    public void openEmptyCartGetText() {
        HomePage homePage = new HomePage();
        homePage.clickLinkCartInformer();
        Cart cart = new Cart();

        assertAll(
                () -> assertEquals("Ваша корзина пуста", cart.getCartEmptyText()),
                () -> assertEquals("Перейти на главную страницу", cart.getCartEmptyActionsText())
        );
    }

    @Test
    @DisplayName("Search for an item and add it to your cart, check for an item in your cart")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarCheckCartWithProduct() {
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addFirstProductInCart();
        productHandler.goToCart();

        Cart cart = new Cart();

        assertAll(
                () -> assertEquals("КОРЗИНА", cart.getHeaderCartText()),
                () -> assertEquals("← Вернуться к покупкам", cart.getLinkBackText()),
                () -> assertEquals(productHandler.firstProduct.getName(), cart.getCartProductText(), "Наименование товаров не совпадает"),
                () -> assertEquals(productHandler.firstProduct.getPrice(), cart.getPriceProductText(), "Цена товара отличается"),
                () -> assertEquals(String.valueOf(productHandler.firstProduct.getAmount()), cart.getFieldProductQuantityText(), "Количество товара не совпадает")
        );
    }

    @Test
    @DisplayName("Add item to cart, check increase, decrease")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarItemRemovalIncreaseDecreaseReturnShop() {
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();
        productHandler.goToCart();

        Cart cart = new Cart();
        cart.clickButtonPlusProduct();

        assertEquals(String.valueOf(productHandler.thirdProduct.getAmount() + 1), cart.getFieldProductQuantityText(), "Количество товара не совпадает");
    }

    @Test
    @DisplayName("Add item to cart, check decrease")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarItemDecrease() {
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();
        productHandler.goToCart();

        Cart cart = new Cart();
        cart.clickButtonPlusProduct();
        cart.clickButtonMinusProduct();

        assertEquals(String.valueOf(productHandler.thirdProduct.getAmount()), cart.getFieldProductQuantityText(), "Количество товара не совпадает");
    }


    @Test
    @DisplayName("check item removal, increase, decrease, and return to shopping")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarItemRemovalReturnShop() {
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();
        productHandler.goToCart();

        Cart cart = new Cart();
        cart.clickDeleteProductInCart();

        assertEquals("Удалить товар из корзины?", cart.getDeleteDialogHeaderText());

        cart.clickButtonCloseDialog();
        cart.clickDeleteProductInCart();

        assertAll(
                () -> assertEquals("НЕ УДАЛЯТЬ", cart.getButtonCanselDeleteDialog()),
                () -> assertEquals("УДАЛИТЬ", cart.getButtonConfirmDeleteDialog())
        );

        cart.clickButtonCanselDeleteDialog();
        cart.clickLinkBack();

        assertEquals("Куртка детская Puma FC Krasnodar School Reversible Jacket", productHandler.thirdProduct.getName());
    }

    @Test
    @DisplayName("Check whether the price of two items is totaled and the quantity of items on the information label")
    public void openSearchFormSendKeysProductClickSubmitAddTwoProductInCarCheckPriceCartWatchInformLabel() {
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();
        productHandler.backPage();
        productHandler.addFirstProductInCart();
        productHandler.goToCart();

        Cart cart = new Cart();

        assertAll(
                () -> assertEquals(productHandler.thirdProduct.getName(), cart.getCartProductText(), "Наименование первого товара не совпадает"),
                () -> assertEquals(productHandler.firstProduct.getName(), cart.getCartProductSecondText(), "Наименование второго товара не совпадает"),
                () -> assertEquals(productHandler.thirdProduct.getPrice(), cart.getPriceProductText(), "Цена первого товара отличается"),
                () -> assertEquals(productHandler.firstProduct.getPrice(), cart.getPriceSecondProductText(), "Цена второго товара отличается"),
                () -> assertEquals(String.valueOf(productHandler.thirdProduct.getAmount()), cart.getFieldProductQuantityText(), "Количество первого товара не совпадает"),
                () -> assertEquals(String.valueOf(productHandler.firstProduct.getAmount()), cart.getFieldSecondProductQuantityText(), "Количество второго товара не совпадает")
        );

        int actualProductHandlerTotalPrice = 0;
        int firstTotalPrice = Integer.parseInt(productHandler.thirdProduct.getPrice().replaceAll("[^\\d]", ""));
        int secondTotalPrice = Integer.parseInt(productHandler.firstProduct.getPrice().replaceAll("[^\\d]", ""));
        int cartTotalPrice = Integer.parseInt(cart.getTotalPriceCartText().replaceAll("[^\\d]", ""));
        actualProductHandlerTotalPrice = (firstTotalPrice * productHandler.thirdProduct.getAmount())  +
                                         (secondTotalPrice * productHandler.firstProduct.getAmount());

         assertEquals(actualProductHandlerTotalPrice, cartTotalPrice, "Итоговая цена не совпадает");
         assertEquals("2", cart.getCartInformerAmoundText());
    }
}
