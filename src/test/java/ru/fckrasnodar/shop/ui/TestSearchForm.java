package ru.fckrasnodar.shop.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSearchForm extends TestBase {

    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickLinkSearchIcon();
    }

    @Test
    @DisplayName("In the item search form, search for text")
    public void openSearchFormGetText() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();

        assertTrue(searchForm.getDisplayedSearchFormVisibleText(), "Найти товар");
    }

    @Test
    @DisplayName("Searching for an existing item")
    public void openSearchSendKeysProductClickSubmitGetText() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("Поло");
        searchForm.clickButtonSearchSubmit();

        assertAll(
                () -> assertEquals("ПОЛО", searchForm.getSearchPageHeaderText()),
                () -> assertEquals("СОРТИРОВКА ПО:", searchForm.getSortLabelText()),
                () -> assertTrue(searchForm.getDisplayedCategorySearchQueryText(), "Поло")
        );
    }

    @Test
    @DisplayName("Search for a non-existent item")
    public void openSearchSendKeysNonExistentProductClickSubmitGetText() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("Мотоцикл");
        searchForm.clickButtonSearchSubmit();

        assertTrue(searchForm.getDisplayedCategorySearchQueryText(), "Мотоцикл");
        assertEquals("Не найдено ни одного товара.", searchForm.getNoFoundProductText());
    }

    @Test
    @DisplayName("Checking if the list of the results contains 'шорты' ")
    public void openSearchSendKeyProductClickSubmitGetResultText() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("шорты");
        searchForm.clickButtonSearchSubmit();

        for (String elementTitle : searchForm.getSearchResultItemsTitleText()) {
            assertTrue(elementTitle.toLowerCase().contains("шорты"), "Результат, не содержащий искомое слово" + elementTitle);
        }
        assertEquals("ШОРТЫ", searchForm.getSearchPageHeaderText());
    }

    @Test
    @DisplayName("Matching the size of the products reflected after the search")
    public void openSearchSendKeyProductClickSubmitGetSizeFirstElement() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("бутсы");
        searchForm.clickButtonSearchSubmit();

        assertAll(
                () -> assertEquals("БУТСЫ", searchForm.getSearchPageHeaderText()),
                () -> assertEquals("282", String.valueOf(searchForm.getFirstProductSortSize().getWidth()), "Ошибка: Ширина отличается"),
                () -> assertEquals("416", String.valueOf(searchForm.getFirstProductSortSize().getHeight()), "Ошибка: Высота отличается")
        );
    }

    @Test
    @DisplayName("Sort item after search")
    public void openSearchSendKeyProductClickSubmitSortProductGetText() {
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("мяч");
        searchForm.clickButtonSearchSubmit();
        searchForm.clickLinkSortSelect();
        searchForm.clickSortSelectOptionText();

        assertAll(
                () -> assertEquals("ЦЕНА ", searchForm.getSortSelectOptionText()),
                () -> assertTrue(searchForm.getDisplayedCategorySearchQueryText(), "МЯЧ")
        );
        for (String elementTitle : searchForm.getSearchResultItemsTitleText()) {
            assertTrue(elementTitle.toLowerCase().contains("мяч"), "Результат, не содержащий искомое слово" + elementTitle);
        }
    }
}
