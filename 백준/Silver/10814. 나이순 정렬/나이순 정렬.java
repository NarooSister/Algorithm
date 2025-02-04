import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Person {
        int age;
        String name;
        int idx;

        public Person(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons.add(new Person(age, name, i));
        }

        persons.sort((p1, p2) -> {
            if (p1.age == p2.age) {
                return p1.idx - p2.idx;
            }
            return p1.age - p2.age;
        });

        for (Person person : persons) {
            sb.append(person.age).append(" ").append(person.name).append("\n");
        }
        System.out.println(sb);
    }

}


