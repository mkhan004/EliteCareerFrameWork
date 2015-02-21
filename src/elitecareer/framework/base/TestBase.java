package elitecareer.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import elitecareer.framework.pages.HomePage;
import elitecareer.framework.pages.JobseekerProfileMenu;
import elitecareer.framework.pages.JobseekerProfilePage;
import elitecareer.framework.pages.PageHeader;
import elitecareer.framework.pages.RegisterPage;
import elitecareer.framework.pages.SignInPage;
import elitecareer.framework.pages.UpdatePersonalInformationPage;

public class TestBase {
	protected WebDriver driver;
	protected HomePage homePage;
	protected PageHeader pageHeader;
	protected SignInPage signInPage;
	protected RegisterPage registerPage;
	protected JobseekerProfilePage jobseekerProfilePage;
	protected JobseekerProfileMenu jobseekerProfileMenu;
	protected UpdatePersonalInformationPage updatePersonalInformationPage;

	@BeforeSuite(alwaysRun = true)
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://localhost:8788/elitecareer/index.php");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		pageHeader = PageFactory.initElements(driver, PageHeader.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		jobseekerProfilePage = PageFactory.initElements(driver, JobseekerProfilePage.class);
		jobseekerProfileMenu = PageFactory.initElements(driver, JobseekerProfileMenu.class);
		updatePersonalInformationPage = PageFactory.initElements(driver, UpdatePersonalInformationPage.class);
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}
