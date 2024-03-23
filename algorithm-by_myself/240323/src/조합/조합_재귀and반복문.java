package 조합;

import java.util.Arrays;

public class 조합_재귀and반복문 {
	
	static int N, R;
	static String[] materials;
	static String[] inputs;
	
	public static void main(String[] args) {
		
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		R = 2;
		inputs = new String[R];
		
		combination(0, 0);
		

	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= R) {
			System.out.println(Arrays.toString(inputs));
			return;
		}
		
		for(int i = idx; i <= N - R + sidx; i++) {
			inputs[sidx] = materials[i];
			combination(i+1, sidx+1);
		}
	}
	
}
