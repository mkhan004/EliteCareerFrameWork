package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class PageHeader extends PageBase{

	@FindBy(linkText = "home")
	public WebElement homePageLink;
	
	@FindBy(linkText = "job seeker")
	public WebElement jobSeekerPageLink;
	
	@FindBy(linkText = "employer")
	public WebElement employerPageLink;
	
	@FindBy(linkText = "job post")
	public WebElement jobPostPageLink;
	
	@FindBy(linkText = "contact us")
	public WebElement contactUsPageLink;
	
	@FindBy(linkText = "about us")
	public WebElement aboutUsPageLink;
	
	@FindBy(linkText = "Signin")
	public WebElement signInPageLink;
	
	@FindBy(linkText = "Register")
	public WebElement registerPageLink;
	
	@FindBy(linkText = "Logout")
	public WebElement logOutLink;
	
	@FindBy(id = "welcome_bar_style2")
	public WebElement profileLink;
	
	public void goToSignInPage(){
		signInPageLink.click();
	}

}
