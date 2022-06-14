import java.util.*;

public class U2020Decabc {
	
	static Scanner in;
	
	static int a;
	static int b;
	static int c;
	static int [] numbers = new int [7];
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.nextLine());
		for (int i = 0; i < 7; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void solve() {
		Arrays.sort(numbers);
		int abc = numbers[6];
		a = numbers[0];
		b = numbers[1];
		c = abc - a - b;
		
	}
	
	public static void output() {
		System.out.println(a + " " + b + " " + c);
	}
}
