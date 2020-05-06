package fr.um3.projet;
import java.util.Random;

public class ParametreJeu {

private static String Dictionnaire[]={"Voiture","Avion","Bateau"};

public static String RandomWord() {
	String word= Dictionnaire[(int)(Math.random()*Dictionnaire.length)];
	return word;
	
}




}
