package ru.panchenkov.autotests.pages.info;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageMesto {

  WebDriver driver;
  // создай локатор для поля «Занятие» в профиле пользователя
  private final By activity = By.id("owner-description");
  // создай локатор для кнопки «Сохранить» в профиле пользователя
  private final By save = By.className("popup__button");

  public ProfilePageMesto(WebDriver driver){
    this.driver = driver;
  }

  // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
  public void checkActivity(String changed){
    Assert.assertTrue(driver.findElement(activity).isEnabled());
    driver.findElement(activity).clear();
    driver.findElement(activity).sendKeys(changed);
  }

  // метод для нажатия на кнопку сохранения профиля
  public void clickProfile(){
    driver.findElement(save).click();
  }
}
