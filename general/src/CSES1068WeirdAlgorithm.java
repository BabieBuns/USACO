import java.util.*;

public class CSES1068WeirdAlgorithm {
	
	static Scanner in;
	
	static long n;
	
	static StringBuilder output;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		n = in.nextLong();
		
		output = new StringBuilder();
	}
	
	public static void solve() {
		output.append(n);
		
		long num = n;
		
		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
			}
			else {
				num *= 3;
				num += 1;
			}
			output.append(" ").append(num);
		}
	}
	
	public static void output() {
		System.out.println(output.toString());
	}
}
