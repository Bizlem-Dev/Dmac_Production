
package com.activeMQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CallService {

	public String callPostService(String urlStr, String[] paramName,
            String[] paramValue) {

        StringBuilder response = new StringBuilder();
        URL url;
        try {
            System.out.println("caalign callPostService");
            url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            OutputStream out = conn.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            for (int i = 0; i < paramName.length; i++) {
                writer.write(paramName[i]);
                writer.write("=");
                writer.write(URLEncoder.encode(paramValue[i], "UTF-8"));
                writer.write("&");
            }
            writer.close();
            out.close();
            if (conn.getResponseCode() != 200) {
                System.out.println("indeside caalign responce" + conn.getResponseCode());
            }
            System.out.println("caalign responce");
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();
            System.out.println("closinng conneciotn" + conn.getResponseCode());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("priting responce");
        System.out.println(response.toString() + "~~~~~~~~~~~~~~~~~~~~~~~");
        return response.toString();
    }

	
	public String callGetService(String urlStr, String[] paramName,
			String[] paramValue) {
		URL url;
		StringBuilder requestString = new StringBuilder(urlStr);
		if (paramName != null && paramName.length > 0) {
			
			for (int i = 0; i < paramName.length; i++) {
				requestString.append("&");
				requestString.append(paramName[i]);
				requestString.append("=");
				requestString.append(paramValue[i]);
				//requestString.append("&");
			}
		}
		StringBuilder sb = new StringBuilder();
		try {
			url = new URL(requestString.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
			br.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return sb.toString();
	}
	
	
}
