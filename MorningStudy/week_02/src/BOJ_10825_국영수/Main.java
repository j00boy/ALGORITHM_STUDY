package BOJ_10825_국영수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] info = new String[N];
		String[] names = new String[N];
		int[] korean = new int[N];
		int[] english = new int[N];
		int[] math = new int[N];
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			info[i] = s;
			String[] arr = s.split(" ");
			
			names[i] = arr[0];
			korean[i] = Integer.parseInt(arr[1]);
			english[i] = Integer.parseInt(arr[2]);
			math[i] = Integer.parseInt(arr[3]);
		}
		
		for(int i = 0; i < N; i++) {
			
		}
		
		// 국어점수 내림차순
//		for(int i = 0; i < koreanScores.length - 1; i++) {
//			int maxIdx = i;
//			for(int j = i + 1; j < koreanScores.length; j++) {
//				if(koreanScores[j] > koreanScores[maxIdx]) {
//					maxIdx = j;
//				}
//			}
//			int tmpK = koreanScores[i];
//			int tmpE = englishScores[i];
//			int tmpM = mathScores[i];
//			String tmp = names[i];
//			
//			koreanScores[i] = koreanScores[maxIdx];
//			englishScores[i] = englishScores[maxIdx];
//			mathScores[i] = mathScores[maxIdx];
//			names[i] = names[maxIdx];
//			
//			koreanScores[maxIdx] = tmpK;
//			englishScores[maxIdx] = tmpE;
//			mathScores[maxIdx] = tmpM;
//			names[maxIdx] = tmp;
//		}
		
		
		
	}
	
	// 오름차순 정렬
	public static void ascendingSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}
	
	// 내림차순 정렬
	public static void descendingSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int maxIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] > arr[maxIdx]) {
					maxIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = tmp;
		}
	}
}