package ru.fckrasnodar.shop.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import ru.fckrasnodar.shop.singleton.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchForm {
    private final String SEARCH_FORM_VISIBLE = "//div[@class='wrap']//form[@class='search-form visible']";
    private final String SEARCH_FORM_VISIBLE_TEXT = "//div[@class='wrap']//input[@placeholder='Найти товары']";
    private final String BUTTON_SEARCH_SUBMIT = "//div[@class='wrap']//button";
    private final String SEARCH_PAGE_HEADER_TEXT = "//div[@id='paper']//h1";
    private final String SORT_LABEL_TEXT = "//div[@class='s-sorting-list sort-filters']//label";
    private final String CATEGORY_SEARCH_QUERY = "//form[@class='s-category-search']//input";
    private final String NO_FOUND_PRODUCT_TEXT = "//div[@class='s-search-page']//p";
    private final String TITLE_SEARCH_RESULT = "//div[@class='item-list']";
    private final String LINK_SORT_SELECT = "//span[@class='fake-select']";
    private final String SORT_SELECT_OPTION_TEXT = "//span[@class='fake-select focused']//span[text()='Цена']";
    private final String FIRST_PRODUCT_SORT = "//div[@class='item'][1]";
    org.openqa.selenium.WebDriver driver;

    public SearchForm() {
        this.driver = WebDriver.getDriver();
    }

    public void clickSearchFormVisible() {
        WebDriver.getDriver().findElement(By.xpath(SEARCH_FORM_VISIBLE)).click();
    }

    public boolean getDisplayedSearchFormVisibleText() {
        return WebDriver.getDriver().findElement(By.xpath(SEARCH_FORM_VISIBLE_TEXT)).isDisplayed();
    }

    public void clickSearchFormVisibleText() {
        WebDriver.getDriver().findElement(By.xpath(SEARCH_FORM_VISIBLE_TEXT)).click();
    }

    public void sendKeysSearchFormVisibleText(String product) {
        WebDriver.getDriver().findElement(By.xpath(SEARCH_FORM_VISIBLE_TEXT)).sendKeys(product);
    }

    public void clickButtonSearchSubmit() {
        WebDriver.getDriver().findElement(By.xpath(BUTTON_SEARCH_SUBMIT)).click();
    }

    public String getSearchPageHeaderText() {
        return WebDriver.getDriver().findElement(By.xpath(SEARCH_PAGE_HEADER_TEXT)).getText();
    }

    public String getSortLabelText() {
        return WebDriver.getDriver().findElement(By.xpath(SORT_LABEL_TEXT)).getText();
    }

    public boolean getDisplayedCategorySearchQueryText() {
        return WebDriver.getDriver().findElement(By.xpath(CATEGORY_SEARCH_QUERY)).isDisplayed();
    }

    public String getNoFoundProductText() {
        return WebDriver.getDriver().findElement(By.xpath(NO_FOUND_PRODUCT_TEXT)).getText();
    }

    public List<String> getSearchResultItemsTitleText() {
        List<WebElement> listSearchResultElements = WebDriver.findElements(TITLE_SEARCH_RESULT);
        List<String> listSearchResultTitles = new ArrayList<>();
        for (WebElement element : listSearchResultElements) {
            listSearchResultTitles.add(element.getText().toLowerCase());
        }
        return listSearchResultTitles;
    }

    public void clickLinkSortSelect() {
        WebDriver.getDriver().findElement(By.xpath(LINK_SORT_SELECT)).click();
    }

    public void clickSortSelectOptionText() {
        WebDriver.getDriver().findElement(By.xpath(SORT_SELECT_OPTION_TEXT)).click();
    }

    public String getSortSelectOptionText() {
        return WebDriver.getDriver().findElement(By.xpath(LINK_SORT_SELECT)).getText();
    }

    public Dimension getFirstProductSortSize() {
        return WebDriver.getDriver().findElement(By.xpath(FIRST_PRODUCT_SORT)).getSize();
    }
}
