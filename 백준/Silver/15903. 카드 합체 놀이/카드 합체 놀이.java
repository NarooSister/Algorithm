import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int cardCount = Integer.parseInt(info[0]);
        int actions = Integer.parseInt(info[1]);

        String[] cards = br.readLine().split(" ");

        PriorityQueue<Long> smallestCards = new PriorityQueue<>();
        for (int i = 0; i < cardCount; i++) {
            smallestCards.offer(Long.parseLong(cards[i]));

        }

        for (int i = 0; i < actions; i++) {
            long first = smallestCards.poll();
            long second = smallestCards.poll();

            long sum = first + second;
            smallestCards.offer(sum);
            smallestCards.offer(sum);
        }
        long answer = 0;
        while (!smallestCards.isEmpty()){
            answer += smallestCards.poll();
        }
        System.out.println(answer);
    }
}
