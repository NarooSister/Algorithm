import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int [] nums = new int [n];
		for(int i = 0; i< n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for(int i = n-2; i >= 0; i--) {
			if(nums[i]>= nums[i+1]) {
				count += nums[i] -(nums[i+1] -1);
				nums[i] = nums[i+1] -1;
			}
		}
		System.out.print(count);
	}
}
