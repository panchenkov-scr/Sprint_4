import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import ru.panchenkov.autotests.pages.auth.HomePageMesto;
import ru.panchenkov.autotests.pages.deals.AboutRentPageMesto;
import ru.panchenkov.autotests.pages.deals.ProfileCustomerPageMesto;
import ru.panchenkov.autotests.pages.info.InfoPageMesto;
import ru.panchenkov.autotests.pages.info.LastPageMesto;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;


@RunWith(Parameterized.class)
public class testOrderCustomer {

  public static WebDriver driver;

  private final String name;
  private final String surname;
  private final String address;
  private final String subway;
  private final String telephone;
  private final String date;
  private final String periods;
  private final String color;
  private final String comment;

  public testOrderCustomer(String name, String surname, String address, String subway, String telephone, String date, String periods, String color, String comment) {
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.subway = subway;
    this.telephone = telephone;
    this.date = date;
    this.periods = periods;
    this.color = color;
    this.comment = comment;
  }

  @Parameterized.Parameters
  public static Object[][] getTestData() {
    return new Object[][] {
            { "Василий", "Сидоров", "Воздвиженка, 15-1", "Арбатская", "+79991707777", "10.12.2022", "сутки", "black","абв" },
            { "Сергей", "Иванов", "Проспект Мира, 29-2", "Проспект Мира", "+79991889922", "12.12.2022", "трое суток", "grey","бва" },
            { "Антон", "Сергеев", "Проспект Вернадского, 34-3", "Красные Ворота", "+79991349987", "16.12.2022", "двое суток", "grey","кошка" },
    };
  }

  @Before
  public void setUp() {
    ChromeDriverService service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File("C:/Development/Sprint_4/chromedriver.exe"))
            .build();
    driver = new ChromeDriver(service);
  }

  //Заказ самоката. Весь флоу позитивного сценария. Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
  //Из чего состоит позитивный сценарий:
  // 1. Нажать кнопку «Заказать». На странице две кнопки заказа.
  // 2. Заполнить форму заказа.
  // 3. Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.

  @Test
  public void checkOrderFormWithHeadButton() {
    // переход на страницу тестового приложения
    driver.get("https://qa-scooter.praktikum-services.ru/");
    // создай объект класса главной страницы приложения
    HomePageMesto objHomePage = new HomePageMesto(driver);
    // дождись загрузки данных профиля на главной странице
    objHomePage.waitForLoadProfileData();
   // Нажать кнопку «Заказать». Кнопка в шапке страницы.
    objHomePage.clickEditHeadOrderButton();
    // создай объект класса главной страницы приложения
    ProfileCustomerPageMesto objOrderPage = new ProfileCustomerPageMesto(driver);
    // дождись загрузки данных на странице заполнения формы заказа
    objOrderPage.waitProfileCustomer();
   // Заполнить форму заказа.
    objOrderPage.fillFirstForm(name, surname, address, subway, telephone);
   // кликни на кнопку Далее страницы заполнения формы заказа
    objOrderPage.clickOrder();
    // создай объект класса страницы до заполнения формы заказа
    AboutRentPageMesto objProfileCustomerPage = new AboutRentPageMesto(driver);
    // дождись загрузки данных профиля заказа
    objProfileCustomerPage.waitForLoadOrderData();
    // Заполнить форму заказа.
    objProfileCustomerPage.fillSecondForm(date, periods, color, comment);
   // кликни кнопку "Заказать"
    objProfileCustomerPage.clickOrder();
    // создай объект класса страницы до заполнения формы заказа
    InfoPageMesto objInfoPage = new InfoPageMesto(driver);
    // дождись загрузки данных профиля заказа
    objInfoPage.waitProfileCustomer();
    //покупка услуги
    objInfoPage.clickConfirm();
    // создай объект класса страницы подтверждения заказа
    LastPageMesto objLastPage = new LastPageMesto(driver);
    // кликни кнопку посмотреть статус
    objLastPage.waitOrderConfirm();
  }

  @Test
  public void checkOrderFormWithCenterButton() {
    // переход на страницу тестового приложения
    driver.get("https://qa-scooter.praktikum-services.ru/");
    // создай объект класса главной страницы приложения
    HomePageMesto objHomePage = new HomePageMesto(driver);
    // дождись загрузки данных профиля на главной странице
    objHomePage.waitForLoadProfileData();
    // Нажать кнопку «Заказать». Кнопка по центру.
    objHomePage.clickEditCenterOrderButton();
    // создай объект класса главной страницы приложения
    ProfileCustomerPageMesto objOrderPage = new ProfileCustomerPageMesto(driver);
    // дождись загрузки данных на странице заполнения формы заказа
    objOrderPage.waitProfileCustomer();
    // Заполнить форму заказа.
    objOrderPage.fillFirstForm(name, surname, address, subway, telephone);
    // кликни на кнопку Далее страницы заполнения формы заказа
    objOrderPage.clickOrder();
    // создай объект класса страницы до заполнения формы заказа
    AboutRentPageMesto objProfileCustomerPage = new AboutRentPageMesto(driver);
    // дождись загрузки данных профиля заказа
    objProfileCustomerPage.waitForLoadOrderData();
    // Заполнить форму заказа.
    objProfileCustomerPage.fillSecondForm(date, periods, color, comment);
    // кликни кнопку "Заказать"
    objProfileCustomerPage.clickOrder();
    // создай объект класса страницы до заполнения формы заказа
    InfoPageMesto objInfoPage = new InfoPageMesto(driver);
    // дождись загрузки данных профиля заказа
    objInfoPage.waitProfileCustomer();
    //покупка услуги
    objInfoPage.clickConfirm();
    // создай объект класса страницы подтверждения заказа
    LastPageMesto objLastPage = new LastPageMesto(driver);
    // кликни кнопку посмотреть статус
    objLastPage.waitOrderConfirm();
  }

  @After
  public void teardown() {
    // Закрой браузер
    driver.quit();
  }
}
