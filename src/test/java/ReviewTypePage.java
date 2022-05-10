import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class ReviewTypePage extends PageBase{

     private By employerReview=By.id("EMPLOYER");
     private By companyNameInputBox = By.name("survey-AddCompany-component");
     private By nextButton = By.xpath("//button[@class='gd-ui-button css-s89dmq evpplnh0']");
     private By selectCompany = By.xpath("(//ul[@class='suggestions down']/li)[1]");

     private By workplacePhoto=By.id("PHOTOS");




 
    public ReviewTypePage (WebDriver driver){
         super (driver);
    }
 
     public EmployerReviewPage employerReviewType(String CompanyName, int i){
        By employeeStatus=By.xpath("(//div[@class=' css-zyyr96 e8vekwx0']/button)["+i+"]");

         this.waitVisibiltyAndFindElement(employerReview).click();
         this.waitVisibiltyAndFindElement(employeeStatus).click();
         this.waitVisibiltyAndFindElement(companyNameInputBox).sendKeys(CompanyName);
         this.waitVisibiltyAndFindElement(selectCompany).click();
         this.waitVisibiltyAndFindElement(nextButton).click();
         return new EmployerReviewPage(this.driver);
     }

     public WorkplacePhotoPage workplacePhoto(String CompanyName){
  
           this.waitVisibiltyAndFindElement(workplacePhoto).click();
           this.waitVisibiltyAndFindElement(companyNameInputBox).sendKeys(CompanyName);
           this.waitVisibiltyAndFindElement(selectCompany).click();
           this.waitVisibiltyAndFindElement(nextButton).click();
           return new WorkplacePhotoPage(this.driver);
       }
    
}