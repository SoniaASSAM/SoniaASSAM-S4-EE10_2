package setUtils;
import java.util.TreeSet;
import java.util.Iterator;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Arrays;



public class Set extends TreeSet<Integer>
{
	static final String SERIAL = "serial";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int card = 0;
	
	public Set()
	{
		super();
	}
	
	public Set(int[] set)
	{
		this();
		card = set.length;
		for (int i=0; i<card; i++) add(new Integer(set[i]));
	}
	
	public Set(Integer[] set)
	{
		this();
		card = set.length;
		for (int i=0; i<set.length; i++) 
		{
			add(set[i]);
		}	
	}
	
	
	@Override 
	public boolean add(Integer i)
	{
		boolean r = super.add(i);
		if (r==true) card++;
		return r;
	}
	
	/***
	 * Fait l'intersection de l'ensemble courant avec l'ensemble en paramètres
	 * @param set : Second ensemble
	 * @return the result
	 */
	public Set inter(Set set)
	{
		Set s = new Set();
		Integer i;
		if (set != null && !set.isEmpty())
		{
			Iterator<Integer> it = this.iterator();
			while (it.hasNext())
			{
				i = it.next();
				if (set.contains(i)) s.add(i);
			}
		}
		return s;
	}
	
	
	@Override
	public String toString()
	{
		String s="[";
		Iterator<Integer> it = this.iterator();
		Integer i;
		while (it.hasNext())
		{
			i = it.next();
			s+= it.hasNext() ? i.toString()+"," : i.toString();
		}
		return s+"]";
	}
	
	public Set union(Set set)
	{
		Set s = (Set)this.clone();
		if (set != null) s.addAll(set);
		return s;
	}
	
	public Set diff(Set set)
	{
		Set s = new Set();
		Integer i;
		if (set != null && !set.isEmpty())
		{
			Iterator<Integer> it = this.iterator();
			while (it.hasNext())
			{
				i = it.next();
				if (! set.contains(i)) s.add(i);
			}
		}
		return s;
	}
	
	public static Set toSet(String s)
	{
		ArrayList <Integer> set = new ArrayList<Integer>();
		String [] st = s.split(",");
		String debut, fin;
		if (st.length ==  1) debut = fin = st[0];
		else 
		{
			debut = st[0] ; 
			fin = st[st.length-1];
		}
		if (debut.charAt(0) == '[' && fin.charAt(fin.length()-1) == ']') 
		{
			try 
			{
				if (!debut.equals(fin))
				{
					set.add(Integer.parseInt(debut.substring(1)));
					set.add(Integer.parseInt(fin.substring(0,fin.length()-1)));
					for (int i=1; i<st.length-1; i++)  set.add(Integer.parseInt(st[i]));
				}
				else 
				{
					String n = debut.substring(1,debut.length()-1);
					if (n.length() != 0) set.add(Integer.parseInt(n));
				}
				
				if (isASet(set)) 
				{
					Object [] set1 = set.toArray();
					Integer [] st1 = Arrays.copyOf(set1, set1.length, Integer[].class);
					return new Set(st1);
				}
					
				return null;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Erreur lecture de l'ensemble! vérifiez la syntaxe");
				return null;
			}
			
		}
		return null;
	}
	
	private static boolean isASet(ArrayList<Integer> set)
	{
		for (int i=0;i<set.size();i++)
		{
			int x = set.get(i).intValue();
			if (x<0) return false;
		}
		return true;
	}
	
	
}