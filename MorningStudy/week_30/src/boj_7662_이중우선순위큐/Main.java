package boj_7662_이중우선순위큐;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	static int T;
	static int Q;
	
	static char letter;
	static int number;
	
	static StringBuilder sb = new StringBuilder();
	
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			Q = sc.nextInt();
			
			map = new TreeMap<>();		// 모든 숫자 저장 정보
			
			for(int i = 0; i < Q; i++) {
				letter = sc.next().charAt(0);
				number = sc.nextInt();
				
				if(letter == 'I') {
					if(map.containsKey(number)) {
						map.put(number, map.get(number) + 1);
					} else {
						map.put(number, 1);
					}
				} else {		// letter = 'D'
					if(map.isEmpty()) {
						continue;
					}
					
					int target = 0;
					
					if(number == 1) {
						target = map.lastKey();
						if(map.containsKey(target)) {
							map.put(target, map.get(target) - 1);
							if(map.get(target) == 0) {
								map.remove(target);
							}
						}
					} else {	// number == -1
						target = map.firstKey();
						if(map.containsKey(target)) {
							map.put(target, map.get(target) - 1);
							if(map.get(target) == 0) {
								map.remove(target);
							}
						}
					}
				}
				
//				System.out.println(map.keySet());
			}
			
			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				Object[] arr = map.keySet().toArray();
				sb.append((Integer) arr[arr.length-1] + " " + (Integer) arr[0] + "\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
}
