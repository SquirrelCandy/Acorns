package steps;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CMSDropdownPage;
import utils.DriverManager;
import utils.PageManager;

public class CMSDropdownsSteps {
	private static Logger logger = LogManager.getLogger("CMSDropdownSteps");
	private static CMSDropdownPage cmsDropdownPage;
	
	@After
	public void after() {
		DriverManager.shutdownDriver();
	}
	
	@Given("^User launches Chrome browser$")
	public void userLaunchesChromeBrowser() {
		DriverManager.initDriver();
		cmsDropdownPage = PageManager.getCMSDropdownPage();
	}
	
	@Given("^User is on CMS Dropdowns page$")
	public void userIsOnCMDDropdownsPage() throws Throwable {
		cmsDropdownPage.navigate();
	}
	
	@When("^User selects option 3 in first dropdown$")
	public void userSelectsFirstDropdown() throws Throwable {
		cmsDropdownPage.selectDropdownOption(3);
	}
	
	@Then("^Option 3 is selected$")
	public void optionThreeIsSelected() throws Throwable {
		String selectedOption = cmsDropdownPage.getSelectedOption();
		logger.info("option [" + selectedOption + "] selected");
		assertEquals("Option 3",selectedOption);
	}
}

