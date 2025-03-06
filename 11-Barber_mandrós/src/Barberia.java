import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread{
    public static Barberia barberia;
    public Object condBarber = new Object();
    private Queue<Client> cua;
    private int cadires;
    public Barberia(int cadires){
        cua = new LinkedList<>();
        this.cadires = cadires; 
    }
    public Client seguentClient(){
        return cua.poll();
    }
    public synchronized void entrarClient(Client c)throws InterruptedException{
        if(cua.size() < cadires){
            synchronized(condBarber){
                cua.add(c);
                condBarber.notify();
                System.out.println("Client "+c.getNom()+" en espera");
            }
        }else System.out.println("No queden cadires, client "+c.getNom()+" se'n va");
    }
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                entrarClient(new Client(i));
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 11; i <= 20; i++){
            try {
                entrarClient(new Client(i));
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        barberia = new Barberia(3);
        Barber b = new Barber("Pepe");
        b.start();
        barberia.start();
    }
}
