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
		int z=0;
		
		ArrayList<Integer> tab = new ArrayList<Integer>();
		
		
		while ( (n<taille) && (l>=0)) {
			
			
			Random rd = new Random();
			System.out.println("tailles : " + taille);

			System.out.println(tab);
			System.out.println(m2);
			System.out.println(l);
			System.out.println("n : " + n);
			System.out.println("z " + z);


			if (rd.nextBoolean()) {
				if (!tab.contains(n)) {
					int nbreA = n + (int)(Math.random() * ((taille-1 - n) + 1));
					m2 = m2 + message.charAt(nbreA);
					l-=1;
					tab.add(n);
					z=n;
					

				}
				
			}
			n+=1;

			
			  if (n<taille && !(l>=0)) { if (l>=0) { n=z; } }
			 
		}
		return (message = m2);
	}
	}


