import java.util.*;
import java.io.*;

public class square {
	
	static BufferedReader in;
	static PrintWriter out;
	
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	
	static int X1;
	static int Y1;
	static int X2;
	static int Y2;
	
	static int length;
	
	public static void main (String [] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException {
		StringTokenizer st;
		
		in = new BufferedReader(new FileReader("square.in"));
		out = new PrintWriter ("square.out");
		
		st = new StringTokenizer(in.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		X1 = Integer.parseInt(st.nextToken());
		Y1 = Integer.parseInt(st.nextToken());
		X2 = Integer.parseInt(st.nextToken());
		Y2 = Integer.parseInt(st.nextToken());
		
		length = 0;
		
		in.close();
	}
	
	public static void solve() {
		int lowerCornerX = Math.min(Math.min(x1, x2), Math.min(X1, X2));
		int lowerCornerY = Math.min(Math.min(y1, y2), Math.min(Y1, Y2));
		int upperCornerX = Math.max(Math.max(x1, x2), Math.max(X1, X2));
		int upperCornerY = Math.max(Math.max(y1, y2), Math.max(Y1, Y2));
		
		findLength(lowerCornerX, lowerCornerY, upperCornerX, upperCornerY);
	}
	
	public static void output() {
		out.print(length*length);
		out.close();
	}
	
	public static void findLength(int lowerCornerX, int lowerCornerY, int upperCornerX, int upperCornerY) {
		if ((lowerCornerX+length) >= upperCornerX && (lowerCornerY+length) >= upperCornerY) {
		}
		else {
			length++;
			findLength(lowerCornerX, lowerCornerY, upperCornerX, upperCornerY);
		}
	}
}
