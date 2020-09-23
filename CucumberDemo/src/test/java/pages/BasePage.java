package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	
  public BasePage(WebDriver driver) {
      this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public void click(By by) {
	  WebElement element = driver.findElement(by);
	  element.click();
  }
  
  public void enter(By by, String input) {
	  WebElement element = driver.findElement(by);
	  element.sendKeys(input);
  }

  public void enter(By by, Keys input) {
	  WebElement element = driver.findElement(by);
	  element.sendKeys(input);
  }
  
  public String getText(By by) {
	  WebElement element = driver.findElement(by);
	  return element.getText();
  }
  
  public void selectByValue(By by, String opt) {
	  Select select = new Select(driver.findElement(by));
	  select.selectByValue(String.valueOf(opt));
  }
  
  public void selectByVisibleText(By by, String opt) {
	  Select select = new Select(driver.findElement(by));
	  select.selectByVisibleText(String.valueOf(opt));
  }
  
  public String getSelectedOption(By by) {
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	  Select select = new Select(driver.findElement(by));
	  WebElement opt = select.getFirstSelectedOption();
	  return opt.getText();
  }
}