import java.util.*;
import java.io.*;
import java.math.*;
public final class Solution 
{
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); //adjacency list of graph
	static boolean[] visited; //array visited of nodes of graph
    public static void main(String[] args)
    {
   	 Reader input = new Reader();
     PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
     int n = input.nextInt(), k = input.nextInt();
     int temp;
     int count = 0;
     for(int i = 0 ; i < n ; i++)
     {
    	 temp = input.nextInt();
    	 if(temp <= 5 - k)
    		 count++;
     }
     out.println(count / 3);
     out.close();	 
    }  
	public static void bfs(int start) 
	{		
		ArrayList<Integer> queue = new ArrayList<>();
		queue.add(start);
		while(queue.size() != 0)
		{
			int node = queue.get(0);
			queue.remove(0);
			if(visited[node])
				continue;
			visited[node] = true;
			/*do something here with variable node if needed*/
			for(int i = 0 ; i < adj.get(node).size(); i++)
				queue.add(adj.get(node).get(i));
		}
	}

	public static int stronglyConnectedComponents() 
	{
		int count = 0;
		for(int i = 0 ; i < adj.size(); i++)
		{
			if(!visited[i])				
			{
				count++;
				dfs(i);
			}
		}
		return count;
	}
	public static void dfs(int start) 
	{
		/*do something here with the node(start) if needed*/
		visited[start] = true;
		for(int i = 0 ; i < adj.get(start).size(); i++)
		{
			if(visited[adj.get(start).get(i)])
				continue;			
			dfs(adj.get(start).get(i));
		}
	} 
    public static int z(int n)
    {
    	/*finds the number of trailing zeros in factorial */
    	int count = 0;
    	for(int i = 5 ; i <= n ; i *= 5)
    	{
    		count += n / i;
    	}
    	return count;
    }
    public static int gcd(int a , int b)
    {
    	if(b == 0)
    		return a;
    	return gcd(b , a %b);
    }
    public static class UnionFind
    {
    	/* this class uses zeroIndexing and gives the result back in zero indexing*/
    	int[] parent;
    	int[] size;
    	int maxSize = 0;
    	public UnionFind(int n)
    	{
    		size = new int[n];
    		parent = new int[n];
    		for(int i = 0 ; i < n ; i++)
    		{
    			parent[i] = i;
    			size[i] = 1;
    		}
    		maxSize = 1;
    	}
    	public int find(int pos)
    	{
    		if(parent[pos] == pos)
    			return pos;
    		return parent[pos] = find(parent[pos]);
    	}
    	public void unify(int x , int y)
    	{
    		int xParent = find(x);
    		int yParent = find(y);
    		if(xParent == yParent)
    			return;
    		else if(size[xParent] > size[yParent]) 
    		{
    			size[xParent] += size[yParent];
    			if(size[xParent] > maxSize)
    				maxSize = size[xParent];
    			parent[yParent] = xParent;
    		}
    		else
    		{
    			size[yParent] += size[xParent];
    			if(size[yParent] > maxSize)
    				maxSize = size[yParent];
    			parent[xParent] = yParent;
    		}
    	}
    	public int maxSize()
    	{
    		return maxSize;
    	}
    	public int connectedComponents()
    	{
    		int count = 0;
    		for(int i = 0 ; i < parent.length ; i++)
    		{
    			if(i == parent[i])
    				count++;
    		}
    		return count;
    	}
    }
    public static class Pair implements Comparable<Pair>
    {
    	int a ,  b;
    	public Pair(int a , int b)
    	{
    		this.a = a;
    		this.b = b;
    	}
		@Override
		public int compareTo(Pair t) {
			// TODO Auto-generated method stub
    		if(t.a == this.a)
    		{
    			if(this.b < t.b)
    				return -1;
    			else if(this.b > t.b)
    				return 1;
    			else
    				return 0;
    		}
    		else if(this.a < t.a)
    			return -1;
    		else
    			return 1;
		}
    }
    public static class Reader
    {
    	BufferedReader br;
    	StringTokenizer st;
    	public Reader()
    	{
    		br = new BufferedReader(new InputStreamReader(System.in));    		
    	}
    	public String next()
    	{
    		try
    		{
        		if(st == null || !st.hasMoreTokens())
        			st = new StringTokenizer(br.readLine());
    		}
    		catch(IOException ex)
    		{
    			ex.printStackTrace();
    			System.exit(1);
    		}    		
    		return st.nextToken();
    	}
    	public int nextInt()
    	{
    		return Integer.parseInt(next());
    	}
    	public double nextDouble()
    	{
    		return Double.parseDouble(next());
    	}
    	public long nextLong()
    	{
    		return Long.parseLong(next());
    	}
    	public String nextLine()
    	{
    		try
    		{
    			return br.readLine();
    		}
    		catch(IOException ex)
    		{
    			ex.printStackTrace();
    			System.exit(1);
    		}
    		return "";
    	}
    }
}
