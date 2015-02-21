package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class SignInPage extends PageBase{

	@FindBy(id = "legend")
	public WebElement signInTitle;
	
	@FindBy(name = "Email")
	public WebElement emailField;
	
	@FindBy(name = "Password")
	public WebElement passwordField;
	
	@FindBy(name = "submit")
	public WebElement submitButton;
}
