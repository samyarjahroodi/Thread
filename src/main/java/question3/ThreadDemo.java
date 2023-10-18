package question3;

public class ThreadDemo {
    public synchronized void testMethod() throws InterruptedException {
        System.out.println("processing for thread");
        Thread.currentThread().getName();
        Thread.sleep(300);
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread1 = new Thread(new Starvation1(threadDemo));
        Thread thread2 = new Thread(new Starvation1(threadDemo));

        thread1.setPriority(10);
        thread2.setPriority(1);

        thread1.start();
        thread2.start();

    }

}
