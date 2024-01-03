package org.example;

import org.perf4j.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class TestExecutionListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestExecutionListener.class);
    private StopWatch stopWatch = new StopWatch();

    @Override
    public void onTestStart(ITestResult testResult) {
        String methodName = testResult.getMethod().getMethodName();
        stopWatch.start();
        logger.info("------------------------------------------------------");
        logger.info("Test: {} START on {}", methodName, new Date(stopWatch.getStartTime()));
        logger.info("------------------------------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        stopWatch.stop();
        String methodName = result.getMethod().getMethodName();
        logger.info("------------------------------------------------------");
        logger.info("Test: {} FINISH, EXECUTION TIME {} sec ", methodName, stopWatch.getElapsedTime() / 1000.);
        logger.info("------------------------------------------------------");
    }
    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
