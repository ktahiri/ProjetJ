package fr.um3.projet;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur extends Thread {
	
	public void run() {
		try {
			ServerSocket sSocket=new ServerSocket(234);
			while(true) {
				Socket s=sSocket.accept();//connecté aux clients 
				new Jeu(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class Jeu extends Thread{//thread qui s'execute pour chaque nouveau client
		private Socket socket ;
	
		public Jeu(Socket socket) {
		super();
		this.socket = socket;
		
	}

		public void run() {// Coder le Jeu en lui meme
			
		}
	}
	public static void main(String[] args) {
		new Serveur().start();	   
		            
	}
}
		         
