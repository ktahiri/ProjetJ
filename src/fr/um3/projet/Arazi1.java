package fr.um3.projet;

import java.util.Random;
import java.util.ArrayList;

public class Arazi1 {
	
	public String modifier (String message) {
		String m = new String("but");
		
		if (message.contains(m)) {
			message = message.replaceAll(m, "");	
		}
		int taille = message.length();
		double l = (int) taille*0.30;
		
		String m2 = new String ("");
		
		int n=0;
		
		ArrayList<Integer> tab = new ArrayList<Integer>();
		
		
		while ( (n<taille) && (l>=0)) {
			
			
			Random rd = new Random();
			if (rd.nextBoolean()) {
				int nbreA = n + (int)(Math.random() * ((taille-1 - n) + 1));
				m2 = m2 + message.charAt(nbreA);
				l-=1;
				
				
			}
			n+=1;
			if (n<taille) {
				if (l>=0) {
					n=0;
				}
			}
		}
		return (message = m2);
	}
	}


