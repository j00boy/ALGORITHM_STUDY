package 조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_재귀호출and리스트 {
	
	static int N, R;
	static String[] materials;
	static String[] inputs;
	static List<String[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		R = 2;
		inputs = new String[R];
		
		combination(0, 0);
		
		for(String[] s : list) {
			System.out.println(Arrays.toString(s));
		}

	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= R) {
			// deep copy가 필요함
			String[] tmp = new String[R];
			for(int i = 0; i < R; i++) {
				tmp[i] = inputs[i];
			}
			
			list.add(tmp);
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
