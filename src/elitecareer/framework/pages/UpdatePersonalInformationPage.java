package elitecareer.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import elitecareer.framework.base.PageBase;

public class UpdatePersonalInformationPage extends PageBase{

	@FindBy(id = "legend")
	public WebElement updatePersonalInformationTitle;
	
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
	
	@FindBy(name = "submit")
	public WebElement submitButton;
	
	@FindBy(xpath = "//*[@id='body_content']/center")
	public WebElement updateConfirmation;
}
