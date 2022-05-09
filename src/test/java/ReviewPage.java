import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ReviewPage extends PageBase{

     private By companyNameInputBox=By.name("survey-AddCompany-component");
     private By statusSelectBox=By.xpath("//div[@class='col-12 col-md-7 px-0 mt-lg mb css-j7qwjs ew8s0qn0']/div[@class='css-47sx24 egu3u860']");
     private By headlineInputBox = By.id("ReviewHeadline");
     private By prosTextField = By.id("ProsTextField");
     private By consTextField = By.id("ConsTextField");
     private By jobFunctionSelectBox=By.xpath("//div[@class='mb css-j7qwjs ew8s0qn0']/div[@data-test='employer-survey-about-sgocContent']");
     private By termsOfUseCheckBox = By.xpath("//div[@class='checkboxBox']");
     private By submitReviewButton = By.xpath("//button[@data-test='employer-survey-singlePage-submit']");



 
    public ReviewPage (WebDriver driver){
         super (driver);
    }
 
     public ResultPage writeReview(int rating,String statusInput, String headline, String pros, String cons, String jobFunction){

          By starReview = By.xpath("(//div[@class='mb']/div/div/div/span)["+ rating +"]");
          By selectedStatus = By.id(statusInput);

          By selectedJobFunction = By.id(jobFunction);

         //this.waitVisibiltyAndFindElement(companyNameInputBox).sendKeys(CompanyName);
         this.waitVisibiltyAndFindElement(starReview).click();

         this.waitVisibiltyAndFindElement(statusSelectBox).click();
         this.waitVisibiltyAndFindElement(selectedStatus).click();

         this.waitVisibiltyAndFindElement(headlineInputBox).sendKeys(headline);
         this.waitVisibiltyAndFindElement(prosTextField).sendKeys(pros);
        this.waitVisibiltyAndFindElement(consTextField).sendKeys(cons);

        WebElement job_Function = this.waitVisibiltyAndFindElement(jobFunctionSelectBox);
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", job_Function); 
        this.waitVisibiltyAndFindElement(jobFunctionSelectBox).click();
        this.waitVisibiltyAndFindElement(selectedJobFunction).click();

        this.waitVisibiltyAndFindElement(termsOfUseCheckBox).click();
        this.waitVisibiltyAndFindElement(submitReviewButton).click();

         return new ResultPage(this.driver);
     }
    
}
