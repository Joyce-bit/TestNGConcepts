package org.screenshots;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClassForScreenshot extends BaseClassForScreenshot implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			System.out.println(result.getMethod().getMethodName());
			captureScreenShot(result.getMethod().getMethodName()+".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
