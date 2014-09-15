import java.io.*;
import java.util.*;

public class Solution
{
	StreamTokenizer in;
	PrintWriter out;

	public static void main(String[] args) throws IOException
	{
		new Solution().run();
	}

	void run() throws IOException
	{
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
		Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
		in = new StreamTokenizer(new BufferedReader(reader));
		out = new PrintWriter(writer);
		solve();
		out.flush();
	}

	void solve() throws IOException
	{
		int n = nextInt();
		for (int i = 1; i <= n; i++)
		{
			String row = nextStr();
			if (isRXCY(row))
				out.println(toColRow(row));
			else
				out.println(toRXCY(row));
		}
	}

	int nextInt() throws IOException
	{
		in.nextToken();
		return (int)in.nval;
	}

	String nextStr() throws IOException
	{
		in.nextToken();
		return (String)in.sval;
	}

	boolean isRXCY(String addr)
	{
		int idxOfR = addr.indexOf('R');
		int idxOfC = addr.indexOf('C');
		if (idxOfR != 0 || idxOfC <= 1) 
			return false;
		else 
		{
			for (int i = 1; i < idxOfC; i++)
			{
				char c = addr.charAt(i);
				if (c >= 'A' && c <= 'Z')
				{
					return false;
				}
			}
		}
		return true;
	}

	String toColRow(String addr)
	{
		int idxOfC = addr.indexOf('C');
		int colNo = Integer.parseInt(addr.substring(idxOfC + 1, addr.length()));

		String col = "";
		
		int q = colNo;
		do
		{
			int r = q % 26;
			q /= 26;
			if (r == 0)
				q--;
			col = (char)((int)'A' + ((r == 0) ? 26 : r) - 1) + col;
		} 
		while (q != 0);

		
		return col + addr.substring(1, idxOfC);
	}

	String toRXCY(String addr)
	{
		int colLen = 0;
		for (int i = 0; i < addr.length(); i++)
		{
			char c = addr.charAt(i);
			if (c >= '0' && c <= '9')
			{
				colLen = i;
				break;
			} else if (i == addr.length() - 1) 
			{
				colLen = addr.length();
				break;
			}
		}

		int colVal = 0;
		for (int i = colLen - 1, j = 0; i >= 0; i--, j++)
		{
			colVal += Math.pow(26, j) * (int)(addr.charAt(i) - 'A' + 1);
		}

		return "R" + addr.substring(colLen, addr.length()) + "C" + colVal;
	}
} 