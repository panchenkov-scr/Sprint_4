import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.panchenkov.autotests.pages.auth.HomePageMesto;
import ru.panchenkov.autotests.pages.deals.OrderPageMesto;

import java.io.File;


public class Praktikum {
  public static WebDriver driver;
  @Before
  public void setUp() {
    ChromeDriverService service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File("C:/Development/Sprint_4/chromedriver.exe"))
            .build();
    driver = new ChromeDriver(service);
  }
  @Test
  public void checkActivity() throws InterruptedException {
    // драйвер для браузера Chrome
    ChromeOptions options = new ChromeOptions();
  //  options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
  //  driver = new ChromeDriver(options);
    // переход на страницу тестового приложения
    driver.get("https://qa-scooter.praktikum-services.ru/");


    // создай объект класса страницы авторизации
    //LoginPageMesto objLoginPage = new LoginPageMesto(driver);
    // выполни авторизацию
    //objLoginPage.login("d0npan@ya.ru","123456!");


    // создай объект класса главной страницы приложения
    HomePageMesto objHomePage = new HomePageMesto(driver);
    // дождись загрузки данных профиля на главной странице
    objHomePage.waitForLoadProfileData();
    // кликни на кнопку редактирования профиля
    objHomePage.clickEditProfileButton();


    // создай объект класса для поп-апа редактирования профиля
    OrderPageMesto objProfilePage = new OrderPageMesto(driver);
    // это переменная со значением, которое надо ввести в поле «Занятие»
    String newActivity = "Тестировщик";
    // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
    objProfilePage.checkActivity(newActivity);
    // сохрани изменения в профиле
    objProfilePage.clickProfile();

    // проверь, что поле «Занятие» на основной странице поменяло значение на новое
    objHomePage.waitForChangedActivity(newActivity);
  }
  @After
  public void teardown() {
    // Закрой браузер
    driver.quit();
  }
}
