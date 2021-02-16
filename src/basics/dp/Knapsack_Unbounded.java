package basics.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack_Unbounded {
	public static void main(String[] subhani) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// #elements
		int W = Integer.parseInt(st.nextToken());// weight of bag
		int[] weights = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			weights[i] = Integer.parseInt(st.nextToken());
		int[] values = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			values[i] = Integer.parseInt(st.nextToken());
		ks(weights, values, n, W);
	}

	public static void ks(int[] weights, int[] values, int n, int W) {
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i <= n; ++i)
			dp[i][0] = 0;
		for (int j = 0; j <= W; ++j)
			dp[0][j] = 0;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= W; ++j) {
				if (weights[i - 1] <= j) {
					int included = values[i - 1] + dp[i][j - weights[i - 1]];
					int excluded = dp[i - 1][j];
					dp[i][j] = Math.max(included, excluded);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		print(dp, n, W);
		System.out.println(dp[n][W]);
	}

	public static void print(int[][] dp, int rows, int columns) {
		for (int i = 0; i <= rows; ++i) {
			for (int j = 0; j <= columns; ++j)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
}
//3 50
//10 20 30
//60 100 120
