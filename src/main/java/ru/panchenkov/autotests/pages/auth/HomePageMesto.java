package ru.panchenkov.autotests.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageMesto {
  WebDriver driver;
  // создай локатор для ключевой фразы в шапке страницы
  private final By homeTitle = By.className("Home_Header__iJKdX");
  // создай локатор для кнопки заказа в шапке страницы
  private final By HeadOrderButton = By.className("Button_Button__ra12g");
  // создай локатор для кнопки заказа в центре страницы
  private final By CenterOrderButton = By.className("Button_UltraBig__UU3Lp");
  // создай локатор для кнопки статуса заказа в шапке страницы
  private final By orderStatusButton = By.className("Header_Link__1TAG7");
  // конструктор
  public HomePageMesto(WebDriver driver) {
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitForLoadProfileData() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(homeTitle).getText() != null
            && !driver.findElement(homeTitle).getText().isEmpty()
    ));
  }

  // метод для нажатия на ПАНЕЛИ ВОПРОСОВ О ВАЖНОМ


  // метод для нажатия на кнопку заказа в шапке страницы
  public void clickEditHeadOrderButton() {
    driver.findElement(HeadOrderButton).click();
  }
  // метод для нажатия на кнопку заказа в центре страницы
  public void clickEditCenterOrderButton() {
    driver.findElement(HeadOrderButton).click();
  }



  //public void waitForChangedActivity(String changed) {
    // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
    //new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (Objects.equals(driver.findElement(activity).getText(), changed)
    //));
  //  ExpectedConditions.textToBePresentInElementLocated(orderStatus, changed);
  //}
}
