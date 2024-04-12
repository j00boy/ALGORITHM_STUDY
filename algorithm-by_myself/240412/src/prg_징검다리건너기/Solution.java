package prg_징검다리건너기;

import java.util.Scanner;

public class Solution {
	
	static int[] D;			// DP 배열
	static int[] stones;	// 디딤돌에 적힌 숫자가 순서대로 담긴 배열
	static int k;			// 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수
	
	public static int solution(int[] stones, int k) {
		int answer = 0;
		
		D = new int[stones.length];
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		stones = new int[] {2,4,5,3,2,1,4,2,5,1};
		k = 3;
		
		
		
		System.out.println(solution(stones, k));
	}
}
