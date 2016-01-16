package osdesign.util;


public class CpuControl {
    public void run() throws InterruptedException {
        Banker bk = new Banker();
        bk.run();
        BestFit bf = new BestFit();
        bf.run();
    }
}
