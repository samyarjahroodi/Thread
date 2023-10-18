package question1;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter your input");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        EvenNumber evenNumber = new EvenNumber(input, list);
        OddNumber oddNumber = new OddNumber(input, list);
        evenNumber.start();
        oddNumber.start();
        synchronized (list) {
            list.wait();
            Thread.sleep(100);
        }

        synchronized (list) {
            Collections.sort(list);
        }
        System.out.println(list);
    }
}


