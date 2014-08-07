package alg;

public class Helper {

	public static boolean ArregloOrdenado(Comparable[] items )
	{
		int N = items.length;
		for(int i=0; i<N-1;i++)
		{
			if(items[i].compareTo(items[i + 1]) > 0)
				return false;
			
		}
		return true;
	}
}
