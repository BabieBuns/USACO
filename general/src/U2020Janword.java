import java.util.*;
import java.io.*;

public class U2020Janword {

	static Scanner in;
	static PrintWriter out;

	static String essay;

	static int n, k;

	static String[] words;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new Scanner(new FileReader("word.in"));
		out = new PrintWriter("word.out");

		StringTokenizer st = new StringTokenizer(in.nextLine());

		essay = "";

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		words = new String[n];
		st = new StringTokenizer(in.nextLine());
		for (int i = 0; i < n; i++) {
			words[i] = st.nextToken();
		}

		in.close();
	}

	public static void solve() {
		String line = words[0];
		String word = "";
		
		essay = words[0];
		
		for (int i = 1; i < words.length; i++) {
			word = words[i];

			if (word.length() + line.length() <= k) {
				essay += " " + word;
				line += word;
			}
			else {
				line = "";
				essay += "\n";
				
				if (word.length() + line.length() <= k) {
					essay += word;
					line += word;
				}
			}
		}
	}

	public static void output() {
		out.print(essay);
		out.close();
	}
}
