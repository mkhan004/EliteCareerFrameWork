package elitecareer.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elitecareer.framework.base.TestBase;

//@Listeners(value={elitecareer.framework.listener.TestReporter.class, elitecareer.framework.listener.PassedTestReport.class})
@Listeners(elitecareer.framework.listener.JyperionListener.class)
public class HomePageTest extends TestBase{
	
	@Test(priority = 0)
	public void testHomePageTitle(){
		Assert.assertEquals(homePage.getPageTitle(), "Job Search, Employment and Careers | EliteCareer");
	}
	
	@Test(priority = 1)
	public void testHomePageUrl(){
		Assert.assertTrue(homePage.verifyCurrentUrlSuffix("index.php"));
	}
	
	@Test(priority = 2)
	public void testJobSearchTitle(){
		Assert.assertEquals(homePage.jobSearchTitle.getText(), "Job Searchs");
	}
	
	@Test(priority = 3)
	public void testNewJobsTitle(){
		Assert.assertEquals(homePage.newJobsTitle.getText(), "New Jobs");
	}
	
	@Test(priority = 4)
	public void testLinkedInPageTitle(){
		Assert.assertEquals(homePage.getElementByName("LinkedIn Profile"), "LinkedIn Profile");
	}
	
	@Test(priority = 5, groups="Regression")
	public void testFacebookPageTitle(){
		Assert.assertEquals(homePage.getElementByName("Facebook Page"), "Facebook Pagee");
		
	}
}
