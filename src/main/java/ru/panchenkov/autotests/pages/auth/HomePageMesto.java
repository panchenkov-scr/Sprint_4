package ru.panchenkov.autotests.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageMesto {
  WebDriver driver;
  private final By profileTitle = By.className("profile__title");
  // создай локатор для кнопки редактирования профиля
  private final By editProfileButton = By.className("profile__edit-button");
  // создай локатор для поля «Занятие» в профиле пользователя
  private final By activity = By.className("profile__description");
  public HomePageMesto(WebDriver driver) {
    this.driver = driver;
  }




  // метод ожидания прогрузки данных профиля
  public void waitForLoadProfileData() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(profileTitle).getText() != null
            && !driver.findElement(profileTitle).getText().isEmpty()
    ));
  }




  // метод для нажатия на кнопку редактирования профиля
  public void clickEditProfileButton() {
    driver.findElement(editProfileButton).click();
  }
  public void waitForChangedActivity(String changed) {
    // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
    //new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (Objects.equals(driver.findElement(activity).getText(), changed)
    //));
    ExpectedConditions.textToBePresentInElementLocated(activity, changed);
  }
}
