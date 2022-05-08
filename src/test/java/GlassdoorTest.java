import org.junit.*;
import io.github.bonigarcia.wdm. WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GlassdoorTest {

    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void login (){
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        DashboardPage dashboardPage=loginPage.login("noyavi7485@3dmasti.com","noyavi7485");
        System.out.println(dashboardPage.getMainCardTitle());
        Assert.assertTrue(dashboardPage.getMainCardTitle().contains ("Hello, what would you like to explore today?"));
    }

    @Test
    public void logout (){
        this.login();
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        MainPage mainPage = dashboardPage.logOut();
        System.out.println(mainPage.getMainCardTitle());
       Assert.assertTrue(dashboardPage.getMainCardTitle().contains ("You deserve a job that loves you back"));
    }

    @After
    public void close(){
        if (driver != null){
            driver.quit();
        }
    }
}

    