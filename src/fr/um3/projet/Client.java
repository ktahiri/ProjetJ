package fr.um3.projet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		System.out.println("----Client----");
		
		try {
			InetAddress add= InetAddress.getLocalHost();
			Socket Detect = new Socket("192.168.1.14",49874);
			String id="Client:  "+add;
			
			BufferedReader Reception=new BufferedReader(
					new InputStreamReader(Detect.getInputStream()));
			System.out.println(Reception.readLine());
			
			PrintWriter Envoie=new PrintWriter(
					new BufferedWriter(
					new OutputStreamWriter(Detect.getOutputStream())),
					true);
		
			//PrintWriter Envoie=new PrintWriter(SocketClient.getOutputStream());
			//Envoie.println(id);
			//Envoie.println("Bonjours");
			
			//Envoie.flush();
			
			Detect.close();
		
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}

