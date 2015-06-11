package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

public class RegisterPageTest extends TestBase{

	@Test(priority = 0)
	public void testRegisterPageTitle(){
		pageHeader.registerPageLink.click();
		Assert.assertEquals(registerPage.getPageTitle(), "Register as Jobseeker & Employer | EliteCareer");
	}
	
	@Test(priority = 1)
	public void testRegisterPageUrl(){
		Assert.assertTrue(registerPage.verifyCurrentUrlSuffix("register.php"));
	}
	
	@Test(priority = 2)
	public void testRegisterTitle(){
		Assert.assertEquals(registerPage.registerTitle.getText(), "Registration");
	}
	
	@Test(priority = 3)
	public void testEmptyFormSublission(){
		registerPage.privacyCheckBox.click();
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be empty."), "* FirstName can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be empty."), "* LastName can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Gender can not be empty."), "* Gender can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* DateOfBirth can not be empty."), "* DateOfBirth can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be empty."), "* PhoneNo can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* UserType can not be empty."), "* UserType can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Email can not be empty."), "* Email can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be empty."), "* Password can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* ConfirmPassword can not be empty."), "* ConfirmPassword can not be empty.");
		//Assert.assertEquals(registerPage.getErrorMessageByValue("* Captcha can not be empty."), "* Captcha can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Privacy can not be empty."), "* Privacy can not be empty.");
	}
	
	@Test(priority = 4)
	public void testFirstNameFieldBellowLowerBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), "* FirstName can not be less than 2 character.");
	}
	
	@Test(priority = 5)
	public void testFirstNameFieldLowerBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("as");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be empty."), null);
	}
	
	@Test(priority = 6)
	public void testFirstNameFieldAboveUpperBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), "* FirstName can not be greater than 30 character.");
	}
	
	@Test(priority = 7)
	public void testFirstNameFieldUpperBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* FirstName can not be empty."), null);
	}
	
	@Test(priority = 8)
	public void testLastNameFieldBellowLowerBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be less than 2 character."), "* LastName can not be less than 2 character.");
	}
	
	@Test(priority = 9)
	public void testLastNameFieldLowerBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("as");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be empty."), null);
	}
	
	@Test(priority = 10)
	public void testLastNameFieldAboveUpperBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), "* LastName can not be greater than 30 character.");
	}
	
	@Test(priority = 11)
	public void testLastNameFieldUpperBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* LastName can not be empty."), null);
	}
	
	@Test(priority = 12)
	public void testDateOfBirthFieldWithInvalidInput(){
		registerPage.dateOfBirthField.clear();
		registerPage.dateOfBirthField.sendKeys("1985-18-30");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Invalid DateOfBirth"), "* Invalid DateOfBirth");
	}
	
	@Test(priority = 13)
	public void testDateOfBirthFieldWithValidInput(){
		registerPage.dateOfBirthField.clear();
		registerPage.dateOfBirthField.sendKeys("1985-12-30");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Invalid DateOfBirth"), null);
	}
	
	/////
	
	@Test(priority = 14)
	public void testPhoneNoFieldBellowLowerBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be less than 3 character."), "* PhoneNo can not be less than 3 character.");
	}
	
	@Test(priority = 15)
	public void testPhoneNoFieldLowerBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("911");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be less than 3 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be empty."), null);
	}
	
	@Test(priority = 16)
	public void testPhoneNoFieldAboveUpperBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be greater than 30 character."), "* PhoneNo can not be greater than 30 character.");
	}
	
	@Test(priority = 17)
	public void testPhoneNoFieldUpperBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be less than 3 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* PhoneNo can not be empty."), null);
	}
	
/////
	@Test(priority = 18)
	public void testEmailFieldIfAlreadyRegistered(){
		registerPage.emailField.clear();
		registerPage.emailField.sendKeys("shakil_ipe@yahoo.com");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* This Email is already registered."), "* This Email is already registered.");
	}
	
	@Test(priority = 19)
	public void testPasswordFieldBellowLowerBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be less than 6 character."), "* Password can not be less than 6 character.");
	}
	
	@Test(priority = 20)
	public void testPasswordFieldLowerBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("911654");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be less than 6 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be greater than 20 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be empty."), null);
	}
	
	@Test(priority = 21)
	public void testPasswordFieldAboveUpperBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be greater than 20 character."), "* Password can not be greater than 20 character.");
	}
	
	@Test(priority = 22)
	public void testPasswordFieldUpperBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("anhgfdsaetyun mjhgfd");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be less than 6 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be greater than 20 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue("* Password can not be empty."), null);
	}
	
	@Test(priority = 23)
	public void testPasswordAndConfirmPasswordFieldsIfDoNotMatch(){
		registerPage.passwordField.sendKeys("bbbbbbb");
		registerPage.confirmPasswordField.sendKeys("aaaaaaa");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue("* ConfirmPassword did not match."), "* ConfirmPassword did not match.");
	}
	
	@Test(priority = 24, enabled = false)
	public void testNewRegistration(){
		driver.get("http://localhost:8788/elitecareer/register.php");
		registerPage.firstNameField.sendKeys("Jon");
		registerPage.lastNameField.sendKeys("Smith");
		registerPage.selectFromDropdownList(registerPage.genderDropDownField, "Male");
		registerPage.dateOfBirthField.sendKeys("1985-12-30");
		registerPage.phoneNoField.sendKeys("347-754-9322");
		registerPage.selectFromDropdownList(registerPage.UserTypeDropDownField, "Jobseeker");
		registerPage.emailField.sendKeys("shakilkhan4_ipe@yahoo.com");
		registerPage.passwordField.sendKeys("36582710");
		registerPage.confirmPasswordField.sendKeys("36582710");
		registerPage.submitButton.click();
		String confirmation = registerPage.confirmationMessage.getText();
		Assert.assertTrue(confirmation.contains("Your Registration is Successful"));
	}
}
