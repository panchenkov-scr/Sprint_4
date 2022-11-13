package ru.panchenkov.autotests.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageMesto {

  WebDriver driver;
  static final By homePage = By.className("Header_LogoScooter__3lsAR");

  // создай локатор для ключевой фразы в шапке страницы
  private final By homeTitle = By.className("Home_Header__iJKdX");
  // создай локатор для кнопки заказа в шапке страницы
  private final By HeadOrderButton = By.className("Button_Button__ra12g");
  // создай локатор для кнопки заказа в центре страницы
  private final By CenterOrderButton = By.className("Button_UltraBig__UU3Lp");
  // создай локатор для кнопки статуса заказа в шапке страницы
  private final By orderStatusButton = By.className("Header_Link__1TAG7");

  private final By question = By.xpath(".//div[@id = 'accordion__heading-0']");

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

  // метод для нажатия на кнопку заказа в шапке страницы
  public void clickEditHeadOrderButton() {
    driver.findElement(HeadOrderButton).click();
  }
  // метод для нажатия на кнопку заказа в центре страницы
  public void clickEditCenterOrderButton() {
    driver.findElement(CenterOrderButton).click();
  }

  // метод для нажатия на вопрос в центре страницы
  public void clickQuestion(String number){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-" + number)));
    Actions builder = new Actions(driver);
    builder.click(element).build().perform();
  }

  // метод для получения текста n-го элемента в вопросе
  public String getQuestionCenterOrderButton(String number){return driver.findElement(By.id("accordion__heading-" + number)).getText();
  }

  // метод для получения текста n-го элемента в ответе
  public void waitForChangedActivity(String number, String changed) {
    // здесь нужно дождаться, чтобы текст заголовка страницы стал равен значению из параметра
    ExpectedConditions.textToBePresentInElementLocated((By.xpath(".//div[@id = 'accordion__panel-" + number + "']/p")), changed);
  }
}
