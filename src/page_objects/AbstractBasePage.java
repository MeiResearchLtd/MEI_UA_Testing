package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pilrhealth.com.ua.util.Retriable;

public class AbstractBasePage {
		
	private static final int DEFAULT_TIMEOUT = 30000;
	protected WebDriver driver;

	public AbstractBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement findElement(By by, long timeout) {
		return new Retriable<WebElement>(timeout) {
			@Override
			protected WebElement tryOnce() {
				return driver.findElement(by);
			}
		}.run();
	}
	protected WebElement findElement(By by) {
		return findElement(by, DEFAULT_TIMEOUT);
	}
	
	protected List<WebElement> findElements(By by, long timeout) {
		return new Retriable<List<WebElement>>(timeout) {
			@Override
			protected List<WebElement> tryOnce() {
				return driver.findElements(by);
			}
		}.run();
	}
	protected List<WebElement> findElements(By by) {
		return findElements(by, DEFAULT_TIMEOUT);
	}
	
	protected void dropDownSelect(By menuSelector, String item) {
		WebElement selector = findElement(menuSelector);
		selector.click();
		selector.sendKeys(item + "\r");
		//selector.click(); //important: this is to make the drop down lose focus and update list
		// but it may fail because element is not attached to page.  Better to click on some other
		// element. What?
	}

}
