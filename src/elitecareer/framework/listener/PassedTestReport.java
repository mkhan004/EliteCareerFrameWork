package elitecareer.framework.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class PassedTestReport implements ITestListener {

	@Override
	public void onStart(ITestContext arg0) {

		System.out.println("\nStart Of Execution(TEST)->" + arg0.getName());

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("\nTest Class: " + getTestClassName(arg0.getInstanceName()).trim());
		//System.out.println("Test Started: " + arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Pass: " + result.getName());
		long rl = result.getEndMillis() - result.getStartMillis();
		System.out.println("MiliSeconds: "+ rl);

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		System.out.println("Test Failed->" + arg0.getName());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		System.out.println("Test Skipped->" + arg0.getName());

	}

	@Override
	public void onFinish(ITestContext arg0) {

		System.out.println("END Of Execution(TEST)->" + arg0.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		// TODO Auto-generated method stub

	}
	
	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		//System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
}
