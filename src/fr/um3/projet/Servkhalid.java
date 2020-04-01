package fr.um3.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class Servkhalid {
	
	public static void main(String[]args) {
		
		System.out.println("Demarraage du seveur ");
		
		try {
			InetAddress add= InetAddress.getLocalHost();
			System.out.println(add);

		}catch(UnknownHostException e){e.printStackTrace();}
		
		
		try {
			System.out.println("En Attente d'une connexion");
			ServerSocket SocketServeur=new ServerSocket(49874,2);
			SocketServeur.setSoTimeout(50000);
			Socket Detect=SocketServeur.accept();
			System.out.println("Une connexion a été établie !");
			
			BufferedReader Reception=new BufferedReader(new InputStreamReader(Detect.getInputStream()));
			System.out.println(Reception.readLine());
			
			
			
			
			SocketServeur.close();
			Detect.close();
			
		} catch(SocketTimeoutException e){System.err.println("Aucun client ne sait connecter dans le temps imparti");}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
