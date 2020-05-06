package fr.um3.projet;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
	
	private PrintWriter Send;
	private BufferedReader Receive;
	private Socket Client;
	private ArrayList<ClientHandler> clients; 
	private int role;
	private Boolean win=false;
	private int cycle=5;
	private String Word;
	public  void setWord(String Word){
		this.Word=Word;

	}

	public String getWord() {return Word;}

	
	public void setrole(int role) {this.role=role;}
	public int getrole() {return role;}
	public ClientHandler(Socket client,ArrayList<ClientHandler> clients,int role) throws IOException {
		this.role=role;
		this.clients=clients;
		this.Client=client;
		Send=new PrintWriter(Client.getOutputStream(),true);
		Receive=new BufferedReader(new InputStreamReader(Client.getInputStream()));
		
	}
	
	
	
	
	
	@Override
	public void run() {
		try {
			Send.println(Server.getRandomRoles());
			
			//if(Server.getRotation()<2) {Send.println("Veuillez attendre qu'une 2eme personne se connecte !");}
			//while(clients.size()!=2) {}
			while(win==false && cycle>0) {
				
				/*JOUEUR 1*/		 if(getrole()==0) {	
					 setWord(ParametreJeu.RandomWord());
					 
					 Send.println("Vous devez faire devenier le mot "+getWord());
					 while(win==false && cycle>0) {
						 
						 Send.println("Il vous reste envore "+cycle+" tentatives.");
						 Send.println("Veillez saisir un indice ");
						 String request=Receive.readLine();
						 String msg=MessageModificateur.modifier(request,getWord());
						 SendMessage("J1/ Indice: "+msg+". A votre tour !", 1);
						 Send.println("Attendez votre tour");
						 cycle--;
						 
						 
					 
					 
					 
					 
					 }
				 
				 }
				 
				 
				/*JOUEUR 2*/ 	if(getrole()==1) {
					 Send.println("Attendez de recevoir votre premiere indice");
					 while(win==false && cycle>0) {
						 Send.println("Il vous reste envore "+cycle+" tentatives.");
						 String request=Receive.readLine();
						 SendMessage("J2/ Reponse: "+request+". A votre tour !", 0);
						 Send.println("Attendez votre tour");
						 cycle--;
			
	
						 
					 }
					 
				 }
				 
				 
				 if(cycle<=0) {SendToAll("Vous avez perdu !!");}
				 
				
				
				
			}
			
		}
			catch (IOException e) {
				
				e.printStackTrace();
			}
			 
		
	}





	private void SendToAll(String message) {
		for(ClientHandler aClient:clients) {
			
			aClient.Send.println(message);
			
		}
		
	}
	private void SendMessage(String message,int numeroduclient) {
		clients.get(numeroduclient).Send.println(message);
		
	}
	
	
}
