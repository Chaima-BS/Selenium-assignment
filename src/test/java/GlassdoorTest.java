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
import java.util.concurrent.TimeUnit;

public class GlassdoorTest {

    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        // define the periode for waiting
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void login (){
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        DashboardPage dashboardPage=loginPage.login("noyavi7485@3dmasti.com","noyavi7485");
        //System.out.println(dashboardPage.getMainCardTitle());
        ReadConfFile conf = new ReadConfFile();
        Assert.assertTrue(dashboardPage.getMainCardTitle().contains (conf.loadProperties().getProperty("login_cardTitle")));
    }

    @Test
    public void writeReview(){
        this.login();
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        ReviewTypePage reviewTypePage = dashboardPage.openWriteReview();
        ReviewPage reviewPage = reviewTypePage.pickReviewType("SAP",1);
        ReadConfFile conf = new ReadConfFile();
        ResultPage resultPage = reviewPage.writeReview(Integer.parseInt(conf.loadProperties().getProperty("rating")),conf.loadProperties().getProperty("Employment_Status"),conf.loadProperties().getProperty("Review_Headline"),conf.loadProperties().getProperty("Pros"),conf.loadProperties().getProperty("Cons"),conf.loadProperties().getProperty("job_Function"));
        //System.out.println(resultPage.getMainCardTitle());
        Assert.assertTrue(resultPage.getMainCardTitle().contains (conf.loadProperties().getProperty("review_cardTitle")));
    }

    @Test
    public void logout (){
        this.login();
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        MainPage mainPage = dashboardPage.logOut();
        ReadConfFile conf = new ReadConfFile();
        //System.out.println(mainPage.getMainCardTitle());
       Assert.assertTrue(mainPage.getMainCardTitle().contains (conf.loadProperties().getProperty("logout_cardTitle")));
    }

    @After
    public void close(){
        if (driver != null){
            driver.quit();
        }
    }
}

    