package com.fpx.test;

import java.io.IOException;

import com.fpx.report.BasicTestReportElement;

import org.testng.Assert;
import org.testng.annotations.*;

import com.fpx.pages.DocumentPage;
import com.fpx.pages.LoginPage;
import com.fpx.pages.OpportunitiesPage;
import com.fpx.pages.ProductsPage;
import com.fpx.pages.QuotePage;
import com.fpx.report.MasterReport;
import com.fpx.report.TestReportModule;


import com.fpx.base.Base;

public class QuoteGeneration extends Base{
	TestReportModule testcaseReport =new TestReportModule();
	MasterReport moduleReport =new MasterReport();
	
	@BeforeSuite
	public void beforesetup()
	{
		testcaseReport.setInitialCount();
	}
	
	@BeforeClass
	public void browserAccess1()throws Exception
	{
		openBrowser();
		
	}
	
	@Test
	public void loginTOApplication() throws Exception
	{
		String starttime = getStartOfDay();
		try
		{
		LoginPage login=new LoginPage();
		login.loginToApplication();
		String endtime = getStartOfDay();
		testcaseReport.addPassCount();
		Assert.assertTrue(driver.getPageSource().contains("Opportunities"),"Login Failed");
		reporting("Login to CPQ onDemand","User is able to access CPQ onDemand", "PASS",starttime,endtime,"");
		}
		catch(IOException e)
		{
			String endtime=getStartOfDay();
			testcaseReport.addFailCount();
			takeSnapshot(currentDir+"\\Report\\HTMLResults"+fileCreation("login"),driver);
			reporting("Login to CPQ onDemand","Not able to access CPQ onDemand", "FAIL",starttime,endtime,currentDir+"\\Report\\HTMLResults"+fileCreation("loginfail"));
		}		
	}
	
	@Test(dependsOnMethods="loginTOApplication")
	public void opportunitySelection() throws Exception
	{
		String starttime = getStartOfDay();
		OpportunitiesPage opportunity = new OpportunitiesPage();
		opportunity.selectOpportunity();
		String endtime=getStartOfDay();
		testcaseReport.addPassCount();
		reporting("Opportunity Selection","Searching Opportunity in CPQ onDemand", "PASS",starttime,endtime,"");
	}
	
	@Test(dependsOnMethods="opportunitySelection")
	public void newQuoteCreation() throws Exception
	{
		String starttime = getStartOfDay();
		QuotePage quote = new QuotePage();
		quote.newQuoteCreation();
		String endtime=getStartOfDay();
		testcaseReport.addPassCount();
		reporting("New Quote Creation","Quote created successfully in CPQ onDemand", "PASS",starttime,endtime,"");
	}
	
	@Test(dependsOnMethods="newQuoteCreation")
	public void productSelection() throws Exception
	{
		String starttime = getStartOfDay();
		ProductsPage products = new ProductsPage();
		products.productSelection();
		String endtime=getStartOfDay();
		testcaseReport.addPassCount();
		reporting("New Product Creation","Product created successfully in CPQ onDemand", "PASS",starttime,endtime,"");
	}
	
	@Test(dependsOnMethods="productSelection")
	public void documentGeneration() throws Exception
	{
		String starttime = getStartOfDay();
		DocumentPage documentGenerate = new DocumentPage();
		documentGenerate.documentGeneration();
		String endtime=getStartOfDay();
		testcaseReport.addPassCount();
		reporting("Proposal Creation","Proposal created successfully in CPQ onDemand", "PASS",starttime,endtime,"");
	}
	
	
	@AfterMethod
	public void totalTestcase()throws Exception
	{
	testcaseReport.addTotalTestCaseCount();	
	
	}
	
	@AfterClass
	public void browserClose()
	{
		testcaseReport.addIndex();		
	}
	
	@AfterTest
	public void afterExecution()
	{		
		testcaseReport.setModulename("Propect Quote");
		testcaseReport.setModuledescription("Smoke level testing to Generate the Quote");
		MasterReport.Totaltestcase+=testcaseReport.getTotaltestcase();
		MasterReport.totalpass+=testcaseReport.getTotalpass();
		MasterReport.totalfail+=testcaseReport.getTotalfail();
		MasterReport.getMasterReport().getModules().add(testcaseReport);
		System.out.println("Total Testcases "+MasterReport.Totaltestcase);
		System.out.println("Pass Cases "+MasterReport.totalpass);
		System.out.println("Fail Cases "+MasterReport.totalfail);
		driver.quit();
	}
	
	
	
	public void reporting(String name, String description, String status, String starttime, String endtime, String snapshot) throws Exception
	{
		BasicTestReportElement basicReport=new BasicTestReportElement();
		basicReport.setName(name);
		basicReport.setDescription(description);
		basicReport.setStatus(status);
		basicReport.setStarttime(starttime);
		basicReport.setEndtime(endtime);
		basicReport.setSnapshot(snapshot);
		testcaseReport.getTestElements().add(basicReport);
	}
}
