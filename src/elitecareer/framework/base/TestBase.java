package elitecareer.framework.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
	
	//After complete execution send pdf report by email
	@AfterSuite
	public void sendMail(){
		sendPDFReportByGMail("banglaoutfitters@gmail.com", "01818365827", "nyseekers@gmail.com", "PDF Report", "");
	}
	
	private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
        	//Set from address
            message.setFrom(new InternetAddress(from));
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           //Set subject
            message.setSubject(subject);
            message.setText(body);
          
            BodyPart objMessageBodyPart = new MimeBodyPart();
            
            objMessageBodyPart.setText("Please Find The Attached Report File!");
            
            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(objMessageBodyPart);

            objMessageBodyPart = new MimeBodyPart();

            //Set path to the pdf report file
            String filename = System.getProperty("user.dir")+"/Default test.pdf"; 
            //Create data source to attach the file in mail
            DataSource source = new FileDataSource(filename);
            
            objMessageBodyPart.setDataHandler(new DataHandler(source));

            objMessageBodyPart.setFileName(filename);

            multipart.addBodyPart(objMessageBodyPart);

            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
