package question3;

public class Starvation2 implements Runnable {
    ThreadDemo threadDemo;

    public Starvation2(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    public Starvation2() {
    }

    @Override
    public void run() {
        try {
            threadDemo.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
