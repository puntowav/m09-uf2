import java.util.Random;

public class Filosof extends Thread{
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private int index;

    private static Random r;

    public Filosof(int index, Forquilla forquillaEsquerra, Forquilla forquillaDreat){
        this.index = index;
        this.forquillaDreta = forquillaDreat;
        this.forquillaEsquerra = forquillaDreat;
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
    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public void menjar()throws InterruptedException{
        while (true) {
            if(agafarForquilles()){
                System.out.printf("%nFilòsof: %d menja", getIndex());
                Thread.sleep(r.nextInt(2000 - 1000 + 1));
                setGana(0);
                System.out.printf("%nFilòsof: %d ha acabat de menjar", getIndex());
                break;
            }else{
                deixarForquilles();
                System.out.printf("%nFilòsof: %s deixa l'esquerra(%d) i espera (dreta ocupada)", getName(), forquillaEsquerra.getIndex());
                setGana(gana + 1);
                System.out.printf("%nFilòsof: %s gana=%d", getName(), getGana());
            }
        }
    }
    public boolean agafarForquilles(){
        if(agafarForquillaEsquerra()){
            if(agafarForquillaDreta()){
                return true;
            }
            System.out.printf("%nFilòsof: %s deixa l'esquerra(%d) i espera (dreta ocupada)", getName(), forquillaEsquerra.getIndex());
            return false;
        }
        return false;
    }
    public boolean agafarForquillaEsquerra(){
        if(forquillaEsquerra.getNumeroPropietari() == -1) {
            forquillaEsquerra.setNumeroPropietari(index);
            return true;
        }
        return false;
    }
    public boolean agafarForquillaDreta(){
        if(forquillaDreta.getNumeroPropietari() == -1) {
            forquillaDreta.setIndex(index);
            return true;
        }
        return false;
    }
    public void deixarForquilles(){
        forquillaEsquerra.resetNumeroPropietari();
        forquillaDreta.resetNumeroPropietari();
    }
    public void pensar()throws InterruptedException{
        Thread.sleep(r.nextInt(2000 - 1000 + 1));
        System.out.printf("%nFilòsof: %s pensat", getName());
    }
    @Override
    public void run() {
        while (true) {
            try {
                menjar();
                pensar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
