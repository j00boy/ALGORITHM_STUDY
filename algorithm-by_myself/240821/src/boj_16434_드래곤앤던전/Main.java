package boj_16434_드래곤앤던전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Room {
		int t;
		int a;
		int h;
		
		public Room(int t, int a, int h) {
			this.t = t;
			this.a = a;
			this.h = h;
		}
	}
	
	static int N;
	static int ATK;
	static Room[] rooms;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ATK = Integer.parseInt(st.nextToken());
		
		rooms = new Room[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			rooms[i] = new Room(t, a, h);
		}
		
		long left = 1;
		long right = Long.MAX_VALUE - 1;
		
		while(left <= right) {
//			System.out.println("left : right = " + left + " " + right);
			long mid = (left + right) / 2;
			long currATK = ATK;
			long currHP = mid;
			boolean isAlive = true;
			
			for(int i = 0; i < N - 1; i++) {
				if(rooms[i].t == 1) {	// 몬스터가 있는 방이면 HP--
					int monsterATK = rooms[i].a;
					int monsterHP = rooms[i].h;
					
					// 몬스터가 죽기 전까지 싸움
//					while(true) {
//						monsterHP -= currATK;
//						
//						if(monsterHP <= 0) {
//							break;
//						}
//						
//						currHP -= monsterATK;
//						if(currHP <= 0) {
//							isAlive = false;
//							break;
//						}
//					}
					
					if(monsterHP % currATK == 0) {
						currHP -= monsterATK * (monsterHP / currATK - 1);
					} else {
						currHP -= monsterATK * (monsterHP / currATK);
					}
					
					if(currHP <= 0) {
						isAlive = false;
					}
					
					// 용사가 죽었다면, left = mid + 1;
					if(!isAlive) {
						left = mid + 1;
						break;
					}
					
				} else if(rooms[i].t == 2) {			// 포션이 있는 방이면 HP++, STR++
					int addATK = rooms[i].a;
					int addHP = rooms[i].h;
					
					currATK += addATK;
					currHP += addHP;
					if(currHP > mid) {
						currHP = mid;
					}
				}
			}
			
			int dragonATK = rooms[N-1].a;
			int dragonHP = rooms[N-1].h;
			
//			while(true) {
//				dragonHP -= currATK;
//				
//				if(dragonHP <= 0) {
//					break;
//				}
//				
//				currHP -= dragonATK;
//				if(currHP <= 0) {
//					break;
//				}
//			}
			
			if(dragonHP % currATK == 0) {
				currHP -= dragonATK * (dragonHP / currATK - 1);
			} else {
				currHP -= dragonATK * (dragonHP / currATK);
			}
			
			if(currHP <= 0) {
				isAlive = false;
			}
			
			if(!isAlive) {
				left = mid + 1;
			} else {	
				right = mid - 1;
			}
			
		}
		
		System.out.println(right + 1);
		
	}
}
