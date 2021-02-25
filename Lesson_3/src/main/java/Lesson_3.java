public class Lesson_3 {
    private static final Object mon = new Object();
    private volatile char tmpCh = 'A';

    public static void main(String[] args) {
        Lesson_3 l=new Lesson_3();
        Thread t1=new Thread(()->{
            l.printA();
        });
        Thread t2=new Thread(()->{
            l.printB();
        });
        Thread t3=new Thread(()->{
            l.printC();
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
        public void printA () {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 3; i++) {
                        while (tmpCh != 'A') {
                            mon.wait();
                        }
                        System.out.println('A');
                        tmpCh = 'B';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void printB(){
            synchronized (mon) {
                try {
                    for (int i = 0; i < 3; i++) {
                        while (tmpCh != 'B') {
                            mon.wait();
                        }
                        System.out.println('B');
                        tmpCh = 'C';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void printC () {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 3; i++) {
                        while (tmpCh != 'C') {
                            mon.wait();
                        }
                        System.out.println('C');
                        tmpCh = 'A';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }