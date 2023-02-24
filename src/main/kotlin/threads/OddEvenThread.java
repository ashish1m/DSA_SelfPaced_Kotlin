package threads;

public class OddEvenThread implements Runnable {

    private Printer printer;
    private int max;
    private boolean isEven;

    public OddEvenThread(Printer printer, int max, boolean isEven) {
        this.printer = printer;
        this.max = max;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int num = isEven ? 0 : 1;
        while (num <= max) {
            if (isEven) {
                printer.printEven(num);
            } else {
                printer.printOdd(num);
            }
            num += 2;
        }
    }
}

class Printer {

    private volatile boolean isEven = true;

    synchronized void printOdd(int number) {
        while (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isEven = true;
        notify();
    }

    synchronized void printEven(int number) {
        while (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isEven = false;
        notify();
    }
}

class Driver {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new OddEvenThread(printer, 10, false), "Odd");
        Thread t2 = new Thread(new OddEvenThread(printer, 10, true), "Even");

        t1.start();
        t2.start();
    }
}


