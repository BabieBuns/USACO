import java.util.*;
import java.io.*;

public class cowsignal {

	static BufferedReader in;
	static PrintWriter out;

	static int M;
	static int N;
	static int K;

	static String[][] signal;
	static String[][] enlargedSignal;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("cowsignal.in"));
		out = new PrintWriter("cowsignal.out");

		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		signal = new String[M][N];

		for (int i = 0; i < M; i++) {
			String temp = in.readLine();
			for (int j = 0; j < N; j++) {
				signal[i][j] = temp.substring(j, j + 1);
			}
		}

		enlargedSignal = new String[K * M][K * N];

		in.close();
	}

	public static void solve() {
		for (int i = 0; i < K * M; i++) {
			for (int j = 0; j < K * N; j++) {
				enlargedSignal[i][j] = signal[i / K][j / K];
			}
		}
	}

	public static void output() {
		for (int i = 0; i < K * M; i++) {
			for (int j = 0; j < K * N; j++) {
				out.print(enlargedSignal[i][j]);
			}
			out.println();
		}
		
		out.close();
	}
}
