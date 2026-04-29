package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports reports;

    public static ExtentReports getInstnce(){

        if (reports == null){
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

            File dir = new File(System.getProperty("user.dir") + "/reports");
            if (!dir.exists()) dir.mkdirs();
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Result");

            reports = new ExtentReports();
            reports.attachReporter(reporter);

            reports.setSystemInfo("Tester", "Yogi Reddy");
            reports.setSystemInfo("Environment", "QA");

        }
        return reports;
    }
}
