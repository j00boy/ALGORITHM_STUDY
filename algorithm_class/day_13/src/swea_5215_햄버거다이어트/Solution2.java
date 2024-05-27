package swea_5215_햄버거다이어트;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	
	static int N;
	static int L;
	static List<Integer> listCal = new ArrayList<>();
	static List<Integer> listScore = new ArrayList<>();
	static int[] sel;	// 재료의 사용유무를 저장하기 위한 boolean 배열
	static int[] scores;
	static int[] calories;
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_5215_햄버거다이어트/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();	// 재료 수
			L = sc.nextInt();	// 제한 칼로리
			
			sel = new int[N];
			scores = new int[N];
			calories = new int[N];
			
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			int maxScore = 0;
			for(int i = 0; i <= N; i++) {
				combinationCal(i, 0, 0);
				combinationScore(i, 0, 0);
				
//				for(int j = 0; j < listCal.size(); j++) {
//					if(listCal.get(i) < 1000) {
//						int t = listScore.get(i);
//						
//						if(t > maxScore) {
//							maxScore = t;
//						}
//					}
//				}
				
				for(int a = 0; a < listCal.size(); a++) {
					if(listCal.get(a) <= L) {
						if(listScore.get(a) > maxScore) {
							maxScore = listScore.get(a);
						}
					}
				}
				
				listCal.clear();
				listScore.clear();
				
			}

			System.out.printf("#%d %d\n", tc, maxScore);
			
		}
		// test case
	}
	
	public static void combinationScore(int target, int idx, int sidx) {
		// 재료를 다 뽑았다면
		if(sidx == target) {
			int tmp = 0;
			for(int i = 0; i < N; i++) {
				tmp += sel[i];
			}
			
			listScore.add(tmp);
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		// 재료를 넣었다.
		sel[sidx] = scores[idx];
		combinationScore(target, idx + 1, sidx + 1);
		
		// 재료를 안 넣었다.
		combinationScore(target, idx + 1, sidx);
	}
	
	public static void combinationCal(int target, int idx, int sidx) {
		// 재료를 다 뽑았다면
		if(sidx == target) {
			int tmp = 0;
			for(int i = 0; i < N; i++) {
				tmp += sel[i];
			}
			
			listCal.add(tmp);
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		// 재료를 넣었다.
		sel[sidx] = calories[idx];
		combinationCal(target, idx + 1, sidx + 1);
		
		// 재료를 안 넣었다.
		combinationCal(target, idx + 1, sidx);
	}
	
}