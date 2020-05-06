package fr.um3.projet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable{
	private PrintWriter Send;
	private BufferedReader Receive;
	private Socket Serveur;
	
	public ServerConnection(Socket serveur) throws IOException{
		Serveur=serveur;
		Send=new PrintWriter(serveur.getOutputStream(),true);
		Receive=new BufferedReader(new InputStreamReader(serveur.getInputStream()));
		
		
		
	}

	@Override
	public void run() {
		while(true) {
			String ReponseServer;
			try {
				ReponseServer = Receive.readLine();
				System.out.println("Server : "+ReponseServer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
			
		}
		
	}
}
