package com.bnmap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

//Try to figure out which ports(0-1023) are available at an IP address via Udp. 

public class UdpMain {

	public static void main(String[] args)
	{
		int port = 1;
		int upperLimit = 14; 
		
		String distIP = "192.168.122.89";
		
		int configuredTimeOut = 12000; 
		
		while(port<upperLimit)
		{
			DatagramSocket UDPSocket = null; 
			InetAddress addr ; 
			
			byte[] buff; 
			
			try {
				UDPSocket = new DatagramSocket(); 
				addr = InetAddress.getByName(distIP);
				
				String message = "This is Bala.";
				buff = message.getBytes();
				DatagramPacket packet = new DatagramPacket(buff,buff.length,addr,port);
				
				UDPSocket.send(packet);
				packet = new DatagramPacket(buff,buff.length);
				
				UDPSocket.setSoTimeout(configuredTimeOut);
				UDPSocket.receive(packet);
				
				String recieved = new String(packet.getData(),0, packet.getLength());
				
				System.out.println("port "+ port +" seems to be opened");
				
				
				
			}catch(SocketTimeoutException ex)
			{
				ex.printStackTrace();
			}
			catch(SocketException e)
			{
				e.printStackTrace();
			} 
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(Exception ex)
			{
				System.out.println();
				ex.printStackTrace();
			}
			finally
			{
				UDPSocket.close();
			}
			port++;
		}
	}
	
	
}
