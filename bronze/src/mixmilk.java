import java.util.*;
import java.io.*;

public class mixmilk {
	
	static BufferedReader in;
	static PrintWriter out;
	
	static long c1;
	static long m1;
	
	static long c2;
	static long m2;
	
	static long c3;
	static long m3;
	
	static String output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException {
		in = new BufferedReader (new FileReader("mixmilk.in"));
		out = new PrintWriter("mixmilk.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		c1 = Long.parseLong(st.nextToken());
		m1 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		c2 = Long.parseLong(st.nextToken());
		m2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		c3 = Long.parseLong(st.nextToken());
		m3 = Long.parseLong(st.nextToken());
		
		output = "";
		
		in.close();
	}
	
	public static void solve() {
		long [] buckets = {m1, m2, m3};
		long [] capacities = {c1, c2, c3};
		
		for (int i = 0; i < 33; i++) {
			//Step 1:
			long aEmpty = buckets[0];
			long bFull = capacities[1] - buckets[1];
			
			if (aEmpty < bFull) {
				buckets[1] += aEmpty;
				buckets[0] -= aEmpty;
			}
			else if (bFull < aEmpty) {
				buckets[1] += bFull;
				buckets[0] -= bFull;
			}
			else {
				buckets[1] += aEmpty;
				buckets[0] -= aEmpty;
			}
			
			//Step 2:
			aEmpty = buckets[1];
			bFull = capacities[2] - buckets[2];
			
			if (aEmpty < bFull) {
				buckets[2] += aEmpty;
				buckets[1] -= aEmpty;
			}
			else if (bFull < aEmpty) {
				buckets[2] += bFull;
				buckets[1] -= bFull;
			}
			else {
				buckets[2] += aEmpty;
				buckets[1] -= aEmpty;
			}
			
			//Step 3:
			aEmpty = buckets[2];
			bFull = capacities[0] - buckets[0];
			
			if (aEmpty < bFull) {
				buckets[0] += aEmpty;
				buckets[2] -= aEmpty;
			}
			else if (bFull < aEmpty) {
				buckets[0] += bFull;
				buckets[2] -= bFull;
			}
			else {
				buckets[0] += aEmpty;
				buckets[2] -= aEmpty;
			}
		}
		
		//100th time
		long aEmpty = buckets[0];
		long bFull = capacities[1] - buckets[1];
		
		if (aEmpty < bFull) {
			buckets[1] += aEmpty;
			buckets[0] -= aEmpty;
		}
		else if (bFull < aEmpty) {
			buckets[1] += bFull;
			buckets[0] -= bFull;
		}
		else {
			buckets[1] += aEmpty;
			buckets[0] -= aEmpty;
		}
		
		output = buckets[0] + "\n" + buckets[1] + "\n" + buckets[2];
	}
	
	public static void output() {
		out.print(output);
		out.close();
	}
}
