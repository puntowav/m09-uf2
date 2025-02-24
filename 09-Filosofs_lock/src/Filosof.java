package src;
import java.util.Random;

public class Filosof extends Thread{
    private long iniciGana;
    private long fiGana;
    private long gana;

    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    private Random r = new Random();;

    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra){
        super(nom);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        gana = 0;
        iniciGana = 0;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public void agafaForquillaDreta(){
        forquillaDreta.agafar();
    }
    public void agafaForquillaEsquerra(){
        forquillaEsquerra.agafar();
    }
    public void agafaForquilles(){
        agafaForquillaDreta();
        agafaForquillaEsquerra();
        System.out.printf("%s té forquilles esq(%d) dreta(%d)%n", getName(), forquillaEsquerra.getIndex(), forquillaDreta.getIndex());
    }
    public void deixarForquilles(){
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.printf("%s deixa les forquilles%n", getName());
    }
    public void menjar()throws InterruptedException{
        agafaForquilles();
        fiGana = System.currentTimeMillis();
        calcularGana();
        System.out.printf("%s menja amb gana %d%n", getName(),(int) gana);
        Thread.sleep(500 + r.nextInt(501));
        deixarForquilles();
        System.out.printf("%s ha acabat de menjar%n", getName());
    }
    public void pensar() throws InterruptedException{
        resetGana();
        System.out.println(this.getName() + " pensant");
        Thread.sleep(1000 + r.nextInt(1001));
    }
    public void calcularGana(){
        gana = ((fiGana - iniciGana)/1000);
    }
    public void resetGana(){
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }
    @Override
    public void run() {
        try {
            while (true) {
                menjar();
                pensar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
