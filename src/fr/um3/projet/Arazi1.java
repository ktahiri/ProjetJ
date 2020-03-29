package fr.um3.projet;

import java.util.Random;

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
		while ( (n<taille) && (l>=0)) {
			int z =0;
			Random rd = new Random();
			if (rd.nextBoolean()) {
				int nbreA = n + (int)(Math.random() * ((taille-1 - n) + 1));
				m2 = m2 + message.charAt(nbreA);
				l-=1;
				z=n+1;
				
			}
			n+=1;
			if (n<1) {
				if (l>=0) {
					n=z;
				}
			}
		}
		return (message = m2);
	}
	}


