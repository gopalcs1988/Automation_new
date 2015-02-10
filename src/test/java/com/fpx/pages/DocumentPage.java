package com.fpx.pages;

import com.fpx.elements.DocumentsPageElements;

public class DocumentPage extends DocumentsPageElements {
	
	public void documentGeneration()throws Exception
	{
		DocumentsPageElements DocPgEle= new DocumentsPageElements();
		findByXpath(DocPgEle.DocumentsButton).click();
		findByCssSelector(DocPgEle.NewDocumentButton).click();
		Thread.sleep(10000);
		findByXpath(DocPgEle.SaveButton).click();
		findByXpath(DocPgEle.ViewPrintable).click();
		
	}

}
