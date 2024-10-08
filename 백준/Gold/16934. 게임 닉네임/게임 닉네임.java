
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> prefix = new HashSet<>();
		Map<String, Integer> stringMap = new HashMap<>();
		String[] strings = new String[n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			strings[i] = str;

			// 중복된 문자열인지 확인
			stringMap.put(str, stringMap.getOrDefault(str, 0) + 1);
			int count = stringMap.get(str);

			if (count == 1) {
				boolean firstNickname = false;
				String nickname = "";
				// 별칭 구하기

				for (int j = 1; j <= str.length(); j++) {
					String sub = str.substring(0, j);

					if (!prefix.contains(sub) && !firstNickname) {
						nickname = sub;
						System.out.println(sub);
						firstNickname = true;
					}
					prefix.add(sub);
				}
				if (!firstNickname) {
					System.out.println(str);
				}

			} else {
				System.out.println(str + count);
			}

		}
	}
}
