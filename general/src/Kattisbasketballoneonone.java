import java.util.*;

public class Kattisbasketballoneonone {
	
	static Scanner in;
	
	static String line;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
				
		line = in.nextLine();
	}
	
	public static void solve() {
		
	}
	
	public static void output() {
		System.out.println(line.charAt(line.length()-2));
	}
}
