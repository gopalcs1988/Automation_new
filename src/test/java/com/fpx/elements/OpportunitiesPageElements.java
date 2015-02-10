package com.fpx.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fpx.base.Base;

public class OpportunitiesPageElements extends Base{
	
	public String List_xpath=".//*[@id='menuContent']/h4[2]/a[text()='List']";
	public String SearchTextBox_classname=".opportunitySearchBox.form-control.ng-pristine.ng-valid";
	public String SearchButton_classname=".btn.btn-primary";
	public String SelectOpportunity_xpath="html/body/div[2]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td/fpx-action-cell/span[1]/span";
}
