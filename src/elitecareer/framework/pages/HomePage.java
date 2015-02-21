package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class HomePage extends PageBase{

	@FindBy(id = "legend")
	public WebElement jobSearchTitle;
	
	@FindBy(id = "application_status_head_container")
	public WebElement newJobsTitle;
	

}
