import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountPage extends PageBase{

    private By cardBy = By.xpath("//div[@id='MainCol']/div[@class='module spacious']/h1");


    public AccountPage (WebDriver driver){
        super(driver);
   }
   public String getMainCardTitle(){
        return this.waitVisibiltyAndFindElement(cardBy).getText();
   }
    
}
