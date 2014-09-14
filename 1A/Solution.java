import java.io.*;
import java.util.*;
import java.lang.Math;

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
		double widthOfArea = (double)nextInt();
		double heightOfArea = (double)nextInt();
		int sizeOfPlate = nextInt();
		long numberOfPlates = (long)(Math.ceil(widthOfArea / sizeOfPlate) * Math.ceil(heightOfArea / sizeOfPlate));
		out.print(numberOfPlates);
	}

	int nextInt() throws IOException
	{
		in.nextToken();
		return (int)in.nval;
	}
}