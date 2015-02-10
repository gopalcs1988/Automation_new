package com.fpx.report;

import java.util.ArrayList;
import java.util.List;

public class TestReportModule {
		
	private List<BasicTestReportElement> testElements = new ArrayList<BasicTestReportElement>() ;
	private String modulename;
	private String moduledescription;
	private int index;
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the moduledescription
	 */
	public String getModuledescription() {
		return moduledescription;
	}

	/**
	 * @param moduledescription the moduledescription to set
	 */
	public void setModuledescription(String moduledescription) {
		this.moduledescription = moduledescription;
	}

	private int Totaltestcase;
	private int totalpass;
	private int totalfail;
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

	/**
	 * @return the testElements
	 */
	public List<BasicTestReportElement> getTestElements() {
		return testElements;
	}
	
	public void setTestElements(List<BasicTestReportElement> testElements) {
		this.testElements = testElements;
	}

	/**
	 * @return the modulename
	 */
	public String getModulename() {
		return modulename;
	}

	/**
	 * @param modulename the modulename to set
	 */
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	
	public void setInitialCount()
	{
		this.setTotalfail(0);
		this.setTotalpass(0);
		this.setTotaltestcase(0);
		this.setIndex(-1);
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
	
	public void addIndex()
	{
		this.setIndex(this.getIndex()+1);
	}
}
