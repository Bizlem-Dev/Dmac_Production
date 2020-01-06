package com.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

/**
 * Servlet implementation class MongoDataCurrent
 */
public class MongoDataCurrent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoDataCurrent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=	response.getWriter();
		//out.append("Served at: ").append(request.getContextPath());
			JSONObject main= new JSONObject();
			JSONArray arr= new JSONArray();
			JSONObject subjson=null;
			JSONArray subarr=null;
			try {
		DBCursor cursor = MongoDB.getReportAllCurrentDate("sfdc", "storemessage");
		int iCount = 0;
		while (cursor.hasNext()) {
			
			
			DBObject  dboj = cursor.next();
			subjson=new JSONObject();
			JSONObject newjson1=null;
			if(dboj.get("messageId") != null) {
				subjson.put("MessageID", dboj.get("messageId").toString());
			}else {
				subjson.put("MessageID", JSONObject.NULL);
			}
//			 newjson1=new JSONObject( dboj.get("request").toString());
//			
//			String[] keys1 = JSONObject.getNames(newjson1);
//
//			String res1="";
//			for (String key1 : keys1) {
//			   
//			    res1  =res1+key1+"= "+ newjson1.getString(key1)+",\n";
//			   
//			}
//			
//			System.out.println("res "+res1);
			if(dboj.get("request") != null) {
			subjson.put("Request", dboj.get("request").toString());
		    }else {
		    	subjson.put("Request", JSONObject.NULL);
		    }
//				subjson.put("Request", res1 );
			if(dboj.get("source") != null) {
			subjson.put("Source", dboj.get("source").toString());
			}else {
				subjson.put("Source", JSONObject.NULL);
			}
			if(dboj.get("reqtime") != null) {
			subjson.put("Request_Time", dboj.get("reqtime").toString());
			}else {
				subjson.put("Request_Time", JSONObject.NULL);
			}
			if(dboj.get("destination") != null) {
			subjson.put("Destination", dboj.get("destination").toString());
			}else {
				subjson.put("Destination", JSONObject.NULL);
			}
			JSONObject newjson2=null;
//		 newjson2=new JSONObject(dboj.get("response").toString());
//		
//		String[] keys2 = JSONObject.getNames(newjson2);
//
//		String res2="";
//		for (String key2 : keys2) {
//		    
//		    res2  =res2+key2+"= "+ newjson2.getString(key2)+",\n";
//		   
//		}
//		
//		System.out.println("res2 "+res2);
			if(dboj.get("response") !=null) {
		       subjson.put("Response", dboj.get("response").toString());
			}else {
				subjson.put("Response", JSONObject.NULL);
			}
//			subjson.put("Response", res2);
			if(dboj.get("restime") != null) {
			subjson.put("Response_Time", dboj.get("restime").toString());
			}else {
				subjson.put("Response_Time", JSONObject.NULL);
			}
			if(dboj.get("status") != null) {
			subjson.put("Status", dboj.get("status").toString());
			}else {
				subjson.put("Status", JSONObject.NULL);
			}
			  arr.put(subjson);
//			subarr = new JSONArray();
//			subarr.put(dboj.get("messageId").toString());
//			subarr.put(dboj.get("request").toString());
//			subarr.put(dboj.get("source").toString());
//			subarr.put(dboj.get("reqtime").toString());
//			subarr.put(dboj.get("destination").toString());
//			subarr.put(dboj.get("response").toString());
//			subarr.put(dboj.get("restime").toString());
//			subarr.put(dboj.get("status").toString());
//			arr.put(subarr);
			  iCount++;
		}
		main.put("recordsTotal", iCount);
		main.put("data", arr);
		out.println(main.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("error mongodata :: "+e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
