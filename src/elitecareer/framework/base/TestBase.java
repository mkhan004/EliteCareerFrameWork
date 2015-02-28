package elitecareer.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import elitecareer.framework.pages.HomePage;
import elitecareer.framework.pages.JobseekerProfileMenu;
import elitecareer.framework.pages.JobseekerProfilePage;
import elitecareer.framework.pages.PageHeader;
import elitecareer.framework.pages.RegisterPage;
import elitecareer.framework.pages.SignInPage;
import elitecareer.framework.pages.UpdatePersonalInformationPage;

public class TestBase {
	public static WebDriver driver;
	static String driverPath = "/Users/shakilkhan/Documents/workspace/Selenium/";
	protected HomePage homePage;
	protected PageHeader pageHeader;
	protected SignInPage signInPage;
	protected RegisterPage registerPage;
	protected JobseekerProfilePage jobseekerProfilePage;
	protected JobseekerProfileMenu jobseekerProfileMenu;
	protected UpdatePersonalInformationPage updatePersonalInformationPage;

	public static WebDriver getDriver() {
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass(alwaysRun = true)
	public void setUp(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
		
		//driver = new FirefoxDriver();
		// driver.get("http://localhost:8788/elitecareer/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

		homePage = PageFactory.initElements(driver, HomePage.class);
		pageHeader = PageFactory.initElements(driver, PageHeader.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		jobseekerProfilePage = PageFactory.initElements(driver,
				JobseekerProfilePage.class);
		jobseekerProfileMenu = PageFactory.initElements(driver,
				JobseekerProfileMenu.class);
		updatePersonalInformationPage = PageFactory.initElements(driver,
				UpdatePersonalInformationPage.class);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	public static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
}
