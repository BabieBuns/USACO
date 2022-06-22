import java.util.*;
import java.io.*;

public class billboard {
	
	static BufferedReader in;
	static PrintWriter out;
	
	static int b1x1;
	static int b1y1;
	static int b1x2;
	static int b1y2;
	
	static int b2x1;
	static int b2y1;
	static int b2x2;
	static int b2y2;
	
	static int tx1;
	static int ty1;
	static int tx2;
	static int ty2;
	
	static int area;
	
	public static void main (String [] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		StringTokenizer st;
		
		in = new BufferedReader(new FileReader("billboard.in"));
		out = new PrintWriter("billboard.out");
		
		st = new StringTokenizer(in.readLine());
		b1x1 = Integer.parseInt(st.nextToken()) + 1000;
		b1y1 = Integer.parseInt(st.nextToken()) + 1000;
		b1x2 = Integer.parseInt(st.nextToken()) + 1000;
		b1y2 = Integer.parseInt(st.nextToken()) + 1000;
		
		st = new StringTokenizer(in.readLine());
		b2x1 = Integer.parseInt(st.nextToken()) + 1000;
		b2y1 = Integer.parseInt(st.nextToken()) + 1000;
		b2x2 = Integer.parseInt(st.nextToken()) + 1000;
		b2y2 = Integer.parseInt(st.nextToken()) + 1000;
		
		st = new StringTokenizer(in.readLine());
		tx1 = Integer.parseInt(st.nextToken()) + 1000;
		ty1 = Integer.parseInt(st.nextToken()) + 1000;
		tx2 = Integer.parseInt(st.nextToken()) + 1000;
		ty2 = Integer.parseInt(st.nextToken()) + 1000;
		
		area = 0;
		
		in.close();
	}
	
	public static void solve() {
		int [][] view = new int[2000][2000];
		
		for (int i = b1x1; i < b1x2; i++) {
			for (int j = b1y1; j < b1y2; j++) {
				view[i][j] = 1;
			}
		}
		
		for (int i = b2x1; i < b2x2; i++) {
			for (int j = b2y1; j < b2y2; j++) {
				view[i][j] = 1;
			}
		}
		
		for (int i = tx1; i < tx2; i++) {
			for (int j = ty1; j < ty2; j++) {
				view[i][j] = 0;
			}
		}
		
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				if (view[i][j] == 1) {
					area++;
				}
			}
		}
		
	}
	
	public static void output() {
		out.print(area);
		out.close();
	}
}
