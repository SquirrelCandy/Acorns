package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CMSDropdownPage extends BasePage {
	By dropdownBy = By.xpath("//select[@id='options']");
	By iframeBy = By.xpath("//iframe[@title='Default example']");
	
	public CMSDropdownPage(WebDriver driver) {
		super(driver);
	}
	
	public void navigate() {
		driver.get("https://design.cms.gov/components/dropdown/");
	}
	
	public void selectDropdownOption(int opt) {
		driver.switchTo().frame(driver.findElement(iframeBy));
		selectByValue(dropdownBy, String.valueOf(opt));
		driver.switchTo().defaultContent();
	}
	
	public String getSelectedOption() {
		driver.switchTo().frame(driver.findElement(iframeBy));
		String opt = getSelectedOption(dropdownBy);
		driver.switchTo().defaultContent();
		return opt;
	}
}
