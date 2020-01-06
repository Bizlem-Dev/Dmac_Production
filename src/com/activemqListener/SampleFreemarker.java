package com.activemqListener;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SampleFreemarker {

	public String sampleInvoiceC(String firstname,String lastname,String invoicenumber,String date) {
		System.out.println("1");
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		System.out.println("2");
		String string = "";
		try {
			//Load template from source folder
			Template template = cfg.getTemplate("src/helloworld.ftl");
			
			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("message", "Hello World!");

			//List parsing 
			List<String> countries = new ArrayList<String>();
			countries.add("India");
			countries.add("United States");
			countries.add("Germany");
			countries.add("France");
			
			data.put("countries", countries);
			
			
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
/*					Writer file = new FileWriter (new File("D:\\FTL_helloworld.pdf"));
			template.process(data, file);
			file.flush();
			file.close();*/
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error "+e.getMessage();
		}

		return string;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Freemarker configuration object
		/*		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
				try {
					//Load template from source folder
					Template template = cfg.getTemplate("src/helloworld.ftl");
					
					// Build the data-model
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("invoiceno", "32");
					data.put("date", "30/09/2017");
					data.put("firstname", "Vivek");
					data.put("lastname", "Kumar");

					//List parsing 
//					List<String> countries = new ArrayList<String>();
//					countries.add("India");
//					countries.add("United States");
//					countries.add("Germany");
//					countries.add("France");
//					
//					data.put("countries", countries);
					
					
					// Console output
//					Writer out = new OutputStreamWriter(System.out);
//					template.process(data, out);
//					//out.write("sv");
//					out.flush();

					// write the freemarker output to a StringWriter 
					StringWriter stringWriter = new StringWriter();
					template.process(data, stringWriter);

					// get the String from the StringWriter
					String string = stringWriter.toString();
					System.out.print(string);
					// File output
					Writer file = new FileWriter (new File("D:\\FTL_helloworld.doc"));
					template.process(data, file);
					file.flush();
					file.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
		int j = 0;
		for(int i=0;i<=12;i++) {
			//j = j + (i%6);
			System.out.println(i%6);
		}
		System.out.println(j);
	}

}
