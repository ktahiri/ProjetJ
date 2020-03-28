package fr.um3.projet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String> list = new ArrayList<String>();
		
		String but = new String ("message");
		list.add(but);
		
		Iterator <String> i = list.iterator();
		
		
		String message = new String ("le message est celui ci");
		
		String uu = new String();
		
		boolean b = true;
		
		while 	(b) {
			while (i.hasNext()){
				String m = i.next();
				if (message.contains(m)) {
					message = message.replaceAll(m, "");	
				}
	
			
			}
		
			int taille = message.length();
			double l = (int) taille*0.30;
		
			String m2 = new String ("");
		
			for (int n=0; n<l;n++) {
				String o2 = new String ("");
				Random rd = new Random();
				if (rd.nextBoolean()) {
					o2 = o2 + message[n];
					
				
				}
			
			}
		}
		
		
		
		
		
		

	}

}
