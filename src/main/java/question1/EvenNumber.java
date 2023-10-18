package question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenNumber extends Thread {
    List<Integer> list;
    int input;

    public EvenNumber(int input, List<Integer> list) {
        this.list = list;
        this.input = input;
    }

    @Override
    public void run() {
        getEvenNumbers();
        synchronized (list) {
            try {
                list.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getEvenNumbers() {
        for (int i = 2; i <= input; i += 2) {
            list.add(i);
        }
    }
}

