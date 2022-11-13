package ru.panchenkov.autotests.pages.deals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileCustomerPageMesto {

  WebDriver driver;
  // создай локатор для ключевой фразы в шапке страницы
  private final By orderTitle = By.className("Order_Header__BZXOb");
  // создай локатор для поля «Имя пользователя» в форме заказа
  private final By nameForm = By.xpath(".//input[@placeholder='* Имя']");
  // создай локатор для поля «Фамилия» в форме заказа
  private final By surnameForm = By.xpath(".//input[@placeholder='* Фамилия']");
  // создай локатор для поля «Фамилия» в форме заказа
  private final By addressForm = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
  // создай локатор для поля «Фамилия» в форме заказа
  private final By subwayForm = By.xpath(".//input[@placeholder='* Станция метро']");
  // создай локатор для поля «Фамилия» в форме заказа
  private final By telephoneForm = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
  // создай локатор для кнопки «Далее» в профиле пользователя
  private final By thenButton = By.className("Button_Middle__1CSJM");

  public ProfileCustomerPageMesto(WebDriver driver) {
    this.driver = driver;
  }

  // метод ожидания прогрузки данных профиля
  public void waitProfileCustomer() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderTitle).getText() != null
            && !driver.findElement(orderTitle).getText().isEmpty()
    ));
  }

  // метод для заполнения формы заказа
  public void fillFirstForm(String name, String surname, String address, String subway, String telephone){
    Assert.assertTrue(driver.findElement(nameForm).isEnabled());
    driver.findElement(nameForm).clear();
    driver.findElement(nameForm).sendKeys(name);

    Assert.assertTrue(driver.findElement(surnameForm).isEnabled());
    driver.findElement(surnameForm).clear();
    driver.findElement(surnameForm).sendKeys(surname);

    Assert.assertTrue(driver.findElement(addressForm).isEnabled());
    driver.findElement(addressForm).clear();
    driver.findElement(addressForm).sendKeys(address);

    Assert.assertTrue(driver.findElement(subwayForm).isEnabled());
    driver.findElement(subwayForm).click();
    driver.findElement(By.xpath("//*[text()='" + subway + "']")).click();

    Assert.assertTrue(driver.findElement(telephoneForm).isEnabled());
    driver.findElement(telephoneForm).clear();
    driver.findElement(telephoneForm).sendKeys(telephone);
  }

  // метод для нажатия на кнопку Далее
  public void clickOrder() {
    driver.findElement(thenButton).click();
  }
}
