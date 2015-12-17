package com.ontestautomation.selenium.ci;

public class HTMLTestCaseDO {

	private String testcasename;
	private String status;
	private String type;
	private String time;

	public String getTestcasename() {
		return testcasename;
	}

	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String times) {
		this.time = times;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HtmlTestCase:: testcasename :"+this.testcasename + " " +"status :"+this.status+" "+"Type :"+this.type+" "+"Time :"+this.time;
	}

}
