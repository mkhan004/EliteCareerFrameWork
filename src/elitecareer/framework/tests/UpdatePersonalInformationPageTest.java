package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

public class UpdatePersonalInformationPageTest extends TestBase{

	@Test(priority = 0)
	public void testEditPersonalInformationLink(){
		pageHeader.signInPageLink.click();
		signInPage.emailField.sendKeys("nurul@yahoo.com");
		signInPage.passwordField.sendKeys("365827");
		signInPage.submitButton.click();
		jobseekerProfilePage.editPersonalInformationLink.click();
		Assert.assertTrue(updatePersonalInformationPage.verifyCurrentUrlSuffix("edit_user.php"));
	}
	
	@Test(priority = 1)
	public void testPageTitle(){
		Assert.assertEquals(updatePersonalInformationPage.getPageTitle(), "Edit Personal Information | EliteCareer");
	}
	
	@Test(priority = 2)
	public void testUpdatePersonalInformationTitle(){
		Assert.assertEquals(updatePersonalInformationPage.updatePersonalInformationTitle.getText(), "Update Personal Information");
	}
	
	@Test(priority = 3)
	public void testFirstNameFieldBellowLowerBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("a");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), "* FirstName can not be less than 2 character.");
	}
	
	@Test(priority = 4)
	public void testFirstNameFieldLowerBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("as");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be empty."), null);
	}
	
	@Test(priority = 5)
	public void testFirstNameFieldAboveUpperBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), "* FirstName can not be greater than 30 character.");
	}
	
	@Test(priority = 6)
	public void testFirstNameFieldUpperBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* FirstName can not be empty."), null);
	}
	
	@Test(priority = 7)
	public void testLastNameFieldBellowLowerBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("a");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be less than 2 character."), "* LastName can not be less than 2 character.");
	}
	
	@Test(priority = 8)
	public void testLastNameFieldLowerBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("as");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be empty."), null);
	}
	
	@Test(priority = 9)
	public void testLastNameFieldAboveUpperBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), "* LastName can not be greater than 30 character.");
	}
	
	@Test(priority = 10)
	public void testLastNameFieldUpperBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* LastName can not be empty."), null);
	}
	
	@Test(priority = 11)
	public void testDateOfBirthFieldWithInvalidInput(){
		updatePersonalInformationPage.dateOfBirthField.clear();
		updatePersonalInformationPage.dateOfBirthField.sendKeys("1985-18-30");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* Invalid DateOfBirth"), "* Invalid DateOfBirth");
	}
	
	@Test(priority = 12)
	public void testDateOfBirthFieldWithValidInput(){
		updatePersonalInformationPage.dateOfBirthField.clear();
		updatePersonalInformationPage.dateOfBirthField.sendKeys("1985-12-30");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue("* Invalid DateOfBirth"), null);
	}
	
	@Test(priority = 13)
	public void testUpdateWithAllValidData(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.dateOfBirthField.clear();
		updatePersonalInformationPage.phoneNoField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("Shakil");
		updatePersonalInformationPage.lastNameField.sendKeys("Khan");
		updatePersonalInformationPage.selectFromDropdownList(registerPage.genderDropDownField, "Male");
		updatePersonalInformationPage.dateOfBirthField.sendKeys("1985-12-30");
		updatePersonalInformationPage.phoneNoField.sendKeys("347-754-9322");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
	}
}
