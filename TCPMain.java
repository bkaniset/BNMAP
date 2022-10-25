package com.bnmap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import com.bnmap.ScriptProperties;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

// Try to figure out which ports(0-1023) are available at an IP address via TCP. 
// JSON file location to be sent via args[1].
public class TCPMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScriptProperties scriptProperties = null;
	 
	 if(args.length>0)
	 {
		 Gson gson = new Gson();
		 
		 try
		 {
		scriptProperties = gson.fromJson(new FileReader(args[1]), ScriptProperties.class);
		 } catch (JsonSyntaxException | JsonIOException| FileNotFoundException e )
		 {
			 ((Throwable) e).printStackTrace();
		 }
		 
		 ScriptEngine scriptEngine = new ScriptEngine();
		 ScriptEngine.executeScript(scriptProperties);
	 }
	 else
	 {
	 	
     int port = 0;
     int upperLimit = 1024; 
     String dstIP = "192.168.122.89";
     
     while(port<upperLimit)
     { 
    	 try {
    	Socket sock = new Socket(dstIP, port);
    	System.out.println("Port "+ port + " seems to be opened");
    	sock.close();
    	 }
    	 catch (Exception ex)
    	 {
    		 System.out.println("Port "+ port + " seems to be closed");
    		 ex.printStackTrace();
    	 }
     port++;
     }
	 }
	}

}
