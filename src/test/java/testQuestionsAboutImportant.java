import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.panchenkov.autotests.pages.auth.HomePageMesto;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;


public class testQuestionsAboutImportant {

  public static WebDriver driver;

  @Before
  public void setUp() {
    ChromeDriverService service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File("C:/Development/Sprint_4/chromedriver.exe"))
            .build();
    driver = new ChromeDriver(service);
  }

  //Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
  @Test
  public void checkQuestionsAboutImportant() {
    // драйвер для браузера Chrome
    ChromeOptions options = new ChromeOptions();
    // переход на страницу тестового приложения
    driver.get("https://qa-scooter.praktikum-services.ru/");

    // создай объект класса главной страницы приложения
    HomePageMesto objHomePage = new HomePageMesto(driver);
    // дождись загрузки данных на главной странице
    objHomePage.waitForLoadProfileData();

    // кликни на 1 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("0");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Сколько это стоит? И как оплатить?", is(objHomePage.getQuestionCenterOrderButton("0")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("4", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");

    // кликни на 2 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("1");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Хочу сразу несколько самокатов! Так можно?", is(objHomePage.getQuestionCenterOrderButton("1")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("4", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");

    // кликни на 3 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("2");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Как рассчитывается время аренды?", is(objHomePage.getQuestionCenterOrderButton("2")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("4", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");

    // кликни на 4 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("3");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Можно ли заказать самокат прямо на сегодня?", is(objHomePage.getQuestionCenterOrderButton("3")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("4", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");

    // кликни на 5 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("4");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Можно ли продлить заказ или вернуть самокат раньше?", is(objHomePage.getQuestionCenterOrderButton("4")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");


    // кликни на 6 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("5");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Вы привозите зарядку вместе с самокатом?", is(objHomePage.getQuestionCenterOrderButton("5")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");

    // кликни на 7 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("6");
    // проверь соответствие текста вопроса образцу
    MatcherAssert.assertThat("Можно ли отменить заказ?", is(objHomePage.getQuestionCenterOrderButton("6")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");

    // кликни на 8 - номер вопроса в центре главной страницы
    objHomePage.clickQuestion("7");
    // проверь соответствие текста вопроса образцу БАГА ЕСТЬ получит "жизу" вместо "живу"
    MatcherAssert.assertThat("Я живу за МКАДом, привезёте?", is(objHomePage.getQuestionCenterOrderButton("7")));
    // проверь соответствие текста ответа образцу
    objHomePage.waitForChangedActivity("7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
  }

  @After
  public void teardown() {
    // Закрой браузер
    driver.quit();
  }
}
