import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[4];
        for (int i = 1; i <= 3; i++) {
            strings[i] = br.readLine();
        }

        int result = 0;

        // 만약 FizzBuzz면 무조건 15의 배수
        if (strings[1].equals("FizzBuzz") || strings[2].equals("FizzBuzz")) {
            result = Integer.parseInt(strings[3]) + 1;
        } else if (strings[3].equals("FizzBuzz")) {
            result = Integer.parseInt(strings[2]) + 2;
        }

        // 만약 두 문자열이  Fizz Buzz
        if (strings[1].equals("Fizz") && strings[2].equals("Buzz")) {
            result = Integer.parseInt(strings[3]) + 1;
        } else if (strings[1].equals("Fizz") && strings[3].equals("Buzz")) {
            result = Integer.parseInt(strings[2]) + 2;
        } else if (strings[1].equals("Fizz")) {
            result = Integer.parseInt(strings[3]) + 1;
        }

        if (strings[2].equals("Fizz") && strings[3].equals("Buzz")) {
            result = Integer.parseInt(strings[1]) + 3;
        } else if (strings[2].equals("Fizz") && !strings[1].equals("Buzz")) {
            result = Integer.parseInt(strings[3]) + 1;
        }

        if (strings[3].equals("Fizz") && !strings[2].equals("Buzz") && !strings[1].equals("Buzz")) {
            result = Integer.parseInt(strings[2]) + 2;
        }

        // 만약 두 문자열이  Buzz Fizz면
        if (strings[1].equals("Buzz") && strings[2].equals("Fizz")) {
            result = Integer.parseInt(strings[3]) + 1;
        } else if (strings[1].equals("Buzz") && strings[3].equals("Fizz")) {
            result = Integer.parseInt(strings[2]) + 2;
        }

        if(strings[2].equals("Buzz") && strings[3].equals("Fizz")){
            result = Integer.parseInt(strings[1]) + 3;
        }

        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}
