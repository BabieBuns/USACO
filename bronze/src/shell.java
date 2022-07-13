import java.util.*;
import java.io.*;

public class shell {

	static BufferedReader in;
	static PrintWriter out;

	static int N;

	static int[][] line;

	static int[] guesses;

	static int output;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("shell.in"));
		out = new PrintWriter("shell.out");

		N = Integer.parseInt(in.readLine());

		line = new int[N][3];

		guesses = new int[3];

		output = -1;
		
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
			line[i][2] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
	}

	public static void solve() {
		char[] board = new char[3];
		int guess = 0;

		// If rock is under 1st one
		board[0] = 'p';
		board[1] = 'b';
		board[2] = 'b';
		for (int i = 0; i < line.length; i++) {
			int a = line[i][0] - 1;
			int b = line[i][1] - 1;
			int g = line[i][2] - 1;
			char tempA = board[a];
			char tempB = board[b];

			board[a] = tempB;
			board[b] = tempA;

			if (board[g] == 'p') {
				guess++;
			}
		}
		guesses[0] = guess;
		guess = 0;

		// If rock is under 2nd one
		board[0] = 'b';
		board[1] = 'p';
		board[2] = 'b';
		for (int i = 0; i < line.length; i++) {
			int a = line[i][0] - 1;
			int b = line[i][1] - 1;
			int g = line[i][2] - 1;
			char tempA = board[a];
			char tempB = board[b];

			board[a] = tempB;
			board[b] = tempA;

			if (board[g] == 'p') {
				guess++;
			}
		}
		guesses[1] = guess;
		guess = 0;

		// If rock is under 3rd one
		board[0] = 'b';
		board[1] = 'b';
		board[2] = 'p';
		for (int i = 0; i < line.length; i++) {
			int a = line[i][0] - 1;
			int b = line[i][1] - 1;
			int g = line[i][2] - 1;
			char tempA = board[a];
			char tempB = board[b];

			board[a] = tempB;
			board[b] = tempA;

			if (board[g] == 'p') {
				guess++;
			}
		}
		guesses[2] = guess;
		guess = 0;
		
		// Determine the greatest number of guesses
		for (int i = 0; i < 3; i++) {
			if (guesses[i] > output) {
				output = guesses[i];
			}
		}
	}

	public static void output() {
		out.print(output);
		out.close();
	}
}
