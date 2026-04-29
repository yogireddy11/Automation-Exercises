package listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverFactory;
import utilities.ExtentManager;

public class TestListeners implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstnce();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ✅");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        String path = Screenshot.takeScreenshot(
                DriverFactory.intiBrowser(),
                result.getMethod().getMethodName()
        );

        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped ⚠️");

    }

    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }
}
