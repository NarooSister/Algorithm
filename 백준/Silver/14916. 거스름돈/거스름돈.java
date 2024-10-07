import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = -1;
		
		for(int i = n/5; i>=0; i--) {
			int remain = n -(i*5);
			if(remain%2 == 0){
				count = i + remain/2;
				break;
			}
		}
		
		System.out.println(count);
	}
}
