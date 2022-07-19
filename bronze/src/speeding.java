import java.util.*;
import java.io.*;

public class speeding {

	static BufferedReader in;
	static PrintWriter out;

	static int N;
	static int M;

	static int[] roadSegment;
	static int[] bessieSegment;

	static int output;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		StringTokenizer st;

		in = new BufferedReader(new FileReader("speeding.in"));
		out = new PrintWriter("speeding.out");

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int beginning = 0;
		int end = 0;
		int speed = 0;
		roadSegment = new int[100];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			end += Integer.parseInt(st.nextToken());
			speed = Integer.parseInt(st.nextToken());

			for (int j = beginning; j < end; j++) {
				roadSegment[j] = speed;
			}

			beginning = end;
		}

		beginning = 0;
		end = 0;
		speed = 0;
		bessieSegment = new int[100];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			end += Integer.parseInt(st.nextToken());
			speed = Integer.parseInt(st.nextToken());

			for (int j = beginning; j < end; j++) {
				bessieSegment[j] = speed;
			}

			beginning = end;
		}

		output = 0;

		in.close();
	}

	public static void solve() {
		int speed = 0;

		for (int i = 0; i < 100; i++) {
			if (bessieSegment[i] > roadSegment[i]) {
				speed = bessieSegment[i] - roadSegment[i];
				if (speed > output) {
					output = speed;
				}
			}
		}
	}

	public static void output() {
		out.println(output);
		out.close();
	}
}
