
import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int [][] bingo = new int [5][5];
		boolean [][] marked = new boolean [5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		int bingoCount = 0;
		
		for(int i = 1; i<=25; i++) {
			int num = sc.nextInt();
			
			// 사회자가 부른 수 찾아서 마킹
			for(int k = 0; k<5; k++) {
				for(int j=0; j<5; j++) {
					if(bingo[k][j] == num) {
						marked[k][j] = true;
						break;
					}
				}
			}
			
			bingoCount = checkBingo(marked);	// 빙고 몇 개인지 확인
			
			if(bingoCount>=3) {
				System.out.println(i);
				break;
			}
		}
	}

	static int checkBingo(boolean [][] marked) {
		int bingoCount = 0;
		
		// 가로 빙고 확인
		for(int i =0; i<5; i++) {
			boolean isBingo = true;	// 각 가로줄이 빙고인지
			for(int j = 0; j < 5; j++) {
				if(!marked[i][j]) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) {
				bingoCount++;
			}
		}
		
		// 세로 빙고 확인
		for(int j =0; j<5; j++) {
			boolean isBingo = true;	// 각 세로줄이 빙고인지
			for(int i = 0; i < 5; i++) {
				if(!marked[i][j]) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) {
				bingoCount++;
			}
		}
		
		// 대각선 빙고 확인(왼쪽 위 -> 오른쪽 아래)
		boolean isBingo = true;
		for(int i = 0; i<5; i++) {
			if(!marked[i][i]) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) bingoCount++;
		
		// 대각선 빙고 확인(오른쪽 위 -> 왼쪽 아래)
		boolean isBingo2 = true;
		for(int i = 0; i <5; i++) {
			if(!marked[i][4-i]) {
				isBingo2 = false;
				break;
			}
		}
		if(isBingo2) bingoCount++;
		
		return bingoCount;
	}
}
