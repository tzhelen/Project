package Auto;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.base;

public class listeners implements ITestListener {

	base b = new base();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			
			b.getScreenshot(result.getName());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			
			b.getScreenshot(result.getName());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
		
		b.getScreenshot(result.getName());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			
			b.getScreenshot(result.getName());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			
			b.getScreenshot(result.getName());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
