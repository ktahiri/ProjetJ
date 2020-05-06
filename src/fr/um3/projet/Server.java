package fr.um3.projet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
	private static final int PORT=9991;
	private static String[] names= {"Joueur 1","Joueur 2"};
	private static String[] roles= {"Dois faire deviner","Dois trouver le mot"};
	private static ArrayList<ClientHandler> clients=new ArrayList();
	private static ExecutorService pool=Executors.newFixedThreadPool(2);
	
	private static int rotation=0;
	public static int getRotation() {return rotation;}
	
	
	public static String getRandomRoles() {
		if(rotation==0){
		String name= names[0];
		String role= roles[0];
		rotation++;
		return name+" : "+role;}
		if(rotation==1){
		String name= names[1];
		String role= roles[1];
		rotation++;
		return name+" : "+role;}
		
		return "";	
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		 int a=0;
		 ServerSocket listener=new ServerSocket(PORT);
		 while(true) {
		 System.out.println("[SERVER] Attente d'une connexion !");
		 Socket client=listener.accept();
		 System.out.println("[SERVER] Une connexion a été effectuée !"); 
		 ClientHandler clientThread=new ClientHandler(client,clients,a);
		 clients.add(clientThread);
		 pool.execute(clientThread);
		 a++;
		 }
		 
	}





}
