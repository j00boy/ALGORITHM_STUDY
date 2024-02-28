package BOJ_11652_카드;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

//		File file = new File("src/BOJ_11652_카드/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 			// 1 <= N <= 100000
		long[] cards = new long[N];		// 카드를 담을 배열 생성
		
		// Long값을 담기 위한 HashMap 생성
		Map<Long, Integer> map = new HashMap<>();

		// test case 시작
		for (int i = 0; i < N; i++) {
			// - 2^62 <= num <= 2^62
			cards[i] = sc.nextLong();
		}
		
		
		for(int i = 0; i < N; i++) {
			if(map.isEmpty() || map.get(cards[i]) == null) {	// map이 비어있거나, 해당 키값이 null일 때,
				map.put(cards[i], 1);							// key값을 넣고 count = 1
			} else {
				int tmp = map.get(cards[i]);					// 키값 중복 X, 해당 키값의 count 반환
				map.replace(cards[i], tmp+1);					// value+1 하여 대체한다.
			}
		}
		
//		System.out.println(map);
		
		int maxCount = Integer.MIN_VALUE;						// 최빈수를 찾기 위한 변수 선언
		for(int n : map.values()) {
			if(n > maxCount) {
				maxCount = n;
			}
		}
		
		
		long minKey = Long.MAX_VALUE;							// 최빈수 중 가장 작은 값을 찾기 위함
		for(long key : map.keySet()) {
			if(map.get(key) == maxCount) {
				if(key < minKey) {
					minKey = key;
				}
			}
		}
		System.out.println(minKey);
		
//		}
//		 test case 끝
	}
}