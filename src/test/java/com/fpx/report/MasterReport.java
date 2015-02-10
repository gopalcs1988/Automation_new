package com.fpx.report;

import java.util.ArrayList;
import java.util.List;

public class MasterReport {
	private static MasterReport fullReport = null;
	public static int Totaltestcase;
	public static int totalpass;
	public static int totalfail;
	
	/**
	 * @return the totaltestcase
	 */
	public int getTotaltestcase() {
		return Totaltestcase;
	}

	/**
	 * @param totaltestcase the totaltestcase to set
	 */
	public void setTotaltestcase(int totaltestcase) {
		this.Totaltestcase = totaltestcase;
	}

	/**
	 * @return the totalpass
	 */
	public int getTotalpass() {
		return totalpass;
	}

	/**
	 * @param totalpass the totalpass to set
	 */
	public void setTotalpass(int totalpass) {
		this.totalpass = totalpass;
	}

	/**
	 * @return the totalfail
	 */
	public int getTotalfail() {
		return totalfail;
	}

	/**
	 * @param totalfail the totalfail to set
	 */
	public void setTotalfail(int totalfail) {
		this.totalfail = totalfail;
	}
	private List<TestReportModule> modules =  new ArrayList<TestReportModule>();

	public static MasterReport getMasterReport(){
		if(fullReport == null){
			fullReport = new MasterReport();
		}
		return fullReport;
	}

	/**
	 * @return the modules
	 */
	public List<TestReportModule> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(List<TestReportModule> modules) {
		this.modules = modules;
	}
	
	
	public void setInitialCount()
	{
		this.setTotalfail(0);
		this.setTotalpass(0);
		this.setTotaltestcase(0);
	}
	
	public void addPassCount()
	{
		this.setTotalpass(this.getTotalpass()+1);
	}
	
	public void addFailCount()
	{
		this.setTotalfail(this.getTotalfail()+1);
	}
	
	public void addTotalTestCaseCount()
	{
		this.setTotaltestcase(this.getTotalfail()+this.getTotalpass());
	}
}
