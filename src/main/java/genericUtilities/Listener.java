package genericUtilities;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * this class provides implementation to ITestListener interface of testNG
 * @author Chaitra M
 *
 */
public class Listener implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== test script execution started ====");
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Passed ====");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//ScreenShot
		//Exception for failure
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Failed ====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName + new JavaUtility().getSystemDate();
		
		WebDriverUtility w = new WebDriverUtility();
		
		try {
			w.captureScreenShot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Skipped ====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("==== Suite Execution Started ====");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("==== Suite Execution Finished ====");
		
	}
	
	

	
}

