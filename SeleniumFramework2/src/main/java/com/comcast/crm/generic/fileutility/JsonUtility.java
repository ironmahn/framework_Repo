//package com.comcast.crm.generic.fileutility;
//
//import java.io.FileReader;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class JsonUtility {
//
//	public String getDataFromJsonFile(String key) throws Throwable {
//
//		FileReader filerdr = new FileReader("./configAppData/commondata.json");
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(filerdr);
//		JSONObject map = (JSONObject) obj;
//		String data = (String) map.get(key);
//
//		return data;
//	}
//}