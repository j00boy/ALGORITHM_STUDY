package 조합;

import java.util.Arrays;

public class 조합_재귀호출 {
	
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
		
		if(idx >= N) {
			return;
		}
		
		inputs[sidx] = materials[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);			// 덮어 씌움
	}
}
