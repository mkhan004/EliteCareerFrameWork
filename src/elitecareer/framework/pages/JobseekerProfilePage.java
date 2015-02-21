package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class JobseekerProfilePage extends PageBase{

	@FindBy(css = "div[id = 'head_style_container_id']")
	public WebElement profileTitle;
	
	@FindBy(xpath = "//*[@id='profile_title_container_id']/h1/i/a/img")
	public WebElement editPersonalInformationLink;
	
	@FindBy(xpath = "//*[@id='experience_title_style']/h3/i/a/img")
	public WebElement editExperienceLink;
	
	@FindBy(xpath = "//*[@id='profile_education_title_style']/h3/i/a/img")
	public WebElement editEducationLink;
}
