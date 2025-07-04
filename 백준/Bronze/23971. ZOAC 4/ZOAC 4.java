import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();

		int countInACol = 0;
		for (int i = 0; i < H; i = i + N + 1) {
			countInACol += 1;
		}
		
		int countInARow = 0;
		for (int i = 0; i < W; i = i + M + 1) {
			countInARow += 1;
		}
		
		System.out.print(countInACol * countInARow);
	}
}