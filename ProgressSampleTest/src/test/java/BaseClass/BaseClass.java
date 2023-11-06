package BaseClass;

import Helpers.CommonMethods;
import Resources.ConstantsLandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
    public ConstantsLandingPage constsLP = new ConstantsLandingPage();
    public static CommonMethods commonMethods = new CommonMethods();
    public static WebDriverWait wait;

    @BeforeAll
    void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeAll
    void setupTest(){
        driver = new ChromeDriver();
        driver.get(constsLP.URL_LANDING_PAGE);
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
        wait = commonMethods.waitSeconds(driver, constsLP.WAIT_SECONDS);
    }
    @AfterAll
    static void teardown(){
        driver.quit();
    }
}
