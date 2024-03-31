package org.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunnerClass implements IRetryAnalyzer{

	public static int min = 0;
	public static int max = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		if(min<max) {
			min++;
			return true;
		}
		
		return false;
	}

}
