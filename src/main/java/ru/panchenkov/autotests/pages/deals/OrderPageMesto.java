package ru.panchenkov.autotests.pages.deals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageMesto {

  WebDriver driver;
  // создай локатор для ключевой фразы в шапке страницы
  private final By orderTitle = By.className("Order_Header__BZXOb");
  // создай локатор для поля «Имя пользователя» в форме заказа
  private final By name = By.xpath(".//input[@placeholder='* Имя']");
  // создай локатор для кнопки «Сохранить» в профиле пользователя
  private final By save = By.className("popup__button");

  public OrderPageMesto(WebDriver driver) {
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitForLoadOrderData() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderTitle).getText() != null
            && !driver.findElement(orderTitle).getText().isEmpty()
    ));
  }



  // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
  //public void checkActivity(String changed) {
  //  Assert.assertTrue(driver.findElement(activity).isEnabled());
  //  driver.findElement(activity).clear();
  //  driver.findElement(activity).sendKeys(changed);
  //}

  // метод для нажатия на кнопку сохранения профиля
  public void clickOrder() {
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
