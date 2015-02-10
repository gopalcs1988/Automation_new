package com.fpx.pages;

import org.openqa.selenium.By;

import com.fpx.elements.OpportunitiesPageElements;

public class OpportunitiesPage extends OpportunitiesPageElements{
	
	public void selectOpportunity()throws Exception
	{
		OpportunitiesPageElements OppPgEle = new OpportunitiesPageElements();
		findByXpath(OppPgEle.List_xpath).click();
		appExplictWaitByClassName(".opportunitySearchBox.form-control.ng-pristine.ng-valid");
		findByCssSelector(".opportunitySearchBox.form-control.ng-pristine.ng-valid").sendKeys("Bank of America/Takeda/DE");
		findByCssSelector(".btn.btn-primary").click();
		Wait();
		findByXpath(OppPgEle.SelectOpportunity_xpath).click();
		Wait();
	}
}
