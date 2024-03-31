package org.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Listening - Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Listening - Test executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Listening - Test got failure");	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Listening - Test is skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Listening - Test got failed with timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listening - Before the test get started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Listening - Test is finished");
	}

}