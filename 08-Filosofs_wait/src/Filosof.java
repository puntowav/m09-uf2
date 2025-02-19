import java.util.Random;

public class Filosof extends Thread{
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private int index;

    private static Random r = new Random();

    public Filosof(int index, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.index = index;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }
    
    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    public int getGana() {
        return gana;
    }
    public int getIndex() {
        return index;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }
    
    public void menjar() throws InterruptedException {
        while (true) {
            if (agafarForquilles()) {
                System.out.printf("%nFilòsof: %d menja", getIndex());
                Thread.sleep(r.nextInt(1001) + 1000);
                setGana(0);
                deixarForquilles();
                System.out.printf("%nFilòsof: %d ha acabat de menjar", getIndex());
                break;
            } else {
                deixarForquilles();
                System.out.printf("%nFilòsof: %d deixa l'esquerra(%d) i espera (dreta ocupada)", 
                                  getIndex(), forquillaEsquerra.getIndex());
                setGana(gana + 1);
                System.out.printf("%nFilòsof: %d gana=%d", getIndex(), getGana());
                wait(500 + r.nextInt(501));
            }
        }
    }
    
    public boolean agafarForquilles()throws InterruptedException{
        synchronized(this){
            while (!agafarForquillaEsquerra()) {
                wait();
            }
        }

        if (agafarForquillaDreta()) {
            return true;
        }

        System.out.printf("%nFilòsof: %d deixa l'esquerra(%d) i espera (dreta ocupada)", 
                          getIndex(), forquillaEsquerra.getIndex());
        forquillaEsquerra.resetNumeroPropietari();

        return false;
    }
    
    public boolean agafarForquillaEsquerra() {
        synchronized(forquillaEsquerra){
            if (forquillaEsquerra.getNumeroPropietari() == -1) {
                forquillaEsquerra.setNumeroPropietari(index);
                return true;
            }
        }
        return false;
    }
    
    public boolean agafarForquillaDreta() {
        synchronized(forquillaDreta){
            if (forquillaDreta.getNumeroPropietari() == -1) {
                forquillaDreta.setNumeroPropietari(index);
                return true;
            }
        }
        return false;
    }
    
    public void deixarForquilles() {
        synchronized(forquillaEsquerra){
            forquillaEsquerra.resetNumeroPropietari();
        }
        synchronized(forquillaDreta){
            forquillaDreta.resetNumeroPropietari();
        }
    }
    
    public void pensar() throws InterruptedException {
        System.out.printf("%nFilòsof: %d pensa", getIndex());
        Thread.sleep(100 + r.nextInt(1001));
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                menjar();
                pensar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
