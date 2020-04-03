package fr.um3.projet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Serveur extends Thread {
	
	public void run() {
		try {
			System.out.println("Demmarage du serveur");
			System.out.println("En Attente d'une connexion");
			ServerSocket SocketServeur=new ServerSocket(49930);
			SocketServeur.setSoTimeout(60000);//Ferme le Socket au bout d'une minute si aucun client ne s'y connecte
			//System.out.println(sSocket.getLocalPort()); Mettre 0 comme port puis effectuer cette comande pour trouver un port fixe de libre
			
			while(true) {
				Socket Detect=SocketServeur.accept();//connecté aux clients 
				System.out.println("Une connexion a été établie avec un client !");
				
				new Jeu(Detect).start();
				//Jeu jeu=new Jeu(Detect); jeu.setsocket(Detect);
				BufferedReader Reception=new BufferedReader(
						new InputStreamReader(Detect.getInputStream()));
				System.out.println(Reception.readLine());
				
				PrintWriter Envoie=new PrintWriter(
						new BufferedWriter(
						new OutputStreamWriter(Detect.getOutputStream())),
						true);
			
			}
		
		}catch(SocketTimeoutException e){System.err.println("Aucun client ne sait connecter dans le temps imparti");}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//modification
	class Jeu extends Thread{//thread qui s'execute pour chaque nouveau client
		private Socket socket ;
	
		public Jeu(Socket socket) {
		super();
		this.socket = socket;}
		
		public Socket getsocket() {return socket;}
		public void setsocket(Socket socket) {this.socket=socket;}
		
		public void run() {// Coder le Jeu en lui meme
			/*BufferedReader Reception = null;
			try {
				Reception = new BufferedReader(new InputStreamReader(getsocket().getInputStream()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				System.out.println(Reception.readLine());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		*/
		}
	}
	public static void main(String[] args) {
		new Serveur().start();	   
		
	
	}
}
		         

