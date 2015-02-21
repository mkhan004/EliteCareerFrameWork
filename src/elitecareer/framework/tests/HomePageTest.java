package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

public class HomePageTest extends TestBase{

	@Test
	public void testHomePageTitle(){
		Assert.assertEquals(homePage.getPageTitle(driver), "Job Search, Employment and Careers | EliteCareer");
	}
	
	@Test
	public void testHomePageUrl(){
		Assert.assertTrue(registerPage.verifyCurrentUrlSuffix(driver, "index.php"));
	}
	
	@Test
	public void testJobSearchTitle(){
		Assert.assertEquals(homePage.jobSearchTitle.getText(), "Job Search");
	}
	
	@Test
	public void testNewJobsTitle(){
		Assert.assertEquals(homePage.newJobsTitle.getText(), "New Jobs");
	}
	
	@Test
	public void testLinkedInPageTitle(){
		Assert.assertEquals(homePage.getElementByName(driver, "LinkedIn Profile"), "LinkedIn Profile");
	}
	
	@Test
	public void testFacebookPageTitle(){
		Assert.assertEquals(homePage.getElementByName(driver, "Facebook Page"), "Facebook Page");
	}
}
