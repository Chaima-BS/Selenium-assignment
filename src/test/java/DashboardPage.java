import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



class DashboardPage extends PageBase{

    private By cardBy = By.xpath("//div[@class='siteHeader__HeaderStyles__navigationWrapper']/div/div[@class='d-flex flex-row align-items-center']/div[@class='col']/h2");
    private By userProfileMenu=By.xpath("//div[@class='d-flex justify-content-between align-items-center px-std px-md-lg siteHeader__HeaderStyles__mainNav']/div[@class='d-none d-lg-flex']/div/div[@class='d-flex']/span");
    private By logoutButton = By.linkText("Sign Out");
    private By companiesMenu=By.linkText("Companies");
    private By reviewButton = By.linkText("Write a Review");

    public DashboardPage (WebDriver driver){
        super(driver);
   }
   public String getMainCardTitle(){
        return this.waitVisibiltyAndFindElement(cardBy).getText();
   }

   public MainPage logOut(){
       // locate the menu to hover over using its xpath
       WebElement ele = this.waitVisibiltyAndFindElement(userProfileMenu);
       // Initiate mouse action using Actions class
       Actions actions = new Actions(this.driver);
       // move the mouse to the earlier identified menu option
       actions.moveToElement(ele).perform();
       this.waitVisibiltyAndFindElement(logoutButton).click();

       return new MainPage(this.driver);
   }


   public ReviewTypePage openWriteReview(){
    // locate the menu to hover over using its xpath
    WebElement ele = this.waitVisibiltyAndFindElement(companiesMenu);
    // Initiate mouse action using Actions class
    Actions actions = new Actions(this.driver);
    // move the mouse to the earlier identified menu option
    actions.moveToElement(ele).perform();
    this.waitVisibiltyAndFindElement(reviewButton).click();

    return new ReviewTypePage(this.driver);
}
}