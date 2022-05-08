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


class LoginPage extends PageBase{

    private By nameInputBox=By.name("username");
    private By passwordInputBox=By.name("password");

   public LoginPage (WebDriver driver){
        super (driver);
   }

    public DashboardPage login(String username, String password){
        this.waitVisibiltyAndFindElement(nameInputBox).sendKeys(username);
       this.waitVisibiltyAndFindElement(passwordInputBox).sendKeys(password+ "\n");
        return new DashboardPage(this.driver);
    }
}