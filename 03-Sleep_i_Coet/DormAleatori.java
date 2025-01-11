import java.util.Random;

public class DormAleatori extends Thread{
    public long time;
    @Override
    public void run(){
        Random r = new Random();
        try {
            time =  System.currentTimeMillis();
            for(int i = 0; i <= 9; i++){
                long l = r.nextInt(1000);
                System.out.print(mostra(i, l));
                Thread.sleep(l);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String mostra(int i, long l){
        return String.format("%s(%d) a dormir %dms total %d%n", getName(), i, l,  System.currentTimeMillis() - time);
    }
    
    public static void main(String[] main) throws InterruptedException{
        DormAleatori joan = new DormAleatori();
        DormAleatori pep = new DormAleatori();

        joan.setName("Joan");
        pep.setName("Pep");

        joan.start();
        pep.start();

        joan.join();

        System.out.println("--Fi del main--");
    }
}
