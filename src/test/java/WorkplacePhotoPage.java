import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WorkplacePhotoPage  extends PageBase{

    private By captionTextField = By.id("captions[0]");

    private By submitPhoto = By.xpath("//button[@class='gd-ui-button css-s89dmq evpplnh0']");




   public WorkplacePhotoPage (WebDriver driver){
        super (driver);
   }

    public ResultPage uploadPhoto(String photoName, String caption){

                WebElement addFile = this.driver.findElement(By.id("photos-survey-fileDrop"));

                String path = System.getProperty("user.dir") + "\\src\\files\\" + photoName;
                addFile.sendKeys(path);
                this.waitVisibiltyAndFindElement(captionTextField).sendKeys(caption);

                WebElement submitButton= this.waitVisibiltyAndFindElement(submitPhoto);
                JavascriptExecutor jse2 = (JavascriptExecutor)driver;
                jse2.executeScript("arguments[0].scrollIntoView()", submitButton); 
                submitButton.click();


    
            return new ResultPage(this.driver);
        }
   
}
