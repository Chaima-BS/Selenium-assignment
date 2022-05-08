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

class DashboardPage extends PageBase{

    private By cardBy = By.xpath("//div[@class='siteHeader__HeaderStyles__navigationWrapper']/div/div[@class='d-flex flex-row align-items-center']/div[@class='col']/h2");
    private By logoutButton=By.linkText("Sign Out");

    public DashboardPage (WebDriver driver){
        super(driver);
   }
   public String getMainCardTitle(){
        return this.waitVisibiltyAndFindElement(cardBy).getText();
   }

   public MainPage logOut(){
       this.waitVisibiltyAndFindElement(logoutButton).click();
        return new MainPage(this.driver);


    /*    // Locating the Main Menu (Parent element)
WebElement mainMenu = driver.findElement(By.linkText("Sign Out"));

//Instantiating Actions class
Actions actions = new Actions(driver);

//Hovering on main menu
actions.moveToElement(mainMenu);

// Locating the element from Sub Menu
WebElement subMenu = driver.findElement(By.xpath("<Xpath of the sub element>"));

//To mouseover on sub menu
actions.moveToElement(subMenu);

//build()- used to compile all the actions into a single step 
actions.click().build().perform();*/
   }
}