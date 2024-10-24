package boj_16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static char[][] map;
	static int[][] zone;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		zone = new int[N][M];

		for (int r = 0; r < N; r++) {
			char[] arr = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = arr[c];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				zone[r][c] = 10000 * r + c;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int row = r;
				int col = c;
				switch (map[r][c]) {
				case 'U':
					row -= 1;
					break;
				case 'D':
					row += 1;
					break;
				case 'L':
					col -= 1;
					break;
				default:
					col += 1;
					break;
				}
				union(zone[r][c], zone[row][col]); 
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				set.add(find(zone[r][c]));
			}
		}

		System.out.println(set.size());
	}

	public static int find(int n) {
		int r = n / 10000;
		int c = n % 10000;

		if (zone[r][c] != 10000 * r + c) {
			zone[r][c] = find(zone[r][c]);
		}

		return zone[r][c];
	}

	public static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a != b) {
			zone[b / 10000][b % 10000] = a;
		}
	}
}
