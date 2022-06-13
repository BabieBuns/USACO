import java.util.*;
import java.io.*;

public class U2018Febteleportation {
	static Scanner in;
	static StringTokenizer st;
	static PrintWriter out;
	
	static int a, b, x, y;
	static int totalDistance;
	
	public static void main (String [] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new Scanner(new File("teleport.in"));
		out = new PrintWriter("teleport.out");
		
		st = new StringTokenizer(in.nextLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		in.close();
	}
	
	public static void solve() {
		totalDistance = 0;
		
		int AB = Math.abs(a-b);
		int AX = Math.abs(a-x) + Math.abs(b-y);
		int AY = Math.abs(a-y) + Math.abs(b-x);
		
		if (AB < AX && AB < AY) {
			totalDistance = AB;
		}
		if (AX < AB && AX < AY) {
			totalDistance = AX;
		}
		if (AY < AB && AY < AX) {
			totalDistance = AY;
		}
	}
	
	public static void output() {
		out.println(totalDistance);
		out.close();
	}
}
