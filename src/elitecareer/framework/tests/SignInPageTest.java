package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;
import elitecareer.framework.dataprovider.TestDataProvider;

@Listeners(elitecareer.framework.listener.JyperionListener.class)
public class SignInPageTest extends TestBase{

	
	@Test(priority = 0)
	public void testSignInPageTitle(){
		pageHeader.signInPageLink.click();
		Assert.assertEquals(signInPage.getPageTitle(), "SignIn | EliteCareer");
	}
	
	@Test(priority = 1)
	public void testSignInPageUrl(){
		Assert.assertTrue(registerPage.verifyCurrentUrlSuffix("signin.php"));
	}
	
	@Test(priority = 2)
	public void testSignInTitle(){
		Assert.assertEquals(signInPage.signInTitle.getText(), "SignIn");
	}
	
	@Test(priority = 3)
	public void testSignInWithEmptyCredentials(){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys("");
		signInPage.passwordField.sendKeys("");
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Email can not be empty."), "* Email can not be empty.");
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Password can not be empty."), "* Password can not be empty.");
	}
	
	@Test(priority = 4, dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testEmailFieldWithWrongEmail(String email, String password){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Email or Password is incorrect."), "* Email or Password is incorrect.");
	}
	
	@Test(priority = 5, dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testEmailFieldWithEmptyEmail(String password){
		signInPage.emailField.clear();
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Email can not be empty."), "* Email can not be empty.");
	}
	
	@Test(priority = 6, dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testPasswordFieldWithWrongPassword(String email, String password){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Email or Password is incorrect."), "* Email or Password is incorrect.");
	}
	
	@Test(priority = 7, dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testPasswordFieldWithEmptyPassword(String email){
		signInPage.emailField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.clear();
		signInPage.submitButton.click();
		Assert.assertEquals(signInPage.getErrorMessageByValue("* Password can not be empty."), "* Password can not be empty.");
	}
	
	@Test(priority = 8, groups="Regression",
			dataProvider = "signInPageDataProvider", dataProviderClass = TestDataProvider.class)
	public void testSignInWithCorrectCredentials(String email, String password){
		signInPage.emailField.clear();
		signInPage.passwordField.clear();
		signInPage.emailField.sendKeys(email);
		signInPage.passwordField.sendKeys(password);
		signInPage.submitButton.click();
		Assert.assertTrue(signInPage.verifyCurrentUrlSuffix("profile.php"));
		pageHeader.logOutLink.click();
		pageHeader.signInPageLink.click();
	}
}
