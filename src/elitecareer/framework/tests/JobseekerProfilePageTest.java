package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;


public class JobseekerProfilePageTest extends TestBase{
	
	@Test(priority = 0)
	public void testJobseekerProfileTitle(){
		pageHeader.signInPageLink.click();
		signInPage.emailField.sendKeys("nurul@yahoo.com");
		signInPage.passwordField.sendKeys("365827");
		signInPage.submitButton.click();
		Assert.assertEquals(jobseekerProfilePage.profileTitle.getText(), "Career Profile");
	}
	
	@Test(priority = 1)
	public void testProfilePageLink(){
		Assert.assertTrue(jobseekerProfilePage.verifyCurrentUrlSuffix("profile.php"));
	}
	
	@Test(priority = 3)
	public void testProfileMenuTitle(){
		Assert.assertEquals(jobseekerProfileMenu.profileMenuTitle.getText(), "Profile Menu");
	}
	
}
