package ru.panchenkov.autotests.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMesto {
  WebDriver driver;
  private final By emailField = By.id("email");
  private final By passwordField = By.id("password");
  private final By signInButton = By.className("auth-form__button");

  public LoginPageMesto(WebDriver driver){
    this.driver = driver;
  }

  public void setUsername(String username) {
    driver.findElement(emailField).sendKeys(username);
  }
  public void setPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
  }
  public void clickSignInButton() {
    driver.findElement(signInButton).click();
  }
  public void login(String username, String password){
    setUsername(username);
    setPassword(password);
    clickSignInButton();
  }
}
