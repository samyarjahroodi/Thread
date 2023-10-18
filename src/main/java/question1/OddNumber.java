package question1;

import java.util.List;
import java.util.TreeMap;

public class OddNumber extends Thread {
    List<Integer> list;
    int input;

    public OddNumber(int input, List<Integer> list) {
        this.input = input;
        this.list = list;
    }

    @Override
    public void run() {
//        try {
//            getOddNumbers();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        getOddNumbers();
        synchronized (list) {
            list.notify();
        }
    }

    public void getOddNumbers() {
        for (int i = 1; i <= input; i += 2) {
            list.add(i);
        }
    }
}
