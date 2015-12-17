package com.ontestautomation.selenium.ci;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class TestRunner {
	@Test
	public void test() {

		
		 Document htmlFile = null;
	        try {
	            htmlFile = Jsoup.parse(new File("/var/lib/jenkins/jobs/TestFramework2/workspace/report/html/all-tests.html"), "ISO-8859-1");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } // right
	        ArrayList<HTMLTestCaseDO> list = new ArrayList<>();
	        Element table = htmlFile.select("table").get(1); //select the first table.
	        Elements rows = table.select("tr");

	        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
	            Element row = rows.get(i);
	            Elements cols = row.select("td");
	            HTMLTestCaseDO htmlTestCaseDO=new HTMLTestCaseDO();
	            htmlTestCaseDO.setTestcasename(cols.get(0).text());
	            htmlTestCaseDO.setStatus(cols.get(1).text());
	            htmlTestCaseDO.setType(cols.get(2).text());
	            htmlTestCaseDO.setTime(cols.get(3).text());
	            list.add(htmlTestCaseDO);

	          
	        }
	        System.out.println(list.toString());
	
		
		
		
	

	}

}
