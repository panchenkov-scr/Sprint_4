package ru.panchenkov.autotests.pages.deals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPageMesto {

  WebDriver driver;
  // создай локатор для ключевой фразы в шапке страницы
  private final By orderTitle = By.className("Order_Header__BZXOb");
  // создай локатор для поля «Дата» в форме заказа
  private final By dateForm = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
  // создай локатор для поля «Период» в форме заказа
  private final By periodForm = By.className("Dropdown-arrow");
  // создай локатор для поля «Цвет» в форме заказа
  //private final By colorForm = By.xpath(".//label[@for='black']/input");
  // создай локатор для поля «Комментарий» в форме заказа
  private final By commentForm = By.xpath(".//input[@placeholder='Комментарий для курьера']");
  // создай локатор для кнопки «Заказать» в профиле пользователя
  private final By order = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Buttons__1xGrp']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

  public AboutRentPageMesto(WebDriver driver) {
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitForLoadOrderData() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderTitle).getText() != null
            && !driver.findElement(orderTitle).getText().isEmpty()
    ));
  }

  // метод для заполнения формы заказа
  public void fillSecondForm(String date, String periods, String color, String comment) {
    Assert.assertTrue(driver.findElement(dateForm).isEnabled());
    driver.findElement(dateForm).clear();
    driver.findElement(dateForm).sendKeys(date);
    driver.findElement(periodForm).click();
    driver.findElement(By.xpath("//div[@class='Dropdown-menu']/*[text()='" + periods + "']")).click();
    driver.findElement(By.xpath(".//label[@for='" + color + "']/input")).click();
    //driver.findElement(colorForm).click();
    Assert.assertTrue(driver.findElement(commentForm).isEnabled());
    driver.findElement(commentForm).clear();
    driver.findElement(commentForm).sendKeys(comment);
  }

  // метод для нажатия на кнопку заказа
  public void clickOrder() {
    driver.findElement(order).click();
  }
}
