package com.mycompany.app;

///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;



public class App {

	
	public static void main(String[] args) {

	  try {

		//URL url = new URL("http://34.70.62.138/artifactory/api/storage/libs-snapshot-local/org/jfrog/test/multi1/6.88-SNAPSHOT/multi1-6.88-20190422.230806-1-tests.jar?stats");
		
		URL url = new URL("http://34.70.62.138/artifactory/api/search/artifact?name=*jar&repos=jcenter-cache");		
  
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream()))); 

		Object output;
		
		//JSONObject jsonObject = (JSONObject) output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
				
			System.out.println(output);
		}
		
		
		
		
		
		

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}

}
