package com.activeMQ;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;

public class FTPClientNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String server = "94.200.40.204";
	        int port = 21;
	        String user = "MQUser";
	        String pass = "Elite$190";
	 
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(server, port);
	            boolean logIn = ftpClient.login(user, pass);
	            System.out.println(logIn);
	            ftpClient.enterLocalPassiveMode();
	 
	     //       ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	            
	            // APPROACH #1: uploads first file using an InputStream
//	            File firstLocalFile = new File("D:/MQ/12Oct/Documents/AOPT_PMT_PLAN Addendum.PDF");
//	 
//	            String firstRemoteFile = "AOPT_PMT_PLAN Addendum.PDF";
//	            InputStream inputStream = new FileInputStream(firstLocalFile);
//	 
//	            System.out.println("Start uploading first file");
//	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
//	            inputStream.close();
//	            if (done) {
//	                System.out.println("The first file is uploaded successfully.");
//	            }
	 
	       
	        } catch (Exception ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    
	}

}
