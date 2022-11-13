package ru.panchenkov.autotests.pages.info;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoPageMesto {

  WebDriver driver;
  // создай локатор для кнопки «Да» при заказе пользователя
  private final By orderTitle = By.className("Order_ModalHeader__3FDaJ");
  // создай локатор для кнопки «Да» при заказе пользователя
  private final By save = By.xpath(".//div[@class='Order_Modal__YZ-d3']/*/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


  public InfoPageMesto(WebDriver driver){
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitProfileCustomer() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderTitle).getText() != null
            && !driver.findElement(orderTitle).getText().isEmpty()
    ));
  }

  // метод для нажатия на кнопку покупки
  public void clickConfirm(){
    driver.findElement(save).click();
  }
}
