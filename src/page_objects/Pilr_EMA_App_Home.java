package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pilr_EMA_App_Home extends AbstractBasePage {
		
	By EmaappPageWelcome = By.cssSelector("h4.lighter.smaller");
	By SurvResponseLink = By.linkText("Survey Responses");
	By ebuilderLink = By.linkText("Builder");
	By applicationLink = By.linkText("Application");
	By languagesLink = By.linkText("Languages");
	By complianceLink = By.linkText("Compliance");
	
	public Pilr_EMA_App_Home(WebDriver driver){
	       super(driver);
	   }
	
	public WebElement activeNavTab() {
		return findElement(By.cssSelector(".page-header ul.nav li.active a"));
	}
	
	//Get the EMA App Page Welcome
    public String getEMAAppPageWelcome(){
        return activeNavTab().getText();
    }
    //Navigate to the Survey Response Page
    public Pilr_Survey_ResponsePage selectSurvResponse() {
  	  findElement(SurvResponseLink).click();
  	  System.out.println("[Page Object]Select Survey Reponse Link");
  	  return new Pilr_Survey_ResponsePage(driver);
    }
    //Navigate to the EMA Builder Page
    public Pilr_Builder_Page selectEMABuilder() {
  	  findElement(ebuilderLink).click();
  	  System.out.println("[Page Object]Select EMA Builder Link");
  	  return new Pilr_Builder_Page(driver);
    }
    //Navigate to the EMA Application Page
    public Pilr_Application_Page selectEMAApplication() {
  	  findElement(applicationLink).click();
  	  System.out.println("[Page Object]Select EMA Application Link");
  	  return new Pilr_Application_Page(driver);
    }
    //Navigate to the EMA Languages Page
    public Pilr_Languages_Page selectEMALanguages() {
  	  findElement(languagesLink).click();
  	  System.out.println("[Page Object]Select EMA Languages Link");
  	  return new Pilr_Languages_Page(driver);
    }
    //Navigate to the EMA Compliance Page
    public Pilr_Compliance_Page selectEMACompliance() {
		driver.findElement(complianceLink).click();
  	  System.out.println("[Page Object]Select EMA Compliance Link");
  	  return new Pilr_Compliance_Page(driver);
    }
	   
}
