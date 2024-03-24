package boj_1759_암호만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int L;
	static int C;
	static char[] alphabets;
	static char[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		alphabets = new char[C];	// 전체 문자열
		sel = new char[L];			// 고른 문자를 저장할 배열
		
		for(int i = 0; i < C; i++) {
			alphabets[i] = sc.next().charAt(0);
		}
		
		// 'a' : 97
		
		Arrays.sort(alphabets);	// 사전 순을 위함 

		comb(0, 0);
		
		System.out.println(sb);
		
		
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx >= L) {		// 문자를 L개만큼 고르면
			int count = 0;	// 최소 자음 2개인지를 확인하기 위함
			String s = "";	// contains 함수 사용하려고 
			for(int i = 0; i < L; i++) {	
				if(sel[i] != 'a' &&  sel[i] != 'e' && sel[i] != 'i' && sel[i] != 'o' && sel[i] != 'u') {	// 자음이라면
					count++;	// 자음 갯수 확인
				}
				s += sel[i];
			}
			s += "\n";
			
			if(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {	// 모음을 1개라도 포함하고 있다면
				if(count >= 2) {	// 자음이 2개 이상이라면
					sb.append(s);	// 출력한다.
					return;
				} else {
					return;
				}
			} else {
				return;
			}
		}
		
		if(idx >= C) {		// 문자 L개만큼 안고르고 idx가 끝까지 가면 종료
			return;
		}
		
		sel[sidx] = alphabets[idx];		// 값 입력
		comb(idx + 1, sidx + 1);		// 넣고 다음꺼 고려
		comb(idx + 1, sidx);			// 안 넣었다고 치고 그 다음 숫자를 넣음
	}
}