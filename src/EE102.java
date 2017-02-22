/**
 * 
 */

import java.util.Scanner;

import setUtils.Set;
/**
 * @author Sonia ASSAM
 *
 */
public class EE102 
{

	/**
	 * @param args
	 */
	
	public static Set readSet(String s)
	{
		if (s.length()!=0) return Set.toSet(s);		
		else throw new IllegalArgumentException("Erreur ! Veuillez entre un ensemble!");
	}
	
	public static String readOp(String s)
	{
		if (s.equals("*") || s.equals("+") || s.equals("-")) return s;
		else throw new IllegalArgumentException("Erreur! Opération incorrecte");
	}
	
	public static void exercice10_2()
	{
		System.out.println("Entrez le premier ensemble");
		Set set1 = readSet(new Scanner(System.in).nextLine());
		System.out.println("Entrez l'opération que vous voulez faire : *, -, +");
		String op = readOp(new Scanner(System.in).nextLine());
		System.out.println("Entrez le second ensemble");
		Set set2 = readSet(new Scanner(System.in).nextLine());
		switch (op)
		{
			case("+") : 
				System.out.println(set1.union(set2));
				break;
			case("*") : 
				System.out.println(set1.inter(set2));
				break;
			case("-") : 
				System.out.println(set1.diff(set2));
				break;
		}	
	}
	
	public static void main(String[] args) 
	{
		while(true) 
		{
			try {exercice10_2();}
			catch (IllegalArgumentException e) {System.out.println(e);}
		}
	}

}
