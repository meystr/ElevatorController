package rozanski.remigiusz.thread;

public class MyThread implements Runnable {

    public MyThread() {
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
