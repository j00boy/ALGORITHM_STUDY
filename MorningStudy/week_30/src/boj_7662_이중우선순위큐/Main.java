package boj_7662_이중우선순위큐;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int T;
	static int Q;
	
	static char letter;
	static int number;
	
	static PriorityQueue<Integer> maxHeap;
	static PriorityQueue<Integer> minHeap;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			Q = sc.nextInt();
			
			maxHeap = new PriorityQueue(Collections.reverseOrder());	// 내림차순
			minHeap = new PriorityQueue();								// 오름차순
			map = new HashMap<>();										// 모든 숫자 저장 정보
			
			for(int i = 0; i < Q; i++) {
				letter = sc.next().charAt(0);
				number = sc.nextInt();
				
				if(letter == 'I') {
					maxHeap.add(number);
					minHeap.add(number);
					if(map.containsKey(number)) {
						map.put(number, map.get(number) + 1);
					} else {
						map.put(number, 1);
					}
				} else {
					
					if(map.size() == 0) {
						continue;
					}
					
					int target = 0;
					if(number == 1) {	// max값을 지움
						while(true) {
							target = maxHeap.poll();
							if(map.containsKey(target)) {		// 저장 정보에 아직 남아 있다면, 정보 수정
								if(map.get(target) == 1) {
									map.remove(target);
								} else {
									map.put(target, map.get(target) - 1);
								}
								break;
							}
						}
					} else {	// min
						while(true) {
							target = minHeap.poll();
							if(map.containsKey(target)) {
								if(map.get(target) == 1) {
									map.remove(target);
								} else {
									map.put(target, map.get(target) - 1);
								}
								break;
							}
						}
					}
				}
				
			}
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				int max = 0;
				int min = 0;
				
				while(true) {
					max = maxHeap.poll();
					if(map.containsKey(max)) {
						if(map.get(max) == 1) {
							map.remove(max);
						} else {
							map.put(max, map.get(max) - 1);
						}
						break;
					}
				}
				
				if(map.isEmpty()) {
					min = max;
					System.out.println(max + " " + min);
					continue;
				}
				
				while(true) {
					min = minHeap.poll();
					if(map.containsKey(min)) {
						if(map.get(min) == 1) {
							map.remove(min);
						} else {
							map.put(min, map.get(min) - 1);
						}
						break;
					}
				}
				
				System.out.println(max + " " + min);
			}
			
		}
		
	}
}
