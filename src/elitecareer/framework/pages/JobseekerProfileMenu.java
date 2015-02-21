package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobseekerProfileMenu {

	@FindBy(id = "menu_head")
	public WebElement profileMenuTitle;
	
	@FindBy(linkText = "profile")
	public WebElement profileLink;
	
	@FindBy(linkText = "status feed")
	public WebElement statusFeedLink;
	
	@FindBy(linkText = "edit profile")
	public WebElement editProfileeLink;
	
	@FindBy(linkText = "update profile")
	public WebElement updateProfileLink;
	
	@FindBy(linkText = "change password")
	public WebElement changePasswordLink;
	
	@FindBy(linkText = "change email")
	public WebElement changeEmailLink;
	
	@FindBy(linkText = "add profile picture")
	public WebElement addProfilePictureLink;
	
	@FindBy(linkText = "add education")
	public WebElement addEducationLink;
	
	@FindBy(linkText = "add experience")
	public WebElement addExperienceLink;
	
	@FindBy(linkText = "add education")
	public WebElement addResumeLink;
	
	@FindBy(linkText = "Application status")
	public WebElement applicationStatusLink;
	
	@FindBy(linkText = "Job Search")
	public WebElement jobSearchLink;
	
	@FindBy(linkText = "logout")
	public WebElement logoutLink;
}