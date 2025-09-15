package ru.fckrasnodar.shop.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSearchForm extends TestBase {

    @BeforeEach
    public void openHomePageClickUserAccount() {
        HomePage homePage = new HomePage();
        homePage.openSite();
        homePage.clickLinkSearchIcon();
    }

    @Test
    @DisplayName("In the item search form, search for text")
    public void openSearchFormGetText(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();

        Assertions.assertTrue(searchForm.getDisplayedSearchFormVisibleText(),"Найти товар");
    }

    @Test
    @DisplayName("Searching for an existing item")
    public void openSearchSendKeysProductClickSubmitGetText(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("Поло");
        searchForm.clickButtonSearchSubmit();

        Assertions.assertEquals("ПОЛО",searchForm.getSearchPageHeaderText());
        Assertions.assertEquals("СОРТИРОВКА ПО:",searchForm.getSortLabelText());
        Assertions.assertTrue(searchForm.getDisplayedCategorySearchQueryText(),"Поло");

    }

    @Test
    @DisplayName("Search for a non-existent item")
    public void openSearchSendKeysNonExistentProductClickSubmitGetText(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("Мотоцикл");
        searchForm.clickButtonSearchSubmit();

        Assertions.assertEquals("МОТОЦИКЛ",searchForm.getSearchPageHeaderText());
        Assertions.assertTrue(searchForm.getDisplayedCategorySearchQueryText(),"Мотоцикл");
        Assertions.assertEquals("Не найдено ни одного товара.",searchForm.getNoFoundProductText());
    }

    @Test
    @DisplayName("Checking if the list of the results contains 'шорты' ")
    public void openSearchSendKeyProductClickSubmitGetResultText(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("шорты");
        searchForm.clickButtonSearchSubmit();

        for(String elementTitle : searchForm.getSearchResultItemsTitleText()){
            Assertions.assertTrue(elementTitle.toLowerCase().contains("шорты"),"Результат, не содержащий искомое слово" + elementTitle);
        }
        Assertions.assertEquals("ШОРТЫ",searchForm.getSearchPageHeaderText());
    }

    @Test
    @DisplayName("Sort item after search")
    public void openSearchSendKeyProductClickSubmitSortProductGetText(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("мяч");
        searchForm.clickButtonSearchSubmit();

        for(String elementTitle : searchForm.getSearchResultItemsTitleText()){
            Assertions.assertTrue(elementTitle.toLowerCase().contains("мяч"),"Результат, не содержащий искомое слово" + elementTitle);
        }
        Assertions.assertEquals("МЯЧ",searchForm.getSearchPageHeaderText());
        Assertions.assertEquals("СОРТИРОВКА ПО:",searchForm.getSortLabelText());

        searchForm.clickLinkSortSelect();
        searchForm.clickSortSelectOptionText();

        Assertions.assertEquals("ЦЕНА ",searchForm.getSortSelectOptionText());
        for(String elementTitle : searchForm.getSearchResultItemsTitleText()){
            Assertions.assertTrue(elementTitle.toLowerCase().contains("мяч"),"Результат, не содержащий искомое слово" + elementTitle);
        }
        Assertions.assertTrue(searchForm.getDisplayedCategorySearchQueryText(),"МЯЧ");
    }

    @Test
    @DisplayName("Matching the size of the products reflected after the search")
    public void openSearchSendKeyProductClickSubmitGetSizeFirstElement(){
        SearchForm searchForm = new SearchForm();
        searchForm.clickSearchFormVisible();
        searchForm.clickSearchFormVisibleText();
        searchForm.sendKeysSearchFormVisibleText("бутсы");
        searchForm.clickButtonSearchSubmit();

        Assertions.assertEquals("БУТСЫ",searchForm.getSearchPageHeaderText());
        Assertions.assertEquals("282",String.valueOf(searchForm.getFirstProductSortSize().getWidth()),"Ошибка: Ширина отличается");
        Assertions.assertEquals("416",String.valueOf(searchForm.getFirstProductSortSize().getHeight()),"Ошибка: Высота отличается");
    }
}
