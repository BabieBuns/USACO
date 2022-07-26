import java.util.*;
import java.io.*;

public class lostcow {

	static Scanner in;
	static PrintWriter out;

	static int x;
	static int y;

	static int output;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new Scanner(new FileReader("lostcow.in"));
		out = new PrintWriter("lostcow.out");

		x = in.nextInt();
		y = in.nextInt();

		output = 0;

		in.close();

	}

	public static void solve() {
		int farmerPosition = x;
		int destination = 0;
		int leftPosition = 0;
		int rightPosition = 0;
		int index = 1;

		while (true) {
			destination = x + index;
			leftPosition = Math.min(farmerPosition, destination);
			rightPosition = Math.max(farmerPosition, destination);

			if (leftPosition <= y && y <= rightPosition) {
				output += Math.abs(y-farmerPosition);
				break;
			}
			
			index *= -2;
			output += rightPosition - leftPosition;
			farmerPosition = destination;
		}
	}

	public static void output() {
		out.println(output);
		out.close();
	}
}
