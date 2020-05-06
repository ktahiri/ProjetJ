package fr.um3.projet;


import java.util.Random;
import java.util.ArrayList;

public class MessageModificateur {
	
	public static String modifier (String message, String but) {

		
		if (message.contains(but)) {
			message = message.replaceAll(but, "");	
		}
		int taille = message.length();
		double l = (int) taille*0.30;
		
		String m2 = new String ("");
		
		int n=0;
		int z=0;
		
		ArrayList<Integer> ind = new ArrayList<Integer>();
		
		while ( (n<taille) && (l>=0) ){
			
			
			Random rd = new Random();
			
			
			if (rd.nextBoolean()) {
				if (!ind.contains(n)) {
					ind.add(n);
					l-=1;
				}	
			}
			
			if (n<taille && !(l>=0)) { if (l>=0) { n=z; } }
			n+=1;
			
		}

		for (int i = 0; i<taille ;i++) {
			if (!ind.contains(i)) {
				m2+= message.charAt(i);
				
			}
		}
			 
		return (message = m2);
	}
	}


