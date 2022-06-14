import java.util.*;
import java.io.*;

public class U2016Janpromote {
	
	static BufferedReader in;
	static PrintWriter out;
	
	static int silverPromotions = 0;
	static int goldPromotions = 0;
	static int platinumPromotions = 0;
	
	static int bronzeBefore = 0;
	static int bronzeAfter = 0;
	static int silverBefore = 0;
	static int silverAfter = 0;
	static int goldBefore = 0;
	static int goldAfter = 0;
	static int platinumBefore = 0;
	static int platinumAfter = 0;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("promote.in"));
		out = new PrintWriter("promote.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		bronzeBefore = Integer.parseInt(st.nextToken());
		bronzeAfter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		silverBefore = Integer.parseInt(st.nextToken());
		silverAfter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		goldBefore = Integer.parseInt(st.nextToken());
		goldAfter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		platinumBefore = Integer.parseInt(st.nextToken());
		platinumAfter = Integer.parseInt(st.nextToken());
		in.close();
	}
	
	public static void solve() {
		platinumPromotions = platinumAfter-platinumBefore;
		goldPromotions = goldAfter-goldBefore + platinumPromotions;
		silverPromotions = silverAfter-silverBefore + goldAfter-goldBefore + platinumPromotions;
	}
	
	public static void output() {
		out.println(silverPromotions);
		out.println(goldPromotions);
		out.println(platinumPromotions);
		out.close();
	}
}
