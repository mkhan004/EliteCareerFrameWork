package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

public class UpdatePersonalInformationPageTest extends TestBase{

	@BeforeTest
	public void signInWithCorrectCredentials(){
		pageHeader.signInPageLink.click();
		signInPage.emailField.clear();
		signInPage.passwordField.clear();
		signInPage.emailField.sendKeys("nurul@yahoo.com");
		signInPage.passwordField.sendKeys("365827");
		signInPage.submitButton.click();
		jobseekerProfilePage.editPersonalInformationLink.click();
	}
	
	@Test
	public void testEditPersonalInformationLink(){
		Assert.assertTrue(updatePersonalInformationPage.verifyCurrentUrlSuffix(driver, "edit_user.php"));
	}
	
	@Test
	public void testPageTitle(){
		Assert.assertEquals(updatePersonalInformationPage.getPageTitle(driver), "Edit Personal Information | EliteCareer");
	}
	
	@Test
	public void testUpdatePersonalInformationTitle(){
		Assert.assertEquals(updatePersonalInformationPage.updatePersonalInformationTitle.getText(), "Update Personal Information");
	}
	
	@Test
	public void testFirstNameFieldBellowLowerBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("a");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), "* FirstName can not be less than 2 character.");
	}
	
	@Test
	public void testFirstNameFieldLowerBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("as");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be empty."), null);
	}
	
	@Test
	public void testFirstNameFieldAboveUpperBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		registerPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), "* FirstName can not be greater than 30 character.");
	}
	
	@Test
	public void testFirstNameFieldUpperBoundary(){
		updatePersonalInformationPage.firstNameField.clear();
		updatePersonalInformationPage.firstNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* FirstName can not be empty."), null);
	}
	
	@Test
	public void testLastNameFieldBellowLowerBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("a");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), "* LastName can not be less than 2 character.");
	}
	
	@Test
	public void testLastNameFieldLowerBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("as");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be empty."), null);
	}
	
	@Test
	public void testLastNameFieldAboveUpperBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bhgfts");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), "* LastName can not be greater than 30 character.");
	}
	
	@Test
	public void testLastNameFieldUpperBoundary(){
		updatePersonalInformationPage.lastNameField.clear();
		updatePersonalInformationPage.lastNameField.sendKeys("anhgfdsaetyun mjhgfds nbvfg bh");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be less than 2 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be greater than 30 character."), null);
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* LastName can not be empty."), null);
	}
	
	@Test
	public void testDateOfBirthFieldWithInvalidInput(){
		updatePersonalInformationPage.dateOfBirthField.clear();
		updatePersonalInformationPage.dateOfBirthField.sendKeys("1985-18-30");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* Invalid DateOfBirth"), "* Invalid DateOfBirth");
	}
	
	@Test
	public void testDateOfBirthFieldWithValidInput(){
		updatePersonalInformationPage.dateOfBirthField.clear();
		updatePersonalInformationPage.dateOfBirthField.sendKeys("1985-12-30");
		updatePersonalInformationPage.submitButton.click();
		Assert.assertEquals(updatePersonalInformationPage.updateConfirmation.getText(), "Update is Successful!");
		Assert.assertEquals(updatePersonalInformationPage.getErrorMessageByValue(driver, "* Invalid DateOfBirth"), null);
	}
	
	@Test(dependsOnMethods = {"testFirstNameFieldLowerBoundary", "testFirstNameFieldUpperBoundary", "testLastNameFieldLowerBoundary", "testLastNameFieldUpperBoundary"})
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
