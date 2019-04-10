package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Update_Group_Modal extends AbstractBasePage {
	By updateGroupWelcome = By.cssSelector("div[class='table-header']");
	By participantStatus = By.cssSelector("select[name='groupIds']");
	By templateAssignments = By.cssSelector("select[name='groupIds']");
	By saveButton = By.cssSelector("input[id='Save']");
	By doneButton = By.xpath("//div[2]/div[2]/button");
	By updateSuccess = By.cssSelector("div[class='table-header']");

	public Update_Group_Modal(WebDriver driver) {
		super(driver);
	}

	// return welcome message
	public String get_Group_Modal_Welcome() {
		return findElement(updateGroupWelcome, 8000).getText();
	}

	// select and update the Participant Status and Template Assignment fields
	public void select_Group_Status(String part_status, String temp_assignments) {
		dropDownSelect(participantStatus, part_status);
		findElements(templateAssignments).get(1).click();
		findElements(templateAssignments).get(1).sendKeys(temp_assignments);
		findElements(templateAssignments).get(1).click();
		findElement(saveButton).click();
	}

	// return success message
	public String Bulk_Update_Status() {
		return findElement(updateSuccess).getText();
	}

	// close modal
	public Bulk_Edit_Participants_Page close_Update_Group_Modal() {
		findElement(doneButton).click();
		return new Bulk_Edit_Participants_Page(driver);
	}

}
