package com.ontestautomation.selenium.ci;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner1 {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("Arg1: " + args[0]);

			// TestCasesMap map = new TestCasesMap();
			// TestCasesMap map = new TestCasesMap();
			// create salesforce domain object in java
			// attr: test_status, desc

			String value = args[0];

			try {
				if (value != null) {
					Result result = JUnitCore.runClasses(Class.forName(value));
					Document htmlFile = null;

					try {
						htmlFile = Jsoup
								.parse(new File(
										"/home/srikanth/.jenkins/workspace/SeliniumReports/report/html/all-tests.html"),
										"ISO-8859-1");
						System.out.println("loaded");
						ArrayList<HTMLTestCaseDO> list = new ArrayList<>();
						Element table = htmlFile.select("table").get(1); // select
																			// the
																			// first
																			// table.
						Elements rows = table.select("tr");

						for (int i = 1; i < rows.size(); i++) { // first row is the
																// col
																// names so skip it.
							Element row = rows.get(i);
							Elements cols = row.select("td");
							HTMLTestCaseDO htmlTestCaseDO = new HTMLTestCaseDO();
							System.out.println(cols.get(0).text());
							htmlTestCaseDO.setTestcasename(cols.get(0).text());
							htmlTestCaseDO.setStatus(cols.get(1).text());
							htmlTestCaseDO.setType(cols.get(2).text());
							htmlTestCaseDO.setTime(cols.get(3).text());
							list.add(htmlTestCaseDO);

						}
						System.out.println(list.toString());
						// htmlFile = Jsoup.parse(new
						// File("/var/lib/jenkins/jobs/TestFramework2/workspace/success.html"),
						// "ISO-8859-1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // right
					
					for (Failure failure : result.getFailures()) {
						// System.out.println(failure.toString());
						// prepare domain object;

						throw (new Exception(failure.toString()));
					}

					System.out.println(result.wasSuccessful());

				} else {

					throw (new Exception("Test case not Found"));
				}
			} catch (Exception e) {

				System.out.println("Ready to record error: " + e.getMessage());
			} finally {

				/*
				 * Document htmlFile = null; try {
				 * 
				 * htmlFile = Jsoup .parse(new File(
				 * "/home/srikanth/.jenkins/workspace/SeliniumReports/report/html/all-tests.html"
				 * ), "ISO-8859-1"); // htmlFile = Jsoup.parse(new // File(
				 * "/var/lib/jenkins/jobs/TestFramework2/workspace/success.html"
				 * ), // "ISO-8859-1"); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } // right
				 * ArrayList<HTMLTestCaseDO> list = new ArrayList<>(); Element
				 * table = htmlFile.select("table").get(1); // select the //
				 * first // table. Elements rows = table.select("tr");
				 * 
				 * for (int i = 1; i < rows.size(); i++) { // first row is the
				 * col // names so skip it. Element row = rows.get(i); Elements
				 * cols = row.select("td"); HTMLTestCaseDO htmlTestCaseDO = new
				 * HTMLTestCaseDO();
				 * htmlTestCaseDO.setTestcasename(cols.get(0).text());
				 * htmlTestCaseDO.setStatus(cols.get(1).text());
				 * htmlTestCaseDO.setType(cols.get(2).text());
				 * htmlTestCaseDO.setTime(cols.get(3).text());
				 * list.add(htmlTestCaseDO);
				 * 
				 * } System.out.println(list.toString());
				 */
			}

		}
	}
}