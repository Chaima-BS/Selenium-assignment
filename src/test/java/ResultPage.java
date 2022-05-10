import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResultPage extends PageBase{
    private By cardBy = By.xpath("//div[@class='my-std']/div/div[@class='textAndIconContainer']/div[@class='text']/span");
    private By uploadPhoto = By.xpath("//div[@class=' css-eu3rpx ena0w9p0']/div[@class='textAndIconContainer']/div[@class='text']/span");

    public ResultPage (WebDriver driver){
        super(driver);
   }
   public String getMainCardTitle(){
        return this.waitVisibiltyAndFindElement(cardBy).getText();
   }

   public String getUploadedPhotoCardTitle(){
     return this.waitVisibiltyAndFindElement(uploadPhoto).getText();
}
    
}
