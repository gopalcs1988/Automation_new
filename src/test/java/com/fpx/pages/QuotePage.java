package com.fpx.pages;
import com.fpx.elements.QuotePageElements;

public class QuotePage extends QuotePageElements
{
	public void newQuoteCreation()
	{
		QuotePageElements qtePgEle = new QuotePageElements();
		findByXpath(qtePgEle.QuotesButton).click();
		Wait();
		findByXpath(qtePgEle.NewQuoteButton).click();
		appExplictWaitByClassName(qtePgEle.QuoteName);
		findByCssSelector(qtePgEle.QuoteName).sendKeys("Testing_quote1212");
		findByXpath(qtePgEle.SaveButton).click();
		Wait();
	}
}