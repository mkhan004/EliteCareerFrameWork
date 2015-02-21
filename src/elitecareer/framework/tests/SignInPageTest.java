package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;
import elitecareer.framework.dataprovider.TestDataProvider;

public class SignInPageTest extends TestBase{

	@Test
	public void testSignInPageTitle(){
		pageHeader.signInPageLink.click();
		Assert.assertEquals(signInPage.getPageTitle(driver), "SignIn | EliteCareer");
	}
	
	@Test
	public void testSignInPageUrl(){
		Assert.assertTrue(registerPage.verifyCurrentUrlSuffix(driver, "signin.php"));
	}
	
	@Test
	public void testSignInTitle(){
		Assert.assertEquals(signInPage.signInTitle.getText(), "SignIn");
	}
	
	@Test(dependsOnMethods = "testSignInPageTitle")
	public void testSignInWithEmptyCredentials(){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys("");
		signInPage.passwordField.sendKeys("");
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Email can not be empty."), "* Email can not be empty.");
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Password can not be empty."), "* Password can not be empty.");
	}
	
	@Test(dependsOnMethods = "testSignInPageTitle", dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testEmailFieldWithWrongEmail(String email, String password){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Email or Password is incorrect."), "* Email or Password is incorrect.");
	}
	
	@Test(dependsOnMethods = "testSignInPageTitle", dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testEmailFieldWithEmptyEmail(String password){
		signInPage.emailField.clear();
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Email can not be empty."), "* Email can not be empty.");
	}
	
	@Test(dependsOnMethods = "testSignInPageTitle", dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testPasswordFieldWithWrongPassword(String email, String password){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Email or Password is incorrect."), "* Email or Password is incorrect.");
	}
	
	@Test(dependsOnMethods = "testSignInPageTitle", dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testPasswordFieldWithEmptyPassword(String email){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.clear();
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue(driver, "* Password can not be empty."), "* Password can not be empty.");
	}
	
	@Test(dependsOnMethods = {"testSignInWithEmptyCredentials"},
			dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testSignInWithCorrectCredentials(String email, String password){
		signInPage.emailField.clear();
		signInPage.passwordField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertTrue(signInPage.verifyCurrentUrlSuffix(driver, "profile.php"));
		pageHeader.logOutLink.click();
		pageHeader.signInPageLink.click();
	}
}
