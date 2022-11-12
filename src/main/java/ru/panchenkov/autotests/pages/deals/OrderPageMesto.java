package ru.panchenkov.autotests.pages.deals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPageMesto {

  WebDriver driver;
  // создай локатор для ключевой фразы в шапке страницы
  private final By orderTitle = By.className("Order_Header__BZXOb");
  // создай локатор для поля «Занятие» в профиле пользователя
  private final By activity = By.id("owner-description");
  // создай локатор для кнопки «Сохранить» в профиле пользователя
  private final By save = By.className("popup__button");

  public OrderPageMesto(WebDriver driver) {
    this.driver = driver;
  }

  // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
  public void checkActivity(String changed) {
    Assert.assertTrue(driver.findElement(activity).isEnabled());
    driver.findElement(activity).clear();
    driver.findElement(activity).sendKeys(changed);
  }

  // метод для нажатия на кнопку сохранения профиля
  public void clickProfile() {
    driver.findElement(save).click();
  }

  // метод для получения текста элемента в заголовке
  //public String textInHeader(){
  //  return driver.findElement(By.className("Order_Header__BZXOb")).getText();
  //}


  public void waitForChangedActivity(String changed) {
    // здесь нужно дождаться, чтобы текст заголовка страницы стал равен значению из параметра

    ExpectedConditions.textToBePresentInElementLocated(orderTitle, changed);
  }


}
