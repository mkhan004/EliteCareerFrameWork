package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

public class RegisterPageTest extends TestBase{

	@Test
	public void testRegisterPageTitle(){
		pageHeader.registerPageLink.click();
		Assert.assertEquals(registerPage.getPageTitle(driver), "Register as Jobseeker & Employer | EliteCareer");
	}
	
	@Test
	public void testRegisterPageUrl(){
		Assert.assertTrue(registerPage.verifyCurrentUrlSuffix(driver, "register.php"));
	}
	
	@Test
	public void testRegisterTitle(){
		Assert.assertEquals(registerPage.registerTitle.getText(), "Registration");
	}
	
	@Test(dependsOnMethods = "testRegisterPageTitle")
	public void testEmptyFormSublission(){
		/*registerPage.firstNameField.clear();
		registerPage.lastNameField.clear();
		registerPage.emailField.clear();
		registerPage.genderDropDownField.clear();
		registerPage.dateOfBirthField.clear();
		registerPage.UserTypeDropDownField.clear();
		registerPage.phoneNoField.clear();
		registerPage.passwordField.clear();
		registerPage.confirmPasswordField.clear();
		registerPage.captchaField.clear();*/
		registerPage.privacyCheckBox.click();
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be empty."), "* FirstName can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be empty."), "* LastName can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Gender can not be empty."), "* Gender can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* DateOfBirth can not be empty."), "* DateOfBirth can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be empty."), "* PhoneNo can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* UserType can not be empty."), "* UserType can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Email can not be empty."), "* Email can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be empty."), "* Password can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* ConfirmPassword can not be empty."), "* ConfirmPassword can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Captcha can not be empty."), "* Captcha can not be empty.");
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Privacy can not be empty."), "* Privacy can not be empty.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testFirstNameFieldBellowLowerBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), "* FirstName can not be less than 2 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testFirstNameFieldLowerBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("as");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testFirstNameFieldAboveUpperBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), "* FirstName can not be greater than 30 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testFirstNameFieldUpperBoundary(){
		registerPage.firstNameField.clear();
		registerPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* FirstName can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testLastNameFieldBellowLowerBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), "* LastName can not be less than 2 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testLastNameFieldLowerBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("as");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testLastNameFieldAboveUpperBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), "* LastName can not be greater than 30 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testLastNameFieldUpperBoundary(){
		registerPage.lastNameField.clear();
		registerPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* LastName can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testDateOfBirthFieldWithInvalidInput(){
		registerPage.dateOfBirthField.clear();
		registerPage.dateOfBirthField.sendKeys("1985-18-30");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Invalid DateOfBirth"), "* Invalid DateOfBirth");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testDateOfBirthFieldWithValidInput(){
		registerPage.dateOfBirthField.clear();
		registerPage.dateOfBirthField.sendKeys("1985-12-30");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Invalid DateOfBirth"), null);
	}
	
	/////
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPhoneNoFieldBellowLowerBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be less than 3 character."), "* PhoneNo can not be less than 3 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPhoneNoFieldLowerBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("911");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be less than 3 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPhoneNoFieldAboveUpperBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be greater than 30 character."), "* PhoneNo can not be greater than 30 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPhoneNoFieldUpperBoundary(){
		registerPage.phoneNoField.clear();
		registerPage.phoneNoField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be less than 3 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be greater than 30 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* PhoneNo can not be empty."), null);
	}
	
/////
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testEmailFieldIfAlreadyRegistered(){
		registerPage.emailField.clear();
		registerPage.emailField.sendKeys("shakil_ipe@yahoo.com");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* This Email is already registered."), "* This Email is already registered.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPasswordFieldBellowLowerBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("a");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be less than 6 character."), "* Password can not be less than 6 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPasswordFieldLowerBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("911654");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be less than 6 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be greater than 20 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPasswordFieldAboveUpperBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be greater than 20 character."), "* Password can not be greater than 20 character.");
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPasswordFieldUpperBoundary(){
		registerPage.passwordField.clear();
		registerPage.passwordField.sendKeys("anhgfdsaetyun mjhgfd");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be less than 6 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be greater than 20 character."), null);
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* Password can not be empty."), null);
	}
	
	@Test(dependsOnMethods = {"testEmptyFormSublission"})
	public void testPasswordAndConfirmPasswordFieldsIfDoNotMatch(){
		registerPage.passwordField.sendKeys("bbbbbbb");
		registerPage.confirmPasswordField.sendKeys("aaaaaaa");
		registerPage.submitButton.click();
		Assert.assertEquals(registerPage.getErrorMessageByValue(driver, "* ConfirmPassword did not match."), "* ConfirmPassword did not match.");
	}
	
	@Test(dependsOnMethods = {"testRegisterPageTitle"})
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
