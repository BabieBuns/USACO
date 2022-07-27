import java.util.*;
import java.io.*;

public class shuffle {

	static BufferedReader in;
	static PrintWriter out;

	static int[] position;
	static int[] shuffle;
	static int[] id;
	static int[] output;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("shuffle.in"));
		out = new PrintWriter("shuffle.out");

		StringTokenizer st = new StringTokenizer(in.readLine());

		int cows = Integer.parseInt(st.nextToken());

		position = new int[cows];
		for (int i = 0; i < cows; i++) {
			position[i] = i;
		}

		shuffle = new int[cows];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < cows; i++) {
			shuffle[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		id = new int[cows];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < cows; i++) {
			id[i] = Integer.parseInt(st.nextToken());
		}

		output = new int[cows];
		
		in.close();
	}

	public static void solve() {
		for (int i = 0; i < 3; i++) {
			int[] temp = duplicate(position);
			for (int j = 0; j < position.length; j++) {
				position[shuffle[j]] = temp[j];
			}
		}

		for (int i = 0; i < id.length; i++) {
			output[i] = findId(id, position, i);
		}
	}

	public static void output() {
		for (int i = 0; i < output.length; i++) {
			out.println(output[i]);
		}
		
		out.close();
	}

	public static int[] duplicate(int[] original) {
		int[] duplicatedArray = new int[original.length];

		for (int i = 0; i < position.length; i++) {
			duplicatedArray[i] = original[i];
		}

		return duplicatedArray;
	}

	public static int findId(int[] id, int[] position, int targetedIndex) {
		int i = 0;

		while (position[i] != targetedIndex) {
			i++;
		}

		return id[i];
	}
}
