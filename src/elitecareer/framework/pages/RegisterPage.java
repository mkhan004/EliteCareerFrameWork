package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class RegisterPage extends PageBase{

	@FindBy(id = "legend")
	public WebElement registerTitle;
	
	@FindBy(name = "FirstName")
	public WebElement firstNameField;
	
	@FindBy(name = "LastName")
	public WebElement lastNameField;
	
	@FindBy(name = "Gender")
	public WebElement genderDropDownField;
	
	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirthField;
	
	@FindBy(name = "PhoneNo")
	public WebElement phoneNoField;
	
	@FindBy(name = "UserType")
	public WebElement UserTypeDropDownField;
	
	@FindBy(name = "Email")
	public WebElement emailField;
	
	@FindBy(name = "Password")
	public WebElement passwordField;
	
	@FindBy(name = "ConfirmPassword")
	public WebElement confirmPasswordField;
	
	@FindBy(name = "Captcha")
	public WebElement captchaField;
	
	@FindBy(name = "Privacy")
	public WebElement privacyCheckBox;
	
	@FindBy(name = "Subscribe")
	public WebElement subscribeCheckBox;
	
	@FindBy(name = "submit")
	public WebElement submitButton;
	
	@FindBy(id = "application_status_container")
	public WebElement confirmationMessage;
	
}
