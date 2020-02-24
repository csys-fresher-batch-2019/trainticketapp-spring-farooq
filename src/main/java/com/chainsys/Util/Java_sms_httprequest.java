package com.chainsys.Util;

	import java.net.*;

	public class Java_sms_httprequest {

		public static void main(String[] args) {
	        try {
	                String recipient = "+918778621280";
	                String message = " Greetings from Mr. Gupta! Have a nice day!";
	                String username = "admin";
	                String password = "abc123";
	                String originator = "+918778621280";

	                String requestUrl  = "http://192.168.43.69/api?action=sendmessage&" +
	                					 "username=" + URLEncoder.encode(username, "UTF-8") +
	                					 "&password=" + URLEncoder.encode(password, "UTF-8") +
	                					 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
	                					 "&messagetype=SMS:TEXT" +
	                					 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
	                					 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
	                					 "&serviceprovider=GSMModem1" +
	                					 "&responseformat=html";



	                URL url = new URL(requestUrl);
	                HttpURLConnection uc = (HttpURLConnection)url.openConnection();

	                System.out.println(uc.getResponseMessage());

	                uc.disconnect();

	        } catch(Exception ex) {
	                System.out.println(ex.getMessage());

	        }
	        
		}

	}
