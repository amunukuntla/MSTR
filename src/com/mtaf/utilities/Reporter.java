package com.mtaf.utilities;

import com.mtaf.accelerators.ActionEngine;
import com.mtaf.accelerators.TestEngine;
import com.mtaf.support.ConfiguratorSupport;
import com.mtaf.support.HtmlReportSupport;
import com.mtaf.support.ReportStampSupport;

public class Reporter extends TestEngine {
	public static ConfiguratorSupport configProps = new ConfiguratorSupport(
			"config.properties");
	static String timeStamp = ReportStampSupport.timeStamp().replace(":", "_")
			.replace(".", "_");

	public static void reportCreater() throws Throwable {
		int intReporterType = Integer.parseInt(configProps
				.getProperty("reportsType"));

		switch (intReporterType) {
		case 1:

			break;
		case 2:

			HtmlReportSupport.htmlCreateReport();
			HtmlReportSupport.createDetailedReport();

			break;
		default:

			HtmlReportSupport.htmlCreateReport();
			break;
		}
	}

	public static void SuccessReport(String strStepName, String strStepDes)
			throws Throwable {
		int intReporterType = Integer.parseInt(configProps
				.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:

			break;
		case 2:
			if (configProps.getProperty("OnSuccessScreenshot")
					.equalsIgnoreCase("True")) {
				ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
						+ strStepDes.replace(" ", "_") + "_"
						+ TestEngine.timeStamp + ".jpeg");
			}
			HtmlReportSupport.onSuccess(strStepName, strStepDes);

			break;

		default:
			if (configProps.getProperty("OnSuccessScreenshot")
					.equalsIgnoreCase("True")) {
				ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
						+ strStepDes.replace(" ", "_") + "_"
						+ TestEngine.timeStamp + ".jpeg");
			}
			HtmlReportSupport.onSuccess(strStepName, strStepDes);
			break;
		}
	}

	public static void failureReport(String strStepName, String strStepDes)
			throws Throwable {
		int intReporterType = Integer.parseInt(configProps
				.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag = true;
			break;
		case 2:
			ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
					+ strStepDes.replace(" ", "_") + "_"
					+ TestEngine.timeStamp + ".jpeg");
			flag = true;
			HtmlReportSupport.onFailure(strStepName, strStepDes);
			break;

		default:
			flag = true;
			ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
					+ strStepDes.replace(" ", "_") + "_" + TestEngine.timeStamp
					+ ".jpeg");
			HtmlReportSupport.onFailure(strStepName, strStepDes);
			break;
		}

	}
	public static void warningReport(String strStepName, String strStepDes)
			throws Throwable {
		int intReporterType = Integer.parseInt(configProps
				.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag = true;
			break;
		case 2:
			ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
					+ strStepDes.replace(" ", "_") + "_"
					+ TestEngine.timeStamp + ".jpeg");
			flag = true;
			HtmlReportSupport.onWarning(strStepName, strStepDes);
			break;

		default:
			flag = true;
			ActionEngine.screenShot(TestEngine.filePath()+"\\Screenshots\\"
					+ strStepDes.replace(" ", "_") + "_" + TestEngine.timeStamp
					+ ".jpeg");
			HtmlReportSupport.onWarning(strStepName, strStepDes);
			break;
		}

	}
}
