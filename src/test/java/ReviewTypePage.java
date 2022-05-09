import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class ReviewTypePage extends PageBase{

private By reviewType=By.id("EMPLOYER");
     private By companyNameInputBox = By.name("survey-AddCompany-component");
     private By nextButton = By.xpath("//button[@class='gd-ui-button css-s89dmq evpplnh0']");
     private By selectCompany = By.xpath("(//ul[@class='suggestions down']/li)[1]");




 
    public ReviewTypePage (WebDriver driver){
         super (driver);
    }
 
     public ReviewPage pickReviewType(String CompanyName, int i){
        By employeeStatus=By.xpath("(//div[@class=' css-zyyr96 e8vekwx0']/button)["+i+"]");

         this.waitVisibiltyAndFindElement(reviewType).click();
         this.waitVisibiltyAndFindElement(employeeStatus).click();
         this.waitVisibiltyAndFindElement(companyNameInputBox).sendKeys(CompanyName);
         this.waitVisibiltyAndFindElement(selectCompany).click();
         this.waitVisibiltyAndFindElement(nextButton).click();
         return new ReviewPage(this.driver);
     }
    
}