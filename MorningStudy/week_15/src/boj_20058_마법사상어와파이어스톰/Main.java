package boj_20058_마법사상어와파이어스톰;

import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int side;
	static int N; // 크기 지수
	static int Q; // 파이어스톰 시전 횟수
	static int[][] map;
	static int[][] copied;
	static int sum;
	static int max;
	static int L; // 시전 단계
	static int Lside;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sum = 0;
		max = 0;

		N = sc.nextInt();
		Q = sc.nextInt();

		side = (int) Math.pow(2, N);

		map = new int[side][side];
		copied = new int[side][side];

		for (int r = 0; r < side; r++) {
			for (int c = 0; c < side; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		print(map);

		for (int i = 0; i < Q; i++) {
			L = sc.nextInt();
			Lside = (int) Math.pow(2, L);
			divideAndRotate(Lside);
			print(copied);
		}

//		print(copied);

	}

	static void divideAndRotate(int part) {
		for (int r = 0; r < side; r += part) {
			for (int c = 0; c < side; c += part) {
				for (int i = r; i < r + part; i++) {
					for (int j = c; j < c + part; j++) {
						// 아 왜 안돌아 
//						System.out.println("(" + i + ", " + j + ")");
					}
				}
			}
		}
	}

	static void print(int[][] arr) {
		System.out.println("----------------------");
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

}