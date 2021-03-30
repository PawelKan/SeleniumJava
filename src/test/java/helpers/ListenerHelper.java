package helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerHelper implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerTool.logInfo("TEST START");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerTool.logInfo("TEST SUCCESS");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerTool.logInfo("TEST FAILURE");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
