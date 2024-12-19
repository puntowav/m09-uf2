package src;

public class MainDemoFil {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("MainDemoFil.main:");
        System.out.println(String.format("Prioritat -> %d, Nom -> %s", t.getPriority(), t.getName()));
        System.out.println(String.format("toString() -> %s", t.toString()));
    }
}
