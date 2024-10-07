import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			char[] chars = new char[n];
			Deque<Character> deque = new ArrayDeque<>();
			String [] str = br.readLine().split(" ");
			
			for (int j = 0; j < n; j++) {
				chars[j] = str[j].charAt(0);
			}
			
			for (char a : chars) {
				if (!deque.isEmpty() && deque.peek() >= a) {
					deque.addFirst(a);
				} else {
					deque.addLast(a);
				}
			}
			
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
