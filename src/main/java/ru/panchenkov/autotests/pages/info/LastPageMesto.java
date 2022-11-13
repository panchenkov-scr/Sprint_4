package ru.panchenkov.autotests.pages.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LastPageMesto {

  WebDriver driver;
  // создай локатор страницы Заказ оформлен
  private final By orderConfirmTitle = By.className("Order_ModalHeader__3FDaJ");
  // создай локатор для кнопки «Посмотреть статус» при заказе пользователя
  private final By save = By.className("Button_Middle__1CSJM");


  public LastPageMesto(WebDriver driver){
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitOrderConfirm() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderConfirmTitle).getText() != null
            && !driver.findElement(orderConfirmTitle).getText().isEmpty()
    ));
  }

  // метод для нажатия на кнопку покупки
  public void clickLookStatus(){
    driver.findElement(save).click();
  }
}
