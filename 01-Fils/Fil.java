public class Fil extends Thread {
    @Override
    public void run() {
        for(int  i = 1; i <= 9; i++){
            System.out.println(getName() + " " + i);
            Thread.yield();
        }
        System.out.println("Termina el fil "+getName());
    }
}   