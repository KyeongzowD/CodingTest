import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Person{
        int num, age;
        String name;

        public Person(int num, int age, String name) {
            this.num = num;
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Person> queue = new PriorityQueue<>(
                Comparator.comparingInt((Person p) -> p.age)
                        .thenComparingInt((Person p) -> p.num)
        );
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            queue.offer(new Person(i, age, name));
        }

        for (int i = 0; i < N; i++) {
            Person person = queue.poll();
            System.out.println(person.age + " " + person.name);
        }
    }
}
