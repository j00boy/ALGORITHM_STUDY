package boj_1541_잃어버린괄호;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String exp = sc.next();
		
		/* [ 내 test case]
		 * 50-40+30-20
		 * [50, 40+30, 20]
		 */
		
		int result = 0;
		
		String[] arr = exp.split("\\-");	// '-'로 표현식을 구분하고,
		int[] nums = new int[arr.length];	// 값 연산을 위해 같은 크기의 int 배열도 만든다.
		
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].contains("+")) {		// '+'가 없는 그냥 숫자만 있다면 
				nums[i] = Integer.parseInt(arr[i]);	// 그대로 대입 
			} else {		// '+'로 구분한 배열을 만든 뒤 각 원소들을 숫자로 치환하여 더해준다.
				String[] tmp = arr[i].split("\\+");		// 특수문자들은 역슬래쉬 2개를 붙여줘야 에러가 발생하지 않는다.
				int sum = 0;
				for(String s : tmp) {
					sum += Integer.parseInt(s);
				}
				nums[i] = sum;
			}
		}
		
		result = nums[0];

		// 음수로 나누었기 때문에, nums[0]에서 뒤에 나오는 원소들을 전부 빼주면 최솟값
		for(int i = 1; i < nums.length; i++) {
			result -= nums[i];
		}
		
		System.out.println(result);
		
	}
}