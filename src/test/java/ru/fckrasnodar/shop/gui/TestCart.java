package ru.fckrasnodar.shop.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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

        Assertions.assertEquals("Ваша корзина пуста", cart.getCartEmptyText());
        Assertions.assertEquals("Перейти на главную страницу", cart.getCartEmptyActionsText());

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

        Cart cart = new Cart();

        Assertions.assertEquals("КОРЗИНА", cart.getHeaderCartText());
        Assertions.assertEquals("← Вернуться к покупкам", cart.getLinkBackText());
        Assertions.assertEquals(productHandler.firstProduct.getName(),cart.getCartProductText(),"Наименование товаров не совпадает");
        Assertions.assertEquals(productHandler.firstProduct.getPrice(),cart.getPriceProductText(),"Цена товара отличается");
        Assertions.assertEquals(String.valueOf(productHandler.firstProduct.getAmount()),cart.getFieldProductQuantityText(),"Количество товара не совпадает");

    }

    @Test
    @DisplayName("Add item to cart, check increase, decrease")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarItemRemovalIncreaseDecreaseReturnShop(){
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();

        Cart cart = new Cart();

        Assertions.assertEquals("КОРЗИНА", cart.getHeaderCartText());
        Assertions.assertEquals(productHandler.thirdProduct.getName(),cart.getCartProductText(),"Наименование товаров не совпадает");

        cart.clickButtonPlusProduct();

        Assertions.assertEquals(String.valueOf(productHandler.thirdProduct.getAmount()+1),cart.getFieldProductQuantityText(),"Количество товара не совпадает");

        cart.clickButtonMinusProduct();

        Assertions.assertEquals(String.valueOf(productHandler.thirdProduct.getAmount()),cart.getFieldProductQuantityText(),"Количество товара не совпадает");

    }

    @Test
    @DisplayName("check item removal, increase, decrease, and return to shopping")
    public void openSearchFormSendKeysProductClickSubmitAddProductInCarItemRemovalReturnShop(){
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();

        Cart cart = new Cart();
        cart.clickDeleteProductInCart();

        Assertions.assertEquals("Удалить товар из корзины?", cart.getDeleteDialogHeaderText());

        cart.clickButtonCloseDialog();
        cart.clickDeleteProductInCart();

        Assertions.assertEquals("НЕ УДАЛЯТЬ", cart.getButtonCanselDeleteDialog());
        Assertions.assertEquals("УДАЛИТЬ", cart.getButtonConfirmDeleteDialog());

        cart.clickButtonCanselDeleteDialog();
        cart.clickLinkBack();
        Assertions.assertEquals("Куртка детская Puma FC Krasnodar School Reversible Jacket",productHandler.thirdProduct.getName());

    }

    @Test
    @DisplayName("Check whether the price of two items is totaled and the quantity of items on the information label")
    public void openSearchFormSendKeysProductClickSubmitAddTwoProductInCarCheckPriceCartWatchInformLabel(){
        HomePage homePage = new HomePage();
        homePage.clickLinkSearchIcon();

        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("куртка");
        searchForm.clickButtonSearchSubmit();

        ProductHandler productHandler = new ProductHandler();
        productHandler.addThirdProductInCart();

        Cart cart = new Cart();
        HomePage homePage2 = new HomePage();
        homePage2.clickLinkSearchIcon();

        SearchForm searchForm2 = new SearchForm();
        searchForm2.clickSearchFormVisible();
        searchForm2.clickSearchFormVisibleText();
        searchForm2.sendKeysSearchFormVisibleText("куртка");
        searchForm2.clickButtonSearchSubmit();

        ProductHandler productHandler2 = new ProductHandler();
        productHandler2.addFirstProductInCart();

        Assertions.assertEquals(productHandler.thirdProduct.getName(),cart.getCartProductText(),"Наименование первого товара не совпадает");
        Assertions.assertEquals(productHandler2.firstProduct.getName(),cart.getCartProductSecondText(),"Наименование второго товара не совпадает");
        Assertions.assertEquals(productHandler.thirdProduct.getPrice(),cart.getPriceProductText(),"Цена первого товара отличается");
        Assertions.assertEquals(productHandler2.firstProduct.getPrice(),cart.getPriceSecondProductText(),"Цена второго товара отличается");
        Assertions.assertEquals(String.valueOf(productHandler.thirdProduct.getAmount()),cart.getFieldProductQuantityText(),"Количество первого товара не совпадает");
        Assertions.assertEquals(String.valueOf(productHandler2.firstProduct.getAmount()),cart.getFieldSecondProductQuantityText(),"Количество второго товара не совпадает");

        int actualProductHandlerTotalPrice = 0;
        int firstTotalPrice = Integer.parseInt(productHandler.thirdProduct.getPrice().replaceAll("[^\\d]",""));
        int secondTotalPrice = Integer.parseInt(productHandler2.firstProduct.getPrice().replaceAll("[^\\d]",""));
        int cartTotalPrice = Integer.parseInt(cart.getTotalPriceCartText().replaceAll("[^\\d]",""));
        actualProductHandlerTotalPrice = firstTotalPrice + secondTotalPrice;

        Assertions.assertEquals(actualProductHandlerTotalPrice,cartTotalPrice,"Итоговая цена не совпадает");
        Assertions.assertEquals("2",cart.getCartInformerAmoundText());
    }
}
