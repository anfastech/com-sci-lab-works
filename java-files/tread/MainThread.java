class Thread1 implements Runnable {
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("Thread1 - iteration " + i);
            try {
                Thread.sleep(50); // 50ms delay
            } catch (InterruptedException e) {
                System.out.println("Thread1 interrupted");
            }
        }
        System.out.println("Thread1 completed.");
    }
}

class Thread2 implements Runnable {
    public void run() {
        for (int i = 0; i <= 25; i++) {
            System.out.println("Thread2 - iteration " + i);
            try {
                Thread.sleep(80); // 80ms delay
            } catch (InterruptedException e) {
                System.out.println("Thread2 interrupted");
            }
        }
        System.out.println("Thread2 completed.");
    }
}

class Thread3 implements Runnable {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Thread3 - iteration " + i);
            try {
                Thread.sleep(30); // 30ms delay
            } catch (InterruptedException e) {
                System.out.println("Thread3 interrupted");
            }
        }
        System.out.println("Thread3 completed.");
    }
}

public class MainThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1(), "T1");
        Thread t2 = new Thread(new Thread2(), "T2");
        Thread t3 = new Thread(new Thread3(), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
