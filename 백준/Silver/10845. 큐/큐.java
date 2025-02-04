import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue_Array queueArray = new Queue_Array();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queueArray.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    sb.append(queueArray.pop() + "\n");
                    break;
                case "size":
                    sb.append(queueArray.size() + "\n");
                    break;
                case "empty":
                    sb.append(queueArray.empty() + "\n");
                    break;
                case "front":
                    sb.append(queueArray.front() + "\n");
                    break;
                case "back":
                    sb.append(queueArray.back() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class Queue_Array {
        int max = 10000;
        int front;
        int rear;
        int[] queue;

        public Queue_Array() {
            front = rear = 0;
            queue = new int[max];
        }

        public void push(int x) {
            queue[rear++] = x;
        }

        public int pop() {
            if (front == rear) return -1;
            return queue[front++];
        }

        public int size() {
            return rear - front;
        }

        public int empty() {
            return front == rear ? 1 : 0;
        }

        public int front() {
            if (front == rear) return -1;
            return queue[front];
        }

        public int back() {
            if (front == rear) return -1;
            return queue[rear-1];
        }
    }
}


