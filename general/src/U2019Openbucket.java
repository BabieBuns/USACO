import java.util.*;
import java.io.*;

public class U2019Openbucket {
	
	static Scanner in;
	static PrintWriter out;
	
	static String[][] barn;
	static int cows;
	static int barnRow;
	static int barnCol;
	static int rockRow;
	static int rockCol;
	static int lakeRow;
	static int lakeCol;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException {
		in = new Scanner(new File("buckets.in"));
		out = new PrintWriter("buckets.out");
		
		barn = new String[10][10];
		cows = 0;
		
		for (int i = 0; i < 10; i++) {
			String row = in.nextLine();
			for (int j = 0; j < 10; j++) {
				barn[i][j] = row.substring(j, j+1);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (barn[i][j].equals("B")) {
					barnRow = i;
					barnCol = j;
				}
				if (barn[i][j].equals("R")) {
					rockRow = i;
					rockCol = j;
				}
				if (barn[i][j].equals("L")) {
					lakeRow = i;
					lakeCol = j;
				}
			}
		}
		in.close();
	}
	
	public static void solve() {
		int minRow = Math.min(barnRow, lakeRow);
		int maxRow = Math.max(barnRow, lakeRow);
		int minCol = Math.min(barnCol, lakeCol);
		int maxCol = Math.max(barnCol, lakeCol);
		
		if (barnRow == lakeRow && barnRow == rockRow && lakeRow == rockRow) {
			if (rockCol < minCol || rockCol > maxCol) {
				cows += Math.abs(barnCol-lakeCol);
			}
			else {
				cows += Math.abs(barnCol-lakeCol)-1 + 3;
			}
		}
		else if (barnCol == lakeCol && barnCol == rockCol && lakeCol == rockCol) {
			if (rockRow < minRow || rockRow > maxRow) {
				cows += Math.abs(barnRow-lakeRow);
			}
			else {
				cows += Math.abs(barnRow-lakeRow)-1 + 3;
			}
		}
		else if (barnRow == lakeRow) {
			cows += Math.abs(barnCol-lakeCol);
		}
		else if (barnCol == lakeCol) {
			cows += Math.abs(barnRow-lakeRow);
		}
		else {
			cows += Math.abs(barnRow-lakeRow);
			cows += Math.abs(barnCol-lakeCol);
		}
		
		cows-=1;
	}
	
	public static void output() {
		out.println(cows);
		out.close();
	}
}
