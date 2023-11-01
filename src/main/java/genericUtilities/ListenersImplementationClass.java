package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



/**this class provides implementation to itestlistners interface
 * @author Rajir
 *
 */
public class ListenersImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testscriptName=result.getMethod().getMethodName();
		System.out.println("===started===");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testscriptName=result.getMethod().getMethodName();
		System.out.println("===passed===");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testscriptName=result.getMethod().getMethodName();
		System.out.println("===Failed===");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testscriptName=result.getMethod().getMethodName();
		System.out.println("===test script execution Skipped===");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
