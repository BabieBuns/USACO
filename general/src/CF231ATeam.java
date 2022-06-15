import java.util.*;
import java.io.*;

public class CF231ATeam {
	
	static Scanner in;
	
	static int output = 0;
	static int n;
	static int [][] friends;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();
		friends = new int [n][3];
		StringTokenizer st = new StringTokenizer("");
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.nextLine());
			for (int j = 0; j < 3; j++) {
				friends[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
	}
	
	public static void solve() {
		for (int i = 0; i < n; i++) {
			int confidentSolutions = 0;
			for (int j = 0; j < 3; j++) {
				if (friends[i][j] == 1) {
					confidentSolutions++;
				}
			}
			if (confidentSolutions >= 2) {
				output++;
			}
		}
	}

	public static void output() {
		System.out.println(output);
	}
}
