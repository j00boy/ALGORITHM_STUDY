package swea_6808_규영이와인영이의카드게임;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int[] 규영 = new int[9];
	static int[] 인영 = new int[9];
	static boolean[] visited = new boolean[9];
	static int[] result = new int[9];
	static int N = 9;
	static int 규영Win;
	static int 규영Lose;
	
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_6808_규영이와인영이의카드게임/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			규영Win = 0;
			규영Lose = 0;
			
			// 규영이의 패 입력, 고정된 순서
			for(int i = 0; i < 9; i++) {
				규영[i] = sc.nextInt();
			}
			
			// 인영이가 갖는 패, 일단 오름차순 정렬
			int index = 0;
			for(int i = 1; i <= 18; i++) {
				boolean flag = true;
				for(int j = 0; j < 9; j++) {
					if(i == 규영[j]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					인영[index++] = i;
				}
			}
			
			// 인영이의 가능한 조합 수 연산
			perm(0);
			
			System.out.printf("#%d %d %d\n", tc, 규영Win, 규영Lose);
			
		}
		// test case
		
	}
	
	public static void perm(int idx) {
		if(idx == N) {
			battle(규영, result);
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) {
				continue;
			}
			
			result[idx] = 인영[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
	
	public static void battle(int[] arr1, int[] arr2) {
		int score1 = 0;
		int score2 = 0;
		for(int i = 0; i < 9; i++) {
			if(arr1[i] > arr2[i]) {
				score1 += arr1[i] + arr2[i];
			} else {
				score2 += arr1[i] + arr2[i];
			}
		}
		
		if(score1 > score2) {
			규영Win++;
		} else {
			규영Lose++;
		}
	}
	
}