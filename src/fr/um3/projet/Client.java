package fr.um3.projet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {
	private static final int PORTserver=9991; 
	private static final String IPserver="127.0.0.1";
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket server=new Socket(IPserver,PORTserver);
		
		ServerConnection serveurC=new ServerConnection(server);
		BufferedReader pressKeyboard= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter Send=new PrintWriter(server.getOutputStream(),true);
		new Thread(serveurC).start();
	while(true) {
		System.out.println(">> ");
		String saisie=pressKeyboard.readLine();
		
		if(saisie.equals("stop")){break;}
		
		Send.println(saisie);
	}
		server.close();
		System.exit(0);
		
		
		
	}
}
