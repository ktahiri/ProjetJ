package fr.um3.projet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		System.out.println("----Client----");
		
		try {
			InetAddress add= InetAddress.getLocalHost();
			Socket SocketClient = new Socket("192.168.1.56",49930);
			String id="Client:  "+add;
			
			PrintWriter Envoie=new PrintWriter(SocketClient.getOutputStream());
			//Envoie.println(id);
			Envoie.println("Bonjours");
			
			Envoie.flush();
			
			SocketClient.close();
		
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
