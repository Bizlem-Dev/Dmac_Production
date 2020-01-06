package com.action;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DocumentTemplate {
	
	public String sampleInvoice(String firstname,String lastname,String invoicenumber,String date) {
		//System.out.println("1");
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		System.out.println("2  "+System.getProperty("java.class.path"));
		String string = "";
		try {
			//Load template from source folder
			cfg.setDirectoryForTemplateLoading(new File("C:/Users/user/eclipse-workspace/CRM_SR_NEW/src"));
			Template template = cfg.getTemplate("helloworld.ftl");
			
			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("invoiceno", "32");
			data.put("date", "30/09/2017");
			data.put("firstname", "Vivek");
			data.put("lastname", "Kumar");

			//List parsing 
//			List<String> countries = new ArrayList<String>();
//			countries.add("India");
//			countries.add("United States");
//			countries.add("Germany");
//			countries.add("France");
//			
//			data.put("countries", countries);
			
			
			// Console output
//			Writer out = new OutputStreamWriter(System.out);
//			template.process(data, out);
//			//out.write("sv");
//			out.flush();

			// write the freemarker output to a StringWriter 
			StringWriter stringWriter = new StringWriter();
			template.process(data, stringWriter);

			// get the String from the StringWriter
			 string = stringWriter.toString();
			System.out.print(string);
			// File output
			Writer file = new FileWriter (new File("D:\\FTL_helloworld.doc"));
			template.process(data, file);
			file.flush();
			file.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error "+e.getMessage();
		}

		return "D:\\FTL_helloworld.doc";
	}
	
}
