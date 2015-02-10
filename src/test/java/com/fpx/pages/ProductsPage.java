package com.fpx.pages;

import com.fpx.elements.ProductsPageElements;

public class ProductsPage extends ProductsPageElements{
	
	public void productSelection() throws Exception
	{
		ProductsPageElements ProductPg=new ProductsPageElements();
		findByXpath(ProductPg.ProductsButton).click();
		Thread.sleep(20000);
		findByXpath(ProductPg.newProduct).click();
		appExplictWaitByXpath(ProductPg.selectGroup);
		findByXpath(ProductPg.selectGroup).click();
		appExplictWaitByXpath(ProductPg.selectNumber);
		findByXpath(ProductPg.selectNumber).sendKeys("1");
		findByXpath(ProductPg.SaveandExit).click();
	}
}
