import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String word = br.readLine();
		

		if(str.length() < word.length()) {
		System.out.println(0);	
			return;
		}
		
		int count = 0;
		for(int i = 0; i <= str.length() - word.length(); i++) {
			String sub = str.substring(i, i + word.length());
			if(sub.equals(word)) {
				count++;
				i += word.length() -1;
			}
			
		}
		System.out.println(count);
	}
}
