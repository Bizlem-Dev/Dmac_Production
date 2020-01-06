package com.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		//MongoDB objMongoDB = new MongoDB();
		DBCollection coll = MongoDB.getMongoDbAnyConn("sfdc", "storemessage");
		BasicDBObject document = new BasicDBObject();
        document.put("name", "vivek");
        coll.insert(document);
        ObjectId id = (ObjectId)document.get( "_id" );
        System.out.println(id);
        //5a14057bdfac262cc933c0bc
        BasicDBObject documentU = new BasicDBObject();
        
        documentU.put("surname", "tripathi");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date)formatter.parse(formatter.format(new Date()));
        documentU.put("reqtime", date);
        coll.update(new BasicDBObject("_id", id),new BasicDBObject("$set", documentU));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static MongoClient mongo;
    public static DB db = null;
    ResourceBundle bundle = null;
	 public static DBCollection getMongoDbAnyConn(String Dbname, String collectionname) {
	        DBCollection newcollection = null;
	        try {
//	        	mongo = new MongoClient("localhost", 27017);
//	            db = mongo.getDB(Dbname);
	        	 if(db == null){
	 	            //mongo = new MongoClient("localhost", 27017).getDB(Dbname);
	 	            //db = mongo.getDB(Dbname);
	 	            db = new MongoClient("localhost", 27017).getDB(Dbname);
	 	            
	 	        	}
	            newcollection = db.getCollection(collectionname);

	            System.out.println("Return collection object......." + newcollection);

	        } catch (Exception e) {
	           // e.printStackTrace();
	        	System.out.println(e.getMessage());
	        	
	        }finally {
//	        	mongo.close();
//	        	db = null;
			}
	        return newcollection;

	    }
	 
	 public ObjectId mongoDBInsert(DBCollection coll,String messageId, String jsonReq,String source) {
		 ObjectId id = null;
	        try {
	        	BasicDBObject document = new BasicDBObject();
	            document.put("messageId", messageId);
	            document.put("request", jsonReq);
	            document.put("source", source);
	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date date = (Date)formatter.parse(formatter.format(new Date()));
	            document.put("reqtime", date);
	            coll.insert(document);
	             id = (ObjectId)document.get( "_id" );
	            System.out.println(id);
	        } catch (Exception e) {
	           // e.printStackTrace();
	        	System.out.println(e.getMessage());
	        }
	        return id;

	    }
	 
	 public String mongoDBUpdate(DBCollection coll,String objectId,String destination, String jsonRes,String status) {
	        try {
	        	BasicDBObject documentU = new BasicDBObject();
	            
	            documentU.put("destination", destination);
	            documentU.put("response", jsonRes);
	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date date = (Date)formatter.parse(formatter.format(new Date()));
	            documentU.put("restime", date);
	            documentU.put("status", status);
	            coll.update(new BasicDBObject("_id", objectId),new BasicDBObject("$set", documentU));
	        } catch (Exception e) {
	           // e.printStackTrace();
	        	System.out.println(e.getMessage());
	        	return e.getMessage();
	        }
	        return "true";

	    }
	 
	 public static DBCursor getReportByMessageId(String database,String collection,String messageId) {
	       // MongoDbConn mdbconn = new MongoDbConn();
	        String email = null;
	        DBCursor cursor = null;
	        try {
	             cursor = MongoDB.getMongoDbAnyConn(database, collection).find(new BasicDBObject("messageId", messageId));

	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println("From email id for case no(" + messageId + ") : " + cursor);
	        return cursor;
	    }
	 
	 public ObjectId mongoDBInsertFull(String messageId, String jsonReq,String source,Date reqDate,String destination, String jsonRes,String status) {
		 ObjectId id = null;
	        try {
	        	 bundle = ResourceBundle.getBundle("serverConfig");
	        	DBCollection coll = MongoDB.getMongoDbAnyConn(bundle.getString("mongodb"), bundle.getString("mongocoll")); 
	        	BasicDBObject document = new BasicDBObject();
	            document.put("messageId", messageId);
	            document.put("request", jsonReq);
	            document.put("source", source);
	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date date = (Date)formatter.parse(formatter.format(reqDate));
	            document.put("reqtime", date);
	            document.put("destination", destination);
	            document.put("response", jsonRes);
	            Date dateRes = (Date)formatter.parse(formatter.format(new Date()));
	            document.put("restime", dateRes);
	            document.put("status", status);
	            coll.insert(document);
	             id = (ObjectId)document.get( "_id" );
	            System.out.println(id);
	        } catch (Exception e) {
	           // e.printStackTrace();
	        	System.out.println(e.getMessage());
	        }
	        return id;

	    }

	 public static DBCursor getReportAll(String database,String collection) {
	       // MongoDbConn mdbconn = new MongoDbConn();
	       
	        DBCursor cursor = null;
	        try {
	             cursor = MongoDB.getMongoDbAnyConn(database, collection).find();

	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println("all resords " + cursor);
	        return cursor;
	    }
	 
	 
	 public static DBCursor getReportAllCurrentDate(String database,String collection) {
	       // MongoDbConn mdbconn = new MongoDbConn();
	       
	        DBCursor cursor = null;
	        try {
//	        	
	        	SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	        	 Date d;	        	
	        	Calendar fromdate = new GregorianCalendar();
	        	fromdate.setTime(new Date());
	        	fromdate.set(Calendar.HOUR_OF_DAY, 0);
	        	fromdate.set(Calendar.MINUTE, 0);
	        	fromdate.set(Calendar.SECOND, 0);
	        	fromdate.set(Calendar.MILLISECOND, 0);
	        	Date midnightYesterday = fromdate.getTime();
	        	System.out.println(fromdate);
	        	
	        	d = fromdate.getTime();
	        	  String time1 = format.format(d);
	        	  
	        	  Date date1;
	        	   date1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(time1);
	        	   System.out.println("1 ::: "+date1);
	        	 
	        	
	        	Calendar todate = new GregorianCalendar();
	        	todate.setTime(new Date());
	        	todate.set(Calendar.HOUR_OF_DAY, 23);
	        	todate.set(Calendar.MINUTE, 59);
	        	todate.set(Calendar.SECOND, 59);
	        	todate.set(Calendar.MILLISECOND, 999);
	        	Date midnightTonight = todate.getTime();
	        	
	        	System.out.println(todate);
	        	
	        	d = todate.getTime();
	        	  String time2 = format.format(d);
	        	  
	        	  Date date2;
	        	   date2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(time2);
	        	   System.out.println("2::: "+date1);
	        	  
	        	
	          	BasicDBObject query = new BasicDBObject();
	        	query.put("reqtime", BasicDBObjectBuilder.start("$gte", date1).add("$lte", date2).get());
	        	cursor = MongoDB.getMongoDbAnyConn(database, collection).find(query).sort(new BasicDBObject("dateAdded", -1));

	            // cursor = MongoDB.getMongoDbAnyConn(database, collection).find();
            
	            
	        } catch (Exception e) {
	            System.out.println(""+e.getMessage());
	        }
	        System.out.println("all resords " + cursor);
	        return cursor;
	    }

}
