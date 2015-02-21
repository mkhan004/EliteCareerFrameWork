package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;


public class JobseekerProfilePageTest extends TestBase{

	@BeforeTest
	public void signInWithCorrectCredentials(){
		pageHeader.signInPageLink.click();
		signInPage.emailField.clear();
		signInPage.passwordField.clear();
		signInPage.emailField.sendKeys("nurul@yahoo.com");
		signInPage.passwordField.sendKeys("365827");
		signInPage.submitButton.click();
	}
	
	@Test
	public void testJobseekerProfileTitle(){
		//pageHeader.profileLink.click();
		Assert.assertEquals(jobseekerProfilePage.profileTitle.getText(), "Career Profile");
	}
	
	@Test
	public void testProfilePageLink(){
		Assert.assertTrue(jobseekerProfilePage.verifyCurrentUrlSuffix(driver, "profile.php"));
	}
	
	@Test
	public void testProfileMenuTitle(){
		Assert.assertEquals(jobseekerProfileMenu.profileMenuTitle.getText(), "Profile Menu");
	}
	
}
