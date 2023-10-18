package question3;

public class Starvation1 implements Runnable {
    ThreadDemo threadDemo;

    public Starvation1(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    public Starvation1() {
    }


    @Override
    public void run() {
        try {
            threadDemo.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadDemo.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadDemo.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadDemo.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
