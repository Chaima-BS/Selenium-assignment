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


class MainPage extends PageBase {
     private By cardBy = By.xpath("//div[@class='lockedSignUp d-flex align-items-center justify-content-center flex-column top-padding-zero']/h1");
   private By loginMenuButton=By.xpath("//div[@class='d-flex justify-content-between LockedHomeHeaderStyles__fullWidth']/div/button");
  
   public MainPage (WebDriver driver){
        super(driver);
        this.driver.get("https://www.glassdoor.com/index.htm");
   }

   public String getPageTitle() {
     return this.driver.getTitle();
 }



   public LoginPage openLogin(){
    //System.out.println(loginMenuButton.);
       this.waitVisibiltyAndFindElement(loginMenuButton).click();
        return new LoginPage(this.driver);
   }

}