package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenerImplementation implements ITestListener {

	ExtentReports er;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Start");
		// for extent report
		extentTest = er.createTest(methodname);
		// extentTest.log(Status.PASS, "Test case passed");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Success");
		extentTest.log(Status.PASS, "Test case passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Failed");
		webDriverUtility wUtility = new webDriverUtility();
		javaUtility jUtil = new javaUtility();
		String sreenshotname = methodname + "-" + jUtil.toGetSystemDateAndTime();
		try {
			// for extent report wee need absoulte path from webdriver utility method and
			// store it here
			String path = wUtility.toTakescreenShot(BaseClass.sDriver, sreenshotname);
			extentTest.addScreenCaptureFromPath(path);
			extentTest.log(Status.FAIL, "Test case failed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Suite execution started---");
		// for extent report
		ExtentSparkReporter esp = new ExtentSparkReporter(
				".//Extentreport//Report-" + new javaUtility().toGetSystemDateAndTime() + ".html");
		esp.config().setDocumentTitle("VTIGER EXECUTION REPORT");
		esp.config().setTheme(Theme.DARK);
		esp.config().setReportName("VTIGER REPORTS");

		er = new ExtentReports();
		er.attachReporter(esp);
		er.setSystemInfo("BaseUrl", "https://localhost:8888/");
		er.setSystemInfo("BaseBrowser", "Chrome");
		er.setSystemInfo("Reporter name", "Shravan Shetty");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Suite execution Completed---");
		er.flush();
	}

}
