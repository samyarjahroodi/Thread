import java.util.List;
import java.util.TreeMap;

public class OddNumber extends Thread {
    int input;
    List<Integer> list;

    public OddNumber(int input, List<Integer> list) {
        this.input = input;
        this.list = list;
    }

    @Override
    public void run() {
        getOddNumbers();
    }

    public void getOddNumbers() {
        for (int i = 1; i <= input; i += 2) {
            list.add(i);
        }
        System.out.println(list);
    }
}
