package com.fpx.test;

import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.fpx.report.MasterReport;
import org.testng.annotations.AfterSuite;

public class jsoncreator {

	@AfterSuite
	public void jsoncreate() throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		String jsonString = obj.writeValueAsString(MasterReport
				.getMasterReport());
		System.out.println(jsonString);
		FileWriter outputFile = new FileWriter(
				"D:\\Liquidation\\B2C\\Project Source\\FPX_Automation\\output.json");
		outputFile.write(jsonString);
		outputFile.close();
	}
}
