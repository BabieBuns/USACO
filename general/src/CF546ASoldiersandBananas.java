import java.util.*;

public class CF546ASoldiersandBananas {
	
	static int k,n,w;
	static int output;
	static Scanner in;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		k = in.nextInt();
		n = in.nextInt();
		w = in.nextInt();
		
		in.close();
	}
	
	public static void solve() {
		int totalPrice = 0;
		
		for (int i = 1; i <= w; i++) {
			totalPrice += i * k;
		}
		
		if (totalPrice <= n) {
			output = 0;
		}
		else {
			output = totalPrice - n;
		}
	}
	
	public static void output() {
		System.out.println(output);
	}
}
