package question2;

public class
Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-1 interrupted.");
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " releases lock2");
            }
            System.out.println(Thread.currentThread().getName() + " releases lock1");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2 interrupted.");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " releases lock1");
            }
            System.out.println(Thread.currentThread().getName() + " releases lock2");
        }
    }
}
