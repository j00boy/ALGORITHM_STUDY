package 조합;

public class 조합_반복문 {
	
	static int N, R;
	static String[] materials;
	static String[] inputs;
	
	public static void main(String[] args) {
		
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		R = 2;
		inputs = new String[R];
		
		for(int i = 0; i < N-1; i++) {
			for(int j = i + 1; j < N; j++) {
				System.out.println(materials[i] + " " + materials[j]);
			}
		}
		

	}
	
}
